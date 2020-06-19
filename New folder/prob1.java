import java.math.*;
import javax.swing.*;
import java.util.*;
public class prob1 {
	public static void main(String[] args) {
		String c="",d1,d2,d3;
		double radio,h,radioi;
		d1=JOptionPane.showInputDialog("Radio:");
		radio=Double.parseDouble(d1);
		d2=JOptionPane.showInputDialog("Altura:");
		h=Double.parseDouble(d2);
		d3=JOptionPane.showInputDialog("Radio Interno:");
		radioi=Double.parseDouble(d3);
		circulo c1=new circulo(radio);
		cilindro c2=new cilindro(radio,h);
		cilindrohueco c3=new cilindrohueco(radio,h,radioi);
		c=c1.toString()+"\n"+c2.toString()+"\n"+c3.toString();
		JTextArea are=new JTextArea(10,20);
		JScrollPane b=new JScrollPane(are);
		are.setText(c);
		JOptionPane.showMessageDialog(null,b);
	}
}
