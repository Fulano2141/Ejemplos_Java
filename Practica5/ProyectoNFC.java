package NFC;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;

import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
public class ProyectoNFC {
	static PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
	static SerialPortEventListener listener = new SerialPortEventListener() {
		@Override
		public void serialEvent(SerialPortEvent serialPortEvent) {
			try {
				if (ino.isMessageAvailable()) {
					String msg = ino.printMessage();
					adicionar("Personal.bin",msg);
				}
			} catch (SerialPortException ex) {
				Logger.getLogger(Adiccion.class.getName()).log(Level.SEVERE, null, ex);
			} catch (ArduinoException ex) {
				Logger.getLogger(Adiccion.class.getName()).log(Level.SEVERE, null, ex);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	};
	static PanamaHitek_Arduino oni = new PanamaHitek_Arduino();
	static SerialPortEventListener listen = new SerialPortEventListener() {
		@Override
		public void serialEvent(SerialPortEvent serialPortEvent) {
			try {
				if (oni.isMessageAvailable()) {
					String msg = oni.printMessage();
					try {
						probar("Personal.bin",msg);
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
			} catch (SerialPortException ex) {
				Logger.getLogger(Buscar.class.getName()).log(Level.SEVERE, null, ex);
			} catch (ArduinoException ex) {
				Logger.getLogger(Buscar.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	};
	public static void main(String[] args) throws IOException {
		for(;true;) {
			String [] menu = {"Añadir codigo","Reporte","Identificar","Salir"};
			String valor = (String) JOptionPane.showInputDialog(null, "Seleccione la opcion","Opciones",JOptionPane.DEFAULT_OPTION,null,menu,menu[0]);
			switch(valor){
			case "Añadir codigo":
				try {
					JOptionPane.showMessageDialog(null, "Ubique la tarjeta");
					ino.arduinoRX("COM5", 9600, listener);
				} catch (ArduinoException ex) {
					Logger.getLogger(Adiccion.class.getName()).log(Level.SEVERE, null, ex);
				} catch (SerialPortException ex) {
					Logger.getLogger(Adiccion.class.getName()).log(Level.SEVERE, null, ex);
				}  
				break;
			case "Reporte": reporte("Personal.bin"); break;
			case "Identificar": 
				try {
					JOptionPane.showMessageDialog(null, "Ubique la tarjeta");
					oni.arduinoRX("COM5", 9600, listen);
				} catch (ArduinoException ex) {
					Logger.getLogger(Adiccion.class.getName()).log(Level.SEVERE, null, ex);
				} catch (SerialPortException ex) {
					Logger.getLogger(Adiccion.class.getName()).log(Level.SEVERE, null, ex);
				}  
				break;
			case "Salir": System.exit(0); break;
			}
		}
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
	public static void adicionar(String string, String msg) throws IOException {
		try {
			DataOutputStream fs = new DataOutputStream(new FileOutputStream(string,true));
			String nom,ocu;
			int edad;	
			nom=JOptionPane.showInputDialog(null,"Ingrese el nombre: ");
			ocu=JOptionPane.showInputDialog(null,"Ocupacion: ");
			edad= Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
			fs.writeUTF(msg);
			fs.writeUTF(nom);
			fs.writeInt(edad);
			fs.writeUTF(ocu);
			fs.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "El archivo no pudo ser creado");
		}
	}
	public static void probar(String msg, String string) throws IOException {
		boolean find=false;
		String user="";
		try {
			DataInputStream fi = new DataInputStream(new FileInputStream(string));
			while(fi.available()!=0){
				String cod = fi.readUTF();
				String nom = fi.readUTF();
				int edad = fi.readInt();
				String ocu = fi.readUTF();
				if(msg.equals(cod)) {
					user="Nombre: "+nom+"\n"
						+"Edad: "+edad+"\n"
						+"Ocupacion: "+ocu;
					find=true;
				}
			}
			fi.close();
		}
		catch(IOException ex){
			find=false;
		}
		if(find)
			JOptionPane.showMessageDialog(null,"\t Usuario \n"+user);
		else
			JOptionPane.showMessageDialog(null, "Usuario no encontrado");
	}
}
