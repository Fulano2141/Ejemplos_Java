/* 5.- Mediante una función obtenga el valor de la serie:
 *  4  –  4/3 + 4/5  –  4/7 + ......... para n términos
 *  El valor de la sumatoria es el valor de PI, por lo tanto introduzca
 *  un valor que se aproxime a este valor empleando una función con retorno. 
 */
import java.util.*;
public class Ejercicio5 {
	static Scanner in = new Scanner(System.in);
	public static void main (String [] args){
		System.out.println("introducir el numero");
		int n = in.nextInt();
		System.out.println("la respuesta es"+ respuesta(n));
	}
	public static double respuesta(int n){
		double d=1;
		double a=0;
		for (int x=0; x<n;x++) {
			a=a+(4/d);
			d+=2;
			a*=-1;
		}
		return a;
	}
}