import java.util.Scanner;

/* 10. Pedir números enteros hasta que se digite un 0, mostrar la suma de todos los números introducidos.
 */
public class Ejercicio10 {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int num=1,sum=0;
		do {
			System.out.println("Digite un numero: ");
			 num = in.nextInt();
			 sum+=num;
		}while(num!=0);
		System.out.println("La sumatoria es:  "+sum);
	}
}
