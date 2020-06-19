/*2.- Efectuar la rotación de un AL que contiene números enteros, mostrar 
 * el AL después de efectuada la rotación. */
import java.util.*;
public class Ejercicio2 {
 ArrayList<Integer> lista=new ArrayList<Integer>();
 public Ejercicio2(ArrayList<Integer> lista)
 {
  this.lista=lista;
 }
 public String toString()
 {
  Collections.reverse(lista);
  String aux="ArrayList:\n";
  for(int i:lista)
  {
   aux=aux+i+"\n";
  }
  return aux;
 }
}
