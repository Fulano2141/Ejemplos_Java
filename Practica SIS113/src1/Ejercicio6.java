/* 6.- Una empresa de seguros tiene contratados a N vendedores. 
 * Cada uno hace tres ventas a la semana. Su política de pagos es 
 * que un vendedor recibe un sueldo base, y un 10% extra por comisiones
 * de sus ventas. El gerente de su compañía desea saber cuánto dinero 
 * obtendrá en la semana cada vendedor por concepto de comisiones por 
 * las tres ventas realizadas, y cuanto tomando en cuenta su sueldo base y sus comisiones.
 */
import java.util.Scanner;
public class Ejercicio6 {
	static Scanner in = new Scanner(System.in);
	public static void main (String [] args){
		System.out.println("Introducir el numero de empleados");
		int emp = in.nextInt();
		int[][] vec = new int[emp][4];
		for(int i=0; i<vec.length;i++) {
			System.out.println("Ingrese la venta del vendedor "+(i+1)+":");
			System.out.printf("Venta 1: ");
			int ven1 = in.nextInt();
			vec[i][0]=ven1;
			System.out.printf("Venta 2: ");
			int ven2 = in.nextInt();
			vec[i][1]=ven2;
			System.out.printf("Venta 3: ");
			int ven3 = in.nextInt();
			vec[i][2]=ven3;
			vec[i][3]=ven1+ven2+ven3;
		}
		System.out.println("El total de ventas por cada vendedor es: ");
		for(int i=0; i<vec.length;i++) {
			System.out.println("vendedor "+(i+1)+" total de: "+vec[i][3]);
		}
		System.out.println("Ingrese el sueldo basico: ");
		int suel=in.nextInt();
		for(int i=0;i<vec.length;i++){
			double totalsuel=suel+vec[i][3]*0.1;
			System.out.println("Sueldo total mas comision del vendedor "+(i+1)+" total de: "+totalsuel);
		}
			
	}
}
