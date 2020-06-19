import java.util.*;
import javax.swing.*;
public class InterfazEjercicio1 {
 public static void main(String args[]){
  ArrayList<Integer> lista=new ArrayList<Integer>();
  String cad1=JOptionPane.showInputDialog(null,"Ingrese a cuantas personas registrara");
  int n=Integer.parseInt(cad1);
  for(int i=0;i<n;i++){
   String cad2=JOptionPane.showInputDialog(null,"Ingrese la altura "+(i+1));
   int h=Integer.parseInt(cad2);
   lista.add(h);
  }
  Ejercicio1 obj1=new Ejercicio1(lista);
  JOptionPane.showMessageDialog(null,obj1);
 }
}
