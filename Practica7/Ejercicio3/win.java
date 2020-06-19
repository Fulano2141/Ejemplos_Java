package Ejercicio3;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class win extends JFrame{

	
	private JTextField txtNcuenta;
	private JPasswordField pas;
	ResultSet consu=null;
	private int cu=0;
    private int co=0;
    
  

	private int aux=0;
    private JTextField txtNcu;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					win window = new win();
					win.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public windos1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setBounds(100, 100, 350, 228);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblContasea = new JLabel("contase\u00F1a");
		lblContasea.setBounds(62, 63, 73, 14);
		getContentPane().add(lblContasea);
		
		JLabel lblNumeroDeCuenta = new JLabel("numero de cuenta");
		lblNumeroDeCuenta.setBounds(42, 25, 93, 14);
		getContentPane().add(lblNumeroDeCuenta);
		
		
		pas = new JPasswordField();
		pas.setBounds(185, 60, 86, 20);
		getContentPane().add(pas);
		
		txtNcu = new JTextField();
		txtNcu.setBounds(185, 22, 86, 20);
		getContentPane().add(txtNcu);
		txtNcu.setColumns(10);
		
		int a=0;
		JButton btnEntrar = new JButton("entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conexion con =new conexion();
				Connection Conexion = (Connection) con.getConexionMYSQL();
				String pasb=pas.getText();
				int contra=Integer.parseInt(pasb);
				String cuen=txtNcu.getText();
				int cuenta=Integer.parseInt(cuen);
				if(Conexion == null) 
					System.out.println("Error");
				else {	
					
						try {
							consu=con.getQuery("select ncuenta,contraseña from cliente");
							System.out.println("Conexion correcta");
							
							while(consu.next()) {
							cu=consu.getInt("ncuenta");
							co=consu.getInt("contraseña");
							if(cu==cuenta && co==contra ) {
								System.out.println("##########");
								
								aux=0;
								break;
							}
							}
							if(aux==0) {
								
										try {
											windos2 window = new windos2(cu,co);
											window.setVisible(true);
										} catch (Exception e) {
											e.printStackTrace();
										}
									
							}
							Conexion.close();
							
						} catch (SQLException ex) {
							Logger.getLogger(conexion.class.getName()).log(Level.SEVERE,null, ex);
						}
					
				}
             
				
			}
		});
		btnEntrar.setBounds(131, 112, 89, 23);
		getContentPane().add(btnEntrar);
		
		
	}
}
