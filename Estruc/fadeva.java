import java.io.*;
import java.text.*;

public class fadeva {

	 public static class nodo {
	  double dato;
	  int fila, columna;
	  nodo sgte;
	 }
	 
	 public static void main(String[] Arg) throws IOException {
	   nodo z=null;
	   int k=(int)leer("Tamaño de la matriz: ");
	   for(int i=1;i<=k;i++){
	     for(int j=1;j<=k;j++){
	       nodo nuevo=new nodo();
	       nuevo.dato=leer("Dato?: "+i+" "+j);
	       nuevo.fila=i;
	       nuevo.columna=j;
	       nuevo.sgte=null;
	       z=add_final(z,nuevo);
	     }
	   }
	   System.out.println("Matriz original");
	   listado(z,k);
	        nodo b=identidad(k);
	        double i=1;
	        nodo aux=new nodo();
	        double q;
	        do{
	            double n=1.0/i;
	            nodo a=multiplica(z,b,k);
	            q=n*traza(a);
	            b=suma(a,q,k);
	            if(nulo(b))
	            {
	                if(i==1)
	                {
	                 aux=z;
	                }
	               break;
	            }
	            aux=b;
	            i++;
	        }while(true);
	        System.out.println("La inversa de la matriz es:");
	        leer1(aux,k,q);
	        //System.out.println(q);
	 }
	public static boolean nulo(nodo cab)
	    {
	        boolean f=true;
	        while(cab!=null)
	        {
	            if(cab.dato!=0)
	            {
	                f=false;
	                break;
	            }
	            cab=cab.sgte;
	        }
	        return f;

	    }
	public static nodo suma(nodo a,double q,int dim)
	{
	    nodo cab1=null;
	    nodo z=new nodo();
	    for(int i=1;i<=dim;i++)
	    {
	        for(int j=1;j<=dim;j++)
	        {
	            z=new nodo();
	            z.dato=buscar(a,i,j)-q*(i==j?1:0);
	            z.fila=i;
	            z.columna=j;
	            z.sgte=cab1;
	            cab1=z;
	        }
	    }
	    return cab1;
	}

	public static nodo identidad(int k){
	  nodo y=null;
	  for(int i=1;i<=k;i++){
	    nodo aux=new nodo();
	    aux.dato=1;
	    aux.fila=i;
	    aux.columna=i;
	    aux.sgte=null;
	    y=add_final(y,aux);
	  }
	  return y;
	}


	public static void leer1(nodo cab,int dim,double q)
	    {
	        DecimalFormat decimales = new DecimalFormat("0.0000");
	        for(int i=1;i<=dim;i++)
	        {
	            for(int j=1;j<=dim;j++)
	            {
	                double m=buscar(cab,i,j);
	                System.out.print(decimales.format(m==0?0.00:m/q)+"\t");
	            }
	            System.out.println();
	        }
	    }
	 public static nodo copia(nodo cab){
	  nodo cabn=null, aux;
	  while(cab!=null){
	   aux=new nodo();
	   aux.dato=cab.dato;
	   aux.fila=cab.fila;
	   aux.columna=cab.columna;
	   aux.sgte=null;
	   cabn=add_final(cabn,aux);
	   cab=cab.sgte;
	  }
	  return cabn;
	 }
	  public static double leer(String x) throws IOException{
	  
	  BufferedReader s= new BufferedReader(new InputStreamReader(System.in));
	  System.out.println(x);
	  double r = Double.parseDouble(s.readLine());
	  return r;
	 }
	public static nodo nuevo() throws IOException{
	  nodo p = new nodo();
	  p.dato=leer("Ingrese Dato");
	  p.sgte=null;
	  
	  return p;
	 }

	public static void listado(nodo c,int g){
	  if(c==null){
	   System.out.println("lista vacia");
	  }
	  int k=0;
	  while(c!=null){
	   System.out.print(c.dato+"\t");
	   c=c.sgte;
	   k++;
	   if(k==g){
	   System.out.print("\n");
	   k=0;
	   }
	   
	  }
	  System.out.println(" ");
	 }
	public static double sacar_dato(nodo cab, int f, int col){
	  double r=0;
	  if(cab!=null){
	    while(cab!=null){
	     if((cab.fila==f)&&(cab.columna==col)){
	      r=cab.dato;
	      break;}
	     }
	  }
	  return r;
	}
	public static nodo add_final(nodo c, nodo nuevo){
	  nodo aux=c;
	  nuevo.sgte=null;
	  if(c==null){
	    c=nuevo;
	  }
	  else{
	    while(aux.sgte!=null){
	      aux=aux.sgte;
	    }
	    aux.sgte=nuevo;
	  }
	  return(c);
	 }
	public static double traza(nodo cab){
	  double s=0;
	  while(cab!=null){
	    if(cab.fila==cab.columna){
	    s+=cab.dato;
	    }
	    cab=cab.sgte;
	  }
	  return s;
	}
	public static boolean verificar_lleno(nodo cab){
	 boolean r=false;
	 while((cab!=null)){
	  if(cab.dato!=0){
	   r=true;
	   break;
	  }
	  cab=cab.sgte;
	 }
	 return r;
	}
	public static nodo multiplica(nodo a,nodo b,int grado)
	{
	    nodo cab=null, aux=new nodo();
	    for(int i=1;i<=grado;i++)
	    {
	        for(int j=1;j<=grado;j++)
	        {
	            double s=0;
	            for(int k=1;k<=grado;k++)
	            {
	                s+=buscar(a,i,k)*buscar(b,k,j);
	            }
	            aux=new nodo();
	            aux.dato=Math.round(s*100)/100;
	            aux.fila=i;
	            aux.columna=j;
	            aux.sgte=null;
	            cab=add_final(cab,aux);
	        }
	    }
	    return cab;
	}
	public static double buscar(nodo cab,int i,int j)
	{
	    double r=0;
	    while(cab!=null)
	    {
	        if(cab.fila==i&&cab.columna==j)
	        {
	            r=cab.dato;
	            break;
	        }
	        cab=cab.sgte;
	    }
	    return r;
	}
	public static nodo resta(nodo a, double q){
	 nodo nueva=null; 
	 while(a!=null){
	         nodo aux=new nodo();
	  if(a.fila==a.columna){
	   aux.dato=a.dato-q;
	  }
	  else
	  {
	          aux.dato=a.dato;
	  }
	  aux.sgte=null;
	  nueva=add_final(nueva, aux);
	  a=a.sgte;
	 }
	 return nueva;
	}
	
	}
