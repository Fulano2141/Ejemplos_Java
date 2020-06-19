// 13.- Un arreglo constante contiene la producción en toneladas 
// métricas de 6 minerales, y otro contiene los nombres de estos 
// minerales, para obtener:
//- Buscar por nombre de mineral y desplegar la producción
//- Ordenar del mayor al menor (producción) y mostrar:
//   Mineral  Produccion ™
//     SN      998.000
//     SB      876.500
//     AU      786.670
//     PT      636.143
//     AG      135.567
//     CU      109.412
import javax.swing.*;
import java.util.*;
class Ejercicio13{
  static Scanner in=new Scanner(System.in);
  public static void main (String [] Fulano)
  {
    String nom[]={"SN","SB","AU","PT","AG","CU"};
    double[] pob={998.000,876.500,786.670,636.143,135.567,109.412};
    System.out.println("Mineral  "+" Produccion");
    for (int i=0;i<pob.length;i++){
    System.out.println(nom[i]+"        "+pob[i]);
    }
    String array[]={in.next()};
    for (int i=0;i<nom.length;i++){
      if(array[0]==nom[i])
        System.out.println(nom[i]+"        "+pob[i]);
    }
  }
}