import java.io.*;

public class matrrices {
  public static class matriz {
    int dato;
    int fi;
    int col;
    matriz sgte;
  }

  public static void main(String[] args) throws IOException {
    int f = 0, c = 0, op, fb = 0, cb = 0;
    matriz z = null;
    matriz a = null;
    matriz b = null;
    matriz C = null;
    do {
      op = menu();
      switch (op) {
        case 1:
          do {
            f = leer("Total de filas de la matriz?");
          } while (f <= 0);
          do {
            c = leer("Total de filas de la matriz?");
          } while (c <= 0);
          a = add(a, f, c);
          break;
        case 2:
          listado("la matriz es :", a, f, c);
          break;
        case 3:
          if (c == f) {
            System.out.println("la traza es " + traza(a, f));
          } else
            System.out.println("no es cuadrada");
          break;
        case 4:
          if (c == f) {
            System.out.println("la diagonal secundaria es " + diagSecun(a, f));
          } else
            System.out.println("no es cuadrada");
          break;
        case 5:
          int fil = leer("Fila:");
          if (fil <= f) {
            System.out.println("la suma de la fila " + fil + " es " + sumaf(a, fil));
          } else
            System.out.println("la fila no existe");
          break;
        case 6:
          z = maximo(a);
          System.out.println("El maximo valor es: " + z.dato + " en [" + z.fi + "][" + z.col + "]");
          maximo(a);
          break;
        case 7:
          maximo_fi(a, f, c);
        case 8:
          int z1;
          do {
            z1 = leer("columna que desea sumar");
          } while (z1 < 0 || z1 > c);
          System.out.println("La suma de la columna: " + suma_columna(a, f, c, z1));
          break;
        case 9:
          int col = leer("# Columna?");
          max_col(a, f, col);
          break;

        case 10:
          do {
            fb = leer("Total de filas de la matriz?");
          } while (fb <= 0);
          do {
            cb = leer("Total de filas de la matriz?");
          } while (cb <= 0);
          b = add(b, fb, cb);
          break;
        case 11:
          listado("la matriz es :", b, fb, cb);
          break;
        case 12:
          if (c == fb) {
            C = multiplicacion(a, b, f, cb, c);
            listado("la matriz es :", C, f, cb);
          } else
            System.out.println("no se puede");
          break;
        case 13:
          listado("la matriz es :", a, f, c);
          listado("la matriz es :", b, fb, cb);
          intercambiar(a, b);
          listado("la matriz es :", a, f, c);
          listado("la matriz es :", b, fb, cb);
          break;

      }
    } while (op != 20);
  }

  public static void intercambiar(matriz x, matriz y) {
    matriz mx = null, my = null;
    int dd;
    mx = maximo(x);
    my = maximo(y);
    dd = mx.dato;
    mx.dato = my.dato;
    my.dato = dd;
  }

  public static void max_col(matriz a, int n, int m) {
    int max = buscar(a, 1, m);
    for (int i = 1; i <= n; i++) {
      if (max <= buscar(a, i, m)) {
        max = buscar(a, i, m);
      }
    }
    System.out.println("el valor maximo de la columna " + m + " es " + max);
  }

  public static int suma_columna(matriz a, int f, int c, int z) {

    int suma = 0;
    for (int j = 1; j <= f; j++) {
      for (int i = 1; i <= c; i++) {
        if (i == z) {
          suma = suma + (buscar(a, j, i));
        }
      }

    }
    return (suma);
  }

  public static int traza(matriz cab, int fila) {
    int s = 0;
    for (int i = 1; i <= fila; i++) {
      s = s + buscar(cab, i, i);
    }
    return (s);
  }

  public static void listado(String z, matriz cab, int n, int m) {
    System.out.println(z);
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        System.out.print(buscar(cab, i, j) + "\t");
      }
      System.out.println();
    }
  }

  private static int diagSecun(matriz cab, int fi) {
    int sum = 0;
    for (int i = 1; i <= fi; i++) {
      for (int j = 1; j <= fi; j++) {
        if (i + j == fi + 1)
          sum = sum + buscar(cab, i, j);
      }
    }
    return sum;
  }

  public static int buscar(matriz cab, int i, int j) {
    int p = 0;
    while (cab != null) {
      if (cab.fi == i && cab.col == j) {
        p = cab.dato;
      }
      cab = cab.sgte;
    }
    return (p);
  }

  public static matriz add(matriz cab, int fi, int co) throws IOException {
    matriz aux;
    for (int i = 1; i <= fi; i++) {
      for (int j = 1; j <= co; j++) {
        aux = new matriz();
        aux.fi = i;
        aux.col = j;
        aux.dato = leer("{" + i + "][" + j + "]");
        aux.sgte = cab;
        cab = aux;
      }
    }
    return (cab);
  }

  public static int menu() throws IOException {
    System.out.println("Basico de matrices");
    System.out.println("1. lectura ");
    System.out.println("2. Listado");
    System.out.println("3. traza");
    System.out.println("4. Diagonal Secundaria");// Miguel Vilca
    System.out.println("5. Sumatoria fila X");// Diego Cordova
    System.out.println("6. Maximo de la matriz");// Martin Campuzano
    System.out.println("7. Maximo por fila");// Andrew Serrano
    System.out.println("8. Suma por columna");// Lizbeth Vera Duran
    System.out.println("9. Max por columna");// Andres Alberto Huerta Monroy
    System.out.println("10. lectura B ");
    System.out.println("11. Listado  B");
    System.out.println("12. Listado  C=A*B");
    System.out.println("13. Listado  intercambio de m�ximos");
    System.out.println("20. Salir");
    int x = leer("?");
    return (x);
  }

  public static void maximo_fi(matriz z, int n, int m) {
    for (int i = 1; i <= n; i++) {
      int x = buscar(z, i, 0);
      for (int j = 1; j <= m; j++) {
        int d = buscar(z, i, j);
        if (d > x) {
          x = buscar(z, i, j);
        }
      }
      System.out.println(i + ".- " + x);
    }
  }

  public static int sumaf(matriz cab, int a) throws IOException {
    int s = 0;
    while (cab != null) {
      if (cab.fi == a) {
        s += cab.dato;
      }
      cab = cab.sgte;
    }
    return s;
  }

  public static int leer(String w) throws IOException {
    BufferedReader k = new BufferedReader(new InputStreamReader(System.in));
    System.out.print(w);
    int p = Integer.parseInt(k.readLine());
    return (p);
  }

  public static matriz maximo(matriz cab) {
    int max = cab.dato;
    matriz maxi = cab;
    while (cab != null) {
      if (cab.dato > max) {
        max = cab.dato;
        maxi = cab;
      }
      cab = cab.sgte;
    }
    return (maxi);
  }

  public static matriz multiplicacion(matriz x, matriz y, int f1, int c2, int k) {
    matriz aux = null, c1 = null;
    for (int i = 1; i <= f1; i++) {
      for (int j = 1; j <= c2; j++) {
        aux = new matriz();
        aux.dato = 0;
        aux.fi = i;
        aux.col = j;
        for (int k1 = 1; k1 <= k; k1++) {
          aux.dato = buscar(x, i, k1) * buscar(y, k1, j) + aux.dato;
        }
        aux.sgte = c1;
        c1 = aux;
      }
    }
    return (c1);
  }
}
