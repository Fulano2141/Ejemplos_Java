//3.- Un archivo contiene los salarios de un grupo de empleados
//    determinar el porcentaje de salarios que estan por debajo
//    del promedio. Crear funciones para :

//    - Escribir el archivo
//    - Leer el archivo
//    - Calcular el porcentaje

//package ArchivosTexto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;

public class Ejemplo3 {

  public static void main(String[] args) throws Exception{
   for(;true;)
   {
    String [] menu1= {"Adicion","Porcentaje","Reporte","Salir"};
    String valor1=(String) JOptionPane.showInputDialog(null,"Seleccione la opcion","Opciones",JOptionPane.DEFAULT_OPTION,null,menu1,menu1[0]);
    switch(valor1)
    {
    case "Adicion": adicion();break;
    case "Porcentaje": porcentaje();break;
    case "Reporte": reporte();break;
    case "Salir": System.exit(0);break;
    }
   }

  }
  public static void adicion() throws IOException
  {
   try{PrintWriter out=new PrintWriter(new FileWriter("salarios.txt",true));
   int n=Integer.parseInt(JOptionPane.showInputDialog(null,"Cuantos salarios:"));
   for(int i=0;i<n;i++)
   {
    String nom=JOptionPane.showInputDialog(null,"Salario:");
    out.println(nom);
   }
   out.close();}
   catch (IOException e) 
   {
    JOptionPane.showMessageDialog(null,"Dato Invalido");
   }
  }
  public static void porcentaje() throws IOException
  {
   try{BufferedReader in=new BufferedReader(new FileReader("salarios.txt"));
   String aux="",ax="";
   int x=0,i=0,n=0,p,m=0,y=0;
   while(in.ready())
   {
    aux=in.readLine();
    x=Integer.parseInt(aux);
    i+=x;
    n++;
   }
   p=i/n;
   in.close();
   BufferedReader out=new BufferedReader(new FileReader("salarios.txt"));
   while(out.ready())
   {
    ax=out.readLine();
    y=Integer.parseInt(ax);
    if(y<p)
     m++;
   }
   double pp=(m*100.0)/n;
   pp=Math.rint(pp*10)/10;
   JOptionPane.showMessageDialog(null,"El porcentaje de salarios por debajo de la media : "+pp);
   out.close();
   }
   catch (IOException e) 
   {
    JOptionPane.showMessageDialog(null,"Error IO");
   }
  }
  public static void reporte() throws Exception
  {
   try{BufferedReader in=new BufferedReader(new FileReader("salarios.txt"));
   String aux="",cad="";
   while(in.ready())
   {
    aux=in.readLine();
    cad+=aux+"\n";
    
   }
   in.close();
   JTextArea area=new JTextArea();
   area.setText(cad);
   JOptionPane.showMessageDialog(null,area);
   }
   catch (IOException e) 
   {
    JOptionPane.showMessageDialog(null,"No existe Archivo");
   }
  }

 }

