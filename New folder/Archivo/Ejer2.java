package Archivo;

import java.io.*;
import java.util.*;
import javax.swing.*;

public class Ejer2 {
	public static void main (String[] args) throws IOException{
		for(;;){
			String []menu = {"Almacenar datos","Aumentar Salario","Ver datos aumentados","Ver datos no aumentados","Salir"};
			String valor= (String) JOptionPane.showInputDialog(null, "Seleccione la opcion:","SAlARIOS", JOptionPane.DEFAULT_OPTION,null,menu,menu);
			switch (valor){
			case "Almacenar datos": crear();break;
		    case "Ver datos no aumentados": leer("salas.txt");break;
		    case "Aumentar Salario": ordenar();break;
		    case "Ver datos aumentados":leer("salan.txt");break;
		    case "Salir": System.exit(0);
		    }
		}
	}
	public static void ordenar()throws IOException {
		try {
			BufferedReader in=new BufferedReader(new FileReader("salas.txt"));
			FileWriter fichero=new FileWriter("salan.txt");
			PrintWriter pw=new PrintWriter(fichero);
			String nom="",aux="";
			for(;(nom=in.readLine())!=null;){
				String[] parts = nom.split(";");
				double salario=Double.parseDouble(parts[2]);
				if(salario<3000)
					salario=salario+salario*0.20;
				if(salario>=3000 && salario<5000)
					salario=salario+salario*0.15;
				if(salario>=5000 && salario<10000)
					salario=salario+salario*0.10;
				if(salario>=10000)
					salario=salario+salario*0.08;
				aux=parts[0]+";"+parts[1]+";"+salario;
				pw.println(aux);
			}
			in.close();
			fichero.close();
			JOptionPane.showMessageDialog(null,"Salarios Aumentados");
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"No se encontro el archivo: "+e);
		}
	}
	public static void crear() throws IOException{
		try {
			FileWriter fichero=new FileWriter("salas.txt",true);
			PrintWriter pw=new PrintWriter(fichero);
			String aux="";
			int n=Integer.parseInt(JOptionPane.showInputDialog(null,"Cuantos trabajadores?:"));
			for(int i=0;i<n;i++){
				String CI=JOptionPane.showInputDialog(null,"Ingrese la Celula de Identidad");
				String Nom=JOptionPane.showInputDialog(null,"Ingrese el nombre");
				String Sal=JOptionPane.showInputDialog(null,"Ingrese el salario");
				aux=CI+";"+Nom+";"+Sal;
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
			String nom="",aux="Celula\tNombre\tSalario\n";
			aux=aux+"-----------------------------------------\n";
			double total=0;
			for(;(nom=in.readLine())!=null;){
				String ds=nom;
				String[] parts = ds.split(";");
				aux=aux+parts[0]+"\t"+parts[1]+"\t"+parts[2]+"\n";
				total=total+Double.parseDouble(parts[2]);
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
