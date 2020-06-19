/* 3.- obtener el valor de la serie 
 * 4/1 - 4/3 + 4/5 - 4/7 + 4/9... */
import java.util.*; 
import javax.swing.*;
public class EJemplo4 {
  static Scanner in=new Scanner (System.in);
  public static void main(String[] Fulano)
  {
    System.out.println("Ingrese el numero");
    int num=in.nextInt();
    double resul=pi(num);
    System.out.println("El resultado es: "+pi(num));
  }
  public static double pi(int num)
  { 
    double xd=0, con1=1;
    for (int con=1;con<=num;con+=2)
    {
      con1++;
      if (con1%2==0)
        xd=xd+4.0/con;
      else 
        xd=xd-4.0/con;
    } 
    return xd;
  }
} 