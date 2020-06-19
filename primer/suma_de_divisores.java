
//1 mediante una funcion obtener la suma de los divisores de un numero entero
import java.util.*;

public class suma_de_divisores {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Introducir el numero");
    int num = in.nextInt();
    int divisor = divisor(num);
    System.out.println("El resultado es = " + divisor);
    in.close();
  }

  public static int divisor(int num) {
    int sum = 0;
    for (int c = 1; c <= num; c++) {
      if (num % c == 0)
        sum += c;
    }
    return sum;

  }
}
