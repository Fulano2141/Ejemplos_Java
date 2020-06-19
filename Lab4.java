/* 4.- almacenar en un arreglo numeros al azar entre 1000 y 9999
// luego mostrar este arreglo y determinar la cantidad de capicuas */
import javax.swing.*;
import java.util.*;
class Lab4
{
  static Scanner in=new Scanner(System.in);
  public static void main (String [] Fulano){
    System.out.printf("Digite el tamaño del arreglo");
    int n=in.nextInt();
    int res,num1=0,n1=0,c1=0;
    int capicua[]=new int[n];
    for(int i=0;i<capicua.length;i++){
       capicua[i]=(int)(Math.random()*999);}
    for(int i=0;i<capicua.length;i++){
      System.out.print(capicua[i]+" ");
      n1=capicua[i];
      num1=0;
      res=0;
      while(n1!=0){
        res=n1%10;
        n1=n1/10;
        num1=num1*10+res;
      }
      if (capicua[i]==num1)
        c1++;
    }
    System.out.printf("Los cantidad de capicuas que existen en el arreglo son: "+c1);
  }
}
  