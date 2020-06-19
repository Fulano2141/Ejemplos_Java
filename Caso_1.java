// 1. 
import javax.swing.*;
public class Caso_1
{
  public static void main (String[] x)
  {
    int c=0;
    int n=Integer.parseInt(JOptionPane.showInputDialog("tamaño de matriz"));
    int a[][] =new int[n][n];
    
    String res="";
    
    for(int f=0;f<a.length;f++)
    {
       res+="\n";

    for(c=0;c<a.length;c++)
     {
        a[f][c]=(int)(Math.random()*199+100);
        res+=a[f][c]+" ";
                        
    }
   }
   JTextArea jt=new JTextArea();
      jt.setText(res);
      JOptionPane.showMessageDialog(null,res);
      
   
   int cc=0;
   for(int f=0;f<a.length;f++)
    {    
        for(c=0;c<a.length;c++)
        { int sum=0;
          int aux=a[f][c];
          while (aux>0)
          {
            sum=sum*10+aux%10;
            aux=aux/10;            
         }
         System.out.println(sum);      
         if (sum==a[f][c])
             cc++;   
           
   }
   }
   System.out.println("Capicuas="+cc);     
 }
}
 