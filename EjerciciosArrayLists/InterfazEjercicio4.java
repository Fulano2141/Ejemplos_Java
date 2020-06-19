import javax.swing.*;
import java.util.*;
public class InterfazEjercicio4 {
 public static void main(String args[])
 {
  ArrayList<Ejercicio4> lista=new ArrayList<Ejercicio4>(); 
  for(;true;){
     String [] menu = {"Crear la venta del a�o","Venta m�xima","Total de ventas","Venta M�nima","Salir"};
     String valor = (String) JOptionPane.showInputDialog(null, "Seleccione la opcion","Opciones",JOptionPane.DEFAULT_OPTION,null,menu,menu[0]);
     switch(valor){
     case "Crear la venta del a�o": {a�adir(lista);}; break;
     case "Venta m�xima": max(lista); break;
     case "Total de ventas": total(lista); break;
     case "Venta M�nima": min(lista); break;
     case "Salir": System.exit(0); break;
     }
 }
 }
 public static void a�adir(ArrayList<Ejercicio4> lista)
 {
  String m[]={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
  lista.clear();
  JOptionPane.showMessageDialog(null,"Escriba las ventas del a�o (Enero-Diciembre | La lista se sobreescribir� cada vez que se use esta funci�n)");
  for(int i=0;i<12;i++)
  {
   String cad1=JOptionPane.showInputDialog(null,"Ingrese la venta de "+m[i]);
   double v=Double.parseDouble(cad1);
   Ejercicio4 obj1=new Ejercicio4(v,m[i]);
   lista.add(obj1);
  }
 }
 public static void max(ArrayList<Ejercicio4> lista)
 {
  double venta=lista.get(0).getVenta();
  double tem;
  String mes=lista.get(0).getMes();
  for(Ejercicio4 tmp:lista)
  {
   tem=tmp.getVenta();
   if(tem>=venta)
   {
    venta=tem;
    mes=tmp.getMes();
   }
  }
  JOptionPane.showMessageDialog(null, "La venta maxima fue de "+venta+" Bs en "+mes);
 }
 public static void total(ArrayList<Ejercicio4> lista)
 {
  double tot=0;
  for(Ejercicio4 tmp:lista)
  {
   tot+=tmp.getVenta();
  }
  JOptionPane.showMessageDialog(null, "El total de las ventas este a�o fue de "+tot+" Bs");
 }
 public static void min(ArrayList<Ejercicio4> lista)
 {
  double venta=lista.get(0).getVenta();
  double tem;
  String mes=lista.get(0).getMes();
  for(Ejercicio4 tmp:lista)
  {
   tem=tmp.getVenta();
   if(tem<=venta)
   {
    venta=tem;
    mes=tmp.getMes();
   }
  }
  JOptionPane.showMessageDialog(null, "La minima venta fue de "+venta+" Bs en "+mes);
 }
 
}
