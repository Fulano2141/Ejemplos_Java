
//3.- obtener el valor de la serie 
import java.util.*;

public class serie {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("introducir el numero");
    int n = in.nextInt();
    double respuesta = respuesta(n);
    System.out.println("la respuesta es" + respuesta);
    in.close();
  }

  public static double respuesta(int n) {
    double d = 1;
    double a = 0;
    for (int x = 0; x < n; x++)
      a = a + (4 / d);
    d += 2;
    a *= -1;
    return a;
  }
}