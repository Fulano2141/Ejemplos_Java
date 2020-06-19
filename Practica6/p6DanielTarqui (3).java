/*  3.-  Escriba un programa donde a partir de un JLIST, el usuario pueda elegir por el código
 *  del producto (de un conjunto de estos almacenado en un archivo de texto)  y una vez visualizado 
 *  muestre la descripción, el stock y el precio unitario.
 */
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Ejercicio3 extends JFrame {
	private JPanel contentPane;
	private JList<String> list;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio3 frame = new Ejercicio3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Ejercicio3() {
		setTitle("Productos");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		list = new JList<String>();
		list.setBounds(33, 55, 137, 150);
		contentPane.add(list);
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		try {
			String aux;
			BufferedReader in=new BufferedReader(new FileReader("Productos.txt"));
			while((aux=in.readLine()) != null) {
				String[] lis=aux.split(";");
				modelo.addElement(lis[0]);
			}
			in.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Archivo no encontrado");
			e.printStackTrace();
		}
		list.setModel(modelo);
		
		JTextArea textArea = new JTextArea(183,150);
		textArea.setBounds(213, 53, 183, 150);
		contentPane.add(textArea);
		
		JLabel lblSeleccioneUnProducto = new JLabel("Seleccione un producto:");
		lblSeleccioneUnProducto.setBounds(33, 25, 257, 23);
		contentPane.add(lblSeleccioneUnProducto);
		
		JButton btnNewButton = new JButton("Ver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a=list.getSelectedValue(), cad="";
				try {
					String aux;
					BufferedReader in=new BufferedReader(new FileReader("Productos.txt"));
					while((aux=in.readLine()) != null) {
						String[] lis=aux.split(";");
						if(a.equals(lis[0])) {
							cad="Codigo: "+lis[0]+"\nDescripcion: "+lis[1]+"\nStock:"+lis[2]+"\nPrecio Unitario: "+lis[3];
						}
					}
					in.close();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Archivo no encontrado");
					e.printStackTrace();
				}
				textArea.setText(cad);
			}
		});
		btnNewButton.setBounds(54, 215, 97, 25);
		contentPane.add(btnNewButton);
				
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		btnLimpiar.setBounds(258, 216, 97, 25);
		contentPane.add(btnLimpiar);		
	}
}
