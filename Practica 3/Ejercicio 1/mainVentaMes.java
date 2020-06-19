/* 1. Dada una clase denominada VentasMes, que contiene el valor de una venta y 
 * adem�s el nombre del mes en donde se produjo la misma, se debe obtener crear:
 * - Constructor de la clase
 * - Getters 
 * - Una funci�n que pueda a�adir a un AL de objetos por las ventas de un a�o.
 * - Una funci�n me indique el mes en donde se dieron las ventas m�ximas de la empresa
 * - Una funci�n que obtenga el total de ventas en el a�o 
 * - Una funci�n que muestre la venta menor y el mes respectivo
Emplear ArrayList */
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class mainVentaMes {
	public static void main(String args[]){
	  ArrayList<VentaMes> lista=new ArrayList<VentaMes>(); 
	  int op=10;
	  do {
		  op=Integer.parseInt(JOptionPane.showInputDialog(null,"1.-Crear la venta del a�o\n2.-Venta m�xima\n3.- Venta M�nima\n4.-Total de ventas\n 0.-Salir"));
		  switch(op){
		  case 1: {VentaMes.a�adir(lista);}; break;
		  case 2: VentaMes.max(lista); break;
		  case 4: VentaMes.total(lista); break;
		  case 3: VentaMes.min(lista); break;
		  case 0: System.exit(0); break;}
	    }while(op!=0);
	 }
}