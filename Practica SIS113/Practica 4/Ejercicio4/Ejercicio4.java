/*4.- Una empresa efectúa el control de asistencia de sus empleados mediante un lector biométrico, el horario en la entrada es a las 8:00 a.m y la salida es a las 16:00 p.m. El empleado tiene una tolerancia de 10 minutos en la entrada, si llega más allá de los 10 minutos de tolerancia se penaliza todos los minutos de atraso (es decir si llega a las 8:12 se penalizan los 12 minutos). De igual forma no puede salir antes del horario establecido en la salida,  (si lo hace se penaliza los minutos faltantes), pero si el empleado entra antes o sale después de sus horarios el sistema solo toma en cuenta las 8 horas laborales de trabajo. 
El problema consiste en determinar los minutos de penalización para el empleado en cualquier día laboral.
       Código Empleado      Hora Entrada         Hora Salida      Penalización          Fecha

101045			7:55		16:15	               0		12/01/2011	
223032			8:11		16:00	             11		12/01/2011
334009			8:30		16:20	             30		12/01/2011
443283	            	             8:05                	16:10                  0		12/01/2011

Emplear un archivo de tipo texto en JAVA para almacenar el código, 
el nombre del empleado, la hora de entrada, la hora de salida y la fecha de registro, 
añadiendo una función para añadir empleados al archivo, una función que genere este 
reporte de penalizaciones.
*/ 
package Ejercicio4;
import java.io.*;
import javax.swing.*;
public class Ejercicio4 {
	public static void main(String[] args) throws Exception{
		for(;true;){
			String [] menu1= {"Añadir dato","Leer archivo","Salir"};
			String valor1=(String) JOptionPane.showInputDialog(null,"Seleccione la opcion","Opciones",JOptionPane.DEFAULT_OPTION,null,menu1,menu1[0]);
			switch(valor1){
			case "Añadir dato":adicion();break;
			case "Leer archivo":reporte(1);break;
			case "Salir": System.exit(0);break;
			}
		}
	}
	public static void reporte(int i) throws Exception{
		try{
			String aux="",cad="Codigo Empleado\tHora Entrada\tHora Salida\tPenalizacion\tFecha\n";
			BufferedReader in=new BufferedReader(new FileReader("Ejer4.txt"));
			while(in.ready()){
				aux=in.readLine();
				String[] part=aux.split(";");
				String[] horen=part[1].split(":");
				String[] horsa=part[2].split(":");
				int pena=biomeent(Integer.parseInt(horen[0]),Integer.parseInt(horen[1]))+biomesal(Integer.parseInt(horsa[0]),Integer.parseInt(horsa[1]));
				cad=cad+part[0]+"\t\t"+part[1]+"\t"+part[2]+"\t"+pena+"\t"+part[3]+"\n";			
			}
			in.close();
			JTextArea area=new JTextArea();
			area.setText(cad);
			JOptionPane.showMessageDialog(null,area);
		}
		catch (IOException e){
			JOptionPane.showMessageDialog(null,"No existe Archivo");
		}
	}
	public static void adicion() throws IOException{
		   try{
			   PrintWriter out=new PrintWriter(new FileWriter("Ejer4.txt",true));
			   int n=Integer.parseInt(JOptionPane.showInputDialog(null,"Cuantos datos desea agregar: "));
			   for(int i=0;i<n;i++){
				   int codi=Integer.parseInt(JOptionPane.showInputDialog(null,"Codigo empleado"));
				   String HorEn=JOptionPane.showInputDialog(null,"Hora de entrada HH:MM");
				   String HorSa=JOptionPane.showInputDialog(null,"Hora de salida HH:MM");
				   String Fecha=JOptionPane.showInputDialog(null,"Fecha DD/MM/AA");
				   String cor=codi+";"+HorEn+";"+HorSa+";"+Fecha;
				   out.println(cor);
			   }
		   out.close();
		   }
		   catch (IOException e){
		    JOptionPane.showMessageDialog(null,"Dato Invalido");
		   }
	} 
	 public static int biomeent(int hor1,int min1){
			if(hor1==8){
				if (min1<=10 && min1>=0)
				return 0;
				else 
				return min1;
			}	
			if(hor1<=7)
				return 0;
			else 
				return 0;

		}
	public static int biomesal(int hor2,int min2){
			int x=0;
			if(hor2==16)
			return x;
			if (hor2==15){
				x=60-min2;
				return x;
			}
			else 
				return x;	
		}
}
