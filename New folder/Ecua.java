import javax.swing.JOptionPane;
// Agregar el ejercicio a la practica
public class Ecua {
	int a,b,c,d;
	double x,y;
	public Ecua(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public void resultado() {
		d=b*b-4*a*c;
		if(d>0) {
			x=(-b+Math.sqrt(d))/(2*a);
			y=(-b-Math.sqrt(d))/(2*a);
		}
		if(d==0){
			x=-b/(2*a);
			y=x;
		}
	}
	public void salida() {
		if(d<0)
			System.out.println("El resultado es imaginario ");
		else {
			System.out.println("El resultado X1 es: "+x+" X2 es: "+y);
		}
	}
	public static void main(String[] X) {
		int a=(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el coheficiente a ")));
		int b=(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el coheficiente b ")));
		int c=(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el coheficiente c ")));
		Ecua x=new Ecua(a,b,c);
		x.salida();
	}
}
