/*12.- Almacene en un arreglo las edades de varias personas (hasta ingresar un -1) y
 * a partir de este arreglo determine la desviación típica.*/
import java.util.*; 
class Problema12{
  static Scanner in=new Scanner (System.in);
  public static void main(String[] Fulano){     
    int edad[]=new int[100];
    int n=0,sum=0,me;
    int i,o;
    for(i=0;n!=-1;){
      System.out.printf("la edad;");
      n=in.nextInt();      
      edad[i]=n;
      i++;
    }
    for(o=0;o<i;){
      sum=sum+edad[o];
      o++;
    }
    me=sum/i; sum=0;
    for(o=0;o<i;o++){
      sum=sum+(edad[i]-me)*(edad[i]-me);
    }
    float var=(float)Math.sqrt(sum/(o+1));
    System.out.printf("La desviacion tipica es: "+var);
  }
}