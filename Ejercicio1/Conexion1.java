package Ejercicio1;
import java.sql.DriverManager;      
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
public class Conexion1{
	private String usuario = "root";
	private String pass = "";
	private String host = "localhost";	
	private String nombre_BD = "ejercicio1";
	private Connection con = null;
	public Connection getConexionMYSQL(){
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String servidor = "jdbc:mysql://" + host + "/" + nombre_BD;
			con = (Connection) DriverManager.getConnection(servidor, usuario, pass);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			return con;
		}
	}
	public ResultSet getQuery(String _query) {
		Statement state = null;
		ResultSet resultado = null;
		try{
			Conexion1 con = new Conexion1();
			Connection conexion = con.getConexionMYSQL();   
			state = (Statement) conexion.createStatement();
			resultado = state.executeQuery(_query); 	  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	public void setQuery(String _query){
	    Statement state = null;
	    try{   
	      state=(Statement) con.createStatement();
	      state.execute(_query);
	    }catch (SQLException e){
	      e.printStackTrace();
	    }
	 }
}

