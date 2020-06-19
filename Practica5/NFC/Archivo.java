package NFC;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
public class Archivo {
	public static void main(String[] args) throws IOException {
		reporte("Personal.bin");
	}
	public static void reporte(String string) throws IOException {
		try {
			DataInputStream fi = new DataInputStream(new FileInputStream(string));
			String cad="Codigo\tNombre\tEdad\tOcupacion\n";
			while(fi.available()!=0){
				String cod = fi.readUTF();
				String nom = fi.readUTF();
				int edad = fi.readInt();
				String ocu = fi.readUTF();
				cad+=cod+"\t"+nom+"\t"+edad+"\t"+ocu+"\t"+"\n";
			}
			JTextArea jta=new JTextArea(20,50);
			jta.setText(cad);
			JScrollPane barra = new JScrollPane(jta);
			JOptionPane.showMessageDialog(null,barra);
			fi.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "no se pudo leer el archivo");
		}
	}

}
