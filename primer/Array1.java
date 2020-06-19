// Arreglos en java

import java.util.*;

public class Array1 {
  static Scanner in = new Scanner(System.in);
  public static void main(String[] Fulano) {
    int vec[] = new int[10]; // int vec[10]
    for (int i = 0; i < vec.length; i++) {
      vec[i] = i + 1;
    }
    for (int i = 0; i < vec.length; i++) {
      System.out.print(vec[i] + " ");
    }
    System.out.println(); // Salto de linea

    // Vectores ocnstantes
    String meses[] = { "Ene", "Feb", "Mar", "Abr", "May", "Jun" };
    for (int i = 0; i < meses.length; i++) {
      System.out.print(meses[i] + " ");
    }
    System.out.println(); // Salto de linea

    // vectores con numeros al azar

    System.out.printf("Digite el tamano del arreglo: ");
    int n = in.nextInt();
    int edad[] = new int[n];
    for (int i = 0; i < edad.length; i++) {
      edad[i] = (int) (Math.random() * 99 + 1);
    }
    for (int i = 0; i < edad.length; i++) {
      System.out.print(edad[i] + " ");
    }
    System.out.println(); // Salto de linea

    System.out.printf("El numero de notas: ");
    int nota = in.nextInt();
    int notas[] = new int[nota];
    for (int i = 0; i < notas.length; i++) {
      System.out.printf("La nota " + (i + 1) + ": ");
      notas[i] = in.nextInt();
    }

    for (int i = 0; i < notas.length; i++) {
      System.out.println(notas[i]);
    }
  }
}