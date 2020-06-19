package circulares;
import java.io.*;
public class ci1 {
    public static class circular
    {
    	int dato;
    	circular sgte;    	
    }
	public static void main(String[] args) throws IOException
	{
		circular cabc=null;
		int op;
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
			}
		}while(op!=10);
	}
	public static void listado(String h,circular c)
	{
		circular z=c;
		if(c!=null)
		{
			do
			{
				System.out.print(z.dato);
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
	}
			
	public static circular add_nodos_circular(circular x)throws IOException
	{
		circular aux=new circular();
		circular z;
		aux.dato=leer("Dato para el nodo");
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
    public static int leer(String z)throws IOException
    {   
    	BufferedReader s=new BufferedReader(new InputStreamReader(System.in));    
    	System.out.println(z);
    	int r=Integer.parseInt(s.readLine());
    	return(r);
    }
}
