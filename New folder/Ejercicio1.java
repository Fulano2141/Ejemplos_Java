import java.util.Scanner;

public class Ejercicio1 {
	private int a,b,c; //nunca un public
						// private, public, protected
	public static void main(String[] X){
		Ejercicio1 obj1=new Ejercicio1(); //creacion del primer objeto "obj"
		obj1.init();
		obj1.suma();
		obj1.display();
	}
	//seccion metodos
	public void init(){  // no debe haber un static para clases
		Scanner in=new Scanner(System.in);
		System.out.println("Ingrese el primer valor");
		a=in.nextInt();
		System.out.println("Ingrese el segundo valor");
		b=in.nextInt();
	}
	public void suma(){
		c=a+b;
	}
	public void display(){
		System.out.println("La suma es: "+c);
	}
}
