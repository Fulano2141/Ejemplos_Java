import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class mainEmpleado {
	public static void main(String[] args) {
		int ci;
		String nom,cargo,c="";
		ci=Integer.parseInt(JOptionPane.showInputDialog("CI:"));
		nom=JOptionPane.showInputDialog("Nombre:");
		cargo=JOptionPane.showInputDialog("Cargo:");
		if(cargo =="Permanente") {
			double Sal=Double.parseDouble(JOptionPane.showInputDialog("Salario Basico:"));
			int DiasTra=Integer.parseInt(JOptionPane.showInputDialog("Dias Trabajados:"));
			Permanente c1=new Permanente(ci,nom,cargo,Sal,DiasTra);
			c=c1.toString();		
		}
		else {
			int HorTra=Integer.parseInt(JOptionPane.showInputDialog("Horas Trabajadas:"));
			int Tari=Integer.parseInt(JOptionPane.showInputDialog("Tarifa Horaria:"));
			Eventual c1=new Eventual(ci,nom,cargo,HorTra,Tari);
			c=c1.toString();
		}
		JTextArea are=new JTextArea(10,20);
		JScrollPane b=new JScrollPane(are);
		are.setText(c);
		JOptionPane.showMessageDialog(null,b);
	}
}
