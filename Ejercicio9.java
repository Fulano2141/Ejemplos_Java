// 9. Una fábrica de llantas quiere un programa para calcular el costo total
// de producción de los n modelos de llantas que produce. Los datos con que 
// cuenta son los siguientes:
// ao,  a1,  ...,  an-1,   y   c0,  c1,   ...,  cn-1, 
// Con:  51>n>0
// ai  enteros  ,  ci   enteros
// Dónde: 
// ai representa la cantidad de llantas producidas del modelo i
// ci representa el costo de producción de una llanta del modelo i
import javax.swing.*;
import java.util.*;
class Ejercicio9
{
  static Scanner in=new Scanner(System.in);
  public static void main (String [] Fulano)
  {
    System.out.printf("Digite el numero total de modelos de llantas llantas");
    int n=in.nextInt();
    int mod[]=new int[n];
    int cantidad[]=new int[n];
    int costo[]=new int[n];
    int j=1,cont=0;
    System.out.println("Digite las cantidades producidas");
    for(int i=0;i<cantidad.length;i++){
      System.out.printf("Cantidad del modelo "+j+":");
      cantidad[i]=in.nextInt();
      j++;
    } j=1;
    System.out.println("Digite los precios ");
    for(int i=0;i<costo.length;i++){
      System.out.printf("Precio del modelo "+j+":");
      costo[i]=in.nextInt();
      j++;
    }j=1;
    for(int i=0;i<mod.length;i++){
      mod[i]=cantidad[i]*costo[i];
      System.out.println("Costo total del modelo "+j+": "+mod[i]);
      cont=cont+mod[i];
      j++;
    }
    System.out.println("El costo total es: "+cont);
  }
}