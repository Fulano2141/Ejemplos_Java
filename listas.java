package tarea_listas;
import java.io.*;
public class listas {
	
		  public static class nodo
		  {
		     int dato;
		     nodo sgte;
		  }
		 public static void main(String arg[])throws IOException
		 {  nodo cab=null;
		   int opciones, dato1, n=0, n1=0;
		   do{
		       menu();
		       opciones=leer("?");
		       switch (opciones)
		       {
		         case 1:
		                cab=agregar_nodo(cab);
		                break;
		         case 2:
		                listado("Datos de la lista\n",cab);
		                break;  
		         case 3:
		                System.out.println(" la sumatoria es "+sumatoria(cab));
		                break;  
		         case 4:
		                cab=borrar_cab(cab);
		                break;
		         case 5:
		               borrar_ultimo(cab);
		               break;
		         case 6:
		              dato1=leer("dato a borrar?");
		              cab=borrar_nodo_dato_x(cab,dato1);
		              break;
		         case 7:
		        	 do {
		        		n=leer("numero de elemento"); 
		        	 }while(n<=0);
		        	 if(n<=contar(cab))
		        	 {
		        		 System.out.println( "la direccion es  "+dir_x(cab,n));
		        	 }
		        	 else
		        		 System.out.println("  NO existe esa posicion ");
		        	 break;
		         case 8:
		        	 do {
			        		n=leer("numero de  primer elemento"); 
			        	 }while(n<=0 || n>=contar(cab));
		        	 do {
			        		n1=leer("numero de  segundo elemento"); 
			        	 }while(n1<=0 || n>=contar(cab) || n>=n1);
		        	 mostrar_a_b(cab,n,n1);
		        	 break;
		         case 9:
		        	 listado("Datos de la  original\n",cab);
		        	 ordenar(cab);
		        	 listado("Datos de la lista ordenada\n",cab);
		        	 break;
		         case 10:
		        	 if(cab!=null) {
		        		 listado("Datos de la  original\n",cab);
		        		 nodo ma=maximo(cab);
			        	 nodo mi=minimo(cab);
			        	 int r=ma.dato;
			        	 ma.dato=mi.dato;
			        	 mi.dato=r;
			        	 listado("Datos de la  original\n",cab);			        	 
		        	 }
		        	break;		        	 
		        	 
		       }
		   }while(opciones!=15);         
		}
		 public static nodo minimo( nodo c)
		 {
			nodo aux=c;
			while(c!=null)
			{
				if(aux.dato>c.dato) {
					aux=c;
				}
				c=c.sgte;
			}
			return(aux);
		 }
		 public static nodo maximo( nodo c)
		 {
			nodo aux=c;
			while(c!=null)
			{
				if(aux.dato<c.dato) {
					aux=c;
				}
				c=c.sgte;
			}
			return(aux);
		 }
		 public static void ordenar(nodo i)
		 {
			 int d;
			 nodo j;
			 if(i!=null)
			 {
				 while(i.sgte!=null)
				 {
					 j=i.sgte;
					 while(j!=null)
					 {
						 if(i.dato>j.dato) {
							 d=i.dato;
							 i.dato=j.dato;
							 j.dato=d;
						 }
						 j=j.sgte;
					 }
					 i=i.sgte;
				 }
			 }
		 }
		 public static void mostrar_a_b(nodo c, int x, int y)
		 {
			nodo uno=dir_x(c,x);
			nodo dos=dir_x(c,y);
			while(uno!=dos)
			{
				System.out.println(" dir= "+uno+" dato= "+uno.dato);
				uno=uno.sgte;
			}
		 }
		 public static nodo dir_x(nodo c, int p)
		 {   int i=1;
			 while(c!=null && i!=p )
			 {
				 c=c.sgte;
				 i++;
			 }
			 return(c);
		 }
		 public static int contar(nodo c)
		 {
		     int cc=0;
		     while(c!=null)
		     {
		       cc++;
		       c=c.sgte;
		     }
		     return(cc);
		 }
		 public static nodo borrar_nodo_dato_x(nodo c,  int db)
		 { nodo q=null,z=null;
		   if(c!=null)
		   {
		     //analisis cabecera
		     while(c.dato==db && c!=null) 
		     {
		           c=borrar_cab(c);
		     }
		     // lo que queda  
		       z=c.sgte; q=c;
		       while( z!=null)
		       {
		         if(z.dato==db)
		         {
		           q.sgte=z.sgte;
		           z=q;
		         }
		         q=z;
		         z=z.sgte;
		       }
		     }
		   return(c);
		   }
	   
		 
		 public static void borrar_ultimo(nodo c)
		 { nodo x=c;
		   if(c!=null && c.sgte!=null)
		        {
		          while(x.sgte!=null)
		          {
		            c=x;
		            x=x.sgte;
		          }
		          c.sgte=null;
		        }
		 }
		 public static nodo borrar_cab(nodo c)
		 {
		   if(c!=null)
		     c=c.sgte;
		   return(c);
		 }
		 public static int sumatoria(nodo c)
		 {
		     int s=0;
		     while(c!=null)
		     {
		       s=s+c.dato;
		       c=c.sgte;
		     }
		     return(s);
		 }
		 public static void listado(String t, nodo c)
		 {
		     System.out.println(t);
		     while(c!=null)
		     {
		       System.out.println("direccion ="+c+"dato es ="+c.dato);
		       c=c.sgte;
		     }
		 }
		 public static nodo agregar_nodo(nodo c)throws IOException
		 { nodo aux=new nodo();
		   aux.dato=leer("dato?");
		   aux.sgte=c;
		   c=aux;
		   return(c);
		 }
		 public static void menu()
		 {
		   System.out.println("listas enlazadas");
		   System.out.println("1. agregar nodos");
		   System.out.println("2. listado");
		   System.out.println("3. sumatoria");
		    System.out.println("4. Borrar dato de la cabecera");
		     System.out.println("5. Borrar ultimo nodo");
		      System.out.println("6. borrar nodo con dato x");
		      System.out.println("7. Desplegar la dirección del nodo n"); 
		      System.out.println("8. preg 13"); 
		      System.out.println("9. Ordenar"); 
		      System.out.println("10. preg 35"); 
		   System.out.println("15.salir");                  
		 }
		 public static int leer(String t)throws IOException
		 {
		    BufferedReader y=new BufferedReader (new InputStreamReader(System.in));
		    System.out.println(t);
		    int p=Integer.parseInt(y.readLine());
		    return(p);   
		 }
}

