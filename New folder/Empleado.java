public class Empleado {
	int ci;
	String nom,cargo;
	public Empleado(int ci, String nom, String car) {
		this.ci = ci;
		this.nom = nom;
		this.cargo = car;
	}
	public int getCi() {
		return ci;
	}
	public String getNom() {
		return nom;
	}
	public String getCargo() {
		return cargo;
	}
	@Override
	public String toString() {
		return "CI:" +getCi()+ "\n Nombre: " + getNom() + "\n Cargo:" + getCargo();
	}
}
