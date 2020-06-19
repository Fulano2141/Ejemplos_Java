package Archivo;
import java.io.*;
import java.util.*;
import javax.swing.*;
public class Ejer1 {
	public static void main (String[] args) throws IOException{
		for(;;){
			String []menu = {"Almacenar datos","Ordenar","Ver datos ordenados","Ver datos desordenados","Salir"};
			String valor= (String) JOptionPane.showInputDialog(null, "Seleccione la opcion:","SAlARIOS", JOptionPane.DEFAULT_OPTION,null,menu,menu);
			switch (valor){
			case "Almacenar datos": crear();break;
		    case "Ver datos desordenados": leer("desordenados.txt");break;
		    case "Ordenar": ordenar();break;
		    case "Ver datos ordenados":leer("ordenados.txt");break;
		    case "Salir": System.exit(0);
		    }
		}
	}
	public static void ordenar()throws IOException {
		try {
			ArrayList<String> nome=new ArrayList<String>();
			BufferedReader in=new BufferedReader(new FileReader("desordenados.txt"));
			String nom="";
			int i=0;
			for(;(nom=in.readLine())!=null;){
				nome.add(nom);
				i++;
			}
			Collections.sort(nome);
			FileWriter fichero=new FileWriter("ordenados.txt");
			PrintWriter pw=new PrintWriter(fichero);
			for(int c=0;c<i;c++){
				String aux=nome.get(c);
				pw.println(aux);
			}
			fichero.close();
			in.close();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"No se encontro el archivo: "+e);
		}
	}
	public static void crear() throws IOException{
		try {
			FileWriter fichero=new FileWriter("desordenados.txt",true);
			PrintWriter pw=new PrintWriter(fichero);
			int n=Integer.parseInt(JOptionPane.showInputDialog(null,"Cuantos nombres?:"));
			for(int i=0;i<n;i++){
				String sal=JOptionPane.showInputDialog(null,"Ingrese el nombre");
				pw.println(sal);
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
			String nom="",aux="";
			for(;(nom=in.readLine())!=null;){
			  aux+=nom+"\n";
			}
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

