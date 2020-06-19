
import java.io.*;

public class listas_b {
	public static class nodo {
	    int dato;
	    nodo sgte;
	   }
	public static void main(String[] args)throws IOException {
		  nodo cab=null;
		  int x;
		  int op;
		  do {
		   op=menu();
		   switch(op) {
		   case 1:
			   cab=agregar_cola(cab);
			    listado(cab);
			    break;
		   case 2:
		    listado(cab);
		      break;
		   case 3:
			   cab=null;
			   break;
		   case 4:
			   if(cab!=null)
			   {
				   cab=cab.sgte;
			   }
			   break;
		   case 5:
			   if(cab!=null && cab.sgte!=null)
			   {
				 quitar_ultimo(cab);  
			   }
			   else
				   System.out.println("lista vacia");
			   break;
		   case 6:
			   if(cab!=null)
			   {
				   quitar_centro(cab);
			   }
			   break;
		   case 7:
			   if(cab!=null && cab.sgte!=null)
			   {
				   x=leer("dato del nodo siguiente al que se quiere eliminar?");
				   quitarndxa(cab,x); 
			   }
			   break;
		   case 8:
			      if(cab!=null)
			      {
			    	  x=leer("dato del nodo a buscar?");
			    	  borrar_despues_x(cab,x);
			      }
		   case 9:
			   if(cab!=null)
			   {
				   x=leer("dato del nodo a eliminar?");
				   quitarndx(cab,x);
			   }
			   break;
		   } 
		  }while(op!=10);
		 }
	public static void quitarndxa (nodo a, int x) {
		if(a.sgte.dato==x) {
			a=a.sgte;
		}else {
			while(a.sgte.sgte!=null && a.sgte.sgte.dato!=x){
				a=a.sgte;
			}
			if(a.sgte.sgte.dato==x) {
				a.sgte=a.sgte.sgte;
			}
		}
	}
	public static void quitarndx (nodo a, int x) {
		if(a.dato==x) {
			a=a.sgte;
		}else {
			while(a.sgte!=null && a.sgte.dato!=x){
				a=a.sgte;
			}
			if(a.sgte.dato==x) {
				a.sgte=a.sgte.sgte;
			}
		}
	}
	 public static int contar(nodo k)
	 { int p=0;
	  while(k!=null)
	  {
	     p++;
		  k=k.sgte;
	  }
	 return(p);
	 }
	public static void quitar_centro(nodo c)
	{
		int cn=contar(c);
		if(cn>3)
		{
		cn=cn/2;
		for(int i=1;i<cn;i++)
		{
			c=c.sgte;
		}
		c.sgte=c.sgte.sgte;
		}
		else
			System.out.println("menos de 3 nodos");
	}
	public static void quitar_ultimo(nodo x)
	{
		nodo z=x;
		while(x.sgte!=null)
		{
			z=x;
			x=x.sgte;
		}
		z.sgte=null;
	}
	public static void borrar_despues_x(nodo c,int x)
	{
		while(c.dato!=x && c!=null )
		{
			c=c.sgte;
		}
		if(c!=null)
		{
			if(c.sgte!=null)
			{
				c.sgte=c.sgte.sgte;
			}
		}
	}
	public static int menu()throws IOException
	{
				   System.out.println("**listas**\n1.Agregar nodo\n2.Listado");
				   System.out.println("3. Borrar lista");
				   System.out.println("4. Borrar nodo de la cabecera");
				   System.out.println("5. Borrar nodo de la cola");
				   System.out.println("6. Borrar nodo del centro de la lista");
				   System.out.println("7. Borrar nodo anterior al nodo que tiene  dato x");
				   System.out.println("8. Borrar posterior al nodo que tiene dato x");
				   System.out.println("9. Borrar nodo con el dato x");
				   System.out.println("10. Salir");
				   int o=leer("?");
				   return(o);
	}
	 public static int leer(String t)throws IOException
	    {
	     BufferedReader h=new BufferedReader ( new InputStreamReader(System.in));
	     System.out.println(t);
	     int p=Integer.parseInt(h.readLine());
	     return(p);
	    }
	 public static void listado(nodo k)
	 {
	  while(k!=null)
	  {
	   System.out.println("dato="+k.dato);
	   k=k.sgte;
	  }
	 }
		 public static nodo agregar_cola(nodo z)throws IOException
		 {
		  nodo nuevo, copia;
		  nuevo=new nodo();
		  nuevo.dato=leer("Dato para el nuevo nodo ");
		  nuevo.sgte=null;
		  if(z==null)
		  {
		   z=nuevo;
		  }
		  else
		  {
		   copia=z;
		   while(copia.sgte!=null)
		   {
		    copia=copia.sgte;
		   }
		   copia.sgte=nuevo;
		  }
		  return(z);
		 }
}
