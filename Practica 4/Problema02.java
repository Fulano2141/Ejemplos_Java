/*2.- Escribir un programa que a partir de un arreglo constante de 10 elementos enteros, 
 * determine el porcentaje de números pares positivos e impares negativos.*/
import java.util.*; 
class Problema02{
  static Scanner in=new Scanner(System.in);
  public static void main (String [] Fulano){
    int cp=0,pi=0;
    int vec1[]={-7,4,6,9,-5,3,-2,-4,7,12};         
    for (int i=0;i<vec1.length;i++){
      if(vec1[i]%2==0 && vec1[i]>0){
        cp++;
      }
     if(vec1[i]%2!=0 && vec1[i]<0){
       pi++;
      }
    }
    pi=pi*100/10;
    cp=cp*100/10;
    System.out.println("El porcentaje de pares positivos es : "+cp+"%");
    System.out.println("El porcentaje de impares negativos es: "+pi+"%");
  }
}