// 2. 
import javax.swing.*;
public class Caso_2
{ 
  static String res="";
  static String meses[]={"ENE","FEB","MAR","ABR","MAY","JUN"};
  static String marcas[]={"TOYOTA","NISSAN","SUBARU","MAZDA0","SUZUKI","MITSUB"};
  static int a[][] =new int[6][6];
  static int marca[]=new int[6];
  
  public static void main (String[] x)
  {    
    generamatriz(); 
    imprimematriz();
    
    
  }  
    public static void generamatriz()
    {
     for(int f=0;f<a.length;f++)
     { 
      for(int c=0;c<a.length;c++)
      {
        a[f][c]=(int)(Math.random()*8999+1000);
      }
     }
    }
   public static void imprimematriz()
   { res+="                   ";
    for (int i=0;i<6;i++)
    { res+=meses[i]+"   ";}  
    for(int f=0;f<a.length;f++)
     { res+="\n";
       res+=marcas[f]+"    ";  
      for(int c=0;c<a.length;c++)
      {
        res+=a[f][c]+"  ";
      }
     }  
      totalventas();
      totalventasmarcas();
      int t=mayormarzo();
      String m=marcas[t];
      res+="\nEn marzo se vendio mas la marca: "+m;
      JTextArea jt=new JTextArea();
      jt.setText(res);
      JOptionPane.showMessageDialog(null,res);
   
 }
 public static void totalventas()
 {
   int suma=0;
    for(int f=0;f<a.length;f++)
    {
       for(int c=0;c<a.length;c++)
       {
        suma=suma+a[f][c];                             
       }
    }
    res=res+"\nTOTAL DE VENTAS: "+suma;
 }
 public static void totalventasmarcas()
 {
    res+="\nTOTAL DE VENTAS POR MARCAS:";
    for(int f=0;f<a.length;f++)
    {  int suma=0;
       res+="\n";
       for(int c=0;c<a.length;c++)
       {
        suma=suma+a[f][c];                             
       }
       marca[f]=suma;
       res=res+marcas[f]+" = "+marca[f]+" ";
 }
 }
 public static int mayormarzo()
 {  
      int aux=a[0][2],pos=0;
      for(int f=0;f<a.length;f++)
      { 
        if (aux<a[f][2])
        {
          aux=a[f][2];
          pos=f;
        }
     }
      return pos;
 }
}
 