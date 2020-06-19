/* 1. Dada una clase denominada VentasMes, que contiene el valor de una venta y 
 * además el nombre del mes en donde se produjo la misma, se debe obtener crear:
 * - Constructor de la clase
 * - Getters 
 * - Una función que pueda añadir a un AL de objetos por las ventas de un año.
 * - Una función me indique el mes en donde se dieron las ventas máximas de la empresa
 * - Una función que obtenga el total de ventas en el año 
 * - Una función que muestre la venta menor y el mes respectivo
Emplear ArrayList */
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class mainVentaMes {
	public static void main(String args[]){
	  ArrayList<VentaMes> lista=new ArrayList<VentaMes>(); 
	  int op=10;
	  do {
		  op=Integer.parseInt(JOptionPane.showInputDialog(null,"1.-Crear la venta del año\n2.-Venta máxima\n3.- Venta Mínima\n4.-Total de ventas\n 0.-Salir"));
		  switch(op){
		  case 1: {VentaMes.añadir(lista);}; break;
		  case 2: VentaMes.max(lista); break;
		  case 4: VentaMes.total(lista); break;
		  case 3: VentaMes.min(lista); break;
		  case 0: System.exit(0); break;}
	    }while(op!=0);
	 }
}