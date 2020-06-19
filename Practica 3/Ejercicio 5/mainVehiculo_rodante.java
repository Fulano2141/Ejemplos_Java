/* 5.- Una clase base denominada “Vehiculo_rodante”, tiene como datos miembro 
 * el número de ruedas  y la capacidad de carga en pasajeros, una clase derivada 
 * llamada camión contiene la capacidad de carga, una segunda clase derivada 
 * llamada automóvil tiene como datos el tipo de automóvil, escribir una función 
 * “toString” que despliegue los datos de cada clase, agregando funciones para acceder
 * a número de ruedas, a la cantidad de pasajeros y la capacidad de carga de las clases. 
 * En el programa principal defina objetos para las tres clases y active estas funciones.
 */
import javax.swing.JOptionPane;
public class mainVehiculo_rodante {
	public static void main(String[] args) {
		int numrue=Integer.parseInt(JOptionPane.showInputDialog("Numero de ruedas"));
		int capacidad=Integer.parseInt(JOptionPane.showInputDialog("Capacidad de personas"));
		String capacarga=JOptionPane.showInputDialog("Capacidad de carga");
		String Tipo=JOptionPane.showInputDialog("Tipo de Automovil");
		Camion fu=new Camion(numrue,capacidad,capacarga);
		Automovil la=new Automovil(numrue,capacidad,Tipo);
		JOptionPane.showMessageDialog(null,fu.toString()+la.toString());
	}
}
