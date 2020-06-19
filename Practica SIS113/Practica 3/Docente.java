import javax.swing.JOptionPane;

public class Docente extends Empleado{
	protected double CaliAsig;
	public Docente(String nomem, int cI, String depen, double caliAsig) {
		super(nomem, cI, depen);
		CaliAsig = caliAsig;
	}
	public double getCaliAsig() {
		return CaliAsig;
	}
	public String calcularSalario() {
		int profe=Integer.parseInt(JOptionPane.showInputDialog("1.-Tiempo completo\n 2.-Horas Catedra"));
		switch(profe) {
		case 1:
			int HorEx=Integer.parseInt(JOptionPane.showInputDialog("Horas De Investigacion "));
			ProfesorTiempoCompleto no=new ProfesorTiempoCompleto(getNomem(),getCI(),getDepen(),getCaliAsig(),HorEx);
			return no.toString();
		case 2:
			int HorE=Integer.parseInt(JOptionPane.showInputDialog("Horas asignadas: "));
			ProfesorHoraCatedra ful=new ProfesorHoraCatedra(getNomem(),getCI(),getDepen(),getCaliAsig(),HorE);
			return ful.toString();
		default: return "Error";
		}
	}
	
}
