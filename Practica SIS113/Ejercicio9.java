/* 9.- Un supermercado decide efectuar una promoción de  descuentos por el valor de las compras que efectúan sus clientes, esta promoción se basa en las siguientes condiciones:
		Si el total de ventas es < 100 Bs. no se aplica ningún descuento
		Si el total de ventas es de 100 Bs o más se aplica un 5% de descuento
		Si el total de ventas es 500 Bs o más se aplica un 8% de descuento
	Leer las compras  efectuadas por n clientes y aplicar los descuentos para obtener el total de ventas efectuadas y el total de ventas con el descuento respectivo.
*/
import java.util.*;
public class Ejercicio9 {
	static Scanner in=new Scanner(System.in);
	public static void main(String[] args) {
		int total, clie,c=0;
		double dec,d=0;
		System.out.println("Ingrese el numero de clientes");
		clie=in.nextInt();
		System.out.println("Ingrese el valor de compras");
		for(int i=1;i<clie;i++) {
			System.out.printf("Cliente "+i+":");
			total=in.nextInt();
			c=c+total;
			dec=desc(total);
			d=d+dec;
		}
	}
	public static double desc(int total){
		double aux=0.0;
		if(total<100)
			return aux;
		if(total>=100 && total<500) {
			aux=total*0.05;
			return aux;
		}
		if(total>=500) {
			aux=total*0.08;
			return aux;
		}
			
	}

}