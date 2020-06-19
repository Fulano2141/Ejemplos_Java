import java.io.*;
public class Ej1 {
    public static class doble
    {
    	int dato;
    	doble sgte, ant;
    }
	public static void main(String[] args)throws IOException {
		doble cab_d=null, cab_i=null;
		doble nuevo=null;
		int op,op2;
		int A=0,B=0;
		do {
			menu1();
			op=leer("?");
			switch(op)
			{
			case 1:
				for(int i=1;i<=100;i++) {
				nuevo=new doble();
				nuevo.dato=(int)(Math.random()*50+1);
				nuevo.sgte=null;
				nuevo.ant=null;
				if(cab_d==null)
				{
					cab_d=nuevo;
					cab_i=nuevo;
				}
				else
				{   
					op2=(int)(Math.random()*2+1);
					if(op2==1) 
					{
						cab_d=agregar_d(cab_d,nuevo);
					}
					else
					{
						cab_i=agregar_i(cab_i,nuevo);
					}
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
			case 4:
				do {
				A=leer("valor de A?");
				B=leer("valor de B?");
				}while(A>=B);
				while(cab_i.dato>B || cab_i.dato<A && cab_i!=null)
				{
					cab_i=cab_i.sgte;
					cab_i.ant=null;
				}
				while(cab_d.dato>B || cab_d.dato<A && cab_d!=null)
				{
					cab_d=cab_d.ant;
					cab_d.sgte=null;
				}
				borrar_centro(cab_i,A,B);
				break;			
				}
		}while(op!=10);

	}
public static void borrar_centro(doble cab, int a, int b)
{
	if(cab!=null)
	{
		while(cab.sgte!=null)
		{
			if(cab.sgte.dato<a || cab.sgte.dato>b)
			{
				cab.sgte=cab.sgte.sgte;
				cab.sgte.ant=cab;
			}else {
				cab=cab.sgte;	
			}
		}
	}
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
public static void menu1()
{
	System.out.println("***LISTA DOBLEMENTE ENLAZADAS***");
	System.out.println("1.- Agregar nodos");
	System.out.println("2.- Listado i_d");
	System.out.println("3.- Listado d_i");
	System.out.println("4.- quitar elementos que no se encuentran en el rango (A,B)");
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