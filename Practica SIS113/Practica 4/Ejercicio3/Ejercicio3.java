/*3.-  Escribir un programa que contenga funciones para:  
	-Crear un archivo de texto que tenga los correos electronicos de varias personas.
	-Leer este archivo y mostrar a los que tienen correo en gmail (verificar si el 
	 archivo existe)
	-Efectuar la b√∫squeda de un correo electr√≥nico en particular y verificar si est√° 
	 o no en el archivo
	-Determinar el porcentaje de correos que pertenecen a  un determinado servidor 
	 de correos que el usuario ingrese  (hotmail,gmail, yahoo,etc).
 */
package Ejercicio3;
import java.io.*;
import javax.swing.*;
public class Ejercicio3 {
	public static void main(String[] args) throws Exception{
		for(;true;){
			String [] menu1= {"AÒadir correo","Leer Archivo","Buscar correo","Estadisticas","Leer Todo el archivo","Salir"};
			String valor1=(String) JOptionPane.showInputDialog(null,"Seleccione la opcion","Opciones",JOptionPane.DEFAULT_OPTION,null,menu1,menu1[0]);
			switch(valor1){
			case "AÒadir correo":adicion();break;
			case "Leer Archivo":reporte(1);break;
			case "Buscar correo": buscar();break;
			case "Estadisticas":porcentaje();break;
			case "Leer Todo el archivo": reporte(2);break;
			case "Salir": System.exit(0);break;
			}
		}
	}
	public static void reporte(int i) throws Exception{
		try{
			String aux="",cad="Correos\n";
			BufferedReader in=new BufferedReader(new FileReader("Ejer3.txt"));
			if (i==1) {
				String gma="gmail.com";
				while(in.ready()){
					aux=in.readLine();
					String[] part=aux.split("@");
					if(gma.equals(part[1]))
						cad=cad+aux+"\n";
					else 
						continue;
			   }
		   		}
			   else {
				   while(in.ready()){
					   aux=in.readLine();
					   cad=cad+aux+"\n";
				   }
		   		}
			   	in.close();
		   		JTextArea area=new JTextArea();
		   		area.setText(cad);
		   		JOptionPane.showMessageDialog(null,area);
		   }
		   catch (IOException e){
		    JOptionPane.showMessageDialog(null,"No existe Archivo");
		   }
		}
	public static void adicion() throws IOException{
		   try{
			   PrintWriter out=new PrintWriter(new FileWriter("Ejer3.txt",true));
			   int n=Integer.parseInt(JOptionPane.showInputDialog(null,"Cuantos correos desea agregar: "));
			   for(int i=0;i<n;i++){
				   String cor=JOptionPane.showInputDialog(null,"correo "+(i+1)+":");
				   out.println(cor);
			   }
		   out.close();
		   }
		   catch (IOException e){
		    JOptionPane.showMessageDialog(null,"Dato Invalido");
		   }
	}
	public static void buscar() throws IOException{
		try{
			   BufferedReader in=new BufferedReader(new FileReader("Ejer3.txt"));
			   String CIb=JOptionPane.showInputDialog(null,"Correo a buscar:");
			   String aux;
			   boolean i=false;
			   while(in.ready()){
				   aux=in.readLine();
				   if(CIb.equals(aux)){
					   i=true;
			   		}else
					   continue;
			   }
			   if(i)
				   JOptionPane.showMessageDialog(null,"Correo Encontrado");
			   else
				   JOptionPane.showMessageDialog(null,"Correo no Encontrado");
			   in.close();
		   	}
		   catch (IOException e){
		    JOptionPane.showMessageDialog(null,"Error IO");
		   }
	}
	 public static void porcentaje() throws IOException{
	   try{
		   BufferedReader in=new BufferedReader(new FileReader("Ejer3.txt"));
		   String aux="",ax="Porcentajes:\n";
		   int c=0,gmail=0,hotmail=0,yahoo=0,otros=0;
		   while(in.ready()){
			   aux=in.readLine();
			   String[] part=aux.split("@");
			   switch(part[1]) {
			   case "gmail.com":gmail++;c++;break;
			   case "hotmail.com":hotmail++;c++;break;
			   case "yahoo.com":yahoo++;c++;break;
			   default: c++;otros++;break;
			   }
		   }
		   ax=ax+"Gmail: "+(gmail*100/c)+"%"+"\nHotmail: "+(hotmail*100/c)+"%"+"\nYahoo: "+(yahoo*100/c)+"%"+"\nOtros: "+(otros*100/c)+"%";
		   in.close();
	   		JTextArea area=new JTextArea();
	   		area.setText(ax);
	   		JOptionPane.showMessageDialog(null,area);
	   }
	   catch (IOException e){
	    JOptionPane.showMessageDialog(null,"Error IO");
	   }
	  }
}
