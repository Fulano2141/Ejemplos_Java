import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
public class Conexion {
	private String Usuario ="root";
	private String pass ="";
	private String host ="localhost";
	private String nombre_BD ="supermercado";
	private Connection con =null;
	public Connection getConexionMYSQL() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance( );
			String servidor = "jdbc:mysql://"+host+"/"+nombre_BD;
			con = (Connection)DriverManager.getConnection(servidor, Usuario, pass);
			return con;
		}catch(Exception e) {
			e.printStackTrace();
			return con;
		}		
	}
	public ResultSet getQuery(String query) {
		Statement state=null;
		ResultSet resultado=null;
		try {
			state=(Statement)con.createStatement();
			resultado = state.executeQuery(query);
		}catch(SQLException e) {
			e.printStackTrace();
			}
	
	return resultado;
	}
}
