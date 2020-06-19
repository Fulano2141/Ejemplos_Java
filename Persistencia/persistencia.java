import java.io.IOException;
import java.io.PrintWriter;

public class persistencia {
  public static void main(String[] args) {
    String _nombreDelArchivo = "ArchivoDeTexto.txt";
    try (PrintWriter out = new PrintWriter(_nombreDelArchivo)) {
      out.println("Hola Felano");
    } catch (IOException e1) {
      e1.printStackTrace();
    }
  }
}