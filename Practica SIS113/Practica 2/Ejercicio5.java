/* 5.-  Crear una aplicación que permita calcular el tiempo de vuelo de todos los vuelos contenidos en el ejemplo, 
 * para tal efecto debe crear constructores y funciones, verifique el funcionamiento con los siguientes datos de prueba:
 * Nº Vuelo	 Hora Salida		Hora Llegada	    Tiempo Vuelo
 * ------------------------------------------------------------------------------------
 * 495			10:15		       12:30			    2:15
 * 706			10:40		       13:20	   			2:40
 * 951			23:30		        2:40	   			3:10
 * 743			23:20	  	        2:10	   			2:50  */
import javax.swing.JOptionPane;
public class Ejercicio5 {
	int HorEn,MinEn,HorSa,MinSa;
	public Ejercicio5(int horEn, int minEn, int horSa, int minSa) {
		HorEn = horEn;
		MinEn = minEn;
		HorSa = horSa;
		MinSa = minSa;
	}
	public void salida() {
		JOptionPane.showMessageDialog(null,"El tiempo de vuelo total es de: "+HorasTot(HorEn,MinEn,HorSa,MinSa)+" Horas "+MinTot(HorEn,MinEn,HorSa,MinSa)+" Minutos" );
	}
	public static void main(String[] args) {
		int HorEn=(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la hora de entrada")));
		int MinEn=(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el minuto de entrada")));
		int HorSa=(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la hora de salida")));
		int MinSa=(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el minuto de salida")));
		Ejercicio5 obj=new Ejercicio5(HorEn,MinEn,HorSa,MinSa);
		obj.salida();
	}
public int HorasTot(int hor0, int min0, int hor1, int min1) {
	int hor2;
	int aux,aux1;
	if (hor1>=hor0){
		aux=hor0*60;
		aux=min0+aux;
		aux1=hor1*60;
		aux1=min1+aux1;
		aux=aux1-aux;
		hor2=aux/60;
	}
	else{
		if (hor0>12)
			hor0=hor0-12;
		if (hor1<12)
			hor1=hor1+12;
		aux=hor0*60;
		aux=min0+aux;
		aux1=hor1*60;
		aux1=min1+aux1;
		aux=aux1-aux;
		hor2=aux/60;
	}
	return hor2;
	}
	public int MinTot(int hor0, int min0, int hor1, int min1){
		int min2;
		int aux,aux1;
		if (hor1>=hor0){
			aux=hor0*60;
			aux=min0+aux;
			aux1=hor1*60;
			aux1=min1+aux1;
			aux1=aux1-aux;
			min2=aux1%60;}
		else{
			if (hor0>12)
				hor0=hor0-12;
			if (hor1<12)
				hor1=hor1+12;
			aux=hor0*60;
			aux=min0+aux;
			aux1=hor1*60;
			aux1=min1+aux1;
			aux1=aux1-aux;
			min2=aux1%60;
		}
		return min2;
	}
}
