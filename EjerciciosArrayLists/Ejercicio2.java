/*2.- Efectuar la rotaci�n de un AL que contiene n�meros enteros, mostrar 
 * el AL despu�s de efectuada la rotaci�n. */
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
