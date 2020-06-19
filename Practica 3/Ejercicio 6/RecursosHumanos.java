public class RecursosHumanos extends Administrativo {
	String Tipo;
	public RecursosHumanos(String nomem, int cI, String depen, double salbas, String tipo) {
		super(nomem, cI, depen, salbas);
		Tipo = tipo;
	}
	public String getTipo() {
		return Tipo;
	}
	@Override
	public String toString() {
		return "Nombre: "+getNomem()+
				"\nCI: "+getCI()+
				"\nDependencia: "+getDepen()+
				"\nSalario Base: "+calcularSalario()+
				"Tipo: " + getTipo();
	}	
	public String calcularSalario() {
		switch(Tipo) {
		case "Tesoreria":
		return 1000.0+getSalbas()+" ";
		case "Secretaria":
			return 700.0+getSalbas()+" ";
		default:return "0"+getSalbas();
		}
		
	}
}
