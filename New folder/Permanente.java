
public class Permanente extends Empleado{
	double Sal;
	int DiasTra;
	public Permanente(int ci, String nom, String car, double sal, int diasTra) {
		super(ci, nom, car);
		Sal = sal;
		DiasTra = diasTra;
	}
	public double getSal() {
		return Sal;
	}
	public int getDiasTra() {
		return DiasTra;
	}
	
	public String toString() {
		double totalga=Sal*DiasTra/30;
		double desc=0;
		super.toString();
		if(totalga>4000)
			desc=totalga*0.1;
		double neto=totalga-desc;
		String cl="Total Ganado: "+totalga+"\n"+"Descuento: "+desc+"\n"+"Total Neto: "+neto+"\n"+super.toString();
		return cl;
	}
}
