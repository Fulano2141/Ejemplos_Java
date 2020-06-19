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
public class temp extends JFrame {
	private JPanel contentPane;
	private JTextField t1;
	private JTextField t4;
	private JTextField t2;
	private JTextField t3;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					temp frame = new temp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public temp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		t1 = new JTextField();
		t1.setBounds(57, 54, 184, 20);
		t1.setToolTipText("ingrese datos");
		contentPane.add(t1);
		t1.setColumns(10);
		
		JButton bt1 = new JButton("Convertir a °c");
		bt1.setBounds(282, 118, 156, 23);
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource()==bt1) {

		            double j=Double.parseDouble(t1.getText());
		            double s=(j-32)*5/9;
		        	t4.setText(Double.toString(s));
		        }
			}
		});
		contentPane.add(bt1);
		
		JButton bt2 = new JButton("Convertir a °F");
		bt2.setBounds(282, 64, 144, 23);
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==bt2) {
		        	double p=Double.parseDouble(t2.getText());
		        	double eu=(9/5*p)+32;
		        	t3.setText(Double.toString(eu));
		        }
			}
		});
		contentPane.add(bt2);
		
		t4 = new JTextField();
		t4.setBounds(461, 119, 223, 20);
		t4.setToolTipText("conversion c");
		t4.setEditable(false);
		contentPane.add(t4);
		t4.setColumns(10);
		
		JLabel lblConvertido = new JLabel("convertido");
		lblConvertido.setBounds(544, 29, 75, 14);
		contentPane.add(lblConvertido);
		
		JLabel lblIngreseUnMonto = new JLabel("Ingrese grados °c");
		lblIngreseUnMonto.setBounds(84, 29, 143, 14);
		contentPane.add(lblIngreseUnMonto);
		
		t2 = new JTextField();
		t2.setBounds(57, 136, 184, 20);
		t2.setToolTipText("ingrese datos");
		t2.setColumns(10);
		contentPane.add(t2);
		
		JLabel label = new JLabel("Ingrese grados °f");
		label.setBounds(84, 97, 143, 14);
		contentPane.add(label);
		
		t3 = new JTextField();
		t3.setBounds(461, 54, 223, 20);
		t3.setToolTipText("conversion f");
		t3.setEditable(false);
		t3.setColumns(10);
		contentPane.add(t3);
	}
}