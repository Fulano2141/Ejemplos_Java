
//2._ mediante una funcion determinar si un numero entero mayor a cero es o no prima
import java.util.*;

public class Nprimo {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("introducir el numero");
    int n = in.nextInt();
    if (respuesta(n) == true)
      System.out.println("es primo");
    else
      System.out.println("no es primo");

    in.close();
  }

  public static boolean respuesta(int n) {
    int res = 0;
    for (int b = 1; b <= n; b++)
      if (n % b == 0)
        res = res + 1;
    if (res == 2)
      return true;
    else
      return false;

  }
}
