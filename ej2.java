/* Generar 
 *  1 0 1
 *  0 1 0
 *  1 0 1
 * Para n terminos */
import java.util.*;
import javax.swing.*;
class ej2 {
  static Scanner sc=new Scanner(System.in);
  public static void main(String Fulano[]){
      String res="";
      int n=Integer.parseInt(JOptionPane.showInputDialog("Orden de la matriz"));
      int[][] A = new int[n][n];
      for(int i=0;i<n;i++)
      {
        res+="\n";
        for (int j=0;j<A.length;j++)
        {
          if ((i+j)%2==0 )
            A[i][j]=1;
          else 
            A[i][j]=0;
          res+=A[i][j];
        }
      }
      JTextArea xy=new JTextArea(30,30);
      JScrollPane sp=new JScrollPane(xy);
      xy.setText(res);
      JOptionPane.showMessageDialog(null,sp);
      
  }
}