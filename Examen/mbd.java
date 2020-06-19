import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
@SuppressWarnings("serial")
public class mbd extends JFrame {
	Conexion con = new Conexion();
	Connection conexion = con.getConexionMYSQL();
	Statement sst =null;
	ResultSet resul=null;
	private JPanel contentPane;
	private JTextField textField;
	double tot=0.0,total=0.0;
	private JTextField txtTotal;
	private JTextField textField_1;
	public static void main(String[] args) {
		try {
			mbd frame = new mbd();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	public mbd() {		
		setTitle("Salarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(22, 55, 527, 188);
		contentPane.add(textArea);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(22, 30, 527, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAgregarDato = new JButton("Agregar Dato");
		btnAgregarDato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Anadir frame = new Anadir();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnAgregarDato.setBounds(225, 290, 120, 25);
		contentPane.add(btnAgregarDato);
		String cad="Codigo\tNombre\tSalario basico \t Bono de antiguedad\tTotal Ganado\n";
		textField.setText(cad);
		cad="";
		try {
			 sst = conexion.createStatement();
		}catch (Exception e) {}
		String cadena = "SELECT * FROM salario;";
		try {
			resul=sst.executeQuery(cadena);
		//Codigo\tNombre\tPrecio\tCantidad\n
		int i=0;
		while(resul.next()){
			String cod=resul.getString("Codigo_empleado");
			String nom=resul.getString("Nombre_empleado");
			String sal=resul.getString("Salario_basico");
			String ant=resul.getString("Antiguedad_del_empleado");
			double bono=Sala(Double.parseDouble(sal),Integer.parseInt(ant));
			tot=bono+Double.parseDouble(sal);
			cad+=cod+"\t"+nom+"\t"+sal+"\t"+bono+"\t\t"+tot+"\n";
			total=tot+total;
			i++;
		}
		}catch (SQLException e){
			e.printStackTrace();
		}
		textArea.setText(cad);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				total=0.0;
				String cad="";
				try {
					 sst = conexion.createStatement();
				}catch (Exception e) {}
				String cadena = "SELECT * FROM salario;";
				try {
					resul=sst.executeQuery(cadena);
				int i=0;
				while(resul.next()){
					String cod=resul.getString("Codigo_empleado");
					String nom=resul.getString("Nombre_empleado");
					String sal=resul.getString("Salario_basico");
					String ant=resul.getString("Antiguedad_del_empleado");
					double bono=Sala(Double.parseDouble(sal),Integer.parseInt(ant));
					tot=bono+Double.parseDouble(sal);
					cad+=cod+"\t"+nom+"\t"+sal+"\t"+bono+"\t\t"+tot+"\n";
					total=tot+total;
					i++;
				}
				}catch (SQLException e){
					e.printStackTrace();
				}
				textArea.setText(cad);
				textField_1.setText(total+"");
			}
		});
		btnActualizar.setBounds(428, 290, 97, 25);
		contentPane.add(btnActualizar);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(45, 290, 97, 25);
		contentPane.add(btnNewButton);
		JScrollPane sr=new JScrollPane(textArea);
		sr.setBounds(22, 55, 527, 188);
		contentPane.add(sr);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setText("TOTAL:");
		txtTotal.setBounds(22, 243, 62, 22);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(452, 243, 97, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(total+"");
		
	}
	public double Sala(double sala, int ant){
		double re=0.0;
		if(ant<5) {
			re=sala*0.1;
		}if(ant>=5 && ant<10) {
			re=sala*0.15;
		}if(ant>=10) {
			re=sala*0.2;
		}
		return re;
	}
}
