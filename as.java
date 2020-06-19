package Lab1l07x09x2018;

import java.util.Scanner;
public class as {
	static Scanner in = new Scanner (System.in);
	public static class nodo
	{
		int dato;
		nodo sgte;
	}
	public static void main(String[] args) 
	{
		nodo cabz=null;
		for (;;)
        {
                Scanner in = new Scanner (System.in);
                System.out.println("1-Agregar nuevos datos");
                System.out.println("2-Listado");
                System.out.println("3-Contador");
                System.out.println("4-Quitarr");
                System.out.println("5-Salir");
                int valor=in.nextInt();
                switch (valor)
                {
                case 1: cabz=add_col(cabz);break;
                case 2:listado(cabz); break;
                case 3: int y=con(cabz) ;System.out.println("Cantidad de nodos: "+y);break;
                case 4: cabz=quitar(cabz);break;
                case 5:System.exit(0);
                }
        }
	}
	public static nodo quitar (nodo cab1)
	{
		nodo z=cab1;
		while (z.sgte!=null)
		{
			z=z.sgte;
		}
		z.sgte=new nodo();
		z.sgte.dato=100;
		z.sgte.sgte=null;
		listado (cab1);
		return (cab1);
	}
	public static void listado (nodo cab)
	{
		while (cab!=null)
		{
			System.out.println(cab.dato);
			cab=cab.sgte;
		}
	}
	public static nodo add_col(nodo cab)
	{
		nodo x, nuevo;
		nuevo=new nodo();
		System.out.println("Escribir el dato");
		nuevo.dato=in.nextInt ();
		nuevo.sgte=null;
		if (cab==null)
		{
			cab=nuevo;
		}
		else
		{
			x=cab;
			while (x.sgte!=null)
			{
				x=x.sgte;
			}
			x.sgte=nuevo;
		}
		return (cab);
	}

	public static int con (nodo cab)
	{
		int c=0;
		while (cab!=null)
		{
			c=c+1;
			cab=cab.sgte;
			
		}
		return (c);
	}
}