
public class Aerolinea {
	protected String NombreAerolinea;
	protected int TelefonoAerolinea;
	boolean EstadoAerolinea;
	public Aerolinea(String nombreAerolinea, int telefonoAerolinea, boolean estadoAerolinea) {
		NombreAerolinea = nombreAerolinea;
		TelefonoAerolinea = telefonoAerolinea;
		EstadoAerolinea = estadoAerolinea;
	}
	public String getNombreAerolinea() {
		return NombreAerolinea;
	}
	public void setNombreAerolinea(String nombreAerolinea) {
		NombreAerolinea = nombreAerolinea;
	}
	public int getTelefonoAerolinea() {
		return TelefonoAerolinea;
	}
	public void setTelefonoAerolinea(int telefonoAerolinea) {
		TelefonoAerolinea = telefonoAerolinea;
	}
	public boolean isEstadoAerolinea() {
		return EstadoAerolinea;
	}
	public void setEstadoAerolinea(boolean estadoAerolinea) {
		EstadoAerolinea = estadoAerolinea;
	}
} 
