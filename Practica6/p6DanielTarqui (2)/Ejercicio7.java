/*  7.- Crear  una aplicación Java que permita asistir en el control de las entradas y salidas de vehículos de un edificio de parqueo, para tal efecto el sistema debe utilizar un archivo de texto, que contenga:
-	Placa del  vehículo
-	Numero de NIT del cliente
-	Hora de ingreso  (hh:mm)
-	Hora de salida (hh:mm)
-	Fecha del dia (Obtener con la clase Calendar)

Los frames deben permitir :
-	Añadir datos al archivo 
-	Emitir un reporte del tiempo utilizado (hh:mm) y el pago por este  tiempo. (JTextArea) 
El pago se realiza en función a:
Menos de 1 hora 5Bs.
Mayor o igual a 1 hora pero menor a 3  paga 10Bs.
Mayor o igual a 3 horas pero menor a 6  paga 15Bs.
Mayor o igual a 6 horas  paga 20Bs.

El reporte debe contener para varios registros:
Placa	Hra. de Ingreso		Hra. de Salida	 Tiempo en minutos	Pago Total
123-ABC 		10:15			11:00		45		    5 Bs.
737-XYZ		11:30			12:30		60		  10 Bs. 
      ------------------------------------------------------------------------------------------------------------------
 Total general:                                                                                               Bs.     15 Bs.w
 */
package Ejercicio7;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

public class Ejercicio7 {

	private JFrame frmParqueo;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblNewLabel_4;
	JButton bot1,bot2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio7 window = new Ejercicio7();
					window.frmParqueo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ejercicio7() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmParqueo = new JFrame();
		frmParqueo.setTitle("PARQUEO");
		frmParqueo.setBounds(100, 100, 447, 370);
		frmParqueo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmParqueo.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HORA DE INGRESO");
		lblNewLabel.setBounds(61, 120, 117, 16);
		frmParqueo.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PLACA VEICULO");
		lblNewLabel_1.setBounds(61, 50, 97, 16);
		frmParqueo.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(190, 47, 116, 22);
		frmParqueo.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblNewLabel_2 = new JLabel("FECHA DEL DIA");
		lblNewLabel_2.setBounds(61, 190, 117, 16);
		frmParqueo.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(190, 117, 116, 22);
		frmParqueo.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(190, 187, 116, 22);
		frmParqueo.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		lblNewLabel_3 = new JLabel("NIT CLIENTE");
		lblNewLabel_3.setBounds(61, 85, 97, 16);
		frmParqueo.getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(190, 82, 116, 22);
		frmParqueo.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(190, 152, 116, 22);
		frmParqueo.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		lblNewLabel_4 = new JLabel("HORA DE SALIDA");
		lblNewLabel_4.setBounds(61, 155, 117, 16);
		frmParqueo.getContentPane().add(lblNewLabel_4);

		bot1= new JButton("A\u00D1ADIR");
		bot1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pla=textField.getText();
				   String nit=textField_3.getText();
				   String he=textField_1.getText();
				   String hs=textField_4.getText();
				   String fe=textField_2.getText();
				   try {
					adicionar(pla,nit,he,hs,fe);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				   textField.setText("");
				   textField_1.setText("");
				   textField_2.setText("");
				   textField_3.setText("");
				   textField_4.setText("");
			}
		});
		bot1.setBounds(109, 267, 97, 25);
		frmParqueo.getContentPane().add(bot1);
		
		bot2= new JButton("REPORTE");
		bot2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					reporte();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		bot2.setBounds(287, 267, 97, 25);
		frmParqueo.getContentPane().add(bot2);
	}

	public static void adicionar(String pl,String nit,String he,String hs,String fe) throws IOException {
		try {
		PrintWriter out=new PrintWriter(new FileWriter("parqueo.txt",true));
		 out.println(pl+";"+nit+";"+he+";"+hs+";"+fe+";");
		 out.close();
	} catch (IOException e) {
		   JOptionPane.showMessageDialog(null, "El archivo no pudo ser creado");
		  }
	}
	public static void reporte() throws IOException {
		  try {
			  BufferedReader in=new BufferedReader(new FileReader("parqueo.txt"));
		   String nom="", cad="placa\thra.ingreso\thra.de salida\t tiempo en minutos\tpagototal\n";
		   cad+="----------------------------------------------------------------------------------------------------------------------------------\n";
		  int pagoto=0;
		   for(;(nom=in.readLine())!=null;){
			   String ds=nom;
			    String[] parts = ds.split(";");
			    String hee=parts[2].split(":")[0];
			    String mee=parts[2].split(":")[1];
			    int h1=Integer.parseInt(hee);
			    int m1=Integer.parseInt(mee);
			    String hss=parts[3].split(":")[0];
			    String mss=parts[3].split(":")[1];
			    int h2=Integer.parseInt(hss);
			    int m2=Integer.parseInt(mss);
			    System.out.println(parts);
			    String a=horas(h1,m1,h2,m2);
			    String []to=a.split(";");
			    int tt=Integer.parseInt(to[0]);
			    int pago=Integer.parseInt(to[1]);
			    pagoto+=pago;
			    cad+=parts[0]+"\t"+parts[2]+"\t"+parts[3]+"\t"+tt+"\t\t"+pago+" bs"+"\n";
		   }
		   cad+="----------------------------------------------------------------------------------------------------------------------------------\n";
		   cad+="total\ngenerado:\n"+pagoto+" bs";
		      JTextArea area=new JTextArea();
			   area.setText(cad);
			   JOptionPane.showMessageDialog(null, area);
			   in.close();
		  } catch (IOException e) {
		   JOptionPane.showMessageDialog(null, "no se pudo leer el archivo");
		  }
		 }
	public static String horas(int h1,int m1,int h2,int m2) {
		int pago = 0,met,mst;
		met=h1*60+m1;
		mst=h2*60+m2;
		int tt=mst-met;
		if(tt<60) {
			pago=5;
		}
		if(tt>=60 && tt<(60*3)) {
			pago=10;
		}
		if(tt>=(60*3) && tt<(60*6)) {
			pago=15;
		}
		if(tt>=60*6 ) {
			pago=20;
		}
		return tt+";"+pago;
	}
}