/*8.- Se tiene el arreglo
 * Ventas:
 * 0      1    2  . . .  10   11
 * vene vfeb vmar . . . vnov vdic
 * Donde se almacenan  las ventas mensuales de una empresa y un arreglo constante que contiene los nombres de los meses:
 * Meses:
 *   0     1     2   . . .  10    11
 * “Ene” “Feb” “Mar” . . . “Nov” “Dic”
 * Escriba un programa que obtenga:
 * a) ¿En qué mes se dieron las ventas máximas de la empresa?
 * b)  ¿A cuánto ascendieron las ventas máximas?
 * c) ¿Cuál fue el total de las ventas?*/
import java.util.*;
class Problema08{
  static Scanner in=new Scanner (System.in);
  public static void main(String[] Fulano){ 
    int s=0,m=0,k=0; 
    String meses[]={"Ene","Feb","Mar","Abr","May","Jun","Jul","Ago","Sep","Oct","Nov","Dic"};
    int ventas[]=new int[12];
    for(int i=0;i<ventas.length;i++){
      System.out.printf("las ventas en "+meses[i]+";");
      ventas[i]=in.nextInt();
    }  
    for(int j=0;j<meses.length;j++){
        System.out.print(meses[j]+" "+ventas[j]+"\n");
      }
    for(int l=0;l<ventas.length;l++){
          s=s+ventas[l];
      if(ventas[l]>m)
     {m=ventas[l];
        k=l;
      }
    }
        System.out.println("el mes en donde vendieron mas fue  "+meses[k]+"  con "+ventas[k]+"\n") ;
        System.out.println("el total de las ventas es  "+s+"\n")  ;
  }
}