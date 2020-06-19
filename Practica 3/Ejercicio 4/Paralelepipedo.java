import java.text.DecimalFormat;

public class Paralelepipedo extends Cuadrado {
	double altura;
	double ancho;
	public Paralelepipedo(double lado, double altura, double ancho) {
		super(lado);
		this.altura = altura;
		this.ancho = ancho;
	}
	public double getAltura() {
		return altura;
	}
	public double getAncho() {
		return ancho;
	}
	public String toString(){
		double sup=2*getLado()*getAltura()+2*getLado()*getAncho()+2*getAncho()*getAltura();
		DecimalFormat form = new DecimalFormat("#.00");
		return form.format(sup)+" ";
	}
}
