// 1 Almacenar numeros al azar entre 100 y 999 mostrar el arreglo y determinar el porcentaje de pares e impares
import javax.swing.*;
import java.util.*;
class Lab1
{
  static Scanner in=new Scanner(System.in);
  public static void main (String [] Fulano)
  {
    System.out.printf("Digite el tamaño del arreglo");
    int n=in.nextInt();
    int arreglo[]=new int[n];
    int c1=0,c2=0;
    for(int i=0;i<arreglo.length;i++){
      arreglo[i]=100+(int)(Math.random()*999+1);
      if(arreglo[i]%2==0)
        c1++;
      else
        c2++;
    }
    int x,y;
    x=c1*100/n;
    y=c2*100/n;
    for (int i=0;i<arreglo.length;i++)
    {
      System.out.print(arreglo[i]+" ");
    }
    System.out.print("Porcentaje de pares es: "+x+"%");
    System.out.print("Porcentaje de impares es: "+y+"%");
  }
}