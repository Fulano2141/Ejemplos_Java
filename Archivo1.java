/*
1.-  Un archivo de texto contiene la cedula, el apellido paterno y el nombre de un 
//   grupo de personas, realizar mediante funciones:

//               - Lectura del archivo 
//               - Copiar a un segundo archivo los datos de las personas que tienen apellidos que comiencen con alguna letra que elija el usuario.
//               - Añadir nuevos nombres al archivo
//               - Buscar a una persona por numero de cedula y desplegar sus datos.
*/

import java.io.*;
import javax.swing.*;

public class Archivo1 
{   
    static String cad1="",cad2,num;
    static int n;
    public static void main(String args[])throws IOException
    {
    int x = 0,option = 0; 
    do
   {
    try{        option=Integer.parseInt(JOptionPane.showInputDialog("1. Mostrar archivo"+"\n"+"2. Copiar"+"\n"+"3. Adicionar nuevos datos"+"\n"+"4.Buscar nit"+"\n"+"5.Salir"+"\n"+"ingrese una opcion")); 
    }
    catch(NumberFormatException ex )
    {
    JOptionPane.showMessageDialog(null,"ingrese solo numeros","error",JOptionPane.INFORMATION_MESSAGE); 
         
    }
 switch(option)
 {
 case 1:JOptionPane.showMessageDialog(null,leer("DATOS.TXT"));
 
 break;
 case 2:
 cad2=JOptionPane.showInputDialog("ingrese la letra inicial del apellido deseado");
 copiar(cad2,"DATOS.TXT");
 JOptionPane.showMessageDialog(null,"archivo creado");
 break;
 case 3:n=Integer.parseInt(JOptionPane.showInputDialog("ingresar el numero de datos deseados"));
 adicionar(n,"DATOS.TXT");
 JOptionPane.showMessageDialog(null,"nuevos datos adicionados");
 break;
 case 4:
 num=JOptionPane.showInputDialog("ingresar el nit que se desea buscar");
 buscar(num,"DATOS.TXT");  
 break;
 case 5:x=5;
 }
 }
 while(x!=5);
    }
 public static String leer(String arch) throws IOException
 {
  File f=new File(arch); 
  BufferedReader bf=new BufferedReader(new FileReader(arch));
  String l,cad="";
  while(bf.ready())
  {
  l=bf.readLine();
  cad+=l+"\n";
  }
  bf.close();
  return cad; 
  
 }
 public static void copiar(String letra,String arch) throws IOException
 {
  File f=new File(arch);
  File f2=new File("copy.txt");
  BufferedReader bf=new BufferedReader(new FileReader(arch));
  BufferedWriter bw=new BufferedWriter(new FileWriter(f2));
  String l,cad;
  while(bf.ready())
  {
  l=bf.readLine();
  if((l.charAt(8))==letra.charAt(0))
  {
  bw.write(l);
  bw.newLine();
  }
  }
  bf.close();
  bw.close(); 
  
 }
 public static void adicionar(int n,String arch) throws IOException
 {
  File f=new File(arch); 
  BufferedWriter bx=new BufferedWriter(new FileWriter(arch,true));
  String cad;
  for(int k=1;k<=n;k++)
  {
  cad=JOptionPane.showInputDialog("ingrese el nueva dato numero:"+k);    
  bx.write(cad);
  bx.newLine();
  }
  bx.close(); 
  }
 public static void buscar(String num,String arch) throws IOException
 {
  File f=new File(arch);
  BufferedReader bf=new BufferedReader(new FileReader(arch));
  String l;
  boolean e=false;
  while(bf.ready())
  {
  l=bf.readLine();
  String s[]=l.split(",");
  if(s[0].equals(num))
  {
  JOptionPane.showMessageDialog(null,"nit encontrado, sus datos son:"+"\n"+l);
  e=false;
  break;    
  }
  else
  e=true;  
  }
  if(e)
  JOptionPane.showMessageDialog(null,"nit no encontrado, datos inexistentes","AVISO",JOptionPane.INFORMATION_MESSAGE);
  bf.close();
   
  
 }
 
  
 }
 
 





