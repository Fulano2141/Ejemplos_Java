
public class Eventual extends Empleado {
	int HorTra,Tari;
	public Eventual(int ci, String nom, String car, int horTra, int tari) {
		super(ci, nom, car);
		HorTra = horTra;
		Tari = tari;
	}
	public int getHorTra() {
		return HorTra;
	}
	public int getTari() {
		return Tari;
	}
	public String toString() {
		double totalga=HorTra*Tari;
		double desc=0;
		if(totalga>4000)
			desc=totalga*0.1;
		double neto=totalga-desc;
		
		String cl="\nTotal Ganado: "+totalga+"\n"+"Descuento: "+desc+"\n"+"Total Neto: "+neto+"\n"+super.toString();
		return cl;
	}
}