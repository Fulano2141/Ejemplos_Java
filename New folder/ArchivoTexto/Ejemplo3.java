package ArchivoTexto;
import java.io.*;
import javax.swing.*;
public class Ejemplo3 {
	public static void main(String[] args) throws IOException {
		for(;true;) {
			String [] menu1 = {"Escribir","Leer","Calcular","Salir"};
			String valor1 = (String)JOptionPane.showInputDialog(null,"Seleccione la opcion","Opciones",JOptionPane.DEFAULT_OPTION,null,menu1,menu1[0]);
			switch(valor1) {
			case "Escribir": adicion();
			break;
			case "Calcular": busque();
			break;
			case "Leer": Repor();
			break;
			case "Salir": System.exit(0);
			}
		}
	}
	public static void busque() throws IOException {
		BufferedReader in=new BufferedReader (new FileReader("Sala.txt"));
		double aux=0,porce=0,n=0;
		while (in.ready()) {
			aux=Double.parseDouble(in.readLine());
			porce=aux+porce;
			n++;
		}
		double pro=(porce/n);
		in.close();
		BufferedReader on=new BufferedReader (new FileReader("Sala.txt"));
		double i=n;
		n=0;
		while (on.ready()) {
			aux=Double.parseDouble(on.readLine());
			if(aux<pro)
			n++;
		}
		JOptionPane.showMessageDialog(null, "Numero de salarios debajo del promedio: "+n+ " \nPromedio: "+pro+"\nPorcentaje: "+(n*100/i));
		on.close();
	}
	public static void Repor() throws IOException {
		BufferedReader in=new BufferedReader (new FileReader("Sala.txt"));
		String aux=" ",cad="";
		JTextArea text = new JTextArea(10,50);
		try {
		while (in.ready()) {
			aux=in.readLine();
			cad+=aux+"\n";
		}
		text.setText(cad);
		JOptionPane.showMessageDialog(null, text,"Salarios", 3);
		in.close();}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null,"No existe el archivo"+e);
		}
	}
	public static void adicion() throws IOException {
		PrintWriter in=new PrintWriter (new FileWriter("Sala.txt",true));
		int n=Integer.parseInt(JOptionPane.showInputDialog("Numero de salarios que desea agregar: "));
		for (int i=0;i<n;i++) {
			String nom=JOptionPane.showInputDialog("Salario: ");
			in.println(nom);
		}
		in.close();
	}
}
