
package ArchivoTexto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
public class Ejemplo1 {
	public static void main (String[] args) throws IOException {
		lectura();
		escritura();
	}
	public static void lectura() throws IOException {
		BufferedReader in=new BufferedReader (new FileReader("Nombres.txt"));
		String aux=" ";
		while (in.ready()) {
			aux=in.readLine();
			System.out.println(aux);
		}
		in.close();
	}
	public static void escritura() throws IOException {
		PrintWriter in=new PrintWriter (new FileWriter("Nombres.txt",true));
		int n=Integer.parseInt(JOptionPane.showInputDialog("Numero de nombres que desea agregar: "));
		for (int i=0;i<n;i++) {
			String nom=JOptionPane.showInputDialog("Nombre: ");
			in.println(nom);
		}
		in.close();
	}
}
