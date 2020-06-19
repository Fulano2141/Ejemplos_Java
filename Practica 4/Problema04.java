/*4.- Un arreglo contiene las edades de un grupo de 50 personas con números al azar,
 * determine: el porcentaje de mayores y menores de edad.*/
import java.util.*; 
class Problema04{
  static Scanner in=new Scanner (System.in);
  public static void main (String [] Fulano){
    int Md=0,md=0;
    int edad[]=new int[50];
    for(int i=0;i<edad.length;i++){
      edad[i]=(int)(Math.random()*99+1);
    }
    for (int i=0;i<edad.length;i++){
      System.out.print(edad[i]+" ");
    }
    for (int i=0;i<edad.length;i++){
      if(edad[i]>=18 ){
        Md++;
      }
     if(edad[i]<18 ){
       md++;
      }
    }
    System.out.println("");
    System.out.println(Md+" son mayores de edad");
    System.out.println(md+" son menores de edad");
  }
}