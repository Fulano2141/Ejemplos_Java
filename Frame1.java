import java.awt.BorderLayout; 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class Frame1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea table;
	ResultSet consu=null;
	int codigo;
	String producto, cad="Codigo\tDescripcion\tPrecio\tStock\n";
	int stock;
	double precio;
	Conexion con = new Conexion();
	Connection Conexion = con.getConexionMYSQL();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 frame = new Frame1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame1() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frame1.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-error.png")));
		setTitle("Conexion con BD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 377, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Estado de conexion:");
		lblNewLabel.setBounds(10, 48, 130, 23);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(135, 48, 144, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		JButton btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Conexion == null) 
					textField.setText("Error con la conexion");
				else {			
						try {
							
							Conexion.close();
							textField.setText("Conexion correcta");
						} catch (SQLException ex) {
							Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null, ex);
						}
					
				}
			}
		});
		btnConectar.setBounds(155, 11, 89, 23);
		contentPane.add(btnConectar);
			
		table = new JTextArea(20,10);
		table.setBounds(21, 116, 330, 143);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("Consulta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consu=con.getQuery("select * from productos");
				if(Conexion == null) 
					textField.setText("Error con la conexion");
				else {			
						try {
							
							while(consu.next()) {
								codigo=consu.getInt("Codigo");
								producto=consu.getString("Descripcion");
								precio=consu.getDouble("Precio_Unitario");
								stock=consu.getInt("Stock");
								cad=cad+codigo+"\t"+producto+"\t"+precio+"\t"+stock+"\n";
							}
							table.setText(cad);
							Conexion.close();
						} catch (SQLException ex) {
							Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null, ex);
						}
					
				}
			}
		});
		btnNewButton.setBounds(155, 82, 89, 23);
		contentPane.add(btnNewButton);
	}
	
	
}
