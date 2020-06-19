package Lab1l07x09x2018;
import java.util.Scanner;

public class Matriz_ejercicios {
	public static class matriz{
		int f,c,d;
		matriz sgte;
	}
	public static void main(String[] args) {
		int n1 = 0, m1 = 0;
		int n2 = 0, m2 = 0;
		matriz cab1 = null;
		matriz cab2 = null;
		matriz cab3 = null;

		int opcion;
		do {
			System.out.println("\n--------------------------------\n");
			System.out.println("1. Crear: ");
			System.out.println("2. Ordenar: ");
			System.out.println("3. Punto silla: ");
			System.out.println("4. Ocurrencias: ");
			System.out.println("5. Los dos minimos: ");
			System.out.println("0. SALIR ");

			opcion = leer("\n--------------------------------\nIngrese su opcion: ");
			switch (opcion) {

			case 1:
				do {
					n1 = leer("total de filas");
				} while (n1 <= 0);

				do {
					m1 = leer("total de columnas");
				} while (m1 <= 0);
				for (int i = 1; i <= n1; i++) {
					for (int j = 1; j <= m1; j++) {
						int dato = leer("Dato?: ");
						cab1 = add_nodo(dato, i, j, cab1);
					}
				}
				listado_matriz(n1, m1, cab1);
				break;
				
			case 2:
				cab2=silla(n1,m1,cab1);
				listado(cab2);
				break;


			}
		} while (opcion != 0);
	}
	public static int leer(String msg) {
		Scanner lee = new Scanner(System.in);
		System.out.println(msg);
		return lee.nextInt();
	}
	public static matriz add_nodo(int dato, int i, int j, matriz x) {
		matriz a;
		matriz copy = new matriz();
		copy.f = i;
		copy.c = j;
		copy.d = dato;
		if (x == null) {
			x = copy;
		} else {
			a = x;
			for (; a.sgte != null;) {
				a = a.sgte;
			}
			a.sgte = copy;
		}
		return (x);
	}
	public static int buscar(int i, int j, matriz x) {
		int a = 0;
		while (x.sgte != null) {
			if (x.f == i && x.c == j) {
				break;
			}
			x = x.sgte;
		}
		return (x.d);
	}
	public static void listado (matriz cab){
		for(;cab!=null;){
			System.out.println("::	"+cab.d+"\t"+cab.f+"\t"+cab.c);
			cab=cab.sgte;
		}
	}
	public static void listado_matriz(int f1, int c1, matriz z1) {
		if (z1 != null) {
			for (int i = 1; i <= f1; i++) {
				for (int j = 1; j <= c1; j++) {
					System.out.print(buscar(i, j, z1) + "\t");
				}
				System.out.println();
			}
		} else {
			System.out.println("La matriz es null");
		}
	}
	public static matriz silla(int f1, int c1,matriz z1){
	
		matriz x= null;
		int dato = 0,aux=0,ff,cc,i,j;
		if (z1 != null) {
			for (i = 1; i <= f1; i++) {
				matriz c=new matriz ();
				aux=0;
				for (j = 1; j <= c1; j++) {
					dato = buscar(i, j, z1);
					if(dato>aux){
						aux=dato;
						ff=i;
						cc=j;
					}
				}
				c.f=i;
				c.c=j;
				c.d=dato;
				if (x == null) {
					x = c;
				} else {
					for (; x.sgte != null;) {
						x = x.sgte;
					}
					x.sgte = c;
				}
				//System.out.println(": "+i+":"+j+":"+dato);
			}
		} else {
			System.out.println("vacio");
		}
		return x;
	}
	

}
