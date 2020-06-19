/*  1. Dada una medida de tiempo expresada en horas, minutos y segundos con 
 *  valores arbitrarios, transforme dicha medida en una expresión correcta. 
 *  Por ejemplo, dada la medida 3h 118m 195s, el programa deberá obtener 
 *  como resultado 5h 1m 15s.
 */
import javax.swing.*;
import java.util.*;
public class Ejercicio1 {
	static Scanner in=new Scanner(System.in);
	public static void main (String[] x){
		int totalseg;
		System.out.printf("Digite las horas");
		int hor=in.nextInt();
		System.out.printf("Digite los minutos");
		int min=in.nextInt();
		System.out.printf("Digite los segundos");
		int seg=in.nextInt();
		totalseg=hor*3600+min*60+seg;
		System.out.println(totalseg);
		hor=(totalseg/3600);
	    min=(totalseg-hor*3600)/60;
	    seg=totalseg-(hor*3600+min*60);
		System.out.printf("El resutaldo es: "+hor+" HH "+min+" MM "+seg+" SS");

	}
}
