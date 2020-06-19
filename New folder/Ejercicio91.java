/* 9.- Un supermercado decide efectuar una promoción de  descuentos por el valor de las compras que efectúan sus clientes, esta promoción se basa en las siguientes condiciones:
		Si el total de ventas es < 100 Bs. no se aplica ningún descuento
		Si el total de ventas es de 100 Bs o más se aplica un 5% de descuento
		Si el total de ventas es 500 Bs o más se aplica un 8% de descuento
	Leer las compras  efectuadas por n clientes y aplicar los descuentos para obtener el total de ventas efectuadas y el total de ventas con el descuento respectivo.
*/
public class Ejercicio91 {
	static Scanner in=new Scanner(System.in);
	public static void main(String[] args) {
		int total, clie,desc;
		System.out.println("Ingrese el numero de clientes");
		clie=in.nextInt();
		for(int i=1<clie;i++) {
			System.out.println("Ingrese el valor de compras");
			System.out.printf("Cliente "+i+":");
			total=in.nextInt();
			desc=descuento(total);
		}
	}
	public int descuento(int total){
		if(total<100)
			return 0;
		if(total>=100 && total<500)
			return total*0.05;
		if(total>=500)
			return total*0.08
			
	}

}
