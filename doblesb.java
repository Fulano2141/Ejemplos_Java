package listas_dobles;
import java.io.*;
public class doblesb {
    public static class doble
    {
    	int dato;
    	doble sgte, ant;
    }
	public static void main(String[] args)throws IOException {
		doble cab_d=null, cab_i=null;
		doble nuevo=null;
		int op,op2;
		do {
			menu1();
			op=leer("?");
			switch(op)
			{
			case 1:
				nuevo=new doble();
				nuevo.dato=leer("dato?");
				nuevo.sgte=null;
				nuevo.ant=null;
				if(cab_d==null)
				{
					cab_d=nuevo;
					cab_i=nuevo;
				}
				else
				{   
					menu2();
					op2=leer("?");
					if(op2==1) 
					{
						cab_d=agregar_d(cab_d,nuevo);
					}
					else
					{
						cab_i=agregar_i(cab_i,nuevo);
					}
				}	
				break;
			case 2:
				System.out.println("De izquierda a derecha");
				listado_i_d(cab_i);
				break;
			case 3:
				System.out.println("De derecha a izquierda");
				listado_d_i(cab_d);
				break;
			}
		}while(op!=10);

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
	System.out.println("1.- Agregar nodos");
	System.out.println("2.- Listado i_d");
	System.out.println("3.- Listado d_i");
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
