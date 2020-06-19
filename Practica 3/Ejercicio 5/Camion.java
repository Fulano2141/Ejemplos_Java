
public class Camion extends Vehiculo_rodante {
	String capacarga;
	public Camion(int numrue, int capacidad, String capacarga) {
		super(numrue, capacidad);
		this.capacarga = capacarga;
	}
	public String getCapacarga() {
		return capacarga;
	}
	@Override
	public String toString() {
		return "Capacidad de carga: "+getCapacarga()+
				"\nNumero de ruedas: "+getNumrue()+
				"\nCapacidad de personas: " + getCapacidad();	
	}
}