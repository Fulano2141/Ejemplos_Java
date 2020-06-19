import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Consulta 
{
 public static String datos() 
 {
  String codigo, descripcion, precio, stock;
  Conexion conexion = new Conexion();
  ResultSet resultado;
  resultado = conexion.getQuery("SELECT * FROM PRODUCTOS");
  String cad="-----------------------------------------------------------------------------\n";
  try 
  {
   cad+=" Codigo \t Descripción \t Precio \t Stock \n\n";
   cad+="-----------------------------------------------------------------------------\n";
   while (resultado.next()) 
   {
    codigo = resultado.getString("codigo");
    descripcion = resultado.getString("descripcion");
    precio = resultado.getString("precio_unitario");
    stock = resultado.getString("stock");
    
    cad+=" "+codigo +"\t"+descripcion+"\t"+precio+"\t"+stock+"\n";
   }
   cad+="-----------------------------------------------------------------------------\n";
   return cad;
   
  } catch (SQLException e) 
  {
   e.printStackTrace();
  }
  return null;
 }
}
