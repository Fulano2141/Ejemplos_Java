import java.io.*;
public class Ej3 {
    public static class doble
    {
    	int dato;
    	doble sgte, ant;
    }
	public static void main(String[] args)throws IOException {
		doble cab_d=null, A=null,cab_d2=null, B=null;
		doble nuevo=null;
		int op,op2;
		int aux=0;
		do {
			menu1();
			op=leer("?");
			switch(op)
			{
			case 1:
				do {
					aux=leer("Número de datos a agregar");
				}while(aux<1);
				for(int i=1;i<=aux;i++) {
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
					aux=leer("Número de datos a agregar");
				}while(aux<1);
				for(int i=1;i<=aux;i++) {
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
				if(tamannio(A)==tamannio(B)) {
					if(igualdad(A,B)==true) {
						System.out.println("Las listas son iguales");
					}else {
						System.out.println("Las listas son del mismo tamaño pero no tienen el mismo contenido");
					}
				}else {
					System.out.println("Las listas no comparten ni el tamaño ni los elementos");
				}
				break;
				}
		}while(op!=10);

	}
	public static boolean igualdad(doble A,doble B) {
		boolean flag=true;
		while(A!=null && flag==true) {
			if(A.dato!=B.dato) {
				flag=false;
			}else {
				A=A.sgte;
				B=B.sgte;
			}	
		}
		return flag;
	}
	public static int tamannio(doble cab) {
		int t=0;
		while(cab!=null) {
			t++;
			cab=cab.sgte;
			}
		return t;
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
	System.out.println("7.- Comparar las listas");
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