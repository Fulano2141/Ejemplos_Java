import java.io.*;
public class Ej2 {
    public static class doble
    {
    	int dato;
    	doble sgte, ant;
    }
	public static void main(String[] args)throws IOException {
		doble cab_d=null, A=null,cab_d2=null, B=null,cab_dU=null, U=null,cab_dI=null, I=null,cab_dD=null, D=null;
		doble nuevo=null,aux=null;
		int op,op2;
		int auxi=0;
		do {
			menu1();
			op=leer("?");
			switch(op)
			{
			case 1:
				do {
					auxi=leer("Número de datos a agregar");
				}while(auxi<1);
				for(int i=1;i<=auxi;i++) {
				nuevo=new doble();
				nuevo.dato=leer("Dato "+i+": ");
				nuevo.sgte=null;
				nuevo.ant=null;
				if(cab_d==null)
				{
					cab_d=nuevo;
					A=nuevo;
				}
				else
				{   
					do {
						menu2();
						op2=leer("");
					}while(op2<1 || op2>2);
					if(op2==1) 
					{
						cab_d=agregar_d(cab_d,nuevo);
					}
					else
					{
						A=agregar_i(A,nuevo);
					}
				}
				}
				break;
			case 2:
				System.out.println("De izquierda a derecha");
				listado_i_d(A);
				break;
			case 3:
				System.out.println("De derecha a izquierda");
				listado_d_i(cab_d);
				break;
			case 4:
				do {
					auxi=leer("Número de datos a agregar");
				}while(auxi<1);
				for(int i=1;i<=auxi;i++) {
				nuevo=new doble();
				nuevo.dato=leer("Dato "+i+": ");
				nuevo.sgte=null;
				nuevo.ant=null;
				if(cab_d2==null)
				{
					cab_d2=nuevo;
					B=nuevo;
				}
				else
				{   
					do {
						menu2();
						op2=leer("");
					}while(op2<1 || op2>2);
					if(op2==1) 
					{
						cab_d2=agregar_d(cab_d2,nuevo);
					}
					else
					{
						B=agregar_i(B,nuevo);
					}
				}
				}
				break;
			case 5:
				System.out.println("De izquierda a derecha");
				listado_i_d(B);
				break;
			case 6:
				System.out.println("De derecha a izquierda");
				listado_d_i(cab_d2);
				break;
			case 7:
				if(A==null) {
					System.out.println("Lista A vacía");
				}else {
					if(B==null) {
						System.out.println("Lista B vacía");
					}else {
						cab_dU=null;
						U=null;
						cab_dI=null;
						I=null;
						cab_dD=null;
						D=null;
						
						aux=A;
						while(aux!=null) {
							nuevo=new doble();
							nuevo.dato=aux.dato;
							if(cab_dU==null)
							{
								cab_dU=nuevo;
								U=nuevo;
							}
							else
							{ 
								cab_dU=agregar_d(cab_dU,nuevo);
							}
							aux=aux.sgte;
						}
						aux=B;
						while(aux!=null) {
							nuevo=new doble();
							nuevo.dato=aux.dato; 
							cab_dU=agregar_d(cab_dU,nuevo);
							aux=aux.sgte;
						}
						System.out.println("Unión");
						listado_i_d(U);
						
						aux=A;
						while(aux!=null) {
							nuevo=new doble();
							nuevo.dato=aux.dato; 
							if(contiene(B,nuevo.dato)==true) {
								if(cab_dI==null)
								{
									cab_dI=nuevo;
									I=nuevo;
								}
								else
								{ 
									cab_dI=agregar_d(cab_dI,nuevo);
								}
							}else {
								if(cab_dD==null)
								{
									cab_dD=nuevo;
									D=nuevo;
								}
								else
								{ 
									cab_dD=agregar_d(cab_dD,nuevo);
								}
							}
							aux=aux.sgte;
						}
						System.out.println("Intersección");
						listado_i_d(I);
						System.out.println("Diferencia");
						listado_i_d(D);
						
					}
				}
				break;
				}
		}while(op!=10);

	}
	public static boolean contiene(doble cab,int x) {
		boolean flag=false;
		while(cab!=null) {
			if(cab.dato==x) {
				flag=true;
			}
			cab=cab.sgte;
		}
		return flag;
	}
public static void listado_d_i(doble cab)
	{
		while(cab!=null)
		{
			System.out.print(cab.dato+"\t");
			cab=cab.ant;
		}
		System.out.println();
	}
public static void listado_i_d(doble cab)
{
	while(cab!=null)
	{
		System.out.print(cab.dato+"\t");
		cab=cab.sgte;
	}
	System.out.println();
}
public static doble agregar_i(doble cab, doble n)
	{
		n.sgte=cab;
		cab.ant=n;
		cab=n;
		return(cab);
	}
public static doble agregar_d(doble cab, doble n)
{
	cab.sgte=n;
	n.ant=cab;
	cab=n;
	return(cab);
}
public static void menu2()
{
	System.out.println("***Agregar en lista DOBLEMENTE ENLAZADAS***");
	System.out.println("1.- Por derecha");
	System.out.println("2.- Por la izquierda");
}
public static void menu1()
{
	System.out.println("***LISTA DOBLEMENTE ENLAZADAS***");
	System.out.println("1.- Agregar nodos a la lista A");
	System.out.println("2.- Listado i_d (Lista A)");
	System.out.println("3.- Listado d_i (Lista A)");
	System.out.println("4.- Agregar nodos a la lista B");
	System.out.println("5.- Listado i_d (Lista B)");
	System.out.println("6.- Listado d_i (Lista B)");
	System.out.println("7.- Unión, Intersección y Diferencia");
	System.out.println("10.- Salir");
}
public static int leer(String p)throws IOException
{
	BufferedReader y=new BufferedReader(new InputStreamReader(System.in));
    System.out.println(p);
    int r=Integer.parseInt(y.readLine());
    return(r);
}
}