package Ejercicio6; 
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
public class Transac extends JFrame {
	private JPanel contentPane;
	private static JTextField textField;
	private ButtonGroup grup;
	private JRadioButton rdbtnDeposito,rdbtnRetiro;
	private JLabel lblCuenta;
	private JTextField textField_1;
	private JLabel lblNewLabel;
	public Transac() {
		setTitle("Transaccion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Date dat = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		rdbtnDeposito = new JRadioButton("Deposito");
		rdbtnDeposito.setBounds(60, 27, 127, 25);
		contentPane.add(rdbtnDeposito);
		
		rdbtnRetiro = new JRadioButton("Retiro");
		rdbtnRetiro.setBounds(244, 27, 127, 25);
		contentPane.add(rdbtnRetiro);
		rdbtnDeposito.setActionCommand("1");
		rdbtnRetiro.setActionCommand("2");
		JLabel lblus = new JLabel("$us:");
		lblus.setBounds(117, 103, 52, 25);
		contentPane.add(lblus);
		grup = new ButtonGroup();
		grup.add(rdbtnDeposito);
		grup.add(rdbtnRetiro);
		textField = new JTextField();
		textField.setBounds(168, 103, 149, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sele=Integer.parseInt(grup.getSelection().getActionCommand());
				int cuenta=Integer.parseInt(textField_1.getText());
				if(sele==1)
					try {
						repor("Usuarios.bin",sele,cuenta);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				else
					try {
						repor("Usuarios.bin",sele,cuenta);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			}
		});
		btnAceptar.setBounds(274, 140, 97, 25);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(60, 141, 97, 25);
		contentPane.add(btnCancelar);
		
		lblCuenta = new JLabel("Cuenta:");
		lblCuenta.setBounds(117, 65, 52, 25);
		contentPane.add(lblCuenta);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(168, 66, 149, 24);
		contentPane.add(textField_1);
		
		lblNewLabel = new JLabel(dateFormat.format(dat));
		lblNewLabel.setBounds(310, 13, 97, 16);
		contentPane.add(lblNewLabel);

	}
	public static void repor(String string, int num1, int cuen) throws IOException {
		try {
			DataInputStream fi = new DataInputStream(new FileInputStream(string));
			ArrayList<String> List = new ArrayList<String>();
			String cad="";
			double con=Double.parseDouble(textField.getText());
			while(fi.available()!=0){
				int num=fi.readInt();
				String nom=fi.readUTF();
				String fe=fi.readUTF();
				double sal=fi.readDouble();
				if(num1==1 && cuen==num ) {
					cad=num+";"+nom+";"+fe+";"+(sal+con);
					List.add(cad);
				}else {
					if(num1==2 && cuen==num) {
						cad=num+";"+nom+";"+fe+";"+(sal-con);
						List.add(cad);
					}else {
						cad=num+";"+nom+";"+fe+";"+sal;
						List.add(cad);
					}
				}
			}
			DataOutputStream fs = new DataOutputStream(new FileOutputStream("Usuarios.bin"));
			for(int i=0;i<List.size();i++) {
				String []aux= List.get(i).split(";");
				fs.writeInt(Integer.parseInt(aux[0]));
				fs.writeUTF(aux[1]);
				fs.writeUTF(aux[2]);
				fs.writeDouble(Double.parseDouble(aux[3]));
			}
			fs.close();
			fi.close();
			JOptionPane.showMessageDialog(null, "Transaccion completa");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "no se pudo leer el archivo");
		}
	}

}
