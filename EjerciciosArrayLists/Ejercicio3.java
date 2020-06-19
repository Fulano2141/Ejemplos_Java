package Practica3;
/*3.   A partir de dos AL que contienen 5 números enteros, intercalar 
 * los elementos de ambos AL y producir un tercer AL. */
import java.util.*;
public class Ejercicio3 {
	ArrayList<Integer> lista1=new ArrayList<Integer>();
	ArrayList<Integer> lista2=new ArrayList<Integer>();
	public Ejercicio3(ArrayList<Integer> lista1,ArrayList<Integer> lista2)
	{
		this.lista1=lista1;
		this.lista2=lista2;
	}
	public ArrayList<Integer> getLista1()
	{
		return lista1;
	}
	public ArrayList<Integer> getLista2()
	{
		return lista2;
	}
	public ArrayList<Integer> Lista3()
	{
		int n=10,i=0,j=0;
		ArrayList<Integer> lista3=new ArrayList<Integer>();
		for(int k=0;k<n;k++)
		{
			if(k%2==0)
			{
				lista3.add(lista1.get(i));
				i++;
			}
			else
			{
				lista3.add(lista2.get(j));
				j++;
			}
		}
		return lista3;
	}
}
