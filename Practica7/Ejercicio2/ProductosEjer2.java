package Ejercicio2;
 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ProductosEjer2 extends JFrame {

	private JPanel contentPane;
	Conexion con = new Conexion();
	Connection conexion = con.getConexionMYSQL();
	Statement st =null;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductosEjer2 frame = new ProductosEjer2();
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
	public ProductosEjer2() {
		
		try {
			 st = conexion.createStatement();
		}catch (Exception e) {}
		String cad="Codigo\tNombre\tPrecio\tStock\n";
		String query="SELECT * FROM producto";
		ResultSet resultSet=null;
		try {
			resultSet = st.executeQuery(query);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try {
			while(resultSet.next()){
				cad=cad+resultSet.getString("Codigo_producto")+"\t"+resultSet.getString("Nombre")+"\t"+resultSet.getString("Precio_unitario")+"\t"+resultSet.getString("Stock")+"\n";
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel lblProductos = new JLabel("PRODUCTOS");
		lblProductos.setBounds(182, 13, 78, 30);
		contentPane.add(lblProductos);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		}); 
		btnNewButton.setBounds(169, 261, 97, 25);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 43, 408, 197);
		contentPane.add(textArea);
		
		textArea.setText(cad);
		textArea.setEditable(false);
		
		JScrollPane scrollBar = new JScrollPane(textArea);
		scrollBar.setBounds(12, 43, 408, 197);
		contentPane.add(scrollBar);
	}
}
