// 1.- Leer un archivo de texto que contiene los nombres
//     de varias personas
package ArchivosTexto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;
public class Ejemplo1 {
	public static void main(String[] args) throws Exception {
		//lectura();
		escritura();
		lectura();
	}
	public static void lectura() throws IOException {
		BufferedReader in=new BufferedReader(new FileReader("nombres.txt"));
	    String aux="";
	    while (in.ready()) {
	    	aux=in.readLine();
	    	System.out.println(aux);
	    }
	    in.close();
	}
	public static void escritura() throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter("nombres.txt",true));
	    int n=Integer.parseInt(JOptionPane.showInputDialog("Cuantos nombres:"));
	    for (int i=0;i<n;i++) {
	    	String nom=JOptionPane.showInputDialog("Nombre:");
	    	out.println(nom); 
	    }
	    out.close();
	}
}
