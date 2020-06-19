package Ejercicio3;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class win2 extends JFrame{
int cu,co;
	  public win2(int cu, int co) throws HeadlessException {
			super();
			this.cu = cu;
			this.co = co;
		}
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public win2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnRetiro = new JButton("retiro");
		btnRetiro.setBounds(136, 46, 130, 23);
		getContentPane().add(btnRetiro);
		
		JButton btnDepocito = new JButton("depocito");
		btnDepocito.setBounds(136, 80, 130, 23);
		getContentPane().add(btnDepocito);
		
		JButton btnConcultaDeSaldo = new JButton("conculta de saldo");
		btnConcultaDeSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conexion con =new conexion();
				Connection Conexion = (Connection) con.getConexionMYSQL();
				if(Conexion == null) 
					System.out.println("Error");
				else {			
						try {
							System.out.println(cu+" "+co);
							
							
							
							
							
							Conexion.close();
							System.out.println("Conexion correcta");
						} catch (SQLException ex) {
							Logger.getLogger(conexion.class.getName()).log(Level.SEVERE,null, ex);
						}
					
				}
			JOptionPane.showMessageDialog(null, "a");
			}
		});
		btnConcultaDeSaldo.setBounds(136, 114, 130, 23);
		getContentPane().add(btnConcultaDeSaldo);
		
		JButton btnSalir = new JButton("salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setBounds(153, 166, 89, 23);
		getContentPane().add(btnSalir);
	}

}
