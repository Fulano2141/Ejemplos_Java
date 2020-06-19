import java.util.ArrayList;
import javax.swing.*;
public class InterfazEmpleado {

  public static void main(String[] args) {
   ArrayList<Empleado> x=new ArrayList<Empleado>();
   int a=0,ci;
   String nom,car;
   while(a!=3){
     a=Integer.parseInt(JOptionPane.showInputDialog(Menu()));
     switch(a){
     case 1:
      a=Integer.parseInt(JOptionPane.showInputDialog(Menu2()));
       switch(a){
       case 1:
        ci=Integer.parseInt(JOptionPane.showInputDialog("Ci"));
        nom=JOptionPane.showInputDialog("nombre");
        car=JOptionPane.showInputDialog("cargo");
        double sa=Double.parseDouble(JOptionPane.showInputDialog("Salario basico"));
        int di=Integer.parseInt(JOptionPane.showInputDialog("Dias trabajados"));
                 x.add(new Permanente(ci,nom,car,sa,di));
        break;
       case 2:
        ci=Integer.parseInt(JOptionPane.showInputDialog("Ci"));
        nom=JOptionPane.showInputDialog("nombre");
        car=JOptionPane.showInputDialog("cargo");
        int ht=Integer.parseInt(JOptionPane.showInputDialog("horas trabajadas"));
        int ph=Integer.parseInt(JOptionPane.showInputDialog("Pago por hora"));
        x.add(new Eventual(ci,nom,car,ht,ph));
        break;
       }
      a=0;
      break;
     case 2:
       String cad="";
       for(int i=0;i<x.size();i++){
       cad+=x.get(i);
      }
       
       JTextArea out=new JTextArea(10,50);
       out.setText(cad);
       JScrollPane barra=new JScrollPane(out);
       JOptionPane.showMessageDialog(null,barra);
       break;
     case 3:
      JOptionPane.showMessageDialog(null,"Fin del Programa");
      break;
         
     }
   }

  }
 private static String Menu() {
   return "**Opciones**\n1.Agregar\n2.Mostrar\n3.Salir";
  }
 private static String Menu2() {
  return "**Agregar**\n1.Permanente\n2.Eventual\n3.atras";
 }
 }

