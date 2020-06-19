import javax.swing.*;
import java.util.*;
public class InterfazEjercicio2 {
 public static void main(String args[])
 {
  ArrayList<Integer> lista=new ArrayList<Integer>();
  String cad1=JOptionPane.showInputDialog(null, "Cuantos numeros enteros ingresara?");
  int n=Integer.parseInt(cad1);
  for(int i=0;i<n;i++)
  {
   String cad2=JOptionPane.showInputDialog(null, "Ingrese el entero "+(i+1));
   int nu=Integer.parseInt(cad2);
   lista.add(nu);
  }
  Ejercicio2 obj1=new Ejercicio2(lista);
  JOptionPane.showMessageDialog(null, obj1.toString());
 }
}
