/* 4.-  Sea la siguiente clase base:
 * 		Cuadrado:
 * 	         lado (tipo real)
 *      y la clase derivada:
 *      Paralelepido:
 *      altura (tipo real)
 *      Escriba los constructores de inicialización respectivos, funciones “getters”, 
 *      una función que encuentre la superficie de cada clase y una función de salida 
 *      que calcule el volumen del paralelepípedo. */
import javax.swing.JOptionPane;
public class mainSuperficie {
	public static void main(String[] args) {
		double ladoa,ladob,ladoc;
		ladoa=Double.parseDouble(JOptionPane.showInputDialog("Ingrese una lado del cubo"));
		ladob=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la medida b de un paralelepipedo"));
		ladoc=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la medida c de un paralelepipedo"));
		Cuadrado obj=new Cuadrado(ladoa);
		Paralelepipedo obj1=new Paralelepipedo(ladoa,ladob,ladoc);
		JOptionPane.showMessageDialog(null,"La superficie del cuadrado de lado: "+ladoa+" es: "+obj.toString());
		JOptionPane.showMessageDialog(null,"La superficie del paralelepipedo es: "+obj1.toString());
	}
}
