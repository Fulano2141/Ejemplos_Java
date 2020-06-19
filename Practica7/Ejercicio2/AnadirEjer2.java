package Ejercicio2;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AnadirEjer2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	Conexion con = new Conexion();
	Connection conexion = con.getConexionMYSQL();
	Statement st =null;
	public AnadirEjer2() {
		try {
			 st = conexion.createStatement();
		}catch (Exception e) {}
		setTitle("Anadir");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(42, 70, 129, 24);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(125, 70, 220, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNit = new JLabel("NIT: ");
		lblNit.setBounds(42, 129, 129, 24);
		contentPane.add(lblNit);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(125, 130, 220, 24);
		contentPane.add(textField_1);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user="", id="";
				id=textField_1.getText();
				user=textField.getText();
				if(!user.equals("") && !id.equals("")) {
				String cadena = "INSERT INTO cliente (NIT, Nombre) VALUE ("+id+",'"+user+"')";
				int i=-1;
				try {
					JOptionPane.showMessageDialog(null, cadena);
					i = st.executeUpdate(cadena);
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
				if(i!=-1) {
					JOptionPane.showMessageDialog(null, "Datos guardados");
					dispose();}
				else
					JOptionPane.showMessageDialog(null, "Error con la Base de datos, datos no guardados");
				}
				
			}
		});
		btnGuardar.setBounds(260, 203, 97, 25);
		contentPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(63, 203, 97, 25);
		contentPane.add(btnCancelar);
	}
}
