import java.util.*;
/* 7.-  En el rango A y B, mostrar la suma de los divisores pares de cada número:
	Ej:
	Sea A= 10 y B= 15
	10 : divisores:  10 + 5+2+1 	 la suma es=12 
	11 : divisores:  11 + 1        			 la suma es=0 
	12 : divisores:  12 + 6 + 4 + 3 + 1      	 la suma es=22 
	……
 */
public class Ejercicio7 {
	static Scanner in = new Scanner(System.in);
	public static void main (String [] args){
		System.out.println("Introducir el limite inferior");
		int infe = in.nextInt();
		System.out.println("Introducir el limite superior");
		int sup = in.nextInt();
		for(int i=infe;i<=sup;i++) {
			int sum=0;
			System.out.printf(i+": divisores: ");
			for(int j=1;j<=i;j++) {
				if(i%j==0)
					System.out.printf(j+", ");
				if(j%2==0 && i%j==0)
						sum=sum+j;
			}
			System.out.println(" la suma es= "+sum);
		}
	}
}	
