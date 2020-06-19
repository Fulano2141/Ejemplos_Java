package prog3;
import java.util.Scanner;
public class Circular {
	int numero;
	Circular sgte;
	boolean vivo;
	public Circular (int n) {
		numero = n;
		sgte = null;
		vivo = true;
	}
	public static Scanner sn=new Scanner(System.in);
	public static void main (String args[]) {
		System.out.println("Cantidad de soldados");
		int m = sn.nextInt();
		System.out.println("Cada cuanto muere");
		int n = sn.nextInt();
		System.out.println("El ultimo es "+josefo(crearLista(m),m,n));
	}
	public static Circular crearLista(int m) {
		Circular cab = null, aux = cab;
		for (int i=1; i<=m; i++) {
			if (cab == null) {
				cab = new Circular(i);
				aux = cab;
			}
			else {
				aux.sgte = new Circular(i);
				aux = aux.sgte;
			}
		}
		aux.sgte = cab;
		return cab;
	}
	public static int josefo (Circular cab, int m, int n) {
		while (Queda_uno(cab) == -1999) {
			
			for (int c = 1; c <= n; c++) {
				if (!cab.vivo) c--;
				else {
					if (c == n) {
						cab.vivo = false;
					}
				}
				cab = cab.sgte;
			}
		}
		return Queda_uno(cab);
		
	}
	public static int Queda_uno(Circular cab) {
		int d=0;
		Circular aux = cab;
		boolean unVivo = false;
		int num = -1999;
		System.out.println("D"+aux.numero);
		while (!aux.sgte.equals(cab)) {
			d++;
			System.out.println(d);
			if (aux.vivo) {
				if (unVivo) return -1999;
				unVivo = true;
				num = aux.numero;
			}
			aux = aux.sgte;
		}
		if (unVivo) 
			{
			return num;
			}
		return -1;
	}
}