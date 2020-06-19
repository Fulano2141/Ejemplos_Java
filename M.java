import javax.swing.*;

public class M
{
  public static void main (String[] args)
  {
    int n=Integer.parseInt(JOptionPane.showInputDialog("orden de n "));
    int c=Integer.parseInt(JOptionPane.showInputDialog("orden de c "));
    int m [][]= new int [n][c];
    String res="";
    int x=0,k=0,o=0;
    for (int i=0;i<m.length;i++)
    {res+="\n";
      for (int j=0;j<m[i].length;j++){
     m[i][j]=(int)(Math.random()*40+1); 
       res=res+m[i][j]+" ";
       if (x<m[i][j])
         x=m[i][j];
       k=i;
       o=j ; 
      }
    }
    JOptionPane.showMessageDialog(null,x);
    JOptionPane.showMessageDialog(null,"la pocosion es "+(k)+" "+(o));
    JTextArea jt = new JTextArea(10,10);
    JScrollPane sp = new JScrollPane(jt);
    jt.setText(res);
    JOptionPane.showMessageDialog(null,res);
  }
}