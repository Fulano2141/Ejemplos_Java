// 3. Crear un programa que permita :
//                 - Adicionar
//                 - Buscar
//                 - Generar un reporte
//                 - Eliminar
// datos de un archivo de texto que contiene:
//                    - Cedula
//                    - Nombre
   
import java.io.*;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.*;
public class Archivo3 {
   public static void main(String args[]) throws IOException
   {
    for(;;){
     String [] menu = {"Adicionar","Busqueda","Reporte","Eliminar","Salir"};
           String valor = (String) JOptionPane.showInputDialog(null, "Seleccione la opcion:","Opciones",JOptionPane.DEFAULT_OPTION,null,menu,menu[0]);
           switch(valor){
           case "Adicionar":{
            adicion();
               break;
           }
           case "Busqueda": {
            buscar();
               break;
           }
           case "Reporte": { reporte(); break;}
           case "Eliminar": { eliminar(); break;}
           case "Salir": {System.exit(0); break;}  
     }
   }
  }
   public static void adicion() throws IOException{
    try{
       FileWriter fichero=null;
       PrintWriter pw=null;
       fichero= new FileWriter("prueba1.txt",true);
       pw= new PrintWriter(fichero);
       String cad1=JOptionPane.showInputDialog(null,"Cuantos datos desea adicionar:");
       int n=Integer.parseInt(cad1);
       for(int i=0;i<n;i++){
           cad1=JOptionPane.showInputDialog(null,"Ingrese el CI:");
           int ci=Integer.parseInt(cad1);
           String nom=JOptionPane.showInputDialog(null,"Ingrese el nombre:");
           cad1=JOptionPane.showInputDialog(null,"Ingrese el salario:");
           double sal=Double.parseDouble(cad1);
           String fe=JOptionPane.showInputDialog(null,"Ingrese la fecha de ingreso:");
           String aux=ci+";"+nom+";"+sal+";"+fe;
           pw.println(aux);}
       fichero.close();}
    catch(Exception ev){
     JOptionPane.showMessageDialog(null, "Hubo un error al abrir el archivo.");
    }
   }
   public static void buscar() throws IOException{
    try{
    String cad1=JOptionPane.showInputDialog(null,"Ingrese el CI a buscar:");
       int ci=Integer.parseInt(cad1);
       File f=new File("prueba1.txt");
       BufferedReader entrada=new BufferedReader(new FileReader(f));
       String linea="";
       String aux="";
       boolean v=false;
       while(entrada.ready())
       {
           linea=entrada.readLine();
        String au[] = linea.split(";");
        int ci2=Integer.parseInt(au[0]);
        if(ci==ci2){
         aux="CI: "+au[0]+"\nNombre: "+au[1]+"\nSalario: "+au[2]+"\nFecha de ingreso: "+au[3];
         v=true;break;
        }
       }
       if(v==true){
       JTextArea ar=new JTextArea(10,20);
       ar.setText(aux);
       JScrollPane sc=new JScrollPane(ar,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
       JOptionPane.showMessageDialog(null, sc);}
       else
        JOptionPane.showMessageDialog(null,"El CI no esta en el archivo.");
       entrada.close();}
    catch(Exception ev){
     JOptionPane.showMessageDialog(null, "Hubo un error al abrir el archivo.");
    }
   }
   public static void reporte() throws IOException{
    try{
       File f=new File("prueba1.txt");
       BufferedReader entrada=new BufferedReader(new FileReader(f));
       String linea="";
       double sum=0.0;
       NumberFormat nf=NumberFormat.getCurrencyInstance(Locale.US);
       String aux="CEDULA\tNOMBRE\tSALARIO\n-----------------------------------------------------------\n";
       while(entrada.ready())
       {
           linea=entrada.readLine();
        String au[] = linea.split(";");
        double sal=Double.parseDouble(au[2]);
        aux+=au[0]+"\t"+au[1]+"\t"+nf.format(sal)+"\n";
        sum+=Double.parseDouble(au[2]);
       }
       aux+="-----------------------------------------------------------\nTotal:\t\t"+nf.format(sum);
       JTextArea ar=new JTextArea(10,20);
       ar.setText(aux);
       JScrollPane sc=new JScrollPane(ar,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
       JOptionPane.showMessageDialog(null, sc);
       entrada.close();}
    catch(Exception ev){
     JOptionPane.showMessageDialog(null, "Hubo un error al abrir el archivo.");
    }
   }
   public static void eliminar() throws IOException{
    try{
    String cad1=JOptionPane.showInputDialog(null,"Ingrese el CI a eliminar:");
       int ci=Integer.parseInt(cad1);
       File f=new File("prueba1.txt");
       BufferedReader entrada=new BufferedReader(new FileReader(f));
       FileWriter fichero=null;
       PrintWriter pw=null;
       fichero= new FileWriter("prueba2.txt");
       pw= new PrintWriter(fichero);
       String linea="";
       boolean v=false;
       while(entrada.ready())
       {
           linea=entrada.readLine();
        String au[] = linea.split(";");
        int ci2=Integer.parseInt(au[0]);
        if(ci!=ci2){
         pw.println(linea);v=true;
        }
       }
       if(v==false)
        JOptionPane.showMessageDialog(null,"La persona no esta en el archivo.");
       else
        JOptionPane.showMessageDialog(null,"Persona eliminada.");
       entrada.close();
       fichero.close();
       File B=new File("prueba2.txt");
       File A=new File("Prueba1.txt");
       A.delete();
       B.renameTo(A);}
    catch(Exception ev){
     JOptionPane.showMessageDialog(null, "Hubo un error al abrir el archivo.");
    }
   }
   }