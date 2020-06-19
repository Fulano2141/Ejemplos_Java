package Ejercicio1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
public class Azar {
	public static void main (String[] args) throws IOException{
		for(;;){
			String []menu = {"Generar numeros","Reporte","Salir"};
			String valor= (String) JOptionPane.showInputDialog(null, "Seleccione la opcion:","Numeros", JOptionPane.DEFAULT_OPTION,null,menu,menu);
			switch (valor){
			case "Generar numeros": crear();break;
			case "Reporte": leer();break;
			case "Salir": System.exit(0);
			}
		}
	 }
	 public static void crear() throws IOException{
	  try{
	  FileWriter fichero=new FileWriter("EjerAzar.txt");
	  PrintWriter pw=new PrintWriter(fichero);
	  int n=(int)(Math.random()*99)+1;
	  for(int i=0;i<n;i++){
		  int sal=(int)(Math.random()*9000)+1000;
		  pw.println(sal);
	  	}
	  JOptionPane.showMessageDialog(null, "Numeros generados!");
	  fichero.close();
	  	}
	  catch(Exception e){
		  JOptionPane.showMessageDialog(null,"Hubo un error al crear el archivo de tipo: "+e);
	  }
	 }
	 public static void leer() throws IOException{
	  try {
	  BufferedReader in=new BufferedReader(new FileReader("EjerAzar.txt"));
	  String nom="",aux="";
	  for(;(nom=in.readLine())!=null;){
		  if(par(nom))
			  aux+=nom+"\n";
		  else
			  continue;
	  }
	  JTextArea area=new JTextArea();
	  area.setText(aux);
	  JOptionPane.showMessageDialog(null, area,"Numeros generados",JOptionPane.PLAIN_MESSAGE);
	  in.close();}
	  catch(Exception e) 
	  {
	   JOptionPane.showMessageDialog(null,"No se encontro el archivo: "+e);
	  }
	 }
	public static boolean par(String nom) {
		int num=Integer.parseInt(nom);
		num=num/1000;
		if(num%2==0)
			return true;
		else
			return false;
	}
}
