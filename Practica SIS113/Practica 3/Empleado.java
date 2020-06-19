public class Empleado {
	protected String Nomem;
	protected int CI;
	protected String Depen;
	public Empleado(String nomem, int cI, String depen) {
		Nomem = nomem;
		CI = cI;
		Depen = depen;
	}
	public String getNomem() {
		return Nomem;
	}
	public int getCI() {
		return CI;
	}
	public String getDepen() {
		return Depen;
	}
}
