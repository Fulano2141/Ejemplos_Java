import java.text.DecimalFormat;
import java.util.*;
public class DistanciaNumeros {
	double x1,x2,y1,y2, d; //nunca un public
	// private, public, protected
	public static void main(String[] X){
		DistanciaNumeros obj1=new DistanciaNumeros(); //creacion del primer objeto "obj"
		obj1.init();
		obj1.dis();
		obj1.display();
	}
//seccion metodos
	public void init(){  // no debe haber un static para clases
		Scanner in=new Scanner(System.in);
		System.out.println("Ingrese el primer punto");
		x1=in.nextDouble();
		y1=in.nextDouble();
		System.out.println("Ingrese el segundo punto");
		x2=in.nextDouble();
		y2=in.nextDouble();
	}
	public void dis(){
		d=Math.sqrt(((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)));
	}
	public void display(){
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println("La distancia es: "+df.format(d));
	}
}
