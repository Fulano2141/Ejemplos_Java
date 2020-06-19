/* 3- Generar 
 *  1 2 3 4 5
 *  1 2 3 4 0
 *  1 2 3 0 0
 *  1 2 0 0 0
 *  1 0 0 0 0
 * Para n terminos */
import java.util.*;
import javax.swing.*;
class ej3 {
  static Scanner sc=new Scanner(System.in);
  public static void main(String Fulano[]){
      String res="";
      int n=Integer.parseInt(JOptionPane.showInputDialog("Orden de la matriz"));
      int[][] A = new int[n][n];
      for(int i=0;i<n;i++)
      {
        res+="\n";
        int c=0;
        for (int j=0;j<A.length;j++)
        {
          c++;
          if ((i+j)<=n-1)
            A[i][j]=c;
          else 
            A[i][j]=0;
          res+=A[i][j];
        }
      }
      JTextArea xy=new JTextArea(10,10);
      JScrollPane sp=new JScrollPane(xy);
      xy.setText(res);
      JOptionPane.showMessageDialog(null,sp);
      
  }
}