/* 5.-  Un archivo de texto contiene los datos de los productos que se venden en un supermercado:
		- Código del producto
		- Nombre 
		- Precio unitario de venta
		- Stock
		- Fecha de vencimiento
Se debe realizar funciones que añadan nuevos productos, también se debe obtener el siguiente reporte de todos los productos
Y también un reporte de los productos que han vencido (fecha de vencimiento expirada). 
 */
package Ejercicio5;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
public class Ejercicio5 {
	public static void main (String[] args) throws IOException{
		for(;;){
			String []menu = {"Almacenar datos","Reporte de todos los productos","Clasificar productos vencidos","Ver productos vencidos","Salir"};
			String valor= (String) JOptionPane.showInputDialog(null, "Seleccione la opcion:","Productos", JOptionPane.DEFAULT_OPTION,null,menu,menu);
			switch (valor){
			case "Almacenar datos": crear();break;
		    case "Reporte de todos los productos": leer("productos.txt");break;
		    case "Clasificar productos vencidos": Fecha();break;
		    case "Ver productos vencidos":leer("vencidos.txt");break;
		    case "Salir": System.exit(0);
		    }
		}
	}
	public static void Fecha()throws IOException {
		try {
			BufferedReader in=new BufferedReader(new FileReader("productos.txt"));
			FileWriter fichero=new FileWriter("vencidos.txt");
			PrintWriter pw=new PrintWriter(fichero);
			String nom="",aux="";
			Calendar c = new GregorianCalendar();
			String dia = (Integer.toString(c.get(Calendar.DATE)));
			String mes = (Integer.toString(c.get(Calendar.MONTH)));
			String annio =(Integer.toString(c.get(Calendar.YEAR)));
			String FA=dia+"/"+mes+"/"+annio;
			SimpleDateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
			Date fechaInicial=dateFormat.parse(FA);
			for(;(nom=in.readLine())!=null;){
				String[] parts = nom.split(";");
				String fecha=parts[4];
				Date fechaFinal=dateFormat.parse(fecha);
				int dias=(int) ((fechaFinal.getTime()-fechaInicial.getTime())/86400000);
				if(dias<=0)
					aux=aux+nom+"\n";
			}
			pw.println(aux);
			in.close();
			fichero.close();
			JOptionPane.showMessageDialog(null,"Productos vencidos clasificados");
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"No se encontro el archivo: "+e);
		}
	}
	public static void crear() throws IOException{
		try {
			FileWriter fichero=new FileWriter("productos.txt",true);
			PrintWriter pw=new PrintWriter(fichero);
			String aux="";
			int n=Integer.parseInt(JOptionPane.showInputDialog(null,"Cuantos productos desea agregar?:"));
			for(int i=0;i<n;i++){
				String CI=JOptionPane.showInputDialog(null,"Ingrese el codigo del producto");
				String Nom=JOptionPane.showInputDialog(null,"Ingrese el nombre del producto");
				String Pu=JOptionPane.showInputDialog(null,"Ingrese el precio unitario");
				String St=JOptionPane.showInputDialog(null,"Ingrese el numero de items");
				String Fv=JOptionPane.showInputDialog(null,"Ingrese la fecha de vencimiento del producto");
				aux=CI+";"+Nom+";"+Pu+";"+St+";"+Fv+"\n";
				pw.println(aux);
			}
		  fichero.close();
		  }
		  catch(Exception e){
		   JOptionPane.showMessageDialog(null,"Hubo un error al crear el archivo de tipo: "+e);
		  }
		 }
	public static void leer(String i) throws IOException{
		try {
			BufferedReader in=new BufferedReader(new FileReader(i));
			String nom="",aux="Codigo\tNombre\tPrecio Unitario\tStock\tPrecio Total\n";
			aux=aux+"-----------------------------------------\n";
			double total=0, punitotal=0;
			for(;(nom=in.readLine())!=null;){
				String ds=nom;
				String[] parts = ds.split(";");
				punitotal=Integer.parseInt(parts[3])*Double.parseDouble(parts[2]);
				aux=aux+parts[0]+"\t"+parts[1]+"\t"+parts[2]+"\t"+parts[3]+"\t"+punitotal+"\n";
				total=total+punitotal;
			}
			aux=aux+"-----------------------------------------\n"+"total\t\t"+total;
			JTextArea area=new JTextArea();
			area.setText(aux);
			JOptionPane.showMessageDialog(null, area);
			in.close();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"No se encontro el archivo: "+e);
		}
	}
}