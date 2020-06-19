import java.util.Scanner;
/* 15.- Almacenar en un arreglo n números al azar en el rango : 1000 al 9999, y determinar cuántos números capicúas existen.
 */
public class Ejercicio15 {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.printf("Ingrese un numero:  ");
		int n=in.nextInt();
		int[] b = new int[n];
		int[] capi=new int[n];
		for(int i=0;i<n;i++){
			int num=1000+(int)(Math.random()*10999);
			b[i]=num;
			if(capicuador(num))
				capi[i]=num;
		}
		
	}
	public static boolean capicuador(int numero) {
		int faltante=numero,numInv=0,restan=0;
		while(faltante!=0) {
			restan=faltante%10;
			numInv=numInv*10+restan;
			faltante=faltante/10;
		}
		if(numero==numInv)
			return true;
		else 
			return false;
	}
}