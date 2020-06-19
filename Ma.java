/* Generar una matriz n*n ocn numeros entre 100 999 determinar los numeros capicua.
 * 
 * 
 */
import javax.swing.*;
public class Ma
{
  public static void main (String[] args)
  {
    int n=Integer.parseInt(JOptionPane.showInputDialog("orden de la matriz "));
    int MAT[][]= new int [n][n];
    String res="";
    for (int i=0;i<n;i++)
    {res+="\n";
      for (int j=0;j<n;j++){
        if (i==j)
       MAT[i][j]=1;
       else
         MAT[i][j]=0;
       if (i+j%2==0)
       MAT[i][j]=1;
      res=res+MAT[i][j]+" ";
      }
    }
    JTextArea jt = new JTextArea(10,10);
    JScrollPane sp = new JScrollPane(jt);
    jt.setText(res);
    JOptionPane.showMessageDialog(null,res);
  }
}