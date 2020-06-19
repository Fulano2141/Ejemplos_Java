/* Una matriz contiene las ventas semestrales de una empresa importadora de vehiculos
 * la empresa importa 6 marcas de vehiculos. En base a estos datos determinar:
 * 
 * - El total de ventas en todo el semestre de todas las marcas *
 * - El total de ventas por tipo de marca *
 * - El vehiculo que mas se vendio en el mes de marzo *
 * - El vehiculo que menos se vendio en junio *
 * - El mes que se vendio mas
 */
import javax.swing.*;
import java.util.*;
public class Ejm2
{
  public static void main (String[] args){
 //   int n=Integer.parseInt(JOptionPane.showInputDialog("orden de la matriz "));
    int MAT[][]= new int [6][7];
    String res="";
    int sum=0;
    for (int i=0;i<6;i++){
      res+="\n";
      sum=0;
      for (int j=0;j<7;j++){
        MAT[i][j]=(int)(Math.random()*7);
        if(j<6)
        sum=sum+MAT[i][j];
        MAT[i][6]=sum;
        res=res+MAT[i][j]+"  ";
      }
    }int tot=0;
    for (int i=0;i<6;i++){
      tot=MAT[i][6]+tot;
    }
    JTextArea jt = new JTextArea(10,10);
    JScrollPane sp = new JScrollPane(jt);
    jt.setText(res);
    JOptionPane.showMessageDialog(null,res);
    JOptionPane.showMessageDialog(null,"El total en todo el semestre es "+tot);   
    JOptionPane.showMessageDialog(null,"El mas vendido en marzo es el vehiculo "+vendimas(MAT));
    JOptionPane.showMessageDialog(null,"El menos vendido en junio es "+vendimenos(MAT));
    JOptionPane.showMessageDialog(null,"El mes que mas se vendio es "+mesmas(MAT));  
  }
  public static int vendimas(int MAT[][]){
    int mayor=0,aux=0;
    for (int i=0;i<6;i++){
      if(MAT[i][2]>mayor)
      {mayor=MAT[i][2];
      aux=i;}
        
    }
    return aux+1;
  }
 public static int vendimenos(int MAT[][]){
   int menor=10,aux=0;
    for (int i=0;i<6;i++){
      if(MAT[i][6]<menor)
      {menor=MAT[i][6];
      aux=i;}
    }
    return aux+1;
 }
 public static int mesmas(int MAT[][]){
  int mayor=0,aux=0,Sum1=0,Sum2=0,Sum3=0,Sum4=0,Sum5=0,Sum6=0;
    for (int i=0;i<6;i++){
      Sum1=Sum1+MAT[i][0];   
    }
    for (int i=0;i<6;i++){
      Sum2=Sum2+MAT[i][0];    
    }
    for (int i=0;i<6;i++){
      Sum3=Sum3+MAT[i][0];  
    }
    for (int i=0;i<6;i++){
      Sum4=Sum4+MAT[i][0]; 
    }
    for (int i=0;i<6;i++){
      Sum5=Sum5+MAT[i][0];
    }
    for (int i=0;i<6;i++){
      Sum6=Sum6+MAT[i][0];
    }
    int TOTMES[]= {Sum1,Sum2,Sum3,Sum4,Sum5,Sum6};
    for(int i=0;i<6;i++){
      if(TOTMES[i]>mayor){
        mayor=TOTMES[i];aux=i;}
    }
    return aux+1; 
  }}