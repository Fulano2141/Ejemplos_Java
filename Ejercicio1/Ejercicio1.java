package Ejercicio1;
import javax.swing.JFrame;  
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
public class Ejercicio1 extends JFrame {
	Conexion1 con = new Conexion1();
	Connection conexion = con.getConexionMYSQL();
	Statement sst =null;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	String[] nom = new String[50];
	String[] pres = new String[50];
	int aux=0;
	public Ejercicio1() {
		try {
			 sst = conexion.createStatement();
		}catch (Exception e) {
		}
		ResultSet resul=null;
		String cadena = "SELECT * FROM productos;";
		//JOptionPane.showMessageDialog(null, cadena);
		try {
			resul=sst.executeQuery(cadena);
		
		String cad="Codigo\tNombre\tPrecio\tCantidad\n";
		int i=0;
		while(resul.next()){
			String cod=resul.getString("Codigos_de_producto");
			String no=resul.getString("Nombre");
			String pre=resul.getString("Precio_de_venta");
			String sto=resul.getString("Cantidad_de_existencia");
			nom[i]=no;
			pres[i]=pre;
			i++;
		}} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setBounds(100, 100, 450, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFormularioDeVenta = new JLabel("FORMULARIO DE VENTA");
		lblFormularioDeVenta.setBounds(144, 13, 150, 30);
		contentPane.add(lblFormularioDeVenta);
		
		JLabel lblNombreCliente = new JLabel("NOMBRE CLIENTE: ");
		lblNombreCliente.setBounds(12, 54, 143, 24);
		contentPane.add(lblNombreCliente);
		
		textField = new JTextField();
		textField.setBounds(154, 56, 215, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblProducto = new JLabel("PRODUCTO: ");
		lblProducto.setBounds(12, 91, 143, 24);
		contentPane.add(lblProducto);
		
		JComboBox comboBox = new JComboBox(nom);
		comboBox.setBounds(110, 91, 150, 24);
		contentPane.add(comboBox);
		
		JLabel lblPrecio = new JLabel("PRECIO: ");
		lblPrecio.setBounds(265, 91, 74, 24);
		contentPane.add(lblPrecio);
		
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int imde=comboBox.getSelectedIndex();
				textField_1.setText(pres[aux]);
			}
		});
		
		
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(316, 92, 74, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCantidad = new JLabel("CANTIDAD: ");
		lblCantidad.setBounds(12, 134, 143, 24);
		contentPane.add(lblCantidad);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(99, 135, 56, 24);
		contentPane.add(spinner);
		
		JCheckBox chckbxDescuento = new JCheckBox("DESCUENTO (10%)");
		chckbxDescuento.setBounds(226, 134, 179, 25);
		contentPane.add(chckbxDescuento);
		
		JLabel lblTipoDeDocumento = new JLabel("TIPO DE DOCUMENTO");
		lblTipoDeDocumento.setBounds(68, 179, 173, 24);
		contentPane.add(lblTipoDeDocumento);
		
		JRadioButton rdbtnReciboDePago = new JRadioButton("RECIBO DE PAGO");
		rdbtnReciboDePago.setBounds(70, 222, 127, 25);
		contentPane.add(rdbtnReciboDePago);
		
		JRadioButton rdbtnFactura = new JRadioButton("FACTURA",true);
		rdbtnFactura.setBounds(230, 222, 127, 25);
		contentPane.add(rdbtnFactura);
		
		ButtonGroup grup = new ButtonGroup();
		grup.add(rdbtnFactura);
		grup.add(rdbtnReciboDePago);
		
		JButton btnGenerar = new JButton("GENERAR");
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnGenerar.setBounds(27, 291, 97, 25);
		contentPane.add(btnGenerar);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setBounds(316, 291, 97, 25);
		contentPane.add(btnSalir);
	}
}
