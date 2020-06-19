/* 1.- Mediante un JComboBox elija de una lista que contiene una lista de pel�culas de estreno 
 * de alguna empresa cinematogr�fica y despliegue en un �rea de texto una peque�o afiche de la 
 * pel�cula elegida (no emplear archivos)
 */
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
public class Ejercicio1 extends JFrame {
	private String peli[]= {"Bohemian Rhapsody","El Cascanueces y los Cuatro Reinos","Millennium: Lo que no te mata te hace m�s fuerte","La noche de Halloween"};
	private String det[]= {"Son los a�os 70. El cantante Freddie Mercury, el guitarrista Brian May, el baterista Roger Taylor y el bajista John Deacon forman la banda brit�nica de rock Queen. Ser�a en 1975 cuando su sencillo Bohemian Rhapsody les colocar�a en un primer plano de la escena musical internacional. El filme es una cr�nica del mete�rico ascenso al Olimpo de la m�sica de esta banda, a trav�s de sus ic�nicas canciones y su revolucionario sonido, desde que Mercury se uniera a Brian May y Roger Taylor, hasta el macroconcierto Live Aid de 1985 en el estadio de Wembley, seis a�os antes de que Mercury muriera de forma prematura. Una celebraci�n rotunda y sonora de Queen y de su extraordinario e inclasificable cantante."
			,"Todo lo que Clara (Mackenzie Foy) quiere es una llave. Durante una fascinante fiesta de Navidad en la que todos reciben sus regalos, su padrino Drosselmeyer (Morgan Freeman) conducir� a la joven hacia esta llave �nica, que desaparece r�pidamente en un extra�o y misterioso mundo paralelo. All�, Clara conocer� a un soldado llamado Phillip (Jayden Fowora-Knight), una pandilla de ratones y a los gobernantes que presiden los tres Reinos: El Reino de las Nieves, el Reino de las Flores, y el Reino de los Dulces. Pero existe un cuarto Reino, el hogar de la tirana Mam� Jengibre (Helen Mirren). All� comenzaron todos los problemas de estos Reinos de fantas�a, cuando Mam� Jengibre inici� la guerra reuniendo a sus tropas. En un lugar donde nada es lo que parece, Clara ser� la �nica que pueda detener los planes de esta tirana."
			,"La chica del drag�n tatuado ha regresado. La joven 'hacker' Lisbeth Salander (Claire Foy) vuelve a demostrar una vez m�s su talento para la investigaci�n y para romper los mejores sistemas de seguridad del mundo. Unir� fuerzas de nuevo con el periodista Mikael Blomkvist (Sverrir Gudnason), un lobo solitario decidido a defender la verdad por encima de todo, aunque esto le lleve a arriesgar su carrera. Adem�s, tendr� que hacer frente a su hermana Camilla (Sylvia Hoeks), quien tendr� la llave a los secretos de su pasado. Juntos, Lisbeth y Mikael se ver�n envueltos en una compleja red de esp�as, ciberdelincuentes y funcionarios corruptos del gobierno. Millennium: Lo que no te mata te hace m�s fuerte es la secuela del filme de David Fincher Los hombres que no amaban a las mujeres (2011)."
			,"El psic�tico Michael Myers (Nick Castle) vuelve a la gran pantalla en el enfrentamiento final. Laurie Strode (Jamie Lee Curtis), que logr� escapar de su matanza en la noche de Halloween cuatro d�cadas atr�s, no ha olvidado aquel fat�dico encuentro en el que fue la �nica superviviente. Por eso, cuarenta a�os m�s tarde, Laurie, que ahora es abuela, ha convertido su casa en un b�nker impenetrable, por si Myers decidiera regresar alg�n d�a. Cuando la amenaza de Myers sea un hecho, la familia Strode, liderada por tres generaciones de mujeres, abuela, madre e hija, se convertir�n en la �nica esperanza para acabar con el villano. La hora de su confrontaci�n final con esta terror�fica figura enmascarada ha llegado. Secuela de La noche de Halloween, el cl�sico de terror de 1978 dirigido por John Carpenter."};
	private JPanel contentPane;
	private JComboBox comboBox;
	private final JEditorPane textArea = new JEditorPane();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio1 frame = new Ejercicio1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Ejercicio1() {
		setTitle("Peliculas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		comboBox = new JComboBox(peli);
		comboBox.setBounds(80, 44, 396, 22);
		contentPane.add(comboBox);
		JLabel lblSeleccioneUnA = new JLabel("Seleccione un a pelicula:");
		lblSeleccioneUnA.setBounds(12, 13, 243, 22);
		contentPane.add(lblSeleccioneUnA);

		textArea.setBounds(12, 79, 528, 233);
		contentPane.add(textArea);
		
		comboBox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				comboActionPerformed(evt);
			}
		});
	}
	private void comboActionPerformed(java.awt.event.ActionEvent evt) {
	    switch (comboBox.getSelectedIndex()) {
	        case 0:
	            textArea.setText(det[comboBox.getSelectedIndex()]);
	            break;
	        case 1:
	        	textArea.setText(det[comboBox.getSelectedIndex()]);
	            break;
	        case 2:
	        	textArea.setText(det[comboBox.getSelectedIndex()]);
	            break;
	        case 3:
	        	textArea.setText(det[comboBox.getSelectedIndex()]);
	            break;
	       default: textArea.setText("");
	    }
	}
}