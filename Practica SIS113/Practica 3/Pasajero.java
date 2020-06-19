import java.util.ArrayList;
public class Pasajero extends Vuelo {
	String Nombre;
	int Celular,CI;
	public Pasajero(String nombreAerolinea, int telefonoAerolinea, boolean estadoAerolinea,
			ArrayList<String> tripulacion, String origen, String destino, String nombre, int celular, int cI) {
		super(nombreAerolinea, telefonoAerolinea, estadoAerolinea, tripulacion, origen, destino);
		Nombre = nombre;
		Celular = celular;
		CI = cI;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public int getCelular() {
		return Celular;
	}
	public void setCelular(int celular) {
		Celular = celular;
	}
	public int getCI() {
		return CI;
	}
	public void setCI(int cI) {
		CI = cI;
	}
	
}
