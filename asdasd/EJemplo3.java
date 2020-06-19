/* Determinar si un numero entero mayor a 0 es o no primo */ 
import java.util.*;
import javax.swing.*;
public class EJemplo3 {
  static Scanner in=new Scanner (System.in);
  public static void main(String[] Fulano)
  {
    System.out.println("Ingrese el numero");
    int num=in.nextInt();
//    boolean resul=primo(num);
    if (primo(num))
      System.out.println("Es primo");
    else
      System.out.println("No es primo");
  }
  public static boolean primo(int num)
  { 
    int xd=0;
    for (int con=1;con<=num;con++)
    {
      if (num%con==0)
        xd=xd+con;
    }  
    int sd=num+1;
    if (sd==xd)
      return true;
    else 
      return false;
  }
}