 /*2.- Dado un arreglo que contiene valores al azar entre 1 y 9999
 efectuar la busqueda secuencial de algun elemento (debe ser unica),
 para que el programa informe el lugar en el que se encuentre
   */          
import javax.swing.*;
public class search{
      public static void main(String[] x){
        String nn=JOptionPane.showInputDialog("Tamaño del arreglo:");
        int n=Integer.parseInt(nn);
        int[] azar=new int[n];
        // Esta funcion carga datos al vector
        llenarvector(azar,n);
        // Esta funcion muestra los datos del vector
        vaciarvector(azar,n);
        int elem=Integer.parseInt(JOptionPane.showInputDialog("Valor a buscar:"));
        int pos=busqueda(azar,n,elem);
        if (pos<0)
          JOptionPane.showMessageDialog(null,"El valor no se encuentra en el vector");
        else
          JOptionPane.showMessageDialog(null,"El valor se encuentra en "+(pos+1));
      }
      public static void llenarvector(int azar[],int n)
      {
        for (int i=0;i<n;i++){
         azar[i]=(int)(Math.random()*99999+1);
        }
       }
      public static void vaciarvector(int azar[],int n)
      {
        for (int i=0;i<n;i++){
         System.out.print(azar[i]+",");
       }
      }
      public static int busqueda(int azar[],int n, int elem){
       int posi=-1;
       for (int i=0;i<n;i++){
         if (elem==azar[i])
         {  
             posi=i;break;
         }  
       }
        return posi; 
                }
      
}    
        
                
  