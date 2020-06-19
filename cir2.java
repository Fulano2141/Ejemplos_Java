package circulares;

import java.io.*;

public class cir2 {
    public static class circular
    {
    	String nombre;
    	circular sgte;    	
    }
	public static void main(String[] args) throws IOException
	{
		circular cabc=null;
		int op,n,x;
		do {
			menu();
			op=leer("?");
			switch(op)
			{
			case 1:
				cabc=add_nodos_circular(cabc);
				break;
			case 2:
				listado("\nDatos de la lista ",cabc);
				break;
			case 3:
				if (cabc!=null)
				{
					do {
						n=leer("numero ?");
					}while(n<=0);
					cabc=josefo(cabc,n);
					System.out.println("Sobreviviente "+cabc.nombre);
				}
				break;
			case 4:
				//RODOLFO CATUNTA
				if(cabc!=null) {
					do {
						x=leer("posicion?");
					}while(x<1);
					cabc=add(cabc,x);
					listado("\nDatos de la lista",cabc);
				}
				break;
			case 5:
				//Mariana Cardozo Costa
				if(cabc!=null)
				{
					do {
						n=leer("numero ?");
					}while(n<=0);
					cabc = borrar (cabc, n);
					listado ("NUEVA LISTA: ", cabc);
					
				}
				break;
			}
		}while(op!=10);
	}
	public static circular add(circular cab,int pos) throws IOException{
		int cont=1;
		circular b=cab;
		circular a=cab;
		while(cont<pos) {
			a=b;
			b=b.sgte;
			cont++;
		}
		circular nuevo=new circular();
		nuevo.nombre=leers("Nuevo nombre?");
		a.sgte=nuevo;
		nuevo.sgte=b;
		return cab;
	}
	public static circular borrar (circular a, int x)
	{
		circular aux = a;
		for (int i=1; i<x-1; i++)
		{
			a=a.sgte;
		}
		a.sgte=a.sgte.sgte;
		return aux;
	}
	
	public static circular josefo(circular c, int nm)
	{ 
			while(c.sgte!=c)
			{
				for(int i=1;i<nm;i++)
				{
					c=c.sgte;
				}
				System.out.println(c.nombre+" le dispara a "+c.sgte.nombre);
	            c.sgte=c.sgte.sgte;
			}
		
	    return(c);
	}
	public static void listado(String h,circular c)
	{
		circular z=c;
		if(c!=null)
		{
			do
			{
				System.out.print(z.nombre+"\t");
				z=z.sgte;
			}
			while(z!=c);
		}	
	}
	public static void menu()
	{
		System.out.println("\n***Listas circulares ****");
		System.out.println("1.- Lectura");
		System.out.println("2.- Listado");
		System.out.println("3.- Problema de Josefo");
		System.out.println("4.- Agregar nodo en la posicionm  x");
		System.out.println("5.- Borrar el nodo de la posiciòn x");
		System.out.println("10.- Salir");
	}
			
	public static circular add_nodos_circular(circular x)throws IOException
	{
		circular aux=new circular();
		circular z;
		aux.nombre=leers("Nombre?");
		aux.sgte=aux;
		if (x==null)
			x=aux;
		else
		{
			z=x;
			while(z.sgte!=x)
				z=z.sgte;
			z.sgte=aux;
			aux.sgte=x;
		}
		return(x);
	}
	 public static String leers(String z)throws IOException
	    {   
	    	BufferedReader s=new BufferedReader(new InputStreamReader(System.in));    
	    	System.out.println(z);
	    	String r=s.readLine();
	    	return(r);
	    }
    public static int leer(String z)throws IOException
    {   
    	BufferedReader s=new BufferedReader(new InputStreamReader(System.in));    
    	System.out.println(z);
    	int r=Integer.parseInt(s.readLine());
    	return(r);
    }
}
