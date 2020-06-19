/* 5.- Una empresa que vende computadoras decide efectuar utilizar una aplicación que le permita dinamizar 
 * el proceso de venta, para lo cual requiere una interfaz denominada “Formulario de Venta”, que contenga:
 * De tal forma que luego de elegir la marca de la computadora y opcionalmente algunos componentes 
 * determine el precio total, al pulsar el botón respetivo. No es necesario incluir ningún tipo de archivo.
 */
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import net.miginfocom.swing.MigLayout;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Ejercicio5 extends JFrame {
	private JRadioButton rdbtnAsus,rdbtnToshiba,rdbtnHp,rdbtnSony;
	private JPanel contentPane;
	private ButtonGroup grup;
	private JLabel lblComponentesOpcionales;
	private JTextField textField;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio5 frame = new Ejercicio5();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Ejercicio5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblComercialcoloso = new JLabel("Comercial \"COLOSO\"");
		lblComercialcoloso.setBounds(12, 12, 127, 16);
		contentPane.add(lblComercialcoloso);
		
		Date dat = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		JLabel label = new JLabel(dateFormat.format(dat));
		label.setBounds(308, 12, 95, 16);
		contentPane.add(label);
		
		JLabel lblFormularioDeVentas = new JLabel("Formulario de ventas");
		lblFormularioDeVentas.setBounds(154, 33, 121, 16);
		contentPane.add(lblFormularioDeVentas);
		
		rdbtnSony = new JRadioButton("SONY 15\" (750 $us)");
		rdbtnSony.setBounds(49, 73, 143, 25);
		contentPane.add(rdbtnSony);
		
		rdbtnHp = new JRadioButton("HP 15\" (690 $us)");
		rdbtnHp.setBounds(238, 73, 143, 25);
		contentPane.add(rdbtnHp);
		
		rdbtnToshiba = new JRadioButton("TOSHIBA 17\" (980 $us)");
		rdbtnToshiba.setBounds(49, 119, 163, 25);
		contentPane.add(rdbtnToshiba);
		
		rdbtnAsus = new JRadioButton("ASUS 13\" (500 $us)");
		rdbtnAsus.setBounds(238, 119, 143, 25);
		contentPane.add(rdbtnAsus);
		
		rdbtnSony.setActionCommand("750");
		rdbtnHp.setActionCommand("690");
		rdbtnToshiba.setActionCommand("980");
		rdbtnAsus.setActionCommand("500");
		
		grup = new ButtonGroup();
		grup.add(rdbtnSony);
		grup.add(rdbtnHp);
		grup.add(rdbtnToshiba);
		grup.add(rdbtnAsus);
		
		lblComponentesOpcionales = new JLabel("Componentes Opcionales");
		lblComponentesOpcionales.setBounds(12, 153, 153, 25);
		contentPane.add(lblComponentesOpcionales);
		
		JCheckBox chDvd = new JCheckBox("DVD Externo (50 $us)");
		chDvd.setBounds(19, 187, 153, 25);
		contentPane.add(chDvd);
		
		JCheckBox chckbxImpresoraHp = new JCheckBox("Impresora HP (65 $us)");
		chckbxImpresoraHp.setBounds(19, 222, 173, 25);
		contentPane.add(chckbxImpresoraHp);
		
		JLabel lblPrecioTotal = new JLabel("Precio Total");
		lblPrecioTotal.setBounds(265, 157, 103, 21);
		contentPane.add(lblPrecioTotal);
		
		JLabel lblus = new JLabel("$us:");
		lblus.setBounds(248, 191, 40, 21);
		contentPane.add(lblus);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(275, 187, 95, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean dvd=chDvd.isSelected();
				boolean imp=chckbxImpresoraHp.isSelected();
				int sum=0;
				if(dvd)
					sum=sum+50;
				if(imp)
					sum=sum+65;
				String prior=grup.getSelection().getActionCommand();
				sum=sum+Integer.parseInt(prior);
				textField.setText(sum+"");
			}
		});
		btnCalcular.setBounds(265, 222, 97, 25);
		contentPane.add(btnCalcular);
	}
}
