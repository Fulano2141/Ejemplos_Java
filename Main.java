// EJEMPLO 1: ARCHIVOS BINARIOS
import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;

public class Main {
 public static void main(String[] args) throws IOException {
  for(;true;){
   String [] menu = {"Adicion","Reporte","Vencimiento","Salir"};
   String valor = (String) JOptionPane.showInputDialog(null, "Seleccione la opcion","Opciones",JOptionPane.DEFAULT_OPTION,null,menu,menu[0]);
   switch(valor){
   case "Adicion": adicionar(); break;
   case "Reporte": reporte(); break;
   case "Vencimiento": vencimiento(); break;
   case "Salir": System.exit(0); break;
   }
  } 
 }

 public static void adicionar() throws IOException {
  try {
   DataOutputStream fs = new DataOutputStream(new FileOutputStream("Productos.dat",true));
   int x;
   int cod=0,st;
   String nom,fec;
   double pr;
   x=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de productos:"));
   for(int i=0; i<x; i++){
    while(cod==0){
     try {
      cod=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el codigo: "));
     } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, "Ingrese numeros");
     }
    }
    nom=JOptionPane.showInputDialog(null,"Ingrese el nombre");
    pr = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio unitario:"));
    st = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el stock: "));
    fec = JOptionPane.showInputDialog("Ingrese fecha de vencimiento: (dd/mm/aaaa)");
    fs.writeInt(cod);
    fs.writeUTF(nom);
    fs.writeDouble(pr);
    fs.writeInt(st);
    fs.writeUTF(fec);
    cod=0;
   }
   fs.close();
  } catch (IOException e) {
   JOptionPane.showMessageDialog(null, "El archivo no pudo ser creado");
  }
 }
 public static void reporte() throws IOException {
  try {
   DataInputStream fi = new DataInputStream(new FileInputStream("Productos.dat"));
   String cad="\tReporte\n\nCodigo\tNombre\tPrecio\tStock\tVencimiento\tTotal\n";
   double sum=0.0;
   while(fi.available()!=0){
    int cod = fi.readInt();
    String nom = fi.readUTF();
    double pr = fi.readDouble();
    int st = fi.readInt();
    String fec = fi.readUTF();
    cad+=cod+"\t"+nom+"\t"+pr+"\t"+st+"\t"+fec+"\t"+(pr*st)+"\n";
    sum+=pr*st;
   }
   cad+="\nTotal\t\t\t\t\t"+sum;
   JTextArea jta=new JTextArea(20,50);
      jta.setText(cad);
      JScrollPane barra = new JScrollPane(jta);
      JOptionPane.showMessageDialog(null,barra);
      fi.close();
  } catch (IOException e) {
   JOptionPane.showMessageDialog(null, "no se pudo leer el archivo");
  }
 }
 
 public static boolean calcular(String fec){
  Calendar fecha = new GregorianCalendar();
  int anio = fecha.get(Calendar.YEAR);
     int mes = fecha.get(Calendar.MONTH);
     int dia = fecha.get(Calendar.DAY_OF_MONTH);
     String fechita=dia +"/" + (mes+1) + "/" + anio;
  boolean m=false;
  String k[]=fec.split("/");
  int k3 = Integer.parseInt(k[0]);
  int k2 = Integer.parseInt(k[1]);
  int k1 = Integer.parseInt(k[2]);
  if (anio<=k1){
   if (anio==k1){
    if (mes<=k2){
     if (mes==k2){
      if (dia<=k3){
       m=true;
      }
     }
    }
    else{
     m=true;
    }
   }
  }
  else{
   m=true;
  }
  return m;
 }
 
 public static void vencimiento() throws IOException {
  try {
   Calendar fecha = new GregorianCalendar();
   int anio = fecha.get(Calendar.YEAR);
      int mes = fecha.get(Calendar.MONTH);
      int dia = fecha.get(Calendar.DAY_OF_MONTH);
      String fechita=dia +"/" + (mes+1) + "/" + anio;
   DataInputStream fi = new DataInputStream(new FileInputStream("Productos.dat"));
   String cad="\tReporte\nFecha"+fechita+"\n\nCodigo\tNombre\tPrecio\tStock\tVencimiento\n";
   boolean a;
   while(fi.available()!=0){
    int cod = fi.readInt();
    String nom = fi.readUTF();
    double pr = fi.readDouble();
    int st = fi.readInt();
    String fec = fi.readUTF();
    a = calcular(fec);
    if (a){
     cad+=cod+"\t"+nom+"\t"+pr+"\t"+st+"\t"+fec+"\n";
    }
   }
   JTextArea jta=new JTextArea(20,50);
      jta.setText(cad);
      JScrollPane barra = new JScrollPane(jta);
      JOptionPane.showMessageDialog(null,barra);
      fi.close();
  } catch (IOException e) {
   JOptionPane.showMessageDialog(null, "No se pudo leer el archivo");
  }
  
 }
 
}
