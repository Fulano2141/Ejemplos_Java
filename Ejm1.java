/* Generar una matriz n*n ocn numeros entre 100 999 determinar los numeros capicua.
 * 
 * 
 */
import javax.swing.*;
import java.util.*;
public class Ejm1
{
  public static void main (String[] args){
    int n=Integer.parseInt(JOptionPane.showInputDialog("orden de la matriz "));
    int MAT[][]= new int [n][n];
    String res="";
    for (int i=0;i<n;i++)
    {res+="\n";
      for (int j=0;j<n;j++){
        MAT[i][j]=100+(int)(Math.random()*899+1);
        res=res+MAT[i][j]+" ";
      }
    }int c=0;
    for (int i=0;i<n;i++){
      for (int j=0;j<n;j++){
        if(Capicua(MAT[i][j]))
          c++;
      }
    }
    JTextArea jt = new JTextArea(10,10);
    JScrollPane sp = new JScrollPane(jt);
    jt.setText(res);
    JOptionPane.showMessageDialog(null,res);
    JOptionPane.showMessageDialog(null,"En la matriz hay "+c+" numeros capicua");    
  }
  public static boolean Capicua(int n){
    int aux=n, sum=0,resto ;
    while(n!=0){
      resto=(n%10);
      sum=sum*10+resto;
      n=n/10;
    }
    if(sum==aux)
      return true;
    else
      return false;
  }
}