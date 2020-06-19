package Javarduino;
import java.io.*;
import java.util.*;
import panamahitek.Arduino.PanamaHitek_Arduino;
import gnu.io.*;
public class testardu implements SerialPortEventListener {
	private OutputStream Output = null;
	private InputStream Input = null;
	SerialPort serialPort;
	private final String PORT_NAME = "COM3";
	private static final int TIME_OUT = 2000;
	private static final int DATA_RATE = 9600;
	public static void main(String[] args) {
	
	}
	private int RecibirDatos() throws IOException {
		int Output = 0;
		Output = Input.read();
		return Output;
		}
	public void ArduinoConnection() throws IOException, TooManyListenersException {

		CommPortIdentifier portId = null;
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

		while (portEnum.hasMoreElements()) {
		CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();

		if (PORT_NAME.equals(currPortId.getName())) {
		portId = currPortId;
		break;
		}
		}

		if (portId == null) {

		System.exit(TIME_OUT);
		return;
		}
		try {
		serialPort = (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);

		serialPort.setSerialPortParams(DATA_RATE,
		SerialPort.DATABITS_8,
		SerialPort.STOPBITS_1,
		SerialPort.PARITY_NONE);

		Output = serialPort.getOutputStream(); //Se prepara a Output //para enviar datos
		Input = serialPort.getInputStream(); //Se prepara input para //recibir datos

		serialPort.addEventListener(this); //Se agrega un Event //Listener
		serialPort.notifyOnDataAvailable(true); //Se indica que se //notifique al usuario cuando sea que halla datos disponibles en //el puerto serie
		} catch (Exception e) {

		}

	}
	public synchronized void serialEvent(SerialPortEvent oEvent) {
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
		try {
		int datos;
		datos = RecibirDatos(); //Se invoca la función RecibirDatos()

		//Esta función devolverá un valor entero en formato ASCII.
		System.out.println((char)datos); //Se imprime en el mensaje

		//haciendo la conversión de ASCII a nuestro alfabeto.
		} catch (Exception e) {
		System.err.println(e.toString());
		}
		}
		}
}
