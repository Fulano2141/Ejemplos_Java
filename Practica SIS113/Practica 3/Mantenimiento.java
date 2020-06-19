import java.util.ArrayList;
public class Mantenimiento extends Administrativo{
	ArrayList<String> list=new ArrayList<String>(); 
	int HorEx;
	public Mantenimiento(String nomem, int cI, String depen, double salbas, ArrayList<String> list, int horEx) {
		super(nomem, cI, depen, salbas);
		this.list = list;
		HorEx = horEx;
	}
	public ArrayList<String> getList() {
		return list;
	}
	public int getHorEx() {
		return HorEx;
	}
	@Override
	public String toString() {
		return "Nombre: "+getNomem()+
				"\nCI: "+getCI()+
				"\nDependencia: "+getDepen()+
				"\nSalones Asignados: " + getList()+
				"\nHoras Extras: " + calcularSalario();
	}
	public String calcularSalario() {
		if(HorEx>0)
			return 40*getHorEx()+"";
		else 
			return getHorEx()+"";
	}
}
