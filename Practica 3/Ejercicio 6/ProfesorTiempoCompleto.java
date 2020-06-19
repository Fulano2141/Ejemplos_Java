import javax.swing.JOptionPane;
public class ProfesorTiempoCompleto extends Docente {
	int HorasInvesti;
	public ProfesorTiempoCompleto(String nomem, int cI, String depen, double caliAsig, int horasInvesti) {
		super(nomem, cI, depen, caliAsig);
		HorasInvesti = horasInvesti;
	}
	public int getHorasInvesti() {
		return HorasInvesti;
	}
	@Override
	public String toString() {
		return "Nombre: "+getNomem()+
				"\nCI: "+getCI()+
				"\nDependencia: "+getDepen()+
				"\nCalificacion Asignada: "+getCaliAsig()+
				"\nHoras Investistigacion: " + getHorasInvesti()+
				"\nSalario: "+ calcularSalario();
	}
	public String calcularSalario() {
		int a=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nivel de estudio\n"+
	     "1.- Pregrado\n"+
		 "2.- Maestria\n"+
	     "3.- Doctorado\n"));
		switch(a) {
		case 1:if(super.CaliAsig>4.5)
			return 12000.0+"Bs. ";
		else
			return 10000.0+"Bs. ";
		case 2:if(super.CaliAsig>4.5)
			return 20000.0+"Bs. ";
		else
			return 18000.0+"Bs. ";
		case 3:if(super.CaliAsig>4.5)
			return 27000.0+"Bs. ";
		else
			return 25000.0+"Bs. ";
		default:return 0.0+"Bs. ";
		}
		
	}
}
