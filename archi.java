package poo;
import java.io.*;
public class archi {
	public static class alumno
	{
	    String nombre;
	    String apellido;
	    int carnet;
	    
	}

	public static void main(String[] args) throws IOException{
		//alumno alu = new alumno() ;
		alumno ve[]= {};
		alumno a[]= {};
		int op,n=0;
	    String mat;
		do{
			op=menu();
			switch(op) {
			
			
			case 1:
				do {
				n=leer("cuantos estudiantes ");
				}while(n<1);
				
				ve=registro_es(n);
				
				break;
			case 2:
				a=ordena(ve,n);
				listado(a,n);
				break;
			case 3:
				mat=leerst("ingrese la materia ");
				buscar(a,n,mat);
				break;
		}
			
		}while(n!=4);
		

	}
	public static int leer(String x)throws IOException
	{
		BufferedReader k=new BufferedReader(new InputStreamReader(System.in));
		System.out.println(x);
		int d=Integer.parseInt(k.readLine());
		return d;
	}
	public static String leerst(String x)throws IOException
	{
		BufferedReader k=new BufferedReader(new InputStreamReader(System.in));
		System.out.println(x);
		String d=k.readLine();
		return d;
	}
	public static int menu() throws IOException{
		System.out.println("***opciones***");
		System.out.println(" 1.-registro\n 2.-listado\n 3.-salir");
		int d=leer("ingrese su opcion" );
		return d;
	}
	public static alumno [] registro_es(int n )throws IOException 
	{   int j;
		alumno []v=new alumno[10];
		alumno []k=new alumno[10];
		for(int i=0;i<n;i++)
		{   v[i]=new alumno();
			v[i].nombre=leerst("ingrese su nombre");
			v[i].apellido=leerst("ingrese su apellido");
			v[i].carnet=leer("ingrese su carnet");
			
			
		}
		return v;
	}
	
	public static void listado(alumno v[],int n)
	{   System.out.println("--Datos--");
		for(int i=0;i<n;i++)
		{
			System.out.println("*"+v[i].apellido+" "+v[i].nombre+
					" CI = "+v[i].carnet);
			
		}
		System.out.println("");
	}
	
	public static alumno[] ordena(alumno z[],int ta)
	{  //ordena por apellido
	   alumno aux=new alumno(); //creamos un objeto vacio
	   for(int i=0;i<ta;i++){
	    for(int j=i;j<ta;j++){
		if(z[i].apellido.compareTo(z[j].apellido)>0){
				    aux=z[i];
				    z[i]=z[j];
				    z[j]=aux;                       
					}
	    }
	   }
	   return (z);      
	}
	public static void buscar(alumno X[],int n1,String b)
	{   int p=0;
	    boolean en=false;
		for(int i=0;i<n1;i++)
		{
			if((X[i].apellido.compareTo(b)==0))
			{
				p=i;
				en=true;
			}
		}
		if(en)
		{
			System.out.println(X[p].apellido+" "+X[p].nombre+", ");
		}
	}

}
