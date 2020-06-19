package ArchivoTexto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
public class Ejemplo2 {
	public static void main(String[] args) throws IOException {
		for(;true;) {
			String [] menu1 = {"Adicion","Busqueda","Reporte","Salir"};
			String valor1 = (String)JOptionPane.showInputDialog(null,"Seleccione la opcion","Opciones",
					JOptionPane.DEFAULT_OPTION,null,menu1,menu1[0]);
			switch(valor1) {
			case "Adicion": adicion();
			break;
			case "Busqueda": busque();
			break;
			case "Reporte": Repor();
			break;
			}
		}
	}

	public static void busque() throws IOException {
		BufferedReader in=new BufferedReader (new FileReader("Telefonos.txt"));
		String aux=" ";
		int flag=0;
		String bus=JOptionPane.showInputDialog("Telefono a Buscar");
		while (in.ready()) {
			aux=in.readLine();
			if(bus.equals(aux)) {
				flag++;
			}
			if(flag==1) {
				JOptionPane.showMessageDialog(null,"Telefono encontrado");
				break;
			}else{
				JOptionPane.showMessageDialog(null,"Telefono no encontrado");
				break;
			}
				
		}
		in.close();
	}

	public static void Repor() throws IOException {
		BufferedReader in=new BufferedReader (new FileReader("Telefonos.txt"));
		String aux=" ",cad="";
		JTextArea text = new JTextArea(10,50);
		try {
		while (in.ready()) {
			aux=in.readLine();
			cad+=aux+"\n";
		}
		text.setText(cad);
		JOptionPane.showMessageDialog(null, text,"Telefonos", 3);
		in.close();}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null,"No existe el archivo"+e);
		}
	}

	public static void adicion() throws IOException {
		PrintWriter in=new PrintWriter (new FileWriter("Telefonos.txt",true));
		int n=Integer.parseInt(JOptionPane.showInputDialog("Numero de nombres que desea agregar: "));
		for (int i=0;i<n;i++) {
			String nom=JOptionPane.showInputDialog("Telefono: ");
			in.println(nom);
		}
		in.close();
	}
	
}
