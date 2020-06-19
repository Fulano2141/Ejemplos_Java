package Lab1l07x09x2018;
import java.util.Scanner;
public class Ejercicio_N_2 
{
	public static class Nodo
	{
		String Nom;
		String Apell;
		int Fono;
		Nodo sgte;
	}
	public static Scanner sn=new Scanner(System.in);
	static int emp_desp;
	static Nodo end;
	public static void main(String[] args)
	{
		end=null;
		System.out.println("Ingrese la cantidad de empleados");
		int cant_emp=sn.nextInt();
		for(int i=1;i<=cant_emp;i++)
		{
			ingresar();
			System.out.println("------------------------");
		}
		System.out.println("Ingrese la cantidad de empleados que se despediran");
		emp_desp=sn.nextInt();
		System.out.println("Lista de despedidos");
		emp_despedidos(end,emp_desp);
	}
	public static void ingresar() 
	{
		Nodo new_nodo = new Nodo();
		sn.nextLine();
		System.out.println("Ingrese el nombre del empleado");
		new_nodo.Nom=sn.nextLine();
		System.out.println("Ingrese los apellidos del empleado");
		new_nodo.Apell=sn.nextLine();
		System.out.println("Ingrese el telefono del empleado");
		new_nodo.Fono=sn.nextInt();
		new_nodo.sgte=null;
		if (end == null)
		{
			end = new_nodo;
		}  
		else{
			new_nodo.sgte = end;
		      end = new_nodo;
		}
	}
	public static void emp_despedidos(Nodo cab,int z)
	{
		for(int j=0;j<z;j++){
			System.out.println(cab.Nom+" "+cab.Apell);
			cab=cab.sgte;
		}
	}
}