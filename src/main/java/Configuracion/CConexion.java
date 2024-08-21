
package Configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Ruben
 */
public class CConexion {

    Connection conectar = null;

    String usuario = "root";
    String contrasenia = "root";
    String bd = "rubenventas";
    String ip = "localhost";
    String puerto = "3307";

    String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + bd;

    public Connection estableceConexion() {
        try {
            // Conectar sin especificar la base de datos
            String cadenaSinBD = "jdbc:mysql://" + ip + ":" + puerto + "/";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(cadenaSinBD, usuario, contrasenia);

            // Verificar si la base de datos existe y crearla si no
            Statement stmt = conectar.createStatement();
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + bd);
            stmt.close();

            // Ahora conectar a la base de datos específica
            conectar.close();  // Cerrar la conexión sin la base de datos
            conectar = DriverManager.getConnection(cadena, usuario, contrasenia);
            //JOptionPane.showMessageDialog(null, "Conexion Correcta");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Conexion Fallida: " + e.toString());
        }
        return conectar;

    }

    public void cerrarConexion() {

        try {
            if (conectar != null && !conectar.isClosed()) {
                conectar.close();
               // JOptionPane.showMessageDialog(null, "Fin de la Conexion");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Conexion Activa"+e.toString());
        }

    }
}
