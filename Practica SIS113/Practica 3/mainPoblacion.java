import java.util.ArrayList;

import javax.swing.JOptionPane;

/*2.-  Dada una clase denominada Poblaci�n que contiene el nombre de un departamento 
 * y la poblaci�n de la misma, se debe obtener:
 * - Constructor de la clase
 * - Una funci�n que a�ada a un AL de objetos la poblaci�n de los nueve departamentos
 * - Una funci�n que indique el nombre del departamento que tiene la mayor poblaci�n y 
 * el nombre del departamento que tiene la menor poblaci�n.
 * Emplear ArrayList */
public class mainPoblacion {
	public static void main(String args[]){
		  ArrayList<Poblacion> list=new ArrayList<Poblacion>(); 
		  int op=10;
		  do {
			  op=Integer.parseInt(JOptionPane.showInputDialog(null,"1.-Actualizar o agregar datos de poblaciones\n2.-Poblacion mayor y menor\n 0.-Salir"));
			  switch(op){
			  case 1: {Poblacion.a�adir(list);}; break;
			  case 2: Poblacion.maxmin(list); break;
			  case 0: System.exit(0); break;}
		    }while(op!=0);
		 }

}
