/* 2.- Generar la aproximación al valor de PI (3.14159…) mediante una serie, 
 * utilizar el concepto de constructor y la definición de algún  objeto. */
import javax.swing.JOptionPane;
public class Ejercicio2 {
	int n;
	public Ejercicio2(int n) {
		this.n = n;
	}
	public double resultado() {
		double aprox=0;
		int con1=1;
	    for (int con=1;con<=n;con+=2)
	    {

	      if (con1%2==0)
	        aprox=aprox+4.0/con;
	      else 
	        aprox=aprox-4.0/con;
	      con1++;
	    } 
	    return Math.abs(aprox);
	}
	public void salida() {
		System.out.println("El resutaldo es: "+resultado());
	}
	public static void main(String[] args) {
		int n=(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese un numero ")));
		Ejercicio2 obj=new Ejercicio2(n);
		obj.salida();
	}
}
