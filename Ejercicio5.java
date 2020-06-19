// 5.- Un arreglo contiene las estaturas en cm de n personas, 
// determinar la mayor estatura, la estatura más baja y el promedio de estaturas.
import javax.swing.*;
import java.util.*;
class Ejercicio5
{
  static Scanner in=new Scanner(System.in);
  public static void main (String [] Fulano)
  {
    System.out.printf("Digite el numero de medidas de las personas ");
    int n=in.nextInt();
    int arreglo[]=new int[n];
    int con1=0,menor=1000,a=0,con2=0, menr=0,b=0,pro=0;
    for(int i=0;i<arreglo.length;i++){
      arreglo[i]=in.nextInt();
    }
    for(int i=0;i<arreglo.length;i++)
    {
      if(arreglo[i]<menor)
      {
        menor=arreglo[i];
        a=i;
      }
    }
    for(int i=0;i<arreglo.length;i++)
    {
      pro=arreglo[i]+pro;
      if(arreglo[i]>menr)
      {
        menr=arreglo[i];
        b=i;
      }
    }
    pro=pro/n;
    System.out.println("La mayor estatura es: "+arreglo[b]);
    System.out.println("La menor estatura es: "+arreglo[a]);
    System.out.println("El promedio de estaturas es: "+pro);
  }
}