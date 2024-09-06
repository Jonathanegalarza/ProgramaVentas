/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import com.toedter.calendar.JDateChooser;
import java.sql.Date;
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
            JLabel lblComprobanteEncontrado, JLabel lblFechaAfactura, JLabel lblNombreCliente, JLabel lbldireccion,
            JLabel lbltelefono, JLabel lblemail, JLabel lbllocalidad, JLabel lblModCliente, JTable TbProductos) {

        Configuracion.CConexion objetoConexion = new Configuracion.CConexion();

        try {

            String consulta = "SELECT rubenventas.factura.idfactura, rubenventas.factura.FechaFacturacion, rubenventas.cliente.Nombre"
                    + ",rubenventas.cliente.Direccion, rubenventas.cliente.Telefono,rubenventas.cliente.Email,"
                    + "rubenventas.cliente.Localidad,rubenventas.cliente.UfechaModificacion FROM rubenventas.factura INNER JOIN cliente ON cliente.idCliente = factura.FCliente WHERE factura.idfactura = ?;";

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
            } else {
                lblComprobanteEncontrado.setText("");
                lblFechaAfactura.setText("");
                lblNombreCliente.setText("");
                lbldireccion.setText("");
                lbltelefono.setText("");
                lblemail.setText("");
                lbllocalidad.setText("");
                lblModCliente.setText("");

                JOptionPane.showMessageDialog(null, "No se encontro el Comprobante");
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error al buscar Comprobante" + e.toString());

        } finally {

            objetoConexion.cerrarConexion();

        }

    }

    public void BuscarFacturaMostrarDatoSProductos(JTextField txtBuscarComprobante, JTable tbProductos, JLabel IVA, JLabel TOTAL) {

        Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("N.Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("PrecioVenta");
        modelo.addColumn("SubTotal");
        tbProductos.setModel(modelo);

        try {

            String consulta = "SELECT rubenventas.producto.Producto, rubenventas.detalle.Cantidad,rubenventas.detalle.PrecioVenta FROM detalle "
                    + "INNER JOIN rubenventas.factura ON rubenventas.factura.idfactura = detalle.Fkfactura "
                    + "INNER JOIN rubenventas.producto ON rubenventas.producto.idproducto = detalle.FkProducto WHERE factura.idfactura= ?;";

            PreparedStatement ps = objetoConexion.estableceConexion().prepareStatement(consulta);
            ps.setInt(1, Integer.parseInt(txtBuscarComprobante.getText()));
            ResultSet rs = ps.executeQuery();

            double totalFactura = 0.0;
            double valorIva = 0.21;

            // Formatear los valores para mostrarlos
            DecimalFormat formato = new DecimalFormat("#.##");

            while (rs.next()) {
                String nombreProducto = rs.getString("Producto");
                int cantidad = rs.getInt("Cantidad");
                double precioVenta = rs.getDouble("PrecioVenta");
                double subtotal = precioVenta * cantidad;
                totalFactura = Double.parseDouble(formato.format(totalFactura + subtotal));

                modelo.addRow(new Object[]{nombreProducto, cantidad, precioVenta, subtotal});
            }

            double totalIVA = Double.parseDouble(formato.format(totalFactura * valorIva));

            IVA.setText(String.valueOf(totalIVA));
            TOTAL.setText(String.valueOf(totalFactura));

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error al cargar productos de la Fatura" + e.toString());
        } finally {

            objetoConexion.cerrarConexion();

        }

    }

    public void mostrarTotalPorFecha(JDateChooser desde, JDateChooser hasta, JTable tablaVentas, JLabel totalGeneral) {
        Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("idfactura");
        modelo.addColumn("FechaFactura");
        modelo.addColumn("NProducto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("PrecioVenta");
        modelo.addColumn("SubTotal");
        tablaVentas.setModel(modelo);
        try {
            /*String consulta = "SELECT factura.idfactura ,factura.FechaFacturacion,producto.Producto,detalle.PrecioVenta "+
"FROM rubenventas.detalle INNER JOIN rubenventas.factura ON factura.idfactura = detalle.Fkfactura "+
"INNER JOIN rubenventas.producto ON producto.idproducto = detalle.FkProducto "+
"WHERE factura.FechaFacturacion BETWEEN '?' AND '?';";*/
            String consulta ="SELECT factura.idfactura,DATE_FORMAT(FechaFacturacion, '%d/%m/%Y') AS fecha_formateada,"
                    +"producto.Producto,detalle.Cantidad,detalle.PrecioVenta FROM rubenventas.detalle INNER JOIN rubenventas.factura"+
"ON factura.idfactura = detalle.Fkfactura INNER JOIN rubenventas.productoON producto.idproducto = detalle.FkProducto" +
"WHERE factura.FechaFacturacion BETWEEN '?' AND '?';";
            PreparedStatement ps = objetoConexion.estableceConexion().prepareStatement(consulta);

            java.util.Date fechaDesde = desde.getDate();
            java.util.Date fechaHasta = hasta.getDate();

            java.sql.Date fechaDesdeSql = new java.sql.Date(fechaDesde.getTime());
            java.sql.Date fechaHastaSql = new java.sql.Date(fechaHasta.getTime());

            ps.setDate(1, fechaDesdeSql);
            ps.setDate(2, fechaHastaSql);
            ResultSet rs = ps.executeQuery();
            double totalFactura = 0.0;
            DecimalFormat formato = new DecimalFormat("#.##");
            while (rs.next()) {
                int idfactura = rs.getInt("idfactura ");
                Date fechaFactura = rs.getDate("fechaFacturacion");
                String nombreProducto = rs.getString("Producto");
                int cantidad = rs.getInt("Cantidad");
                double precioVenta = rs.getInt("PrecioVenta");
                
                
                double subTotal = cantidad * precioVenta;

                totalFactura = Double.parseDouble(formato.format(totalFactura + subTotal));

                modelo.addRow(new Object[]{idfactura, fechaFactura, nombreProducto, cantidad, precioVenta, subTotal});
            }
            totalGeneral.setText(String.valueOf(totalFactura));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se obtuvieron los Datos " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
        //for para bloquear la tabla y no modificar los datos
        for (int columm = 0; columm < tablaVentas.getColumnCount(); columm++) {

            Class<?> columClass = tablaVentas.getColumnClass(columm);
            tablaVentas.setDefaultEditor(columClass, null);

        }
    }
}
