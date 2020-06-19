import java.util.Scanner;
/* 12.  Obtenga el factorial de un número entero
 */
public class Ejercicio12 {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int num,fac=1;
		System.out.println("Ingrese un numero: ");
		num=in.nextInt();
		for(int i=1;i<=num;i++) {
			fac=fac*i;
		}
		System.out.println("Su factorial es: "+fac);
	}
}
