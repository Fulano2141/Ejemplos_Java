/* 4- Generar una matriz n* n con numeros al azar
 * Para n terminos */
import java.util.*;
import javax.swing.*;
class ej4 {
  static Scanner sc=new Scanner(System.in);
  public static void main(String Fulano[]){
      String res=" ";
      int n=Integer.parseInt(JOptionPane.showInputDialog("Orden de la matriz"));
      int m=Integer.parseInt(JOptionPane.showInputDialog("Orden de la matriz"));
      int[][] A = new int[n][m];
      for (int i=0;i<A.length;i++){
        res+="\n";
        for (int j=0;j<A[1].length;j++){
          A[i][j] = (int)(Math.random()*9);
          res+=A[i][j]+" ";
      }
      }
      JTextArea xy=new JTextArea(10,10);
      JScrollPane sp=new JScrollPane(xy);
      xy.setText(res);
      JOptionPane.showMessageDialog(null,sp);
      int may,fm=0,cm=0;
      may=A[0][0];
      for (int i=0;i<A.length;i++) {  
        for (int j=0;j<A[i].length;j++){
          if (A[i][j]>may){
            may=A[i][j];
            fm=i;
            cm=j;
          }
        }           
      }
      JOptionPane.showMessageDialog(null,"El mayor es "+A[fm][cm]+" Posicion "+fm+","+cm);
      /*      for(int i=0;i<n;i++)
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
*/      }
  }
