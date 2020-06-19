package NFC;
import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
public class Buscar {
	public static void main(String[] args) {
				try {
					ino.arduinoRX("COM5", 9600, listener);
	        } catch (ArduinoException ex) {
	            Logger.getLogger(Buscar.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (SerialPortException ex) {
	            Logger.getLogger(Buscar.class.getName()).log(Level.SEVERE, null, ex);
	        }
    }
	static PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
	static SerialPortEventListener listener = new SerialPortEventListener() {
		@Override
		public void serialEvent(SerialPortEvent serialPortEvent) {
			try {
				if (ino.isMessageAvailable()) {
					String msg = ino.printMessage();
					probar("Personal.bin",msg);
				}
			} catch (SerialPortException ex) {
				Logger.getLogger(Buscar.class.getName()).log(Level.SEVERE, null, ex);
			} catch (ArduinoException ex) {
				Logger.getLogger(Buscar.class.getName()).log(Level.SEVERE, null, ex);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	};
	public static void probar(String string, String msg) throws IOException {
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
			JOptionPane.showMessageDialog(null, ex);
			find=false;
		}
		if(find)
			JOptionPane.showMessageDialog(null,"\t Usuario \n"+user);
		else
			JOptionPane.showMessageDialog(null, "Usuario no encontrado");
	}
}