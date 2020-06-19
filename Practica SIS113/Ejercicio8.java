/* 8. Se requiere un programa que permita a un cajero automático saber 
 * cuántos billetes de Bs.50, Bs.20, Bs.100 y Bs.200 debe darle a un cliente 
 * para suplir una cierta cantidad digitada. Se requiere darle, siempre 
 * la menor cantidad de billetes posible.
 */
import java.util.*;
public class Ejercicio8 {
	static Scanner in=new Scanner(System.in);
	public static void main(String[] args) {
		int total,ve,cin,cien,dosc;
		System.out.println("Digite el valor");
		total=in.nextInt();
		dosc=total/200;
		total=total-dosc*200;
		cien=total/100;
		total%=100;
		cin=total/50;
		total%=50;
		ve=total/20;
		total%=20;
		System.out.println(dosc+" billetes de 200");
		System.out.println(cien+" billetes de 100");
		System.out.println(cin+" billetes de 50");
		System.out.println(ve+" billetes de 20");
		System.out.println(total+" pesos ");
		
	}

}
