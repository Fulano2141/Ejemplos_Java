import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Anadir extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnNewButton;
	public Anadir() throws SQLException {
		setTitle("Agregar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 322, 278);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(142, 48, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);  
		
     
		textField_1 = new JTextField();
		textField_1.setBounds(142, 80, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(142, 113, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(142, 146, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setBounds(50, 51, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(50, 79, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Salario Basico");
		lblNewLabel_2.setBounds(20, 116, 96, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Antiguedad");
		lblNewLabel_3.setBounds(30, 149, 77, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conexion con = new Conexion();
				Connection conexion = con.getConexionMYSQL();
			    ResultSet resultado;
				con.setQuery("INSERT INTO salario (Codigo_empleado,Nombre_empleado,Salario_basico,Antiguedad_del_empleado) value('"+textField.getText()+"'"+","+"'"+textField_1.getText()+"'"+","+"'"+textField_2.getText()+"'"+","+"'"+textField_3.getText()+"')");
				JOptionPane.showMessageDialog(null,"Datos agregado");
				dispose();
			}
		});
		btnAgregar.setBounds(184, 194, 89, 23);
		contentPane.add(btnAgregar);
		
		btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(33, 193, 97, 25);
		contentPane.add(btnNewButton);
		
	}
}
