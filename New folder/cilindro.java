
public class cilindro extends circulo {
	protected double altura;
	public cilindro(double radio, double altura) {
		super(radio);
		this.altura = altura;
	}
	public double getAltura() {
		return altura;
	}
	public double superficie() {
		return Math.rint(Math.PI*getRadio()*getRadio()*getAltura()*100)/100;
	}
	public String toString() {
		String cl="";
		cl="Superficie Cilindro: "+superficie();
		return cl;		
	}
}
