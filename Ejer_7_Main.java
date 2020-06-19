package P2SarviaRodrigo;

import javax.swing.JOptionPane;

/**	7.-Crear una aplicación que permita calcular el tiempo de vuelo de 
      todos los vuelos contenidos en el ejemplo, para tal efecto debe 
      crear constructores y funciones, verifique el funcionamiento con 
      los siguientes datos de prueba:
		Nº Vuelo  Hora Salida  Hora Llegada	 Tiempo Vuelo
		   495		10:15		  12:30			2:15
		   706		10:40		  13:20	   		2:40
		   951		23:30		   2:40	   	    3:10
		   743		23:20	  	   2:10	   		2:50
*/

public class Ejer_7_Main 
{
	public static void main(String[] args) 
	{
		Ejer_7_TiempoVuelo f;
		f=new Ejer_7_TiempoVuelo();
		f.setNu(Integer.parseInt(JOptionPane.showInputDialog("Nº de vuelo")));
		f.Separar("Horsa de salida", 1);
		f.Separar("Horsa de llegada", 2);
		f.Tiempo();
		f.Mostrar();

	}

}
