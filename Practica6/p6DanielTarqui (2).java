/* 2.	Crear un JFrame que simule la pantalla de inicio de sesión de cualquier sistema, mínimamente deberá contener un JTextField donde se ingrese el nombre de usuario, un JPasswordField donde se ingrese la contraseña y un JButton que sirva para validar los datos. Internamente el programa deberá contener un archivo binario con los siguientes nombres de usuario y sus contraseñas:
	USUARIO		CONTRASEÑA	
	carlos		car1783
	romina		458.ARG
	joanna		joaNaa123
	pedro		ppp123
	Al hacer click en el botón para validar se pueden presentar 3 casos:
	•	El usuario y contraseña coinciden con alguno de los proporcionados más arriba: entonces mostrar un mensaje con el texto : “ Bienvenido (usuario) “
	•	El usuario coincide con alguno de los proporcionados más arriba pero la contraseña no: entonces mostrar un mensaje con el texto : “ contraseña incorrecta, intente de nuevo”
	•	Ni el usuario ni la contraseña coinciden con alguno de los proporcionados más arriba: entonces mostrar un mensaje con el texto : “usuario no encontrado” 
	Los datos deben estar guardados en un archivo binario. */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Ejercicio2 extends JFrame {
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	protected int i=1;
	private String use[]={"carlos","romina","joanna","pedro"}; 
	private String pass[]={"car1783","458.ARG","joaNaa123","ppp123"};
	private JButton btnNewButton;
	private JLabel lblNewLabel,lblRegistrarse,lblUsuario,lblContrasena;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio2 frame = new Ejercicio2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Ejercicio2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblRegistrarse = new JLabel("Registrarse");
		lblRegistrarse.setBounds(181, 13, 145, 34);
		contentPane.add(lblRegistrarse);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(53, 72, 74, 23);
		contentPane.add(lblUsuario);
		
		lblContrasena = new JLabel("Contrasena:");
		lblContrasena.setBounds(53, 128, 74, 23);
		contentPane.add(lblContrasena);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(162, 128, 211, 23);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(162, 72, 211, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Iniciar sesion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comprobar(textField.getText(),passwordField.getText());
				i++;
			}
		});
		btnNewButton.setBounds(152, 189, 114, 34);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("Bienvenido!!");
		lblNewLabel.setBounds(181, 99, 181, 23);
	}
	public void comprobar(String text, String string){
		boolean user=false,passw=false;
		if(i==3){
			textField.setEditable(false);
			passwordField.setEditable(false);
			btnNewButton.setVisible(false);
		}
		for(int z=0;z<use.length;z++) {
			if(text.equals(use[z])) {
				user=true;
			}
			if(string.equals(pass[z])) {
				passw=true;
			}
		}
		
		if(user && passw) {
			lblNewLabel.setVisible(true);
			btnNewButton.setVisible(false);
			lblUsuario.setVisible(false);
			lblContrasena.setVisible(false);
			lblRegistrarse.setVisible(false);
			textField.setVisible(false);
			passwordField.setVisible(false);
			contentPane.add(lblNewLabel);
		}else {
			if(user) {
				JOptionPane.showMessageDialog(null,"Contrasena incorrecta");
			}if(passw) {
				JOptionPane.showMessageDialog(null,"Usuario incorrecto");
			}
		}
		textField.setText("");
		passwordField.setText("");
	}
}
