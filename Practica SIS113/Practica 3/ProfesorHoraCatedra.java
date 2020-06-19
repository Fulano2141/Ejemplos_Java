public class ProfesorHoraCatedra extends Docente {
	int horasAsig;
	public ProfesorHoraCatedra(String nomem, int cI, String depen, double caliAsig, int horasAsig) {
		super(nomem, cI, depen, caliAsig);
		this.horasAsig = horasAsig;
	}
	public int getHorasAsig() {
		return horasAsig;
	}
	@Override
	public String toString() {
		return "Nombre: "+getNomem()+
				"\nCI: "+getCI()+
				"\nDependencia: "+getDepen()+
				"\nCalificacion Asignada: "+getCaliAsig()+
				"\nHoras Asignadas: " + getHorasAsig()+
				"\nSalario: "+ calcularSalario();
	}
	public String calcularSalario() {
		return getHorasAsig()*50+" ";
	}	
}
