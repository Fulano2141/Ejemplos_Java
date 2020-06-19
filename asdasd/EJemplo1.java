import java.util.*;
import javax.swing.*;
public class EJemplo1 {
  static Scanner in=new Scanner (System.in);
  public static void main(String[] asd)
  {
    System.out.println("Ingrese el numero");
    int num = in.nextInt();
    boolean respuesta=capicua(num);
    if (respuesta==true)
      System.out.println("Es capicua");
    else 
      System.out.println("No es capicua");
  }
  public static boolean capicua(int num)
  {
    int aux=num;
    int mod;
    int res=0;
    while(aux>0)
    {
      mod=aux%10;
      res=(res*10)+mod;
      aux=aux/10;
    }
    if (num==aux)
      return true;
    else 
      return false;
  }
}