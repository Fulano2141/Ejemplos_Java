package P2SarviaRodrigo;

import javax.swing.JOptionPane;

/**	6.- Una empresa efectúa el control de asistencia de sus empleados 
       mediante un lector biométrico, el horario en la entrada es a 
       las 8:00 a.m y la salida es a las 16:00 p.m. El empleado tiene 
       una tolerancia de 10 minutos en la entrada, si llega más allá 
       de los 10 minutos de tolerancia se penaliza todos los minutos 
       de atraso (es decir si llega a las 8:12 se penalizan los 12 minutos). 
       De igual forma no puede salir antes del horario establecido en la 
       salida,  (si lo hace se penaliza los minutos faltantes), pero si 
       el empleado entra antes o sale después de sus horarios el sistema 
       solo toma en cuenta las 8 horas laborales de trabajo. 
    El problema consiste en determinar los minutos de penalización para el empleado 
    en cualquier día laboral. Para tal propósito debe crear constructores y funciones, 
    verifique el funcionamiento con los siguientes datos de prueba:
 Código Empleado Hora Entrada Hora Salida  Penalización   Fecha
	101045			7:55		16:15	       0		12/01/2011	
	223032	        8:11		16:00	       11		12/01/2011
	334009		    8:30		16:20	       30		12/01/2011
	443283	        8:05        16:10          0		12/01/2011
*/


public class Ejer_6_Main {
	public static void main(String[] args) {
		Ejer_6_Horario[] v={};
		Ejer_6_Horario[] c={};
		Ejer_6_Horario x;
		x=new Ejer_6_Horario();
		x.setFecha(JOptionPane.showInputDialog("Fecha de Ingreso"));
		x.setID(Integer.parseInt(JOptionPane.showInputDialog("ID del Empleado")));
		v=x.Separa("Hora de llegada",1);
		c=x.Separa("Hora de Salida",2);
		x.Penalizacion(v,c);
	}
}
