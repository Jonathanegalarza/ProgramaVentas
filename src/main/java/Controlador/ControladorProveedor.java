/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruben
 */
public class ControladorProveedor {

    public void MostrarProveedor(JTable tablaTotalProveedores) {

        Configuracion.CConexion ObjetoConexion = new Configuracion.CConexion();

        Modelo.modeloProveedor objetoProveedor = new Modelo.modeloProveedor();

        DefaultTableModel modelo = new DefaultTableModel();

        String sql = "";

        modelo.addColumn("IdProveedor");
        modelo.addColumn("Nombre");
        modelo.addColumn("Cuit");
        modelo.addColumn("Direccion");
        modelo.addColumn("Localidad");
        modelo.addColumn("Email");
        modelo.addColumn("Telefono");
        modelo.addColumn("UfechaModificacion");

        tablaTotalProveedores.setModel(modelo);
        sql = "select Proveedor.IdProveedor,Proveedor.Nombre,Proveedor.Cuit,Proveedor.Direccion,Proveedor.Localidad,Proveedor.Email,"
                + "Proveedor.Telefono,Proveedor.UfechaModificacion from Proveedor;";

        try {
            Statement st = ObjetoConexion.estableceConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                objetoProveedor.setIdProveedor(rs.getInt("IdProveedor"));
                objetoProveedor.setNombre(rs.getString("Nombre"));
                objetoProveedor.setCuit(rs.getString("Cuit"));
                objetoProveedor.setDireccion(rs.getString("Direccion"));
                objetoProveedor.setLocalidad(rs.getString("Localidad"));
                objetoProveedor.setTelefono(rs.getString("Telefono"));
                objetoProveedor.setEmail(rs.getString("Email"));
                objetoProveedor.setUfechaModificacion(rs.getString("UfechaModificacion"));
                modelo.addRow(new Object[]{
                    objetoProveedor.getIdProveedor(),
                    objetoProveedor.getNombre(),
                    objetoProveedor.getCuit(),
                    objetoProveedor.getDireccion(),
                    objetoProveedor.getLocalidad(),
                    objetoProveedor.getTelefono(),
                    objetoProveedor.getEmail(),
                    objetoProveedor.getUfechaModificacion(),});
            }
            tablaTotalProveedores.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar Proveedor" + e.toString());
        } finally {
            ObjetoConexion.cerrarConexion();
        }

    }

    public void AgregarProveedor(JTextField Nombre,
            JTextField Cuit,
            JTextField Telefono,
            JTextField Direccion,
            JTextField Localidad,
            JTextField Email,
            JTextField Observaciones) {

        Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
        Modelo.modeloProveedor objeProveedor = new Modelo.modeloProveedor();

        String consulta = "insert into Proveedor (Nombre,Cuit,Telefono,Direccion,Localidad,Email,Observaciones)value(?,?,?,?,?,?,?)";

        try {
            objeProveedor.setNombre(Nombre.getText());
            objeProveedor.setCuit(Cuit.getText());
            objeProveedor.setTelefono(Telefono.getText());
            objeProveedor.setDireccion(Direccion.getText());
            objeProveedor.setLocalidad(Localidad.getText());
            objeProveedor.setEmail(Email.getText());
            objeProveedor.setObservaciones(Observaciones.getText());

            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);

            cs.setString(1, objeProveedor.getNombre());
            cs.setString(2, objeProveedor.getCuit());
            cs.setString(3, objeProveedor.getTelefono());
            cs.setString(4, objeProveedor.getDireccion());
            cs.setString(5, objeProveedor.getLocalidad());
            cs.setString(6, objeProveedor.getEmail());
            cs.setString(7, objeProveedor.getObservaciones());

            cs.execute();

            JOptionPane.showMessageDialog(null, "Guardado Exitoso");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Fallo de Guardado " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }

    }

    public void Seleccionar(JTable tablaTotalProveedores, JTextField id, JTextField Nombre,
            JTextField Cuit,
            JTextField Telefono,
            JTextField Direccion,
            JTextField Localidad,
            JTextField Email,
            JTextField Observaciones) {

        int fila = tablaTotalProveedores.getSelectedRow(); //gurada la fila seleccionada

        try {
            if (fila > 0) {
                id.setText(tablaTotalProveedores.getValueAt(fila, 0).toString());
                Nombre.setText(tablaTotalProveedores.getValueAt(fila, 1).toString());
                Cuit.setText(tablaTotalProveedores.getValueAt(fila, 2).toString());
                Telefono.setText(tablaTotalProveedores.getValueAt(fila, 3).toString());
                Direccion.setText(tablaTotalProveedores.getValueAt(fila, 4).toString());
                Localidad.setText(tablaTotalProveedores.getValueAt(fila, 5).toString());
                Email.setText(tablaTotalProveedores.getValueAt(fila, 6).toString());
                Observaciones.setText(tablaTotalProveedores.getValueAt(fila, 7).toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No se pudo Seleccionar"+e.toString());
        }

    }
    public void BuscarProveedor(JTextField Nombre, JTable tablaProveedor) {
        Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
        Modelo.modeloProveedor objetoProveedor = new Modelo.modeloProveedor();

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("IdProveedor");
        modelo.addColumn("Nombre");
        

        tablaProveedor.setModel(modelo);

        try {
            String consulta = "SELECT * FROM facturar.proveedor WHERE proveedor.Nombre like concat('%',? ,'%')";
            PreparedStatement ps = objetoConexion.estableceConexion().prepareStatement(consulta);
            ps.setString(1,Nombre.getText() );
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objetoProveedor.setIdProveedor(rs.getInt("idProveedor"));
                objetoProveedor.setNombre(rs.getString("Nombre"));
                
                modelo.addRow(new Object[]{
                    objetoProveedor.getIdProveedor(),
                    objetoProveedor.getNombre()});

            }
            tablaProveedor.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede cargar Lista" + e.toString());

        } finally {
            objetoConexion.cerrarConexion();
        }
        for (int column = 0; column < tablaProveedor.getColumnCount(); column++) {
            Class<?> ColumClass = tablaProveedor.getColumnClass(column);
            tablaProveedor.setDefaultEditor(ColumClass, null);

        }
    }


}
