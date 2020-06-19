/*14.- Almacenar en un arreglo los n primeros números primos.*/
import java.util.*; 
class Problema14{
  static Scanner in=new Scanner (System.in);
  public static void main(String[] args){
    System.out.printf("La cantidad de numeros primos ");
    int n=in.nextInt();
    int i, cnp = 0, res;
    int num[] = new int[n + 1];
    for (i = 0; i < n; i++) {
      num[i] = (int) (Math.random() * 100);
      res = 0;
      for (int j = 1; j <= num[i]; j++) {
        if (num[i] % j == 0) {
          res++;
        }
      }
      if (res == 2) {
        cnp++;
        System.out.println("numero primo =" + num[i]);
      }
    }
    System.out.println("La cantidad de numeros primos es :" + cnp);        
  }
  
}