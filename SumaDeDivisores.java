
//1 mediante una funcion obtener la suma de los divisores de un numero entero
import java.util.*;

public class SumaDeDivisores {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("introducir el numero");
    int num = in.nextInt();
    int divisor = divisor(num);
    System.out.println("resouesta =" + divisor);
    in.close();
  }

  public static int divisor(int num) {
    // int divisor;
    int b = 0;
    // for (int c = 0; c == num; c++)
      // divisor = num / c;
    if (num % b == 0)
      b = b + b;
    return b;

  }
}
