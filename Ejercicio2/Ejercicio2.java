/*2.-  Escribir un programa  para realizar lo siguiente:
 Un archivo de texto contiene la cedula, el apellido paterno y el nombre, 
 de un grupo de personas (emplear tokens para separar campos), realizar mediante funciones:
	-Lectura del archivo. 
	-Copiar a un segundo archivo los datos de las personas que tienen apellidos 
	 que comiencen con alguna letra que elija el usuario.
	-Añadir nuevos nombres al archivo.
	-Buscar a una persona por número de cedula y desplegar sus datos. */
package Ejercicio2;
import java.io.*;
import javax.swing.*;
public class Ejercicio2 {
	public static void main(String[] args) throws Exception{
		for(;true;){
			String [] menu1= {"Leer","Filtrar por apellido","Adicionar","Buscar","Leer Archivo Filtrado","Salir"};
			String valor1=(String) JOptionPane.showInputDialog(null,"Seleccione la opcion","Opciones",JOptionPane.DEFAULT_OPTION,null,menu1,menu1[0]);
			switch(valor1){
			case "Adicionar": adicion();break;
			case "Filtrar por apellido": porcentaje();break;
			case "Leer": reporte();break;
			case "Buscar":buscar();break;
			case "Leer Archivo Filtrado":reporte1();break;
			case "Salir": System.exit(0);break;
			}
		}
	}
	public static void buscar() throws IOException{
		try{
			   BufferedReader in=new BufferedReader(new FileReader("Ejer2.txt"));
			   String CIb=JOptionPane.showInputDialog(null,"Celula de Identidad a buscar:");
			   String aux;
			   boolean i=true;
			   while(in.ready()){
				   aux=in.readLine();
				   String[] part=aux.split(";");
				   if(CIb.equals(part[0])){
					   JOptionPane.showMessageDialog(null,"Celula\tApellido\tNombre\n"+part[0]+"\t"+part[1]+"\t"+part[2]);
					   i=false;
			   		}else
					   continue;
			   }
			   if(i)
				   JOptionPane.showMessageDialog(null,"Celula no Encontrada");				   
			   in.close();
		   	}
		   catch (IOException e){
		    JOptionPane.showMessageDialog(null,"Error IO");
		   }
	}
	public static void adicion() throws IOException{
	   try{
		   PrintWriter out=new PrintWriter(new FileWriter("Ejer2.txt",true));
		   int n=Integer.parseInt(JOptionPane.showInputDialog(null,"Cuantas personas: "));
		   for(int i=0;i<n;i++){
			   String CI=JOptionPane.showInputDialog(null,"Celula de Identidad:");
			   String ApPa=JOptionPane.showInputDialog(null,"Apellido Paterno:");
			   String Nom=JOptionPane.showInputDialog(null,"Nombre:");
			   String nom=CI+";"+ApPa+";"+Nom;
			   out.println(nom);
	   }
	   out.close();}
	   catch (IOException e){
	    JOptionPane.showMessageDialog(null,"Dato Invalido");
	   }
	  }
	public static void porcentaje() throws IOException{
	   try{
		   BufferedReader in=new BufferedReader(new FileReader("Ejer2.txt"));
		   PrintWriter out=new PrintWriter(new FileWriter("auxEjer2.txt"));
		   String Apa=JOptionPane.showInputDialog(null,"Letra a filtrar:");
		   String aux;
		   while(in.ready()){
			   aux=in.readLine();
			   String[] part=aux.split(";");
			   if((Apa.charAt(0))==(part[1].charAt(0)))
				   out.println(aux);
			   else
				   continue;
		   }
		   in.close();
		   out.close();
	   	}
	   catch (IOException e){
	    JOptionPane.showMessageDialog(null,"Error IO");
	   }
	  }
	public static void reporte() throws Exception{
	   try{
		   BufferedReader in=new BufferedReader(new FileReader("Ejer2.txt"));
		   String aux="",cad="Celula\tApellido\tNombre\n";
		   while(in.ready()){
			   aux=in.readLine();
			   String[] part=aux.split(";");
			   cad=cad+part[0]+"\t"+part[1]+"\t"+part[2]+"\n";
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
	public static void reporte1() throws Exception{
		   try{
			   BufferedReader in=new BufferedReader(new FileReader("auxEjer2.txt"));
			   String aux="",cad="Celula\tApellido\tNombre\n";
			   while(in.ready()){
				   aux=in.readLine();
				   String[] part=aux.split(";");
				   cad=cad+part[0]+"\t"+part[1]+"\t"+part[2]+"\n";
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
}