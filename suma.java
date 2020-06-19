
//4,- obtener la suma de : 1+4+9+16+25
import java.util.*;

public class suma {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("introducir el numero");
    int n = in.nextInt();
    int respuesta = respuesta(n);
    System.out.println("la respuesta es  " + respuesta);
    in.close();
  }

  public static int respuesta(int n) {
    int x = 0;
    int a = 0;
    for (int i = 0; i <= n; i++) {
      x = x + (a * a);
      a = a + 1;
    }

    return x;
  }
}