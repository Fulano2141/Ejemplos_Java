import java.util.*;
import javax.swing.*;

class Ejemplo3 {
  public static void main(final String[] args) {
    int n1, n2, n3;
    final Scanner in = new Scanner(System.in);
    JOptionPane.showMessageDialog(null, "Ingrese el primer numero ");
    n1 = in.nextInt();
    System.out.println("Ingrese el segundo numero");
    n2 = in.nextInt();
    n3 = n1 + n2;
    JOptionPane.showMessageDialog(null, "La respuesta es: " + n3);
    in.close();

  }
}
