package Faddeva;

import java.io.*;
public class InversaPorFadheva {
	  public static class matriz
	  {
		  int fi,col;
		  double dato;
		  matriz sgte;
	  }
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		matriz A=null;
		int af=0,ac=0,op;
        do {
        	menu();
        	op=leer("opcion?");
        	switch (op)
        	{
        	case 1:
        		A=null;
        		do {
        			af=leer("Total de filas");
        		}while(af<=0 || af>10);
        		do {
        			ac=leer("Total de columnas");
        		}while(ac<=0 || ac>10);
        		A=agregar_matriz(A,af,ac);
        		break;
        	case 2:
        		listado("\n** Matriz A**\n",A,af,ac);
        	    break;
        	case 3:
        		if(A==null) {
        			System.out.println("Matriz vacia");
        		}else {
        			if(af!=ac) {
        				System.out.println("La matriz debe ser cuadrada");
        			}else {
        				listado("\n** Matriz Inversa**\n",inversa(A,af),af,ac);
        			}
        		}
        		break;
        	}
        }while(op!=4);
	}
	public static void menu()
	{
		System.out.println("*** matrices ***");
		System.out.println("1. lectura de A");
		System.out.println("2. listado de A");
		System.out.println("3. Inversa");
		System.out.println("4. Salir");
	}
	public static int leer(String x)throws IOException
	{
		BufferedReader z=new BufferedReader(new InputStreamReader(System.in));
		System.out.println(x);
		int r=Integer.parseInt(z.readLine());
		return(r);
	}
	public static double leer2(String x)throws IOException
	{
		BufferedReader z=new BufferedReader(new InputStreamReader(System.in));
		System.out.println(x);
		double r=Double.parseDouble(z.readLine());
		return(r);
	}
	public static matriz agregar_matriz(matriz a, int f, int c)throws IOException
	{   matriz nuevo=null;
	    for(int i=0;i<f;i++)
	    {
	    	for(int j=0;j<c;j++)
	    	{
	    		nuevo=new matriz();
	    		nuevo.fi=i;
	    		nuevo.col=j;
	    		nuevo.dato=leer2("["+i+"]["+j+"]");
	    		nuevo.sgte=a;
	    		a=nuevo;

	    	}
	    }
	    return(a);
	}
	public static void listado(String h, matriz a,int f, int c)
	{
		System.out.println(h);
		for(int i=0;i<f;i++)
		{
			for(int j=0;j<c;j++)
			{
				System.out.print(buscar(a,i,j)+"\t");
			}
			System.out.println();
		}
	}
	public static double buscar(matriz a,int fi,int cj) {
		while(a!=null && (a.fi!=fi || a.col!=cj)) {
			a=a.sgte;
		}
		return (a.dato);
	}
	public static double sumaTraza (matriz a)
	{
		double sum=0;
		while(a!=null)
		{
			if(a.fi==a.col)
			{
				sum+=a.dato;
			}
			a=a.sgte;
		}
		return sum;
	}
	public static matriz inversa(matriz a,int f) {
		matriz aux=null,b=null,inv=null,au2=null,au3=a;
		double qi=0;
		for(int i=1;i<=f;i++) {
			if(b!=null) {
				au3=null;
				au3=multiplicar(a,b,f,f,f);
			}
			qi=(sumaTraza(au3))/i;
			aux=null;
			aux=resta(au3,qi);
		if(i!=f) {
				b=null;
				b=aux;
		}
		}
		double det=det(f,qi);
		if(det==0) {
			System.out.println("Determinante igual a 0");
		}else {
			det=(1/det)*Math.pow((-1), (f-1));
			while(b!=null) {
				au2=new matriz();
				au2.fi=b.fi;
				au2.col=b.col;
				au2.dato=det*b.dato;
				au2.sgte=inv;
				inv=au2;
				b=b.sgte;
			}
		}
		return inv;
	}
	public static matriz resta(matriz a, double qi) {
		matriz aux=null,au2=null;
		while(a!=null) {
			au2=new matriz();
			au2.fi=a.fi;
			au2.col=a.col;
			if(au2.fi==au2.col) {
				au2.dato=a.dato-qi;
			}else {
				au2.dato=a.dato;
			}
			au2.sgte=aux;
			aux=au2;
			a=a.sgte;
		}
		return aux;
	}
	public static double det(int f,double qi) {
		return((Math.pow((-1), (f-1)))*qi);
	}
	public static matriz multiplicar(matriz a, matriz b, int f,int c1, int c)
	{
		matriz R=null, nuevo=null;
		double s=0;
		for(int i=0;i<f;i++)
		{
			for(int j=0;j<c;j++)
			{
				s=0;
				for(int k=0;k<c1;k++)
				{
					s=s+buscar(a,i,k)*buscar(b,k,j);
				}
			    nuevo=new matriz();
			    nuevo.dato=s;
			    nuevo.fi=i;
			    nuevo.col=j;
			    nuevo.sgte=R;
			    R=nuevo;
			}
		}
		return(R);
	}
}