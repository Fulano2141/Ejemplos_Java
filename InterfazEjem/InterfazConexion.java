import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.Connection;

public class InterfazConexion
{
 public static String verificar() 
 {
  String cad = null;
  Conexion con = new Conexion();
  Connection conexion = con.getConexionMYSQL();
  if (conexion == null)
  {
   System.out.println("ERROR: 2018 en la conexi�n con la Base de Datos");
   cad= "ERROR: 2018 en la conexi�n con la Base de Datos";
   return cad;
  }else
  {
   try 
   {
    System.out.println("�Conexi�n con la Base de Datos CORRECTA!");
    conexion.close();
    cad = "�Conexi�n con la Base de Datos CORRECTA!";
    return cad;
   } catch (SQLException ex) 
   {
    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null, ex);
   }
  }
  return cad;
 }
 
}