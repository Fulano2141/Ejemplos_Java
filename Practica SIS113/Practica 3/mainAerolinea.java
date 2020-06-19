/* 3. Una aerolínea brinda vuelos trasladando pasajeros en aviones entre diferentes destinos. 
 * Cada vuelo sale de un aeropuerto de origen y llega a un aeropuerto de destino  Algunos 
 * vuelos pueden tener escalas intermedias. Los aeropuertos están localizados en ciudades, 
 * pudiendo tener una ciudad más de un aeropuerto. A cada vuelo se le asigna un avión y una 
 * tripulación, la cual consta de 2 pilotos, 1 operador de comunicaciones, 2 comisarios de 
 * abordo y 4 azafatas. Cada pasajero de un vuelo tiene asignado un asiento.
 * Identifique clases y relaciones entre clases, agregue atributos y operaciones tomado en 
 * cuenta  un contexto general.
 */
import javax.swing.JOptionPane;
public class mainAerolinea {
	public static void main(String args[]){
		String nombreaero=JOptionPane.showInputDialog(null,"Ingrese nombre de la aerolinea");
		int teleaero=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese telefono de la aerolinea"));
		boolean estado=true;  
		Aerolinea obj=new Aerolinea(nombreaero,teleaero,estado);}
}
