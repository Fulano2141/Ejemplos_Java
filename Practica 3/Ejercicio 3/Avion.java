import java.util.ArrayList;
public class Avion extends Vuelo{
	String Marca, Modelo, Capacidad;
	public Avion(String nombreAerolinea, int telefonoAerolinea, boolean estadoAerolinea, ArrayList<String> tripulacion,
			String origen, String destino, String marca, String modelo, String capacidad) {
		super(nombreAerolinea, telefonoAerolinea, estadoAerolinea, tripulacion, origen, destino);
		Marca = marca;
		Modelo = modelo;
		Capacidad = capacidad;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public String getModelo() {
		return Modelo;
	}
	public void setModelo(String modelo) {
		Modelo = modelo;
	}
	public String getCapacidad() {
		return Capacidad;
	}
	public void setCapacidad(String capacidad) {
		Capacidad = capacidad;
	}
}
