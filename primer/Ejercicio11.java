// 11.-  Dado un arreglo que contiene la poblaci�n de los nueve 
// departamentos del pa�s y otro que contiene los nombres de estos 
// departamentos, genere un b�sico grafico estad�stico que muestre 
// esta poblaci�n (utilice un factor de escala), adem�s indique el 
// nombre del departamento que tiene la mayor poblaci�n y el nombre 
// del departamento que tiene la menor poblaci�n.

public class Ejercicio11 {
  public static void main(String[] Fulano) {
    System.out.println("Departamento\tPoblacion");
    String nom[] = { "Beni", "Chuquisaca", "Cochabamba", "La Paz", "Oruro", "Pando", "Potosi", "Santa Cruz", "Tarija" };
    int[] pob = { 421196, 576153, 1758143, 2706351, 494178, 110436, 823517, 2655084, 482196 };
    for (int i = 0; i < 9; i++) {
      System.out.println(nom[i] + "\t\t" + pob[i]);
    }
    int a = 0, menor = 0, mayor = 0;
    for (int i = 0; i < 9; i++) {
      if (pob[i] < menor) {
        menor = pob[i];
        a = i;
      }
    }
    System.out.println("La menor poblacion es de: " + nom[a] + " con " + pob[a]);
    
    a = 0;
    for (int i = 0; i < 9; i++) {
      if (pob[i] > mayor) {
        mayor = pob[i];
        a = i;
      }
    }
    System.out.println("La mayor poblacion es de: " + nom[a] + " con " + pob[a]);

  }
}