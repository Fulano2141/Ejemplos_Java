package Lab1l07x09x2018;
import java.util.Scanner;

public class Laboratorio_N_1 {
	public static class Nodo{
		int dato;
		Nodo sgte;
	}
	public static Scanner sn=new Scanner(System.in);
	static Nodo end;
	static int tam,i=0;
	public static void main(String[] args) {
		int opc;
		end=null;
		System.out.println("Ingrese el tamaño de la pila");
		tam=sn.nextInt();
		do{
			System.out.println("Seleccione una de las opciones ");
			System.out.println("1-Nuevo dato");
			System.out.println("2-Eliminar dato");
			System.out.println("3-Listado");
			System.out.println("4-Salir");
			opc=sn.nextInt();
			if(opc==1)
			{
				agregar();
			}
			if(opc==2)
			{
				System.out.println("Ingrese el dato que desea eliminar");
				int n=sn.nextInt();
				end=elim(n);
			}
			if(opc==3)
			{
				listado(end);
			}
		}while(opc!=4);
		
	}
	public static void agregar() {
		if(i<tam){
			i++;
			Nodo new_nodo = new Nodo();
			sn.nextLine();
			System.out.println("Ingrese el dato");
			new_nodo.dato=sn.nextInt();
			new_nodo.sgte=null;
			if (end == null){
				end = new_nodo;
			}  
			else{
				new_nodo.sgte = end;
			    end = new_nodo;
			}
		}
		else{
			System.out.println("Datos llenos");
		}
	}
	public static Nodo elm2() {
	    if (end == null)
	      return null;
	    Nodo o = end;
	    end = end.sgte;
	    i--;
	    return o;
	}
	public static Nodo elim(int eliminar){
		if(end!=null)
		{
			if(eliminar==end.dato){
				end=elm2();
			}
			else{
				Nodo b=end;
				boolean t=false;
				for(int j=0;j<i;j++){
					if(b.sgte.dato==eliminar){
						t=true;
						break;
					}
					b=b.sgte;
				}
				if(t=true){
					b.sgte=b.sgte.sgte;
					i--;
				}
				else{
					System.out.println("Dato no registrado");
				}
				
			}
		}
		return end;
	}
	public static void listado(Nodo cab){
		for(int j=0;j<i;j++){
			System.out.print(cab.dato+",");
			cab=cab.sgte;
		}
		System.out.println();
	}
}
