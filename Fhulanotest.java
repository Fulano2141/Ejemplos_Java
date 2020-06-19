import com.panamahitek.ArduinoException;  
import com.panamahitek.PanamaHitek_Arduino;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import java.awt.EventQueue;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;
@SuppressWarnings("serial")
public class Fhulanotest extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;		
	private JTextField textField_3;
	public static void main(String[] args) throws ArduinoException, SerialPortException {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fhulanotest frame = new Fhulanotest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Fhulanotest() {
		PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
		setTitle("Control por NFC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(12, 46, 79, 32);
		contentPane.add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 79, 79, 32);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(103, 79, 138, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(12, 112, 79, 32);
		contentPane.add(lblEdad);
		
		JLabel lblOcupacion = new JLabel("Ocupacion:");
		lblOcupacion.setBounds(12, 145, 79, 32);
		contentPane.add(lblOcupacion);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(103, 112, 138, 32);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(103, 145, 138, 32);
		contentPane.add(textField_2);
		JButton btnNewButton = new JButton("REGISTRAR");
		btnNewButton.setBounds(71, 190, 114, 32);
		contentPane.add(btnNewButton);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(103, 46, 138, 32);
		contentPane.add(textField_3);
		
		JLabel lblRegristrar = new JLabel("REGISTRARSE");
		lblRegristrar.setBounds(91, 13, 109, 20);
		contentPane.add(lblRegristrar);
		
		textField_3.setText("No hay codigo");
		textField_3.setEditable(false);
		
		JButton btnHistorial = new JButton("Historial");
		btnHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					hist("Historial.txt");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnHistorial.setBounds(353, 50, 97, 25);
		contentPane.add(btnHistorial);
		
		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					reporte("Personal.bin");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnUsuarios.setBounds(353, 116, 97, 25);
		contentPane.add(btnUsuarios);
		
		JButton button = new JButton("Cancelar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		button.setBounds(353, 190, 97, 25);
		contentPane.add(button);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre=textField.getText();
				int edad=Integer.parseInt(textField_1.getText());
				String ocu=textField_2.getText();
				String cod=textField_3.getText();
				try {
					adicionar("Personal.bin",cod,edad,nombre,ocu);
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});		
		SerialPortEventListener listener = new SerialPortEventListener() {
			@Override
			public void serialEvent(SerialPortEvent serialPortEvent) {
					try {
						String msg = ino.printMessage();
						textField_3.setText(msg);
					} catch (SerialPortException | ArduinoException e) {
						e.printStackTrace();
					}			
			}
		};
		try {
			ino.arduinoRX("COM5", 9600, listener);
		} catch (ArduinoException | SerialPortException e) {
			e.printStackTrace();
		}
	}
	public static void adicionar(String string, String msg, int edad, String nom, String ocu) throws IOException {
		try {
			DataOutputStream fs = new DataOutputStream(new FileOutputStream(string,true));
			fs.writeUTF(msg);
			fs.writeUTF(nom);
			fs.writeInt(edad);
			fs.writeUTF(ocu);
			fs.close();
			JOptionPane.showMessageDialog(null, "Usuario agregado");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "El archivo no pudo ser creado");
		}
	}
	public static void reporte(String string) throws IOException {
		try {
			DataInputStream fi = new DataInputStream(new FileInputStream(string));
			String cad="Codigo\tNombre\tEdad\tOcupacion\n";
			while(fi.available()!=0){
				String cod=fi.readUTF();
				String nom=fi.readUTF();
				int edad=fi.readInt();
				String ocu=fi.readUTF();
				cad+=cod+"\t"+nom+"\t"+edad+"\t"+ocu+"\t"+"\n";
			}
			JTextArea jta=new JTextArea(10,30);
			jta.setText(cad);
			JScrollPane barra = new JScrollPane(jta);
			JOptionPane.showMessageDialog(null,barra);
			fi.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "no se pudo leer el archivo");
		}
	}
	public static void hist(String string, String string2) throws IOException {
		try{
			String aux="",cad="Nombre\tHora\tFecha\n";
			BufferedReader in=new BufferedReader(new FileReader(string));
			DataInputStream fi = new DataInputStream(new FileInputStream(string2));
			while(in.ready()){
				aux=in.readLine();
				String[] part=aux.split(";");
				while(fi.available()!=0){
					String cod=fi.readUTF();
					String nom=fi.readUTF();
					int edad=fi.readInt();
					String ocu=fi.readUTF();
					if(cod.equals(part[0])) 	
						cad=cad+nom+"\t"+part[1]+"\t"+part[2]+"\n";			
				}
			}
			in.close();
			fi.close();
			JTextArea jta=new JTextArea(10,25);
			jta.setText(cad);
			JScrollPane barra = new JScrollPane(jta);
			JOptionPane.showMessageDialog(null,barra);
		}
		catch (IOException e){
			JOptionPane.showMessageDialog(null,"No existe Archivo");
		}
	}
	public static void hist(String string) throws IOException {
		try{
			String aux="",cad="Codigo\tFecha\tHora_de_entrada\tHora_de_salida\tDetalle\n";
			BufferedReader in=new BufferedReader(new FileReader(string));
			while(in.ready()){
				aux=in.readLine();
				String[] part=aux.split(";");
				cad=cad+part[0]+"\t"+part[1]+"\t"+part[2]+"\t\t"+part[3]+"\n";			
			}
			in.close();
			JTextArea jta=new JTextArea(10,70);
			jta.setText(cad);
			JScrollPane barra = new JScrollPane(jta);
			JOptionPane.showMessageDialog(null,barra);
		}
		catch (IOException e){
			JOptionPane.showMessageDialog(null,"No existe Archivo");
		}
	}
}
