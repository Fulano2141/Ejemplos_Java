import javax.swing.JOptionPane;

public class mainFactorial2 {
	public static void main(String[] X) {
		JOptionPane.showMessageDialog(null, "Ingrese el numero ");
		int num=(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese un numero ")));
		Factorial2 x=new Factorial2(num);
		x.salida();
	}
}
