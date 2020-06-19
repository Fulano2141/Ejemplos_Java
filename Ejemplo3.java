import java.util.*;
import javax.swing.*;
class Ejemplo3
{
  public static void main (String[]args)
  {
   int n1,n2,n3;
   Scanner in = new Scanner (System.in);
   JOptionPane.showMessageDialog(null,"EL primer numero ");
   n1=in.nextInt();
    System.out.println("segundo numero");
   n2=in.nextInt();
   n3=n1+n2;
     JOptionPane.showMessageDialog(null,"respuesta es "+n3);
  }
}
