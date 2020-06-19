// 3 .Almacenar en un arreglo numeros al azar entre 0 y 9999
// que representen la produccion del oro en el transcursode un a�o
// luego mostrar este arreglo junto a un arreglo que contenga los nombres de los meses del a�o
//      ene: 2342
//      feb:2345
// ... .. ... .. .
// Tambien se debe mostrar la produccion total de oro en el a�o y finalmente en que mes 
// se produjo la menor produccion 

import java.util.*;

class Lab3 {
  static Scanner in = new Scanner(System.in);

  public static void main(String[] Fulano) {
    int con1 = 0, menor = 10000, u = 0;
    int arreglo[] = new int[12];
    for (int i = 0; i < arreglo.length; i++) {
      arreglo[i] = (int) (Math.random() * 9999 + 1);
      con1 = con1 + arreglo[i];
    }
    for (int i = 0; i < arreglo.length; i++) {
      if (arreglo[i] < menor) {
        menor = arreglo[i];
        u = i;
      }
    }
    String meses[] = { "Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic" };
    for (int i = 0; i < meses.length; i++) {
      System.out.print(meses[i] + ": " + arreglo[i] + "\n");
    }
    System.out.print("La produccion total es: " + con1);
    System.out.print("\n La menor cantidad de produccion es de: " + arreglo[u]);
  }
}