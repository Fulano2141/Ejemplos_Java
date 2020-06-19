/**
 * Auto Generated Java Class.
 */
import java.io.*;
import java.util.Scanner;
public class J2 {
  //definicion del nodo:
 public static class nodo
 {
   int dato;
   nodo sgte;
 }
  public static void main(String arg[])
  {
      int opcion ;
      nodo cab=null;
      do{
        opcion=menu();
        switch (opcion){
          case 1: 
               cab=adicionar(cab);
               break;
          case 2:
               listado(cab);
               break;
          case 3:
                System.out.println("Lasuma es "+sumatoria(cab));
                break;
          case 4:
                System.out.println("total de nodos "+contar(cab));
                break;
          case 5:
                funcion1(cab);
                System.out.println("La lista ha sido modificada");
                listado(cab);
                break;
          case 6:
                cambiojuan(cab);
                System.out.println("La lista ha sido modificada");
                listado(cab);
                break;
          case 7:
                segundamitad(cab);
                System.out.println("lista modificada");
           break;
        }
      }while(opcion!=15);
  }
   public static int sumatoria(nodo c)
  { int t=0;
    while(c!=null)
    {
      System.out.println(c.dato);
      t=c.dato+t;
      c=c.sgte;  
    }
  return(t);
   }
  public static int contar(nodo c)
  { int t=0;
    while(c!=null)
    {
      System.out.println(c.dato);
      c=c.sgte;
      t++;
    }
  return(t);
  }
  public static void listado(nodo c)
  {
    while(c!=null)
    {
      System.out.println(c.dato);
      c=c.sgte;
    }
  }
  public static int menu()
  {
    System.out.println("1 agregar un nodo \n2. listado ");
    System.out.println("3. sumatoria \n4Contar");
    System.out.println("5. Funcion 1\n");
    System.out.println("6. Cambio\n");
    System.out.println("7.Quitar segunda mitad del nodo");
    int x=leer("Su opcion es?");      
    return(x);
  }
  public static nodo adicionar(nodo c)
  {
    nodo nuevo=new nodo();
    nuevo.dato=leer("dato?");
    nuevo.sgte=c;
    c=nuevo;
    return(c);
  }
  public static int leer(String x)
 {
   Scanner sc = new Scanner(System.in);
    System.out.println(x);
   int n = sc.nextInt();
   return(n);
  // x = sc.nextDouble();
}
  public static void funcion1(nodo cab){
    while(cab!=null){
      if(cab.dato%2==0){
        cab.dato*=5;
      }
      cab=cab.sgte;
    }
  }

  //juan cutile
  public static void cambiojuan(nodo cab)
  {
    while(cab!=null)
    {
      if(cab.dato==2)
      {
        cab.dato=8;
      }
      cab=cab.sgte;
    }
  }
  //Jorge de la Rocha
  //
  public static void segundamitad(nodo cab)
  {
    int f = contar(cab);
    
    for(int i=0;i<f/2;i++)
    {
      cab=cab.sgte;//Saul Alejandro Medina Lobo 
    }
    cab.sgte=null;
  }
 
}
