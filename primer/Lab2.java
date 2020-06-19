//2  Ingresar N valores en un arreglo que representen las edades de un grupo
// de personas para determinar 
// -catidad de mayores de edad
// -cantidad de menores de 5 a�os
// - cantidad de mayores de 70 a�os

import java.util.*;

class Lab2 {
  static Scanner in = new Scanner(System.in);

  public static void main(String[] Fulano) {
    System.out.printf("El numero de edades a ingresar");
    int n = in.nextInt();
    int edad[] = new int[n];
    int may18 = 0, men5 = 0, may70 = 0;
    for (int i = 0; i < edad.length; i++) {
      System.out.printf("La edad " + (i + 1) + ";");
      edad[i] = in.nextInt();
      if (edad[i] <= 5 && edad[i] > 0)
        men5++;
      if (edad[i] >= 18)
        may18++;
      if (edad[i] >= 70)
        may70++;
    }
    System.out.printf("El numero de menores a cinco a�os es: " + men5);
    System.out.printf("\nEl numero de mayores de edad es: " + may18);
    System.out.printf("\nEl numero de mayores de 70 es: " + may70);
  }
}