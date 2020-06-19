/* 6.- Se debe almacenar los datos de las transacciones bancarias de clientes que tienen  
 * su caja de ahorros en un banco, para lo cual se debe crear un archivo tipo binario que guarde los siguientes datos:
 *	- Número de cuenta
 *	- Nombre del cliente
 *	- Fecha de apertura de cuenta
 *	- Saldo actual
 *Se debe crear un JFrame que contenga botones para activar frames para:
 * -	Añadir nuevos clientes 
 * -	Efectuar la búsqueda por número de cliente 
 * -	Actualizar el saldo por depósitos y retiros que efectué el cliente (Incluir JRadioButton)
 * -	Generar un reporte de todos los clientes (Incluir un componente JTable)
 * Se recomienda en el punto de actualización registrar en otro archivo binario las transacciones 	
 * efectuadas por el cliente, con el  formato:
 * - Nro de cuenta
 * - Fecha de transacción
 * - Tipo de transacción (JRadioButton)
 * - Monto de la transacción */
package Ejercicio6;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class Ejercicio6 extends JFrame {
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio6 frame = new Ejercicio6();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Ejercicio6() {
		setTitle("ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAnadir = new JButton("Anadir");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Anadir frame1 = new Anadir();
					frame1.setVisible(true);
					frame1.setLocationRelativeTo(null);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAnadir.setToolTipText("Anade nuevos datos");
		btnAnadir.setBounds(66, 48, 120, 25);
		contentPane.add(btnAnadir);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Buscar frame2 = new Buscar();
					frame2.setVisible(true);
					frame2.setLocationRelativeTo(null);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnBuscar.setBounds(254, 48, 120, 25);
		contentPane.add(btnBuscar);
		
		JButton btnTransaccion = new JButton("Transaccion");
		btnTransaccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Transac frame3 = new Transac();
					frame3.setVisible(true);
					frame3.setLocationRelativeTo(null);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnTransaccion.setBounds(66, 110, 120, 25);
		contentPane.add(btnTransaccion);
		
		JButton btnCancelar = new JButton("Reporte");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					reporte("Usuarios.bin");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCancelar.setBounds(254, 110, 120, 25);
		contentPane.add(btnCancelar);
		
		JLabel lblSeleccioneQueAccion = new JLabel("Seleccione que accion desea realizar:");
		lblSeleccioneQueAccion.setBounds(22, 13, 285, 22);
		contentPane.add(lblSeleccioneQueAccion);
		
		JButton button = new JButton("Cancelar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button.setBounds(157, 169, 120, 25);
		contentPane.add(button);
	}
	public static void reporte(String string) throws IOException {
		try {
			DataInputStream fi = new DataInputStream(new FileInputStream(string));
			String cad="Codigo\tNombre\tEdad\tOcupacion\n";
			while(fi.available()!=0){
				int cod=fi.readInt();
				String nom=fi.readUTF();
				String edad=fi.readUTF();
				double ocu=fi.readDouble();
				cad+=cod+"\t"+nom+"\t"+edad+"\t"+ocu+"\t"+"\n";
			}
			JTextArea jta=new JTextArea(10,30);
			jta.setText(cad);
			JScrollPane barra = new JScrollPane(jta);
			JOptionPane.showMessageDialog(null,barra);
			fi.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "no se pudo leer el archivo");
		}
	}
}
