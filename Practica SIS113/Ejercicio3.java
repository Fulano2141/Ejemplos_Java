/* 3.- Una empresa comercial vende n productos en un día, de los cuales factura al precio de cada 
 * uno con un IVA del 13% y si el monto final se excede en 2500 Bs, se aplica un descuento del 5%. 
 * Obtener la suma total de las ventas realizadas en el día y calcular el pago del IVA del 13% al 
 * servicio de Impuestos Nacionales.
 */
import java.util.*;
public class Ejercicio3 {
	static Scanner in=new Scanner(System.in);
	public static void main (String[] x){
		System.out.printf("Ingrese el numero de ventas: ");
		int num=in.nextInt();
		System.out.println("Ingrese el precio de cada uno: ");
		int vec[]=new int[num]; 
		for (int i=0;i<vec.length;i++){
			int pre=0;
			System.out.printf(i+1+" ");
			pre=in.nextInt();
			vec[i]=pre;
	    	}
		int total=0;
		for (int i=0;i<vec.length;i++){
			total=total+vec[i];
	    	}
		System.out.println("El total es: "+total);
		}
}
