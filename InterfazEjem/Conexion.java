import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Conexion 
{
 private String usuario = "root";
 private String pass = "";
 private String host = "localhost";
 private String nombre_BD = "supermercado";
 private Connection con = null;
 
 public Connection getConexionMYSQL()
 {
  try 
  {
   Class.forName("com.mysql.jdbc.Driver").newInstance();
   String servidor = "jdbc:mysql://" + host + "/" + nombre_BD;
   con = (Connection) DriverManager.getConnection(servidor, usuario, pass);
   return con;
  } catch (Exception e) 
  {
   e.printStackTrace();
   return con;
  }
 }

 public ResultSet getQuery(String _query) 
 {
  Statement state = null;
  ResultSet resultado = null;
  try 
  {
   Conexion con = new Conexion();
   Connection conexion = con.getConexionMYSQL();
   
   state = (Statement) conexion.createStatement();
   resultado = state.executeQuery(_query);
   
  } catch (SQLException e) 
  {
   e.printStackTrace();
  }
  return resultado;
 }
}

