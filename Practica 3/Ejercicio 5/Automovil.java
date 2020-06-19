
public class Automovil extends Vehiculo_rodante {
	String tipoAuto;
	public Automovil(int numrue, int capacidad, String tipoAuto) {
		super(numrue, capacidad);
		this.tipoAuto = tipoAuto;
	}
	public String getTipoAuto() {
		return tipoAuto;
	}
	@Override
	public String toString() {
		return "\nTipo de Automovil: "+getTipoAuto() ;
	}
}
