import javax.swing.*;
import java.math.*;
import java.util.*;
public class Interfaz
{
public static void main(String args[])
{
String c="";
String d1,d2,d3;
double radio,h,radioi;
d1=JOptionPane.showInputDialog("Radio:");
radio=Double.parseDouble(d1);
d2=JOptionPane.showInputDialog("Altura:");
h=Double.parseDouble(d2);
d3=JOptionPane.showInputDialog("Radio Interno:");
radioi=Double.parseDouble(d3);
Circulo c1=new Circulo(radio);
Cilindro c2=new Cilindro(radio,h);
CilindroHueco c3=new CilindroHueco(radio,h,radioi);
c=c1.toString()+"\n"+c2.toString()+"\n"+c3.toString();
JTextArea areasal=new JTextArea(10,20);
JScrollPane b=new JScrollPane(areasal);
areasal.setText(c);         
JOptionPane.showMessageDialog(null,b);
}
}



