import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Administrativo extends Empleado{
	double Salbas;
	public Administrativo(String nomem, int cI, String depen, double Salbas) {
		super(nomem, cI, depen);
		this.Salbas=Salbas;
	}
	public double getSalbas() {
		return Salbas;
	}
	public String calcularSalario() {
		int profe=Integer.parseInt(JOptionPane.showInputDialog("1.-Mantenimiento\n 2.-Recursos Humanos"));
		switch(profe) {
		case 1:
			ArrayList<String> list=new ArrayList<String>(); 
			int HorE=Integer.parseInt(JOptionPane.showInputDialog("Numero de lugares en mantemiento: "));
			for(int i=0;i<HorE;i++){
				  String v=JOptionPane.showInputDialog(null,"Ingrese el lugar a mantener: ");
				  list.add(v);
		  }
			int HorEx=Integer.parseInt(JOptionPane.showInputDialog("Horas Extras: "));
			Mantenimiento no=new Mantenimiento(getNomem(),getCI(),getDepen(),Salbas,list,HorEx);
			return no.toString();
		case 2:
			String Tipo=JOptionPane.showInputDialog("Tipo: ");
			RecursosHumanos ful=new RecursosHumanos(getNomem(),getCI(),getDepen(),Salbas,Tipo);
			return ful.toString();
		default: return "Error";
		}
	}
}
