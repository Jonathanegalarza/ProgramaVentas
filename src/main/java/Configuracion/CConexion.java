/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Ruben
 */
public class CConexion {

    Connection conectar = null;

    String usuario = "root";
    String contrasenia = "root";
    String bd = "facturar";
    String ip = "localhost";
    String puerto = "3307";

    String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + bd;

    public Connection estableceConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena, usuario, contrasenia);
            JOptionPane.showMessageDialog(null, "Conexion Correcta");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Conexion Fallida" + e.toString());

        }
        return conectar;

    }

    public void cerrarConexion() {

        try {
            if (conectar != null && !conectar.isClosed()) {
                conectar.close();
                JOptionPane.showMessageDialog(null, "Fin de la Conexion");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Conexion Activa"+e.toString());
        }

    }
}
