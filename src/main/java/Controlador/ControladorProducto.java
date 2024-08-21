/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.awt.HeadlessException;
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
public class ControladorProducto {

    public void MostrarPorductos(JTable tablaTotalProducto) {

        Configuracion.CConexion ObjetoConexion = new Configuracion.CConexion();

        Modelo.modeloProducto objetoProducto = new Modelo.modeloProducto();

        DefaultTableModel modelo = new DefaultTableModel();

        String sql = "";

        modelo.addColumn("IdProducto");
        modelo.addColumn("Producto");
        modelo.addColumn("Neto");
        modelo.addColumn("Iva");
        modelo.addColumn("PrecioProducto");
        modelo.addColumn("Stock");
        modelo.addColumn("UltimaModificacion");

        tablaTotalProducto.setModel(modelo);
        sql = "SELECT producto.idProducto,producto.Producto,producto.Neto,producto.Iva,producto.PrecioProducto,producto.Stock,producto.UltimaModificacion from producto;";

        try {
            Statement st = ObjetoConexion.estableceConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                objetoProducto.setIdProducto(rs.getInt("IdProducto"));
                objetoProducto.setProducto(rs.getString("Producto"));
                objetoProducto.setNeto(rs.getDouble("Neto"));
                objetoProducto.setIva(rs.getDouble("Iva"));
                objetoProducto.setPrecioProducto(rs.getDouble("PrecioProducto"));
                objetoProducto.setStock(rs.getInt("Stock"));
                objetoProducto.setUltimaModificacion(rs.getString("UltimaModificacion"));

                modelo.addRow(new Object[]{
                    objetoProducto.getIdProducto(),
                    objetoProducto.getProducto(),
                    objetoProducto.getNeto(),
                    objetoProducto.getIva(),
                    objetoProducto.getPrecioProducto(),
                    objetoProducto.getStock(),
                    objetoProducto.getUltimaModificacion(),});
            }
            tablaTotalProducto.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar Producto" + e.toString());
        } finally {
            ObjetoConexion.cerrarConexion();
        }

    }

    public void AgregarProducto(JTextField Producto,
            JTextField Neto,
            JTextField Iva,
            JTextField PrecioProducto,
            JTextField Stock,
            JTextField UltimaModificacion
    ) {

        Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
        Modelo.modeloProducto objeProducto = new Modelo.modeloProducto();

        String consulta = "insert into Producto (Producto,Neto,Iva,PrecioProducto,Stock)value(?,?,?,?,?)";

        try {
            objeProducto.setProducto(Producto.getText());
            objeProducto.setNeto(Double.valueOf(Neto.getText()));
            objeProducto.setIva(Double.valueOf(Iva.getText()));
            objeProducto.setPrecioProducto(Double.valueOf(PrecioProducto.getText()));
            objeProducto.setStock(Integer.parseInt(Stock.getText()));

            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);

            cs.setString(1, objeProducto.getProducto());
            cs.setDouble(2, objeProducto.getNeto());
            cs.setDouble(3, objeProducto.getIva());
            cs.setDouble(4, objeProducto.getPrecioProducto());
            cs.setInt(5, objeProducto.getStock());

            cs.execute();

            JOptionPane.showMessageDialog(null, "Guardado Exitoso");

        } catch (HeadlessException | NumberFormatException | SQLException e) {

            JOptionPane.showMessageDialog(null, "Fallo de Guardado " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }

    }

    public void Seleccionar(JTable tablaTotaltbProducto,
            JTextField id,
            JTextField Producto,
            JTextField Neto,
            JTextField Iva,
            JTextField PrecioProducto,
            JTextField Stock,
            JTextField UltimaModificacion) {

        int fila = tablaTotaltbProducto.getSelectedRow(); //guarda la fila seleccionada

        try {
            if (fila > 0) {
                id.setText(tablaTotaltbProducto.getValueAt(fila, 0).toString());
                Producto.setText(tablaTotaltbProducto.getValueAt(fila, 1).toString());
                Neto.setText(tablaTotaltbProducto.getValueAt(fila, 2).toString());
                Iva.setText(tablaTotaltbProducto.getValueAt(fila, 3).toString());
                PrecioProducto.setText(tablaTotaltbProducto.getValueAt(fila, 4).toString());
                Stock.setText(tablaTotaltbProducto.getValueAt(fila, 5).toString());
                UltimaModificacion.setText(tablaTotaltbProducto.getValueAt(fila, 6).toString());

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo Seleccionar" + e.toString());
        }

    }

    public void modificarProducto(JTextField id,
            JTextField Producto,
            JTextField Neto,
            JTextField Iva,
            JTextField PrecioProducto,
            JTextField Stock,
            JTextField UltimaModificacion
    ) {

        Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
        Modelo.modeloProducto objeProducto = new Modelo.modeloProducto();

        String consulta = "UPDATE `facturar`.`producto` SET"
                + " `Producto` = '?',"
                + " `Neto` = '?',"
                + " `Iva` = '?',"
                + " `PrecioProducto` = '?',"
                + " `Stock` = '?'"
                + " WHERE (`idProducto` = '?'); ";

        try {
            objeProducto.setIdProducto(Integer.parseInt(id.getText()));
            objeProducto.setProducto(Producto.getText());
            objeProducto.setNeto(Double.valueOf(Neto.getText()));
            objeProducto.setIva(Double.valueOf(Iva.getText()));
            objeProducto.setPrecioProducto(Double.valueOf(PrecioProducto.getText()));
            objeProducto.setStock(Integer.parseInt(Stock.getText()));

            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);

            cs.setString(1, objeProducto.getProducto());
            cs.setDouble(2, objeProducto.getNeto());
            cs.setDouble(3, objeProducto.getIva());
            cs.setDouble(4, objeProducto.getPrecioProducto());
            cs.setInt(5, objeProducto.getStock());
            cs.setInt(6, objeProducto.getIdProducto());
        

            cs.execute();
            JOptionPane.showMessageDialog(null, "Se a Modificado Correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo Modificarr" + e.toString());
        } finally {

            objetoConexion.cerrarConexion();
        }

    }
public void LimpiarCamposProductos(JTextField id,
            JTextField Producto,
            JTextField Neto,
            JTextField Iva,
            JTextField PrecioProducto,
            JTextField Stock,
            JTextField UltimaModificacion
    ) {

        id.setText("");
        Producto.setText("");
        Neto.setText("");
        Iva.setText("");
        PrecioProducto.setText("");
        Stock.setText("");
        UltimaModificacion.setText("");
        

    }

    public void EliminarProducto(JTextField id) {

        Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
        Modelo.modeloProducto objeproProducto = new Modelo.modeloProducto();

        String consulta = "delete from producto where producto.idProducto = ?;";

        try {
            objeproProducto.setIdProducto(Integer.parseInt(id.getText()));
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            cs.setInt(1, objeproProducto.getIdProducto());
            cs.execute();

            JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Se ha eliminado" + e.toString());

        } finally {
            objetoConexion.cerrarConexion();

        }

    }
}
