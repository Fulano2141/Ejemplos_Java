
package Ejercicio2;
import java.sql.SQLException;  
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.Connection;

public class InterfazConexion{
 public static String verificar() 
 {
  String cad = "";
  Conexion con = new Conexion();
  Connection conexion = con.getConexionMYSQL();
  if (conexion == null)
  {
   System.out.println("ERROR");
   cad= "ERROR";
   return cad;
  }else
  {
   try 
   {
    System.out.println("¡Conexión con la Base de Datos CORRECTA!");
    conexion.close();
    cad = "CORRECTA";
    return cad;
   } catch (SQLException ex) 
   {
    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null, ex);
   }
  }
  return cad;
 }
 
}