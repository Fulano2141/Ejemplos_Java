/*6.- Dados dos arreglos constantes de igual tamaño, generar un 
 * tercer arreglo con los elementos intercalados.*/
import java.util.*; 
class Problema06{
  static Scanner in=new Scanner (System.in);
  public static void main(String[] Fulano){
    int l=0,k=1;
    int vec1[]={1,2,3,4,5,6,7,8,9};         
    int vec2[]={9,7,8,6,5,4,3,2,1};
   int vec[]=new int[18];        
    for (int i=0;i<9;i++){
      vec[l]=vec1[i];
        l=l+2;
    }
     for (int i=0;i<9;i++){
      vec[k]=vec2[i];
        k=k+2;
    } 
    for (int i=0;i<18;i++){
      System.out.print(vec[i]+" ");
    }
  }
}