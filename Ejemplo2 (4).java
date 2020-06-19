import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
public class Ejemplo2 extends JFrame implements ActionListener{
	JButton bt1,bt2;
	JLabel lb1,lb2,lb3;
	JTextField tf1,tf2,tf3;
	public Ejemplo2 () {
		super("Cambio de grados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		lb1 = new JLabel("Grados centrigrados: ");
		lb2 = new JLabel("Grados farenheit:    ");
		lb3 = new JLabel("Resultado:    ");
		tf1 = new JTextField (10);
		tf2 = new JTextField (10);
		tf3 = new JTextField (10);
		bt1 = new JButton ("Convertir");
		bt2 = new JButton ("Convertir");
		add(lb1);		add(tf1);		add(bt1);
		add(lb2);		add(tf2);		add(bt2); 
		add(lb3);		add(tf3);
		bt1.addActionListener(this);
		bt1.setToolTipText("Calcular el cambio");
		bt2.addActionListener(this);
		bt2.setToolTipText("Limpiar resultado");
		setVisible(true);
		tf3.setEditable(false);
	}
	public void actionPerformed (ActionEvent event) {
		if(event.getSource()==bt1){
			double x=Double.parseDouble(tf1.getText());
			String cen=cambio1(x);
			tf2.setText("");
			tf3.setText(cen+" Farenheit");
		}
		if(event.getSource()==bt2){
			double x=Double.parseDouble(tf2.getText());
			String cen=cambio2(x);
			tf1.setText("");
			tf3.setText(cen+" Centrigrados");
		}
	}
	public String cambio1(double bol) {
		double con=bol*(9.0/5.0)+32;
		return ""+con;
	}
	public String cambio2(double bol) {
		double con=(bol-32)*(5.0/9.0);
		return ""+con;
	}
}
