import java.text.DecimalFormat;
public class Cuadrado {
	double lado;
	public Cuadrado(double lado) {
		this.lado = lado;
	}
	public double getLado() {
		return lado;
	}
	public void setLado(double lado) {
		this.lado = lado;
	}
	public String toString() {
		DecimalFormat form = new DecimalFormat("#.00");
		return form.format(getLado()*getLado())+" ";
		
	}
}
