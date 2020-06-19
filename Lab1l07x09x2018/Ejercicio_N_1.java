package Lab1l07x09x2018;
import java.util.Scanner;
public class Ejercicio_N_1 
{
	public static class Nodo
	{
		String Nom;
		String Apell;
		int Fono;
		Nodo sgte;
	}
	public static Scanner sn=new Scanner(System.in);
	static int cup,i=0;
	static Nodo end;
	public static void main(String[] args) 
	{
		int op;
		end=null;
		System.out.println("Ingrese el numero de cupos maximo");
		cup=sn.nextInt();
		do
		{
			System.out.println("Seleccione una opcion ");
			System.out.println("1-Nuevo paciente");
			System.out.println("2-Eliminar paciente");
			System.out.println("3-Listado de turnos");
			System.out.println("4-Salir");
			op=sn.nextInt();
			if(op==1)
			{
				agregar();
			}
			if(op==2)
			{
				System.out.println("Ingrese el nombre del paciente que desea eliminar");
				sn.nextLine();
				String n=sn.nextLine();
				end=elim_cita(n);
			}
			if(op==3)
			{
				turnos(end);
			}
		}while(op!=4);
		
	}
	public static void agregar() 
	{
		if(i<cup){
			i++;
			Nodo new_nodo = new Nodo();
			sn.nextLine();
			System.out.println("Ingrese el nombre del paciente");
			new_nodo.Nom=sn.nextLine();
			System.out.println("Ingrese los apellidos del paciente");
			new_nodo.Apell=sn.nextLine();
			System.out.println("Ingrese el telefono del paciente");
			new_nodo.Fono=sn.nextInt();
			new_nodo.sgte=null;
			if (end == null)
			{
				end = new_nodo;
			}  
			else
			{
				Nodo p=end;
				while(p.sgte!=null) 
				{
					p=p.sgte;
				}
				p.sgte=new_nodo;
			}
		}
		else
		{
			System.out.println("Capacidad maxima de pacientes alcanzada");
		}
	}

	public static Nodo elim_cita(String eliminar)
	{
		if(end!=null)
		{
			if(eliminar.equals(end.Nom)){
				end=eliminar();
			}
			else{
				Nodo b=end;
				boolean t=false;
				for(int j=0;j<i;j++){
					if(b.sgte.Nom.equals(eliminar))
					{
						t=true;
						break;
					}
					b=b.sgte;
				}
				if(t=true)
				{
					b.sgte=b.sgte.sgte;
					i--;
				}
				else
				{
					System.out.println("Paciente no registrado");
				}
				
			}
		}
		return end;
	}
	public static Nodo eliminar() 
	{
	    if (end == null)
	      return null;
	    Nodo o = end;
	    end = end.sgte;
	    i--;
	    return o;
	}
	public static void turnos(Nodo cab)
	{
		for(int j=0;j<i;j++){
			System.out.println(cab.Nom+" "+cab.Apell+" turno numero "+(j+1));
			cab=cab.sgte;
		}
	}
}
