import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class Ejemplo3  extends JFrame implements ActionListener {
	JButton bt1;
	JLabel lb1,lb2,lb3;
	JTextField tf1;
	JPasswordField tf2;
	int i=1;
	public Ejemplo3 () {
		super("Ingresar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		lb1 = new JLabel("REGISTRARSE");
		lb2 = new JLabel("USUARIO:   ");
		lb3 = new JLabel("CONTRASEÑA:");
		tf1 = new JTextField (10);
		tf2 = new JPasswordField (10);
		bt1 = new JButton ("INGRESAR");
		add(lb1);		add(lb2);
		add(tf1);		add(lb3);
		add(tf2);		add(bt1);	
		bt1.addActionListener(this);
		bt1.setToolTipText("INGRESAR");
		setVisible(true);
		
	}
	public void actionPerformed (ActionEvent event) {
		if(event.getSource()==bt1){
			String user=tf1.getText();
			String pass=tf2.getText();
			log(user,pass);
		}
		
	}
	@SuppressWarnings("unlikely-arg-type")
	public void log(String user, String pass) {
		if(i!=3) {
			i++;
			String [] Usuarios = {"Fulano","Felano","qwerty"};
			String [] Contra = {"2142","1234","4321"};
			//JOptionPane.showMessageDialog(null, i);
			for(int o=0;Usuarios.length>o;o++) {
				if(user.equals(Usuarios[o])) {
					for(int u=0;Usuarios.length>u;u++) {
						if(pass.equals(Contra[u])) {
							JOptionPane.showMessageDialog(null,"Bienvenido");
							i=3;
						}
					}
				}
			}
		}
		else {
			tf1.setEditable(false);
			tf2.setEditable(false);
		}
	}
	public static void main(String[] args) {
		Ejemplo3 v1=new Ejemplo3();
		v1.setBounds(0,0,400,150);
		//v1.setVisible(true);
		v1.setLocationRelativeTo(null);
	}
}
