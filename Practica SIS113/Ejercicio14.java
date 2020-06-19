import java.util.Scanner;

/* 14.- Simular el lanzamiento de un dado n veces y determinar la frecuencia de repetición de cada cara (emplear arreglo).
 */
public class Ejercicio14 {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Ingrese el numero de lanzamientos del dado ");
		int n=in.nextInt();
		int[ ] b = new int[6];
		for(int i=0;i<n;i++){
			int dado=(int)(Math.random()*6)+1;
			if(dado==1)
				b[0]++;
			if(dado==2)
				b[1]++;
			if(dado==3)
				b[2]++;
			if(dado==4)
				b[3]++;
			if(dado==5)
				b[4]++;
			if(dado==6)
				b[5]++;
		}
		for(int i=0;i<6;i++) {
			System.out.printf(b[i]+", ");
		}
		
		
	}

}
