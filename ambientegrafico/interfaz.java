package fabri;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
public class interfaz extends JFrame {

	private JPanel contentPane;
	private JTextField txtIngreseElMonto;
	private JTextField textField_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfaz frame = new interfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public interfaz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		txtIngreseElMonto = new JTextField();
		txtIngreseElMonto.setToolTipText("ingrese en bolivianos");
		txtIngreseElMonto.setBounds(42, 39, 184, 20);
		contentPane.add(txtIngreseElMonto);
		txtIngreseElMonto.setColumns(10);
		JButton bt1 = new JButton("Dolares");
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource()==bt1) {

		            double j=Double.parseDouble(txtIngreseElMonto.getText());
		        	double s=j/6.98;
		        	textField_1.setText(Double.toString(s));
		        }
			}
		});
		bt1.setBounds(72, 87, 89, 23);
		contentPane.add(bt1);
		
		JButton bt2 = new JButton("Euros");
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==bt2) {
		        	double p=Double.parseDouble(txtIngreseElMonto.getText());
		        	double eu=p/8.50;
		        	textField_1.setText(Double.toString(eu));
		        }
			}
		});
		bt2.setBounds(72, 121, 89, 23);
		contentPane.add(bt2);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Bolivianos convertidos");
		textField_1.setEditable(false);
		textField_1.setBounds(224, 89, 143, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblConvertido = new JLabel("convertido");
		lblConvertido.setBounds(267, 113, 75, 14);
		contentPane.add(lblConvertido);
		
		JLabel lblIngreseUnMonto = new JLabel("Ingrese un Monto en Bolivianos");
		lblIngreseUnMonto.setBounds(42, 11, 184, 14);
		contentPane.add(lblIngreseUnMonto);
	}
}