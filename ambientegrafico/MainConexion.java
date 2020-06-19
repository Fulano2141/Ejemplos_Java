import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.Connection;
public class MainConexion {
	public static void main(String[] args) {
		Conexion con =new Conexion();
		Connection Conexion = con.getConexionMYSQL();
		if(Conexion == null) 
			System.out.println("Error");
		else {			
				try {
					Conexion.close();
					System.out.println("Conexion correcta");
				} catch (SQLException ex) {
					Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null, ex);
				}
			
		}
	}
}
