import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.awt.HeadlessException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
public class rxComplex {
	public static void main(String[] args) {
		for(;true;){
			String [] menu = {"Añadir nuevos clientes","Buscar por numero de cuenta","Reporte","Graficar saldos","Salir"};
			String valor = (String) JOptionPane.showInputDialog(null, "Seleccione la opcion","Opciones",JOptionPane.DEFAULT_OPTION,null,menu,menu[0]);
			switch(valor){
			case "Añadir nuevos clientes": 
				try {
					ino.arduinoRX("COM5", 9600, listener);
				} catch (ArduinoException ex) {
					Logger.getLogger(rxComplex.class.getName()).log(Level.SEVERE, null, ex);
				} catch (SerialPortException ex) {
					Logger.getLogger(rxComplex.class.getName()).log(Level.SEVERE, null, ex);
				}
				break;
			case "Reporte":// reporte("Banco.dat");
			break;
			case "Buscar por numero de cuenta":  
			try {
				ino.arduinoRX("COM5", 9600, Fhulano);
	        } catch (ArduinoException ex) {
	            Logger.getLogger(rxComplex.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (SerialPortException ex) {
	            Logger.getLogger(rxComplex.class.getName()).log(Level.SEVERE, null, ex);
	        }
			break;
			case "Salir": System.exit(0); break;
			}
		} 
    }
	static PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
	static SerialPortEventListener listener = new SerialPortEventListener() {
		@Override
		public void serialEvent(SerialPortEvent serialPortEvent) {
			try {
				JOptionPane.showMessageDialog(null, "Ingrese la tarjeta");
				if (ino.isMessageAvailable()) {
						
					String msg = ino.printMessage();
					try {
						adicionar("Personal.bin",msg);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			} catch (SerialPortException ex) {
				Logger.getLogger(rxComplex.class.getName()).log(Level.SEVERE, null, ex);
			} catch (ArduinoException ex) {
				Logger.getLogger(rxComplex.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	};
	static PanamaHitek_Arduino in = new PanamaHitek_Arduino();
	static SerialPortEventListener Fhulano = new SerialPortEventListener() {
		@Override
		public void serialEvent(SerialPortEvent serialPortEvent) {
			try {
				if (in.isMessageAvailable()) {
					String msg = in.printMessage();
					try {
						if(probar("Personal.bin",msg)) 
							JOptionPane.showMessageDialog(null, "");
						else
							JOptionPane.showMessageDialog(null, "");
					} catch (HeadlessException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (SerialPortException ex) {
				Logger.getLogger(rxComplex.class.getName()).log(Level.SEVERE, null, ex);
			} catch (ArduinoException ex) {
				Logger.getLogger(rxComplex.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	};
	public static boolean probar(String string, String msg) throws IOException {
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
			return true;
		else
			return false;
	}
	public static void adicionar(String string, String msg) throws IOException {
		try {
			DataOutputStream fs = new DataOutputStream(new FileOutputStream(string,true));
			String nom,ocu;
			int edad;	
			nom=JOptionPane.showInputDialog(null,"Ingrese el nombre");
			ocu=JOptionPane.showInputDialog(null,"Fecha de apertura");
			edad= Integer.parseInt(JOptionPane.showInputDialog("Saldo:"));
			fs.writeUTF(msg);
			fs.writeUTF(nom);
			fs.writeInt(edad);
			fs.writeUTF(ocu);
			fs.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "El archivo no pudo ser creado");
		}
	}
}