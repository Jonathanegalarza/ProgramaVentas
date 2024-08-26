/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package respaldo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Ruben
 */
public class Respaldo {
        private static Respaldo instanciaBackup;
    
    //Creamos el método para generar la copia
    public void crearBackup() throws IOException{ //puede llamarse crearRespaldo()
        Process proceso = Runtime.getRuntime().exec("C:\\xampp\\mysql\\bin\\mysqldump -u root -proot rubenventas"); //aqui pones tu ruta de Mysql , usuario y password
        InputStream entrada = proceso.getInputStream();
            try (FileOutputStream archivo = new FileOutputStream("RespaldoBD_rubenventas.sql")) {
                byte[] buffer = new byte[1000];
                int byteLeido = entrada.read(buffer);
                
                while(byteLeido > 0){
                    archivo.write(buffer,0, byteLeido);
                    byteLeido = entrada.read(buffer);
                }   }
    }
    
    
    public static Respaldo getInstance(){
        if(instanciaBackup == null){
            instanciaBackup = new Respaldo();
        }
        return instanciaBackup;
    }
}
