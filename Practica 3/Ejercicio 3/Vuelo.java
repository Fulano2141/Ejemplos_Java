import java.util.ArrayList;
public class Vuelo extends Aerolinea {
	ArrayList<String> Tripulacion=new ArrayList<String>();
	String Origen,Destino;
	public Vuelo(String nombreAerolinea, int telefonoAerolinea, boolean estadoAerolinea, ArrayList<String> tripulacion,
			String origen, String destino) {
		super(nombreAerolinea, telefonoAerolinea, estadoAerolinea);
		Tripulacion = tripulacion;
		Origen = origen;
		Destino = destino;
	}
	public ArrayList<String> getTripulacion() {
		return Tripulacion;
	}
	public void setTripulacion(ArrayList<String> tripulacion) {
		Tripulacion = tripulacion;
	}
	public String getOrigen() {
		return Origen;
	}
	public void setOrigen(String origen) {
		Origen = origen;
	}
	public String getDestino() {
		return Destino;
	}
	public void setDestino(String destino) {
		Destino = destino;
	}
}
