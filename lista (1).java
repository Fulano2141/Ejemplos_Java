import java.io.*;
public class lista
{
  public static class nodo
  {
     int dato;
     nodo sgte;
  }
 public static void main(String arg[])throws IOException
 {  nodo cab=null;
   int opciones;
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
       }
   }while(opciones!=5);         
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
       System.out.println(c.dato);
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
   System.out.println("5.salir");                  
 }
 public static int leer(String t)throws IOException
 {
    BufferedReader y=new BufferedReader (new InputStreamReader(System.in));
    System.out.println(t);
    int p=Integer.parseInt(y.readLine());
    return(p);   
 }
}