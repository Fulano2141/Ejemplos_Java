/* 4.- obtener la suma de :
 * 1 + 4 + 9 + 16 + 25.....n +*/
import java.util.*; 
import javax.swing.*;
public class EJemplo5 {
  static Scanner in=new Scanner (System.in);
  public static void main(String[] Fulano)
  {
    System.out.println("Ingrese el numero");
    int num=in.nextInt();
    int resul=pi(num);
    System.out.println("El resultado es: "+pi(num));
  }
  public static int pi(int num)
  { 
    int xd=0, con1=0;
    for (int con=1;con<=num;con++)
    {
      xd=con*con;
      con1=con1+xd;
    } 
    return con1;
  }
} 