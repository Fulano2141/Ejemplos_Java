// 3.- Escribir un programa que genere un arreglo de 50 posiciones con 
// números al azar en el rango (1-9999) y determine cuántos de estos 
// elementos son números primos.
import javax.swing.*;
import java.util.*;
class Ejercicio3
{
  public static void main (String [] Fulano)
  {     
    int array[]=new int[50];
    for(int i=0;i<array.length;i++){
      array[i]=(int)(Math.random()*9999+1);
    }
    System.out.print("Los numeros primos del arreglo son: ");
    for (int i=0;i<array.length;i++)
    {
      int a=0, n=0;
       for(n=1;n<=(array[i]);n++){
         if(array[i]%n==0){
           a++;}
       }
       if(a==2)
         System.out.print(array[i]+" ");
    }
  }
}