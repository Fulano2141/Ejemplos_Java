import javax.swing.*;

public class Matr
{
  public static void main (String[] args)
  {
    int n=Integer.parseInt(JOptionPane.showInputDialog("orden de la matriz "));
    int m [][]= new int [n][n];
    String res="";
    for (int i=0;i<n;i++)
    {res+="\n";
      for (int j=0;j<n;j++){
        if (i==j)
       m[i][j]=1;
       else
       m[i][j]=0;
       if (i+j==n-1)
       m[i][j]=1;
       
       res=res+m[i][j]+" ";
      }
    }
    JTextArea jt = new JTextArea(10,10);
    JScrollPane sp = new JScrollPane(jt);
    jt.setText(res);
    JOptionPane.showMessageDialog(null,res);
  }
}