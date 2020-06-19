package Ejercicio1;
import java.sql.SQLException;   
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mysql.jdbc.Connection;
public class InterfazConexion{
	public static String verificar() {
		String cad = "";
		Conexion1 con = new Conexion1();
		Connection conexion = con.getConexionMYSQL();
		if (conexion == null){
			System.out.println("ERROR");
			cad= "ERROR";
			return cad;
  }else
  {
   try 
   {

    conexion.close();
    cad = "CORRECTA";
    return cad;
   } catch (SQLException ex) 
   {
    Logger.getLogger(Conexion1.class.getName()).log(Level.SEVERE,null, ex);
   }
  }
  return cad;
 }
 
}