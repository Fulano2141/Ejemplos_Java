/* 13.-  Dado un arreglo con  elementos constantes, mediante 
 * una función almacene en un segundo vector la suma de sus dígitos:
 * Sea:
 * 	a={ 123 , 275 , 164 ,  951}
 * el vector resultante será:
 * 	b={ 6 ,14 , 11, 15}
 */
import java.util.Scanner;
public class Ejercicio13 {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int a[]= {123,275,164,951};
		int[] b = new int[4];
		for(int i=0;i<a.length;i++) {
			int aux=a[i];
			b[i]=digitador(aux);
		}
		System.out.println("Vector a: ");
		for(int i=0;i<a.length;i++) {
			System.out.printf(a[i]+", ");
		}
		System.out.println("\nVector b: ");
		for(int i=0;i<a.length;i++) {
			System.out.printf(b[i]+", ");
		}
	}
	public static int digitador(int num) {
		int aux,total=0;
		aux=num;
		while(num!=0){
			total=total+num%10;
			num=num/10;
		}
		return total;
	}
}
