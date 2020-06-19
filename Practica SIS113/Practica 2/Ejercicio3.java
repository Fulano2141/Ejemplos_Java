/* 3.- Una clase denominada Parqueo contiene los datos de registro de un parqueo de vehículos, estos son:
 * -	El número de placa
 * -	La hora de entrada (hh:mm)
 * -	La hora de salida (hh:mm)
 * Escriba un programa que además del constructor, funciones para lograr:
 * -	El tiempo y el pago por el servicio de estacionamiento de coches en un parqueo, 
 * teniendo en cuenta que la primera hora de estadía se paga 8 Bs., y las restantes 3 Bs. c/hora. 
 * Si el uso del servicio es menor a una hora se cobra por la hora y de igual manera si excede 
 * la hora se cobra por la hora siguiente.
 * Crear objetos para verificar con los siguientes casos:
 * Hora Entrada   Minuto de entrada    Hora Salida   Minuto Salida   Tiempo    Pago
 * 		09				35					10				15	    1 hora     8 Bs.
 * 		11				10					12				20	    2 horas    11 Bs.
 *		17				55					21				30	    4 horas    17 Bs. */
import javax.swing.JOptionPane;
public class Ejercicio3 {
	int HorEn,MinEn,HorSa,MinSa;
	private String Placa;
	public Ejercicio3(int horEn, int minEn, int horSa, int minSa, String Placa) {
		HorEn = horEn;
		MinEn = minEn;
		HorSa = horSa;
		MinSa = minSa;
		this.Placa=Placa;
	}
	public void salida() {
		int hh=HorasTot(HorEn,MinEn,HorSa,MinSa),mm=MinTot(HorEn,MinEn,HorSa,MinSa);
		int aux=8;
		if(hh==0 && mm>0)
			aux=8;
		if(hh>0){
			for(int i=0;i<hh;i++)
				aux=aux+3;
		}
		if(hh==0 && mm==0)
			aux=0;
		JOptionPane.showMessageDialog(null,"El automovil: "+Placa+"\nDebe: "+aux+"bs.");
	}
	public static void main(String[] args) {
		String Placa=JOptionPane.showInputDialog(null,"Ingrese la placa");
		int HorEn=(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la hora de entrada")));
		int MinEn=(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el minuto de entrada")));
		int HorSa=(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la hora de salida")));
		int MinSa=(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el minuto de salida")));
		Ejercicio3 obj=new Ejercicio3(HorEn,MinEn,HorSa,MinSa,Placa);
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