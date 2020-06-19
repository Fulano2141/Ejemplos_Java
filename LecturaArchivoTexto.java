import java.io.*;
public class LecturaArchivoTexto
{
  public static void main(String[]x) //throws IOException
  {
    BufferedReader in=new BufferedReader(new FileReader("prueba.txt"));
    String cad="";
    while (in.ready())
    { cad=in.readLine();
      System.out.println(cad);
   }
    in.close();
}
}