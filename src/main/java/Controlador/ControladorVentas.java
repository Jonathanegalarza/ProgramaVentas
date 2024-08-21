/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.modeloProducto;
import com.google.protobuf.StringValue;
import com.mysql.cj.jdbc.CallableStatement;
import com.mysql.cj.protocol.a.ResultsetFactory;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruben
 */
public class ControladorVentas {

    public void BuscarProducto(JTextField nombreProducto, JTable tablaProductos) {
        Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
        Modelo.modeloProducto objetoProducto = new Modelo.modeloProducto();

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("IdProducto");
        modelo.addColumn("Producto");
        modelo.addColumn("Neto");
        modelo.addColumn("Iva");
        modelo.addColumn("PrecioProducto");
        modelo.addColumn("Stock");
        modelo.addColumn("UltimaModificacion");

        tablaProductos.setModel(modelo);

        try {
            String consulta = "SELECT * from producto WHERE producto.Producto like concat('%',?,'%')";
            PreparedStatement ps = objetoConexion.estableceConexion().prepareStatement(consulta);
            ps.setString(1, nombreProducto.getText());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objetoProducto.setIdProducto(rs.getInt("idProducto"));
                objetoProducto.setProducto(rs.getString("Producto"));
                objetoProducto.setNeto(Double.valueOf(rs.getDouble("Neto")));
                objetoProducto.setIva(Double.valueOf(rs.getDouble("Iva")));
                objetoProducto.setPrecioProducto(Double.valueOf(rs.getInt("PrecioProducto")));
                objetoProducto.setStock(rs.getInt("Stock"));
                objetoProducto.setUltimaModificacion(rs.getString("UltimaModificacion"));
                modelo.addRow(new Object[]{
                    objetoProducto.getIdProducto(),
                    objetoProducto.getProducto(),
                    objetoProducto.getNeto(),
                    objetoProducto.getIva(),
                    objetoProducto.getPrecioProducto(),
                    objetoProducto.getStock(),
                    objetoProducto.getUltimaModificacion()
                });

            }
            tablaProductos.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede caragar Lista" + e.toString());

        } finally {
            objetoConexion.cerrarConexion();
        }
        for (int column = 0; column < tablaProductos.getColumnCount(); column++) {
            Class<?> ColumClass = tablaProductos.getColumnClass(column);
            tablaProductos.setDefaultEditor(ColumClass, null);

        }
    }

    public void SeleccionarProductoVenta(JTable tablaProducto,
            JTextField id,
            JTextField Producto,
            JTextField Neto,
            JTextField Iva,
            JTextField Stock,
            JTextField PrecioProducto,
            JTextField PrecioFinal) {

        int fila = tablaProducto.getSelectedRow();

        try {
            if (fila >= 0) {
                id.setText(tablaProducto.getValueAt(fila, 0).toString());
                Producto.setText(tablaProducto.getValueAt(fila, 1).toString());
                Neto.setText(tablaProducto.getValueAt(fila, 2).toString());
                Iva.setText(tablaProducto.getValueAt(fila, 3).toString());
                Stock.setText(tablaProducto.getValueAt(fila, 5).toString());
                PrecioProducto.setText(tablaProducto.getValueAt(fila, 4).toString());
                PrecioFinal.setText(tablaProducto.getValueAt(fila, 4).toString());

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error de Seleccion" + e.toString());

        }

    }

    public void BuscarCliente(JTextField nombreCliente, JTable tablaCliente) {
        Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
        Modelo.modeloCliente objetoCliente = new Modelo.modeloCliente();

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("IdCliente");
        modelo.addColumn("Nombre");
        modelo.addColumn("Dni");
        modelo.addColumn("Direccion");
        modelo.addColumn("Localidad");
        modelo.addColumn("Telefono");
        modelo.addColumn("Email");
        modelo.addColumn("UfechaModificacion");

        tablaCliente.setModel(modelo);

        try {
            String consulta = "SELECT * from cliente WHERE cliente.Nombre like concat('%',?,'%')";
            PreparedStatement ps = objetoConexion.estableceConexion().prepareStatement(consulta);
            ps.setString(1, nombreCliente.getText());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objetoCliente.setIdCliente(rs.getInt("idCliente"));
                objetoCliente.setNombre(rs.getString("Nombre"));
                objetoCliente.setDni(rs.getString("Dni"));
                objetoCliente.setDireccion(rs.getString("Direccion"));
                objetoCliente.setLocalidad(rs.getString("Localidad"));
                objetoCliente.setTelefono(rs.getString("Telefono"));
                objetoCliente.setEmail(rs.getString("Email"));
                modelo.addRow(new Object[]{
                    objetoCliente.getIdCliente(),
                    objetoCliente.getNombre(),
                    objetoCliente.getDni(),
                    objetoCliente.getDireccion(),
                    objetoCliente.getLocalidad(),
                    objetoCliente.getTelefono(),
                    objetoCliente.getEmail()
                });

            }
            tablaCliente.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede caragar Lista" + e.toString());

        } finally {
            objetoConexion.cerrarConexion();
        }
        for (int column = 0; column < tablaCliente.getColumnCount(); column++) {
            Class<?> ColumClass = tablaCliente.getColumnClass(column);
            tablaCliente.setDefaultEditor(ColumClass, null);

        }
    }

    public void SeleccionarClienteVenta(JTable tablaCliente,
            JTextField id,
            JTextField Nombre,
            JTextField Dni,
            JTextField Direccion,
            JTextField Localidad,
            JTextField Telefono,
            JTextField Email) {

        int fila = tablaCliente.getSelectedRow();

        try {
            if (fila >= 0) {
                id.setText(tablaCliente.getValueAt(fila, 0).toString());
                Nombre.setText(tablaCliente.getValueAt(fila, 1).toString());
                Dni.setText(tablaCliente.getValueAt(fila, 2).toString());
                Direccion.setText(tablaCliente.getValueAt(fila, 3).toString());
                Localidad.setText(tablaCliente.getValueAt(fila, 4).toString());
                Telefono.setText(tablaCliente.getValueAt(fila, 5).toString());
                Email.setText(tablaCliente.getValueAt(fila, 6).toString());

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error de Seleccion" + e.toString());

        }

    }

    public void PasarPruductosVentas(JTable tablaResumen,
            JTextField id,
            JTextField Producto,
            JTextField Neto,
            JTextField Iva,
            JTextField Stock,
            JTextField PrecioProducto,
            JTextField PrecioFinal,
            JTextField CantidadVentas) {

        DefaultTableModel modelo = (DefaultTableModel) tablaResumen.getModel();
        int stockDisponible = Integer.parseInt(Stock.getText());
        String idProducto = id.getText();

        for (int i = 0; i < modelo.getRowCount(); i++) {
            String idExistente = (String) modelo.getValueAt(i, 0);
            if (idExistente.equals(idProducto)) {

                JOptionPane.showMessageDialog(null, "El Producto ya esta Registrado");
                return;
            }

        }

        String nProducto = Producto.getText();
        Double PrecioUnitario = Double.parseDouble(PrecioProducto.getText());
        int cantidad = Integer.parseInt(CantidadVentas.getText());
        if (cantidad > stockDisponible) {
            JOptionPane.showMessageDialog(null, "A superado el Stock Disponible");
            return;

        }
        Double subTotal = PrecioUnitario * cantidad;
        modelo.addRow(new Object[]{idProducto, nProducto, PrecioUnitario, cantidad, subTotal});

    }

    public void EliminarProductosSelecionadosResumenVentas(JTable tablaResumen) {

        try {
            DefaultTableModel modelo = (DefaultTableModel) tablaResumen.getModel();
            int indiceSelecionado = tablaResumen.getSelectedRow(); //se toma el valor de la seleccion en la tablaResumen

            if (indiceSelecionado != -1) {//si hay un valor seleccionado lo tamamos

                modelo.removeRow(indiceSelecionado);// una vez seleccionado se elimina

            } else {
                JOptionPane.showMessageDialog(null, "Selecciona un Producto a eliminar de la Lista");
            }
        } catch (HeadlessException e) {

            JOptionPane.showMessageDialog(null, "Error al Eliminar" + e.toString());
        }

    }

    public void calcularTotalPagar(JTable tablaResumen, JLabel IVA, JLabel TOTAL) {

        DefaultTableModel modelo = (DefaultTableModel) tablaResumen.getModel();
        double totalSubtotal = 0;
        double Iva = 0.21;
        double totaliva = 0;

        DecimalFormat formato = new DecimalFormat("#.##");

        for (int i = 0; i < modelo.getRowCount(); i++) {
            totalSubtotal = Double.parseDouble(formato.format(totalSubtotal + (double) modelo.getValueAt(i, 4)));
            totaliva = Double.parseDouble(formato.format(Iva * totalSubtotal));
        }
        TOTAL.setText(String.valueOf(totalSubtotal));
        IVA.setText(String.valueOf(totaliva));

    }

    public void crearFactura(JTextField idCliente) {
        Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
        Modelo.modeloCliente objetoCliente = new Modelo.modeloCliente();

        String consulta = "INSERT INTO factura (FechaFacturacion, Fcliente)value (curdate(),?);";

        try {
            objetoCliente.setIdCliente(Integer.parseInt(idCliente.getText()));
            CallableStatement cs = (CallableStatement) objetoConexion.estableceConexion().prepareCall(consulta);
            cs.setInt(1, objetoCliente.getIdCliente());
            cs.execute();
            JOptionPane.showMessageDialog(null, "Se creo la      Factura");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "No se puede Crear Factura" + e.toString());
        } finally {
            objetoConexion.cerrarConexion();

        }

    }

    public void realizarVenta(JTable TablaResumenVenta) {
        Configuracion.CConexion objetoConexion = new Configuracion.CConexion();

        String consultaDetalle = "INSERT INTO detalle(Fkfactura,FkProducto,Cantidad,PrecioVenta)values ((SELECT MAX(idFactura)from factura),?,?,?); ";
        String consultaStock = "UPDATE producto SET producto.Stock = Stock-? WHERE idProducto=?;";
        try {
            PreparedStatement psDetalle = objetoConexion.estableceConexion().prepareStatement(consultaDetalle);
            PreparedStatement psStock = objetoConexion.estableceConexion().prepareStatement(consultaStock);

            int filas = TablaResumenVenta.getRowCount();

            for (int i = 0; i < filas; i++) {
                int idProducto = Integer.parseInt(TablaResumenVenta.getValueAt(i, 0).toString());
                int cantidad = Integer.parseInt(TablaResumenVenta.getValueAt(i, 3).toString());
                double PrecioVenta = Double.parseDouble(TablaResumenVenta.getValueAt(i,2).toString());
                
                psDetalle.setInt(1,idProducto);
                psDetalle.setInt(2,cantidad);
                psDetalle.setDouble(3,PrecioVenta);
                psDetalle.executeUpdate();
                
                psStock.setInt(1,cantidad);
                psStock.setInt(2,idProducto);
                psStock.executeUpdate();
                
 
            }
            
            JOptionPane.showMessageDialog(null, "Venta Realizada");

        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "No Se Realizo la Venta "+e.toString());
        } finally {
        objetoConexion.cerrarConexion();
        }

    }

    
    
     public  void limpiarCamposLuegoVenta(JTextField buscarCliente,JTable TablaCliente,
             JTextField buscarPorducto, JTable tablaProducto,
             JTextField selecIdCliente,
             JTextField SELEC){
         
         
         
     }
}
