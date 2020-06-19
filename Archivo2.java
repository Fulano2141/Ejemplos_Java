/* Escribir un programa que añada a un archivo de texto 
 * las edades de un grupo de personas y copie a un 2do archivo
 * las edades que esten por encima del promedio
 */ 
 
import java.io.*;
import javax.swing.*;
public class Archivo2 {
 public static void main(String args[]) throws IOException
 {
      crear();
      copiar();
      leer();
 }
 public static void crear() throws IOException{
  FileWriter fichero=null;
  PrintWriter pw=null;
  fichero= new FileWriter("prueba1.txt");
  pw= new PrintWriter(fichero);
  String cad1=JOptionPane.showInputDialog(null,"Cuantas edades desea agregar:");
  int n=Integer.parseInt(cad1);
  for(int i=0;i<n;i++){
   cad1=JOptionPane.showInputDialog(null,"Ingrese la edad:");
   int edad=Integer.parseInt(cad1);
   pw.println(edad);}
  fichero.close();
 }
 public static void leer() throws IOException{
  File f=new File("prueba1.txt");
  BufferedReader entrada=new BufferedReader(new FileReader(f));
  String linea="";
  while(entrada.ready())
  {
   linea+=entrada.readLine()+"\n";
  }
  JTextArea ar=new JTextArea(10,20);
        ar.setText(linea.toString());
        JScrollPane sc=new JScrollPane(ar,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        JOptionPane.showMessageDialog(null, sc);
  entrada.close();
 }
 public static int promedio() throws IOException{
  File f=new File("prueba1.txt");
  BufferedReader entrada=new BufferedReader(new FileReader(f));
  String linea;
  int su=0,cont=0,aux; 
  while(entrada.ready())
  {
   linea=entrada.readLine();
   aux=Integer.parseInt(linea);
   su+=aux;
   cont++;
  }
  entrada.close();
 return su/cont;
 }
 public static void copiar() throws IOException{
  int prom=promedio();
  FileWriter fichero=null;
  PrintWriter pw=null;
  fichero= new FileWriter("copia.txt");
  pw= new PrintWriter(fichero);
  File f=new File("prueba1.txt");
  BufferedReader entrada=new BufferedReader(new FileReader(f));
  String linea;
  while(entrada.ready()){
   linea=entrada.readLine();
   int aux=Integer.parseInt(linea);
   if(aux>prom)
    pw.println(linea);
   }
  entrada.close();
  fichero.close();
  }
 }
