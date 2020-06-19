
public class cilindrohueco extends cilindro {
	protected double A;
	public cilindrohueco(double radio, double altura, double a) {
		super(radio, altura);
		A = a;
	}
	public double superficie() {
		double aux=Math.PI*getRadio()*getRadio()*getAltura()-Math.PI*getRadio()*getRadio();
		return Math.rint(aux*100)/100;
	}
	public String toString() {
		String cl="";
		cl="Superficie Cilindro Hueco: "+superficie();
		return cl;		
	}
}
