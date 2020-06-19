/* 4- Generar una matriz n* n con numeros al azar
 * Para n terminos */
import java.util.*;
import javax.swing.*;
class ej5 {
  static Scanner sc=new Scanner(System.in);
  public static void main(String Fulano[]){
      String res=" ",es=" ";
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
      res+="\n";
      res+="\n";
      
     for(int j=0;j<A[0].length;j++){
       res+="\n";
       for(int i = 0; i < A.length; i++){
         res+=A[i][j]+" ";
       }
     }
     
     JTextArea xy=new JTextArea(20,20);
      JScrollPane sp=new JScrollPane(xy);
      xy.setText(res);
      JOptionPane.showMessageDialog(null,sp);
    
      }
  }