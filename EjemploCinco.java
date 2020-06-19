 /*3.- Generar para un orden n la matriz:

                    1  2  3  4  5
                    1  2  3  4  0
                    1  2  3  0  0
                    1  2  0  0  0
                    1  0  0  0  0

4.- Generar una matriz de orden n*m con numeros al azar
    y determinar cual es el mayor valor y cual su posicion (muestre la matriz)

5.- Generar una matriz n * m de numeros aleatorios y despues almacenar en otra matriz 
la transpuesta de la primera 
matriz (mostrar ambas matrices)
*/   
import javax.swing.*;
public class EjemploCinco
{
  public static void main(String[] x)
  {
    int n=Integer.parseInt(JOptionPane.showInputDialog("Filas de la matriz:"));
    int m=Integer.parseInt(JOptionPane.showInputDialog("Columnas de la matriz:"));
    int a[][]=new int[n][m];
    int b[][]=new int[m][n];
    String res="";
    for (int f=0;f<a.length;f++)
    { res+="\n";   
      for (int c=0;c<a[f].length;c++)
      {
         a[f][c]=(int)(Math.random()*99+1);
         res+=a[f][c]+" ";  
      }
    }
    
    for (int f=0;f<a.length;f++)
    { 
      for (int c=0;c<a[f].length;c++)
      {
         b[c][f]=a[f][c];
                  
      }
    }
    res+="\n";
    for (int f=0;f<b.length;f++)
    { res+="\n";   
      for (int c=0;c<b[f].length;c++)
      {
         res+=b[f][c]+" ";  
                  
      }
    }
    JTextArea jt=new JTextArea(10,10);
    JScrollPane sp = new JScrollPane(jt);
    jt.setText(res);
    JOptionPane.showMessageDialog(null,sp);
  }
}
