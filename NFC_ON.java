import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
public class NFC_ON {
	public static void main(String[] args) {
		try {
			ino.arduinoRX("COM5", 9600, listener);
		} catch (ArduinoException ex) {
			Logger.getLogger(NFC_ON.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SerialPortException ex) {
			Logger.getLogger(NFC_ON.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	static PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
	static SerialPortEventListener listener = new SerialPortEventListener() {
		@Override
		public void serialEvent(SerialPortEvent serialPortEvent) {
			try {
				if (ino.isMessageAvailable()) {
					String msg = ino.printMessage();
					try {
						hist("Historial.txt",msg);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} catch (SerialPortException ex) {
				Logger.getLogger(NFC_ON.class.getName()).log(Level.SEVERE, null, ex);
			} catch (ArduinoException ex) {
				Logger.getLogger(NFC_ON.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		public void hist(String string, String msg) throws IOException {
			try{
				BufferedReader in=new BufferedReader(new FileReader(string));
				ArrayList<String> list=new ArrayList<String>();
				Date date = new Date();
				DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String aux="";
				while(in.ready()){
					aux=in.readLine();
					list.add(aux);
				}
				in.close();
				boolean tr=true;
				for(int i=0;list.size()>i;i++) {
					String au=list.get(i);
					String [] part=au.split(";");
					if(msg.equals(part[0])) {
						String cor=msg+";"+part[1]+";"+part[2]+";"+hourFormat.format(date);
						list.set(i,cor);
						tr=false;
					}
				}
				if(tr) {
				String cor=msg+";"+dateFormat.format(date)+";"+hourFormat.format(date);
				list.add(cor);}
				PrintWriter out=new PrintWriter(new FileWriter(string));
				for(int i=0;list.size()>i;i++) {
					out.println(list.get(i));
				}
				out.close();
				JOptionPane.showMessageDialog(null,"Usuario registrado");
			}
			catch (IOException e){
				PrintWriter out=new PrintWriter(new FileWriter("Historial.txt"));
				Date date = new Date();
				DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String cor=msg+";"+dateFormat.format(date)+";"+hourFormat.format(date);
				out.println(cor);
				out.close();
			}
		}
	};
}
