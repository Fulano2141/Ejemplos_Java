/*1.-  Almacenar un vector con números al azar entre A y B, e imprima la suma 
 * de los componentes de índice par y los componentes
 * de índice impar.*/
import java.util.*;
class Problema01{
  static Scanner in=new Scanner(System.in);
  public static void main (String [] Fulano){
    System.out.printf("Digite el tamaño del arreglo");
    int n=in.nextInt();
    System.out.printf("Digite el intervalo");
    int a=in.nextInt();
    int b=in.nextInt();
    System.out.print(". La suma de los pares del arreglo es: "+cosme(n,a,b));
  }
  public static int cosme(int n, int a ,int b){
        int array[]=new int[n];
    for(int i=0;i<array.length;i++){
      array[i]=(int)(Math.random()*(b-a)+a);
    }int c=0;
    for (int i=0;i<array.length;i++){
      System.out.print(", "+array[i]);
      if (array[i]%2==0)
      c=c+array[i];
    }
    return c; 
  }
}