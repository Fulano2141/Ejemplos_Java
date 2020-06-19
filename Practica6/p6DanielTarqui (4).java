/* 4.-  Un archivo de texto contiene los  n�meros de  cedula y los nombres de un grupo de personas 
 * (separados por una coma), escriba un programa que permita almacenar en el archivo nuevas personas, 
 * efectuar la b�squeda (con el componente JCOMBOBOX) de alguna persona por el n�mero de cedula y 
 * generar un reporte de todo el archivo. Adem�s debe agregar una fotograf�a de cada persona, de 
 * tal forma que en el proceso de b�squeda despliegue esta fotograf�a, junto a sus datos.
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
public class Ejercicio4 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio4 frame = new Ejercicio4();
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
	public Ejercicio4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
