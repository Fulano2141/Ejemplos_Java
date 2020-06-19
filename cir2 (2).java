package circudobel;

import java.io.*;
/*
 * hecho por
 * josue mamani becerra
 * daniel tarqui apaza
 * jonas maidana alvarado
 * */
public class cir2 {
    public static class circular
    {
    	String nombre;
    	circular sgte; 
    	circular ant;
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
				int love=leer("cantidad de datos");
				for(int i=0;i<love;i++) {
				cabc=add_nodos_circular(cabc);
				}
				break;
			case 2:
				listado("\nDatos de la lista ",cabc);
				break;
			case 3:
				if (cabc!=null)
				{
					cabc=josefo(cabc);
					System.out.println("Sobreviviente "+cabc.nombre);
				}
				break;
		
			
			}
		}while(op!=10);
	}
	

	
	public static circular josefo(circular c)
	{ 
			while(c.sgte!=c)
			{
				int nm=(int)(Math.random()*cota(c))+1;
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
	public static void listadoant(String h,circular c)
	{
		circular z=c;
		if(c!=null)
		{
			do
			{
				System.out.print(z.nombre+"\t");
				z=z.ant;
			}
			while(z!=c);
		}	
	}
	public static int cota(circular c)
	{int con=0;
		circular z=c;
		if(c!=null)
		{
			do
			{
				con++;
				z=z.sgte;
			}
			while(z!=c);
		}
		return con;
	}
	public static void menu()
	{
		System.out.println("\n***Listas circulares ****");
		System.out.println("1.- Lectura");
		System.out.println("2.- Listado");
		System.out.println("3.- Problema de Josefo");
		System.out.println("10.- Salir");
	}
			
	public static circular add_nodos_circular(circular x)throws IOException
	{
		circular aux=new circular();
		circular z;
		aux.nombre=leers("Nombre?");
		aux.sgte=aux;
		aux.ant=aux;
		if (x==null)
			x=aux;
		else
		{
			z=x;
			while(z.sgte!=x) 
				z=z.sgte;
			z.sgte=aux;
			aux.sgte=x;
			x.ant=aux;
			aux.ant=z;
			
			
			
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
