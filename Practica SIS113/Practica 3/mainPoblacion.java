import java.util.ArrayList;

import javax.swing.JOptionPane;

/*2.-  Dada una clase denominada Población que contiene el nombre de un departamento 
 * y la población de la misma, se debe obtener:
 * - Constructor de la clase
 * - Una función que añada a un AL de objetos la población de los nueve departamentos
 * - Una función que indique el nombre del departamento que tiene la mayor población y 
 * el nombre del departamento que tiene la menor población.
 * Emplear ArrayList */
public class mainPoblacion {
	public static void main(String args[]){
		  ArrayList<Poblacion> list=new ArrayList<Poblacion>(); 
		  int op=10;
		  do {
			  op=Integer.parseInt(JOptionPane.showInputDialog(null,"1.-Actualizar o agregar datos de poblaciones\n2.-Poblacion mayor y menor\n 0.-Salir"));
			  switch(op){
			  case 1: {Poblacion.añadir(list);}; break;
			  case 2: Poblacion.maxmin(list); break;
			  case 0: System.exit(0); break;}
		    }while(op!=0);
		 }

}
