import java.io.*;

public class polinomios {
  public static class nodo {
    int ter;
    int ex;
    nodo sgte;
  }

  public static void main(String arg[]) throws IOException {
    nodo cab = null;
    int opciones;
    do {
      menu();
      opciones = leer("?");

      switch (opciones) {
        case 1:
          cab = null;
          int e = leer("Grado:");
          cab = agregar_nodo(e);
          System.out.println(cab.sgte + "\n");
          break;
        case 2:
          listado("Datos de la lista\n", cab);
          break;
        /*
         * case 3: System.out.println(" la sumatoria es "+sumatoria(cab)); break;
         */
      }
    } while (opciones != 5);
  }

  public static void listado(String t, nodo c) {
    System.out.println(t + "\n");
    while (c != null) {
      if (c.ex == 0) {
        System.out.print(c.ter);
      } else {
        System.out.print(c.ter + "X^" + c.ex + " + ");
      }
      c = c.sgte;
    }
  }

  public static nodo agregar_nodo(int e) throws IOException {
    nodo c = null;
    for (int i = e; i >= 0; i--) {
      nodo aux = new nodo();
      int t = leer("Termino: ");
      if (t != 0) {
        aux.ter = t;
        aux.ex = (e - i);
        aux.sgte = c;
        c = aux;
      }
    }
    return (c);
  }

  public static void menu() {
    System.out.println("Polinomios");
    System.out.println("1. Lectura de Polinomio");
    System.out.println("2. Lista");
    System.out.println("3. Derivadqas");
    System.out.println("5. Integrales");
    System.out.println("6. Salir");
  }

  public static int leer(String t) throws IOException {
    BufferedReader y = new BufferedReader(new InputStreamReader(System.in));
    System.out.println(t);
    int p = Integer.parseInt(y.readLine());
    return (p);
  }
}