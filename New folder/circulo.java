
public class circulo {
	protected double radio;
	public circulo(double radio) {
		this.radio = radio;
	}
	public double getRadio() {
		return radio;
	}
	public void setRadio(double radio) {
		this.radio = radio;
	}
	public double superficie() {
		return Math.rint(Math.PI*getRadio()*getRadio()*100)/100;
	}
	public String toString() {
		String cl="";
		cl="Superficie Circulo: "+superficie();
		return cl;		
	}
}
