package Practica3;
/*3.   A partir de dos AL que contienen 5 números enteros, intercalar 
 * los elementos de ambos AL y producir un tercer AL. */
import javax.swing.*;
import java.util.*;
public class InterfazEjercicio3 {
	public static void main (String args[])
	{
		ArrayList<Integer> lista1=new ArrayList<Integer>();
		ArrayList<Integer> lista2=new ArrayList<Integer>();
		for(int i=0;i<5;i++)
		{
			String cad1=JOptionPane.showInputDialog(null,"Ingrese el elemento "+(i+1)+" de la Lista 1");
			int n=Integer.parseInt(cad1);
			lista1.add(n);
		}
		for(int i=0;i<5;i++)
		{
			String cad1=JOptionPane.showInputDialog(null,"Ingrese el elemento "+(i+1)+" de la Lista 2");
			int n=Integer.parseInt(cad1);
			lista2.add(n);
		}
		Ejercicio3 obj1=new Ejercicio3(lista1,lista2);
		
		JOptionPane.showMessageDialog(null, "ArrayList 1:\n"+obj1.getLista1()+"\nArrayList 2:\n"+obj1.getLista2()+"\nArrayList Combinado:\n"+obj1.Lista3());
	}
}
