package Lab1l07x09x2018;

import java.util.Scanner;

public class Matriz_dispersa {
	
	public static class matriz{
		int f,c,d;
		matriz sgte;
	}

	public static void main(String[] args) {
		int opcion,n,g1 = 0,g2= 0 ;
		int n1,gg1= 0 ,gg2=  0;
		matriz cab1 = null;
		matriz cab2 = null;
		matriz cab3 = null;
		for(;;){
			System.out.println("\n--------------------------------\n");
			System.out.println("1. Crear1 y listar2: ");
			System.out.println("2. Crear2 y listar2: ");
			System.out.println("3. Traza: ");
			System.out.println("4. Suma: ");
			System.out.println("5. Multilicar: ");
			System.out.println("SALIR ");
			opcion=leer("\n--------------------------------\nIngrese su opcion: ");
			switch(opcion){
			case 1:
				do{
					n=leer("Cantidad de datos: ");
				}while (n<=0);
				do{
					g1=leer("N: ");
				}while (n<=0);
				do{
					g2=leer("M: ");
				}while (n<=0);
				if(n<=g1*g2){
					cab1=crear(n,g1,g2);
					System.out.println("\nListado en lista: ");
					listado(cab1);
					System.out.println("\nListado en matriz: ");
					listado_matriz(g1, g2, cab1);
				}else{
					System.out.println("No se puede");
				}
				break;
			case 2:
				do{
					n1=leer("Cantidad de datos: ");
				}while (n1<=0);
				do{
					gg1=leer("N: ");
				}while (n1<=0);
				do{
					gg2=leer("M: ");
				}while (n1<=0);
				if(n1<=gg1*gg2){
					cab2=crear(n1,gg1,gg2);
					System.out.println("\nListado en lista: ");
					listado(cab2);
					System.out.println("\nListado en matriz: ");
					listado_matriz(gg1, gg2, cab2);
				}else{
					System.out.println("No se puede");
				}
				break;
			case 3:
				
				System.out.println("Matriz 1:"+traza(cab1));
				System.out.println("Matriz 2:"+traza(cab1));
				System.out.println("Matriz 3:"+traza(cab1));
				break;
			case 4:
				cab3 = sum(g1, g2, cab1, gg1, gg2, cab2, cab3);
				System.out.println("\nListado en lista: ");
				listado(cab3);
				System.out.println("\nListado en matriz: ");
				listado_matriz(gg1, gg2, cab3);
				break;
			case 5:
				cab3 = mult(g1, g2, cab1, gg1, gg2, cab2, cab3);
				System.out.println("\nListado en lista: ");
				listado(cab3);
				System.out.println("\nListado en matriz: ");
				listado_matriz(g1, gg2, cab3);
				break;
			case 6:
				System.exit(0);
				
			}
		}
	}
	public static int leer(String a){
		Scanner x = new Scanner(System.in); 
		System.out.println(a);
		return (x.nextInt()); 
	}
	public static int traza(matriz cab) {
		matriz x=cab;
		int sum=0;
		for(;x!=null;){
			if(x.c==x.f){
				sum+=x.d;
			}
			x=x.sgte;
		}
		return sum;
	}
	public static matriz crear(int n,int g1,int g2){
		int dato,a,b;
		matriz aa;
		matriz x=null;
		for(int i=0;i<n;i++){
			matriz cab=new matriz();
			do{
				dato=leer("Dato "+(i+1)+"?: ");
			}while(dato<=0);
			do{
				a=leer("Fila: ");
			}while(a>g1);
			do{
				b=leer("Col: ");
			}while(b>g2);
			cab.f=a;
			cab.c=b;
			cab.d=dato;
			if (x == null) {
				x = cab;
			} else {
				for (; x.sgte != null;) {
					x = x.sgte;
				}
				x.sgte = cab;
			}
		}
			return (x);
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
	public static int buscar(int i, int j, matriz x) {
		int p = 0;
		while (x != null) {
			p=0;
			if (x.f == i && x.c == j) {
				break;
			}else{
				p=1;
			}
			x = x.sgte;
		}
		if(p==0){
			return (x.d);
		}else{
			return 0;
		}
	}
	public static matriz sum(int f1, int c1, matriz z1, int f2, int c2, matriz z2, matriz c) {

		matriz z3 = new matriz();

		if (f1 == f2 && c1 == c2) {
			for (int i = 1; i <= f1; i++) {
				for (int j = 1; j <= c1; j++) {

					int p = (buscar(i, j, z1) + buscar(i, j, z2));
					z3 = add_nodo(p, i, j, z3);

				}

			}

		} else {
			System.out.println("Las matrices no son operables");
		}
		return z3;
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
	public static matriz mult(int f1, int c1, matriz z1, int f2, int c2, matriz z2, matriz c) {
		matriz z3 = new matriz();
		int p=0;
		if (c1 == f2) {
			System.out.println("La matriz resultante es: ");

			for (int i = 1; i <= f1; i++) {
				
				for (int j = 1; j <= c2; j++) {
					p=0;
					for (int h = 1; h <= c1; h++) {
						p =p+( buscar(i, h, z1) * buscar(h, j, z2));
					}
					System.out.println("p"+p);
					z3 = add_nodo(p, i, j, z3);
				}
				
			}
		} else {
			System.out.println("Los rangos de las matrices son incorrectos");
		}

		return z3;
	}
	
}
