/*
 * Jimena Silvia Choque Callisaya
 */
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Ejercicio_1
{
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
                String [] menu = {"Agregar","Listado","Quitar nodos con 2","Agregar un dato en posicion dada","Salir"};
                String valor=(String) JOptionPane.showInputDialog(null, "Seleccione la opcion: ","OPCIONES", JOptionPane.DEFAULT_OPTION, null, menu,menu[0]);
                switch (valor)
                {
                        case "Agregar":cabz=add_col(cabz); break;
                        case "Listado":lis(cabz); break;
                        case "Quitar nodos con 2":prom(cabz);
                        	break;
                        case "Agregar un dato en posicion dada":
                        	String q=JOptionPane.showInputDialog("Ingrese la posicion");
                            int x=Integer.parseInt(q);
                        	cabz=addpos(cabz,x); break;
                        case "Salir":System.exit(0);
                }
        }
	}
	public static nodo add_col(nodo cab, int i)
	{
		int con=1;
		nodo x, nuevo;
		nuevo=new nodo();
		String q=JOptionPane.showInputDialog("Ingrese el dato");
        int q3=Integer.parseInt(q);
		nuevo.dato=q3;
		nuevo.sgte=null;
		if (cab==null)
		{
			cab=nuevo;
		}
		else
		{
			x=cab;
			while (con!=i)
			{
				con++;
			}
			nuevo.sgte=x.sgte;
			x.sgte=nuevo;
			while (x.sgte!=null)
			{
				x=x.sgte;
			}
			x.sgte=nuevo;
		}
		return (cab);
	}
	public static nodo prom (nodo cab)
	{
		nodo nuevo=new nodo();
		while (cab!=null)
		{
			if (cab.dato!=2)
			{
				cab=cab.sgte;
			}
			else
			{
				cab.dato=cab.sgte.dato;
				cab=cab.sgte.sgte;
			}
			
		}
		return cab;
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
	public static nodo addpos(nodo cab, int p)
	{
		int x=p-1;
		nodo nuevo=null,z;
		int c=con(cab);
		if (x<=c)
		{
			nuevo=new nodo();
			String q=JOptionPane.showInputDialog("Ingrese el dato");
	        int q3=Integer.parseInt(q);
	        nuevo.dato=q3;
			nuevo.sgte=null;
			if (x==0)
			{
				nuevo.sgte=cab;
				cab=nuevo;
			}
			else
			{
				z=cab;
				for (int i=1;i<x;i++)
				{
					z=z.sgte;
				}
				nuevo.sgte=z.sgte;
				z.sgte=nuevo;
			}
		}
		return (cab);
	}
	public static void lis (nodo cab)
	{
		String r=""; 
		while (cab!=null)
		{
			r=r+"Dato: "+cab.dato+"\n";
			cab=cab.sgte;
		}
		JOptionPane.showMessageDialog(null, r);
	}
}
