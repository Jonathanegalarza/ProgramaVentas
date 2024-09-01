/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruben
 */
public class ControladorReportes {
    
    
    
   public void BuscarFacturaMostrarDatosCliente(JTextField txtBuscarComprobante,
           JLabel lblComprobanteEncontrado,JLabel lblFechaAfactura,JLabel lblNombreCliente, JLabel lbldireccion,
           JLabel lbltelefono,JLabel lblemail ,JLabel lbllocalidad ,JLabel lblModCliente ,JTable TbProductos ){
       
  Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
       
       try {
          
           String consulta= "SELECT rubenventas.factura.idfactura, rubenventas.factura.FechaFacturacion, rubenventas.cliente.Nombre" +
",rubenventas.cliente.Direccion, rubenventas.cliente.Telefono,rubenventas.cliente.Email," +
"rubenventas.cliente.Localidad,rubenventas.cliente.UfechaModificacion FROM rubenventas.factura INNER JOIN cliente ON cliente.idCliente = factura.FCliente WHERE factura.idfactura = ?;";
           
           PreparedStatement ps = objetoConexion.estableceConexion().prepareStatement(consulta);
           ps.setInt(1, Integer.parseInt(txtBuscarComprobante.getText()));
           ResultSet rs = ps.executeQuery();
           
           
           if (rs.next()) {
            lblComprobanteEncontrado.setText(String.valueOf(rs.getInt("idfactura")));
            lblFechaAfactura.setText(rs.getDate("FechaFacturacion").toString());
            lblNombreCliente.setText(rs.getString("Nombre"));
            lbldireccion.setText(rs.getString("Direccion"));
            lbltelefono.setText(String.valueOf(rs.getInt("Telefono")));
            lblemail.setText(rs.getString("Email"));
            lbllocalidad.setText(rs.getString("Localidad"));
            lblModCliente.setText(rs.getDate("UfechaModificacion").toString());
           }else{
               lblComprobanteEncontrado.setText("");
            lblFechaAfactura.setText("");
            lblNombreCliente.setText("");
            lbldireccion.setText("");
            lbltelefono.setText("");
            lblemail.setText("");
            lbllocalidad.setText("");
            lblModCliente.setText("");
            
               JOptionPane.showMessageDialog(null,"No se encontro el Comprobante");
           }
       } catch (Exception e) {
       
       JOptionPane.showMessageDialog(null,"Error al buscar Comprobante"+ e.toString());
       
       
       } finally {
       
       objetoConexion.cerrarConexion();
       
       }
       
   }
   public void BuscarFacturaMostrarDatoSProductos(JTextField txtBuscarComprobante,JTable tbProductos, JLabel IVA,JLabel TOTAL){
       
       Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
       DefaultTableModel modelo = new DefaultTableModel();
modelo.addColumn("N.Producto");
modelo.addColumn("Cantidad");
modelo.addColumn("PrecioVenta");
modelo.addColumn("SubTotal");
tbProductos.setModel(modelo);

       try {
          
           String consulta= "SELECT rubenventas.producto.Producto, rubenventas.detalle.Cantidad,rubenventas.detalle.PrecioVenta FROM detalle " +
"INNER JOIN rubenventas.factura ON rubenventas.factura.idfactura = detalle.Fkfactura " +
"INNER JOIN rubenventas.producto ON rubenventas.producto.idproducto = detalle.FkProducto WHERE factura.idfactura= ?;";
           
           PreparedStatement ps = objetoConexion.estableceConexion().prepareStatement(consulta);
           ps.setInt(1, Integer.parseInt(txtBuscarComprobante.getText()));
           ResultSet rs = ps.executeQuery(); 
           
          double totalFactura =0.0;
        double valorIva =0.21;

        // Formatear los valores para mostrarlos
        DecimalFormat formato = new DecimalFormat("#.##");
        
           while (rs.next()) {
               String nombreProducto= rs.getString("Producto");
               int cantidad = rs.getInt("Cantidad");
               double precioVenta = rs.getDouble("PrecioVenta");
               double subtotal= precioVenta* cantidad;
               totalFactura = Double.parseDouble(formato.format(totalFactura+ subtotal));
               
               modelo.addRow(new Object[]{nombreProducto,cantidad,precioVenta,subtotal});
           }
           
          double totalIVA=Double.parseDouble(formato.format(totalFactura*valorIva));
          
        
        IVA.setText(String.valueOf(totalIVA));
        TOTAL.setText(String.valueOf(totalFactura));
        
           
       } catch (Exception e) {
       
       JOptionPane.showMessageDialog(null,"Error al cargar productos de la Fatura"+e.toString());
       } finally {
           
           objetoConexion.cerrarConexion();
           
       }
   }

}
