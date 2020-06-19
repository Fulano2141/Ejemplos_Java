package Ejercicio2;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class VentaEjer2 extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblFecha;
	private JTextField textField_5;
	private JButton btnGuardar;
	private JButton btnCancelar;
	Conexion con = new Conexion();
	Connection conexion = con.getConexionMYSQL();
	Statement st =null;

	public VentaEjer2() {
		try {
			 st = conexion.createStatement();
		}catch (Exception e) {}
		setTitle("Venta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 348, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String FechaActual=dateFormat.format(date);
		
		JLabel lblNit = new JLabel("NIT:");
		lblNit.setBounds(29, 44, 62, 24);
		contentPane.add(lblNit);
		
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setBounds(29, 79, 62, 24);
		contentPane.add(lblProducto);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(29, 113, 62, 24);
		contentPane.add(lblCantidad);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(29, 150, 62, 24);
		contentPane.add(lblPrecio);
		
		textField = new JTextField();
		textField.setBounds(141, 45, 133, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(141, 80, 133, 23);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(141, 114, 133, 23);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(141, 151, 133, 23);
		contentPane.add(textField_3);
		
		lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(29, 187, 62, 24);
		contentPane.add(lblFecha);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(141, 187, 133, 23);
		contentPane.add(textField_5);
		
		textField_5.setText(FechaActual);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cadena = "INSERT INTO Venta (Codigo_Producto, NIT, Cantidad, Precio_de_venta, Fecha) VALUES ";
				String nit=textField.getText(), cod=textField_1.getText(), can=textField_2.getText();
				String preci=textField_3.getText(), fe=textField_5.getText();
				cadena=cadena+"("+cod+","+nit+","+can+","+preci+","+fe+")";
				int i=-1;
				try {
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
		});
		btnGuardar.setBounds(177, 234, 97, 25);
		contentPane.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(39, 234, 97, 25);
		contentPane.add(btnCancelar);
	}

}
