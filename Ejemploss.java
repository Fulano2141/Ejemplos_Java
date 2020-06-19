import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/* crear una interface de usuario sin layouts que permita efecuar el cambio de moneda:
 * Entrada: Bolivianos
 * Salida: Dolares y Euros 
 */
public class Ejemploss extends JFrame implements ActionListener {
	JButton bt1, bt2, bt3;
	JLabel lb1, lb2;
	JTextField tf1, tf2;

	// public static void main(String[] args) {
	// 	Ejemploss ej = new Ejemploss();
	// }

	public Ejemploss() {
		super("Cambio de moneda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		lb1 = new JLabel("Ingrese el monto: ");
		lb1.setBounds(15, 0, 200, 20);// (x,y,ancho,alto)
		tf1 = new JTextField(10);
		tf1.setBounds(15, 60, 200, 20);
		lb2 = new JLabel("El cambio es:");
		lb2.setBounds(15, 120, 200, 50);
		tf2 = new JTextField(10);
		tf2.setBounds(15, 240, 200, 50);
		bt1 = new JButton("Calcular");
		bt1.setBounds(15, 340, 200, 50);
		bt2 = new JButton("Borrar");
		bt2.setBounds(230, 340, 200, 50);
		bt3 = new JButton("Finalizar");
		// bt3.setBounds(400,340,200,50);
		add(lb1);
		add(tf1);
		add(lb2);
		add(tf2);
		add(bt1);
		add(bt2);
		add(bt3);
		bt1.addActionListener(this);
		bt1.setToolTipText("Calcular el cambio");
		bt2.addActionListener(this);
		bt2.setToolTipText("Limpiar resultado");
		bt3.addActionListener(this);
		bt3.setToolTipText("");
		tf2.setEditable(false);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == bt1) {
			double x = Double.parseDouble(tf1.getText());
			String cam = cambio(x);
			tf2.setText(cam);
		}
	}

	public String cambio(double bol) {
		double eu = bol * 9.92;
		double dol = bol * 6.96;
		return "Euros: " + eu + " Dolares: " + dol;
	}
}