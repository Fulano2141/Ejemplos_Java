import java.text.DecimalFormat;
import java.util.Scanner;

public class conversor {
	double x,y,r,ang; //nunca un public
	// private, public, protected
	public static void main(String[] X){
		conversor obj1=new conversor(); //creacion del primer objeto "obj"
		obj1.init();
		obj1.opc();
		obj1.display();
	}
	//seccion metodos
	public void init(){  // no debe haber un static para clases
		Scanner in=new Scanner(System.in);
		System.out.printf("Ingrese coordenadas en X: ");
		x=in.nextInt();
		System.out.printf("Ingrese coordenadas en Y: ");
		y=in.nextInt();
	}
	public void opc(){
		double angul;
		r=Math.sqrt((x*x+y*y));
		angul=Math.atan((y/x));
		ang= Math.toDegrees(angul);
	}
	public void display(){
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println("El resultado es: "+df.format(r)+" de radio y "+df.format(ang)+" de angulo");
	}
}
