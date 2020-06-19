/* 1.- Dado un arreglo que contiene las ventas mensuales
de varios productos de un supermercado en un semestre,determinar:
           - El mes en el que se produjo la venta menor
           - El mes en el que se produjo la venta mayor
           - El total de ventas de todos los productos
El programa debe contener dos arreglos constantes:
            - valores de las ventas
            - meses de las ventas
*/            
import javax.swing.*;
public class Ventas{
      public static void main(String[] x){
        double[] venta={12000,23500.5,3834,847545,37734,4458745};
        String[] mes={"ENE","FEB","MAR","ABR","MAY","JUN"};
        int n=6;
        String nm1=ventamenor(venta,mes,n);
        JOptionPane.showMessageDialog(null,"Se vendio menos en:"+nm1);
        String nm2=ventamayor(venta,mes,n);
        JOptionPane.showMessageDialog(null,"Se vendio mas en:"+nm2);
        double total=totalventas(venta,n);
        JOptionPane.showMessageDialog(null,"El total de ventas es:"+total);
      }
      public static String ventamenor(double venta[],String mes[],int n)
      {
       double min=venta[0];int pos=0;
       for (int i=1;i<n;i++)
       {
         if (min>venta[i])
         {    min=venta[i];
              pos=i;
         }  
        }
       return mes[pos];
      }
      public static String ventamayor(double venta[],String mes[],int n){
        double max=venta[0];int pos=0;
       for (int i=1;i<n;i++){
         if (max<venta[i]){
              max=venta[i];
              pos=i;
         }  
              }
         return mes[pos];
      }    
      public static double totalventas(double venta[],int n)
      { double suma=0;
        for (int i=0;i<n;i++){
         suma+=venta[i];
           }  
        return suma;
      } 
}    
        
                
  