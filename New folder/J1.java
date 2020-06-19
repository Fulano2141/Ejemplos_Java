/**
 * Auto Generated Java Class.
 */
import java.util.Scanner;
public class J1 {
  
 public static void main(String arg[])
 {
   int k=leer("Dato?");
   System.out.println("el dato es "+k);
 } 
 public static int leer(String x)
 {
   Scanner sc = new Scanner(System.in);
    System.out.println(x);
   int n = sc.nextInt();
   return(n);
  // x = sc.nextDouble();
}
}