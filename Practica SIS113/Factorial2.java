import javax.swing.JOptionPane;

public class Factorial2 {
	int num,res;
	public Factorial2(int num) {
		this.num = num;
	}
	public int resultado() {
		int m=1;
		for(int i=1;i<=num;i++) {
			m=m*i;}
		return m;
	}
	public void salida() {
		System.out.println("El factorial es: "+resultado());
	}
	public static void main(String[] X) {
	//	JOptionPane.showMessageDialog(null, "Ingrese el numero ");
		int num=(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese un numero ")));
		Factorial2 x=new Factorial2(num);
		x.salida();
	}

	
}
