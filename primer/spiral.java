import java.util.*;

public class spiral {
  /*
   * Genera una matriz spiral/caracol de n*n con numeros desde 1 hasta n*n
   */
  static void generate(int n) {
    int caracol[][] = new int[n][n];
    int num = 1;
    int c1 = 0; // Genera columna1
    int c2 = n - 1; // Genera columna2
    int r1 = 0; // Genera fila1
    int r2 = n - 1;// Genera fila 2
    while (num <= n * n) {
      for (int i = c1; i <= c2; i++) {
        caracol[r1][i] = num;
        num++;
      }
      for (int j = r1 + 1; j <= r2; j++) {
        caracol[j][c2] = num;
        num++;
      }
      for (int i = c2 - 1; i >= c1; i--) {
        caracol[r2][i] = num;
        num++;
      }
      for (int j = r2 - 1; j >= r1 + 1; j--) {
        caracol[j][c1] = num;
        num++;
      }
      c1++;
      c2--;
      r1++;
      r2--;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(caracol[i][j] + "\t");
      }
      System.out.println();
    }
  }

  private static final Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.print("Ingrese el tamano de la matriz: ");
    int n = Integer.parseInt(scan.nextLine());
    generate(n);
  }
}