package Controlador;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ControladorPresupuesto {
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
                objetoProducto.getUltimaModificacion()
            });
        }
        tablaProductos.setModel(modelo);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "No se puede cargar la lista: " + e.toString());
    } finally {
        objetoConexion.cerrarConexion();
    }
    for (int column = 0; column < tablaProductos.getColumnCount(); column++) {
        Class<?> ColumClass = tablaProductos.getColumnClass(column);
        tablaProductos.setDefaultEditor(ColumClass, null);
    }
}


    public void SeleccionarProductoPresupuesto(JTable tablaProducto,
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
            JOptionPane.showMessageDialog(null, "Error de selección: " + e.toString());
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
            JOptionPane.showMessageDialog(null, "No se puede cargar la lista: " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
        for (int column = 0; column < tablaCliente.getColumnCount(); column++) {
            Class<?> ColumClass = tablaCliente.getColumnClass(column);
            tablaCliente.setDefaultEditor(ColumClass, null);
        }
    }

    public void SeleccionarClientePresupuesto(JTable tablaCliente,
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
            JOptionPane.showMessageDialog(null, "Error de selección: " + e.toString());
        }
    }

    public void PasarPruductosPresupuesto(JTable tablaResumen,
                                          JTextField id,
                                          JTextField Producto,
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
                JOptionPane.showMessageDialog(null, "El Producto ya está registrado");
                return;
            }
        }

        String nProducto = Producto.getText();
        Double PrecioUnitario = Double.valueOf(PrecioProducto.getText());
        int cantidad = Integer.parseInt(CantidadVentas.getText());
        if (cantidad > stockDisponible) {
            JOptionPane.showMessageDialog(null, "Ha superado el Stock disponible");
            return;
        }
        double subTotal = PrecioUnitario * cantidad;
        modelo.addRow(new Object[]{idProducto, nProducto, cantidad, subTotal});
    }

    public void EliminarProductosSelecionadosResumenPresupuesto(JTable tablaResumen) {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tablaResumen.getModel();
            int indiceSelecionado = tablaResumen.getSelectedRow(); // se toma el valor de la selección en la tablaResumen

            if (indiceSelecionado != -1) { // si hay un valor seleccionado, lo tomamos
                modelo.removeRow(indiceSelecionado); // una vez seleccionado se elimina
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona un Producto a eliminar de la lista");
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + e.toString());
        }
    }

    public void calcularTotalPresupuesto(JTable tablaResumen, JLabel IVA, JLabel TOTAL) {
        DefaultTableModel modelo = (DefaultTableModel) tablaResumen.getModel();
        double total = 0;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            total += (double) modelo.getValueAt(i, 3); // Sumar la columna del subTotal
        }
        double iva = total * 0.21;
        IVA.setText(new DecimalFormat("#.##").format(iva));
        TOTAL.setText(new DecimalFormat("#.##").format(total + iva));
    }

    public void realizarPresupuesto(JTable tablaResumen,
                                    JTextField IdPresupuesto,
                                    JTextField IdCliente,
                                    JTextField Fecha) {
        Configuracion.CConexion objetoConexion = new Configuracion.CConexion();

        // Paso 1: Insertar un nuevo presupuesto
        String sqlPresupuesto = "INSERT INTO presupuesto (idPresupuesto, idCliente, Fecha) VALUES (?, ?, ?)";
        try {
            PreparedStatement psPresupuesto = objetoConexion.estableceConexion().prepareStatement(sqlPresupuesto, PreparedStatement.RETURN_GENERATED_KEYS);
            psPresupuesto.setString(1, IdPresupuesto.getText());
            psPresupuesto.setString(2, IdCliente.getText());
            psPresupuesto.setString(3, Fecha.getText());

            int affectedRows = psPresupuesto.executeUpdate();

            if (affectedRows == 0) {
                throw new Exception("Error al crear el presupuesto, no se ha creado ninguna fila.");
            }

            // Paso 2: Obtener el id del presupuesto generado
            ResultSet generatedKeys = psPresupuesto.getGeneratedKeys();
            int idPresupuesto = 0;
            if (generatedKeys.next()) {
                idPresupuesto = generatedKeys.getInt(1);
            }

            // Paso 3: Insertar los detalles del presupuesto
            String sqlDetalle = "INSERT INTO detallePresupuesto (idPresupuesto, idProducto, cantidad, subTotal) VALUES (?, ?, ?, ?)";
            PreparedStatement psDetalle = objetoConexion.estableceConexion().prepareStatement(sqlDetalle);

            for (int i = 0; i < tablaResumen.getRowCount(); i++) {
                String idProducto = tablaResumen.getValueAt(i, 0).toString();
                int cantidad = Integer.parseInt(tablaResumen.getValueAt(i, 2).toString());
                double subTotal = Double.parseDouble(tablaResumen.getValueAt(i, 3).toString());

                psDetalle.setInt(1, idPresupuesto);
                psDetalle.setString(2, idProducto);
                psDetalle.setInt(3, cantidad);
                psDetalle.setDouble(4, subTotal);

                psDetalle.executeUpdate();
            }

            JOptionPane.showMessageDialog(null, "Presupuesto generado exitosamente.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al generar el presupuesto: " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }
}
