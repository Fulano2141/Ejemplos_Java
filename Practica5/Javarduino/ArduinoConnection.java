package Javarduino;

public class ArduinoConnection {
	public void ArduinoConnection() {

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

		System.exit(ERROR);
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

		System.exit(ERROR);
		}

		}
}
