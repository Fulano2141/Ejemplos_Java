package Ejercicio1;
import java.awt.EventQueue; 
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.mysql.jdbc.Connection;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

public class BusAnElim extends JFrame {
	Conexion1 con = new Conexion1();
	Connection conexion = con.getConexionMYSQL();
	Statement sst =null;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusAnElim frame = new BusAnElim();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public BusAnElim() {
		try {
			 sst = conexion.createStatement();
		}catch (Exception e) {}
		setTitle("Formulario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnAnadir = new JRadioButton("Anadir",true);
		rdbtnAnadir.setBounds(41, 43, 79, 25);
		contentPane.add(rdbtnAnadir);
		
		JRadioButton rdbtnEliminar = new JRadioButton("Eliminar");
		rdbtnEliminar.setBounds(162, 43, 92, 25);
		contentPane.add(rdbtnEliminar);
		
		JRadioButton rdbtnBuscar = new JRadioButton("Buscar");
		rdbtnBuscar.setBounds(283, 43, 127, 25);
		contentPane.add(rdbtnBuscar);
		
		rdbtnAnadir.setActionCommand("1");
		rdbtnEliminar.setActionCommand("2");
		rdbtnBuscar.setActionCommand("3");
		
		textField = new JTextField();
		textField.setBounds(157, 93, 202, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		ButtonGroup grup = new ButtonGroup();
		grup.add(rdbtnAnadir);
		grup.add(rdbtnEliminar);
		grup.add(rdbtnBuscar);
		
		JLabel lblProducto = new JLabel("Codigo de producto:");
		lblProducto.setBounds(34, 93, 116, 22);
		contentPane.add(lblProducto);
		
		SpinnerNumberModel model = new SpinnerNumberModel(0,0,999,1);
		
		JSpinner spinner = new JSpinner(model);
	    spinner.setBounds(330, 183, 56, 22);
	    contentPane.add(spinner);
		
		rdbtnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textField_2.setEditable(false);
				textField_3.setEditable(false);
				spinner.setEnabled(false);
			}
		});
		rdbtnAnadir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textField_2.setEditable(true);
				textField_3.setEditable(true);
				spinner.setEnabled(true);
			}
		});
		rdbtnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textField_2.setEditable(false);
				textField_3.setEditable(false);
				spinner.setEnabled(false);
			}
		});
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)  {
				String op=grup.getSelection().getActionCommand();
				
				if(op.equals("1")) {
					String cadena = "INSERT INTO Productos (Codigos_de_producto, Nombre, Precio_de_venta, Cantidad_de_existencia) "
							+ "VALUE ('"+textField.getText()+"','"+textField_2.getText()+"','"+textField_3.getText()+"','"+spinner.getValue()+"')";
					//JOptionPane.showMessageDialog(null, cadena);
					int i=-1;
					try {
						i = sst.executeUpdate(cadena);
					} catch (SQLException ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
					if(i!=-1) {
						JOptionPane.showMessageDialog(null, "Datos guardados");
						dispose();}
					else
						JOptionPane.showMessageDialog(null, "Error con la Base de datos, datos no guardados");
				}//DELETE FROM `ejercicio1`.`productos` WHERE (`Codigos_de_producto` = '123P');
				if(op.equals("2")) {
					String cadena = "DELETE FROM productos WHERE productos.Codigos_de_producto = '"+textField.getText()+"'";
					//JOptionPane.showMessageDialog(null, cadena);
					boolean i=true;
					try {
						i = sst.execute(cadena);
					} catch (SQLException ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
					if(!i) {
						JOptionPane.showMessageDialog(null, "Datos eliminados");
						dispose();}
					else
						JOptionPane.showMessageDialog(null, "Error con la Base de datos, datos no eliminados");
				}
				if(op.equals("3")) {
					ResultSet resul=null;
					String cadena = "SELECT * FROM productos WHERE productos.Codigos_de_producto = '"+textField.getText()+"'";
					//JOptionPane.showMessageDialog(null, cadena);
					try {
						resul=sst.executeQuery(cadena);
					
					String cad="Codigo\tNombre\tPrecio\tCantidad\n";
					while(resul.next()){
						cad=cad+resul.getString("Codigos_de_producto")+"\t"+resul.getString("Nombre")+"\t"+resul.getString("Precio_de_venta")+"\t"+resul.getString("Cantidad_de_existencia")+"\n";
					}
					if(cad.equals("")) {
						JOptionPane.showMessageDialog(null,"Dato no encontrado");
					}else {
						JTextArea text=new JTextArea(cad);
						JScrollPane sc=new JScrollPane(text);
						JOptionPane.showMessageDialog(null, sc);
					}} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				textField.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}
		});
		btnConfirmar.setBounds(267, 228, 97, 25);
		contentPane.add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Salir");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					sst.close();
				} catch (SQLException e) {}
				System.exit(0);
			}
		});
		btnCancelar.setBounds(60, 228, 97, 25);
		contentPane.add(btnCancelar);
		
		JButton btnVenta = new JButton("Venta");
		btnVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Ejercicio1 frame = new Ejercicio1();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception eq) {
					eq.printStackTrace();
				}
			}
		});
		btnVenta.setToolTipText("Realizar una venta");
		btnVenta.setBounds(196, 276, 97, 25);
		contentPane.add(btnVenta);
		
		JLabel lblRealizarUnaVenta = new JLabel("Realizar una venta:");
		lblRealizarUnaVenta.setBounds(30, 276, 127, 25);
		contentPane.add(lblRealizarUnaVenta);
		
		JLabel lblConexionConBd = new JLabel("Conexion con BD:");
		lblConexionConBd.setBounds(64, 18, 144, 16);
		contentPane.add(lblConexionConBd);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(202, 15, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		InterfazConexion.verificar();
	    String cad = InterfazConexion.verificar();
	    textField_1.setText(cad);
	    
	    JLabel lblNombre = new JLabel("Nombre:");
	    lblNombre.setBounds(34, 138, 116, 22);
	    contentPane.add(lblNombre);
	    
	    textField_2 = new JTextField();
	    textField_2.setColumns(10);
	    textField_2.setBounds(157, 138, 202, 22);
	    contentPane.add(textField_2);
	    
	    JLabel lblPrecioDeVenta = new JLabel("Precio de venta:");
	    lblPrecioDeVenta.setBounds(34, 183, 116, 22);
	    contentPane.add(lblPrecioDeVenta);
	    
	    textField_3 = new JTextField();
	    textField_3.setColumns(10);
	    textField_3.setBounds(157, 183, 56, 22);
	    contentPane.add(textField_3);
	    
	    JLabel lblCantidad = new JLabel("Cantidad:");
	    lblCantidad.setBounds(245, 183, 73, 22);
	    contentPane.add(lblCantidad);
	    
	    
	}

}
