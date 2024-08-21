/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Configuracion.CConexion;
import java.sql.CallableStatement;
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
public class ControladorCliente {

    public void MostrarClienteS(JTable tablaTotalClientes) {

        Configuracion.CConexion ObjetoConexion = new Configuracion.CConexion();

        Modelo.modeloCliente objetoCliente = new Modelo.modeloCliente();

        DefaultTableModel modelo = new DefaultTableModel();

        String sql = "";

        modelo.addColumn("IdCliente");
        modelo.addColumn("Nombre");
        modelo.addColumn("Dni");
        modelo.addColumn("Direccion");
        modelo.addColumn("Localidad");
        modelo.addColumn("Telefono");
        modelo.addColumn("Email");
        modelo.addColumn("UfechaModificacion");

        tablaTotalClientes.setModel(modelo);
        sql = "select cliente.idCliente,cliente.Nombre,cliente.Dni,cliente.Direccion,cliente.Localidad,cliente.Telefono,"
                + "cliente.Email,cliente.UfechaModificacion from cliente;";

        try {
            Statement st = ObjetoConexion.estableceConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                objetoCliente.setIdCliente(rs.getInt("IdCliente"));
                objetoCliente.setNombre(rs.getString("Nombre"));
                objetoCliente.setDni(rs.getString("Dni"));
                objetoCliente.setDireccion(rs.getString("Direccion"));
                objetoCliente.setLocalidad(rs.getString("Localidad"));
                objetoCliente.setTelefono(rs.getString("Telefono"));
                objetoCliente.setEmail(rs.getString("Email"));
                objetoCliente.setUfechaModificacion(rs.getString("UfechaModificacion"));

                modelo.addRow(new Object[]{
                    objetoCliente.getIdCliente(),
                    objetoCliente.getNombre(),
                    objetoCliente.getDni(),
                    objetoCliente.getDireccion(),
                    objetoCliente.getLocalidad(),
                    objetoCliente.getTelefono(),
                    objetoCliente.getEmail(),
                    objetoCliente.getUfechaModificacion(),});
            }
            tablaTotalClientes.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar Cliente" + e.toString());
        } finally {
            ObjetoConexion.cerrarConexion();
        }

    }

    public void AgregarCliente(JTextField Nombre,
            JTextField Dni,
            JTextField Telefono,
            JTextField Direccion,
            JTextField Localidad,
            JTextField Email,
            JTextField Observaciones
    ) {

        Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
        Modelo.modeloCliente objeCliente = new Modelo.modeloCliente();

        String consulta = "insert into cliente (Nombre,Dni,Telefono,Direccion,Localidad,Email,Observaciones)value(?,?,?,?,?,?,?)";

        try {
            objeCliente.setNombre(Nombre.getText());
            objeCliente.setDni(Dni.getText());
            objeCliente.setTelefono(Telefono.getText());
            objeCliente.setDireccion(Direccion.getText());
            objeCliente.setLocalidad(Localidad.getText());
            objeCliente.setEmail(Email.getText());
            objeCliente.setObservaciones(Observaciones.getText());

            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);

            cs.setString(1, objeCliente.getNombre());
            cs.setString(2, objeCliente.getDni());
            cs.setString(3, objeCliente.getTelefono());
            cs.setString(4, objeCliente.getDireccion());
            cs.setString(5, objeCliente.getLocalidad());
            cs.setString(6, objeCliente.getEmail());
            cs.setString(7, objeCliente.getObservaciones());

            cs.execute();

            JOptionPane.showMessageDialog(null, "Guardado Exitoso");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Fallo de Guardado " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }

    }

    public void Seleccionar(JTable tablaTotaltbclientes,
            JTextField id,
            JTextField Nombre,
            JTextField Dni,
            JTextField Telefono,
            JTextField Direccion,
            JTextField Localidad,
            JTextField Email,
            JTextField UfechaModificacion,
            JTextField Observaciones) {

        int fila = tablaTotaltbclientes.getSelectedRow(); //guarda la fila seleccionada

        try {
            if (fila > 0) {
                id.setText(tablaTotaltbclientes.getValueAt(fila, 0).toString());
                Nombre.setText(tablaTotaltbclientes.getValueAt(fila, 1).toString());
                Dni.setText(tablaTotaltbclientes.getValueAt(fila, 2).toString());
                Direccion.setText(tablaTotaltbclientes.getValueAt(fila, 4).toString());
                Localidad.setText(tablaTotaltbclientes.getValueAt(fila, 5).toString());
                Telefono.setText(tablaTotaltbclientes.getValueAt(fila, 3).toString());
                UfechaModificacion.setText(tablaTotaltbclientes.getValueAt(fila, 7).toString());
                Email.setText(tablaTotaltbclientes.getValueAt(fila, 6).toString());
                Observaciones.setText(tablaTotaltbclientes.getValueAt(fila, 8).toString());

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo Seleccionar" + e.toString());
        }

    }

    public void modificarCliente(JTextField id,
            JTextField Nombre,
            JTextField Dni,
            JTextField Telefono,
            JTextField Direccion,
            JTextField Localidad,
            JTextField Email,
            JTextField UfechaModificacion,
            JTextField Observaciones
    ) {

        Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
        Modelo.modeloCliente objeCliente = new Modelo.modeloCliente();

        String consulta = "UPDATE `facturar`.`cliente`"
                + " SET `Nombre` = ?,"
                + " `Dni` = ?,"
                + " `Telefono` = ?,"
                + " `Direccion` = ?,"
                + " `Localidad` = ? ,"
                + " `Email` = ?,"
                + " `Observaciones` = ?,"
                + " `PersAutorizadas` = ?,"
                + " `LimiteCompra` = ?"
                + " WHERE (`idCliente` = ?); ";

        try {
            objeCliente.setIdCliente(Integer.parseInt(id.getText()));
            objeCliente.setNombre(Nombre.getText());
            objeCliente.setDni(Dni.getText());
            objeCliente.setTelefono(Telefono.getText());
            objeCliente.setDireccion(Direccion.getText());
            objeCliente.setLocalidad(Localidad.getText());
            objeCliente.setEmail(Email.getText());
            objeCliente.setObservaciones(Observaciones.getText());

            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);

            cs.setString(1, objeCliente.getNombre());
            cs.setString(2, objeCliente.getDni());
            cs.setString(3, objeCliente.getTelefono());
            cs.setString(4, objeCliente.getDireccion());
            cs.setString(5, objeCliente.getLocalidad());
            cs.setString(6, objeCliente.getEmail());
            cs.setString(7, objeCliente.getObservaciones());
            cs.setInt(8, objeCliente.getIdCliente());

            cs.execute();
            JOptionPane.showMessageDialog(null, "Se a Modificado Correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo Modificarr" + e.toString());
        } finally {

            objetoConexion.cerrarConexion();
        }

    }

    public void LimpiarCamposClientes(JTextField id,
            JTextField Nombre,
            JTextField Dni,
            JTextField Telefono,
            JTextField Direccion,
            JTextField Localidad,
            JTextField Email,
            JTextField UfechaModificacion,
            JTextField Observaciones
    ) {

        id.setText("");
        Nombre.setText("");
        Dni.setText("");
        Telefono.setText("");
        Direccion.setText("");
        Localidad.setText("");
        Email.setText("");
        UfechaModificacion.setText("");
        Observaciones.setText("");

    }

    public void EliminarCliente(JTextField id) {

        Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
        Modelo.modeloCliente objeCliente = new Modelo.modeloCliente();

        String consulta = "delete from cliente where cliente.idCliente = ?;";

        try {
            objeCliente.setIdCliente(Integer.parseInt(id.getText()));
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            cs.setInt(1, objeCliente.getIdCliente());
            cs.execute();

            JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Se ha eliminado" + e.toString());

        } finally {
            objetoConexion.cerrarConexion();

        }

    }

}
