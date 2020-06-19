import java.io.*;
import java.util.*;
public class EscrituraArchivoTexto
{
  public static void main(String[]x) throws IOException
  {
    PrintWriter out=new PrintWriter(new FileWriter("prueba.txt",true));
    int n;
    Scanner in=new Scanner(System.in);
    System.out.println("Cuantos nombres:");
    n=in.nextInt();
    String cad="";
    for (int i=0;i<n;i++){
         System.out.println("nombre:");
         cad=in.next();
         out.println(cad);
   }
    out.close();
}
}