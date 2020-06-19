import java.util.*;
import javax.swing.*;
public class EJemplo2 {
  static Scanner in=new Scanner (System.in);
  public static void main(String[] Fulano)
  {
    System.out.println("Ingrese el numero");
    int num=in.nextInt();
    System.out.println("El resultado es: "+divisores(num));
  }
  public static int divisores(int num)
  {
    int xd=0;
    for (int con=1;con<=num;con++)
    {
      if (num%con==0)
        xd=xd+con;
    }    
    return xd;
  }
}