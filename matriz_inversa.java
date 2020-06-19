import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
public class matriz_inversa {
	public static class matriz {
		double dato;
		int fila; 
		int columna;
		matriz sgte;
	}
	public static void main(String[] Arg) throws IOException {
		matriz z=null;
		int k=(int)leer("Tamaño de la matriz: ");
		for(int i=1;i<=k;i++){
			for(int j=1;j<=k;j++){
				matriz nuevo=new matriz();
				nuevo.dato=leer("Dato ["+i+"]["+j+"]:");
				nuevo.fila=i;
				nuevo.columna=j;
				nuevo.sgte=null;
				z=add_final(z,nuevo);
			}
		}
		System.out.println("Matriz original");
		listado(z,k);
		matriz b=identidad(k);
		double i=1;
		matriz aux=new matriz();
		double q;
		do{
			double n=1.0/i;
			matriz a=multiplica(z,b,k);
			q=n*traza(a);
			b=suma(a,q,k);
			if(nulo(b)){
				if(i==1){
					aux=z;
				}
				break;
			}
			aux=b;
			i++;
		}while(true);
		System.out.println("La inversa de la matriz es:");
		leer(aux,k,q);
	}
	public static boolean nulo(matriz cab){
		boolean f=true;
		while(cab!=null){
			if(cab.dato!=0){
				f=false;
				break;
			}
			cab=cab.sgte;
		}
		return f;
	}
	public static matriz suma(matriz a,double q,int dim){
		matriz cab1=null;
		matriz z=new matriz();
		for(int i=1;i<=dim;i++){
			for(int j=1;j<=dim;j++){
				z=new matriz();
				z.dato=buscar(a,i,j)-q*(i==j?1:0);
				z.fila=i;
				z.columna=j;
				z.sgte=cab1;
				cab1=z;
			}
		}
		return cab1;
	}	
	public static matriz identidad(int k){
		matriz y=null;
		for(int i=1;i<=k;i++){
			matriz aux=new matriz();
			aux.dato=1;
			aux.fila=i;
		    aux.columna=i;
		    aux.sgte=null;
		    y=add_final(y,aux);
		}
		return y;
	}
	public static void leer(matriz cab,int dim,double q){
		DecimalFormat decimales = new DecimalFormat("0.00");
		for(int i=1;i<=dim;i++){
			for(int j=1;j<=dim;j++){
				double m=buscar(cab,i,j);
				if(m==0)
					System.out.print("0"+"\t");
				else
					System.out.print(decimales.format(m/q)+"\t");
			}
			System.out.println();
		}
	}
	public static double leer(String x) throws IOException{	
		BufferedReader s= new BufferedReader(new InputStreamReader(System.in));
		System.out.print(x);
		double r = Double.parseDouble(s.readLine());
		return r;
	}
	public static void listado(matriz cab, int n){ 	
		if(cab==null){
			System.out.println("lista vacia");
		}
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				System.out.print(buscar(cab,i,j)+"\t");
			}
			System.out.println();
		}
	}
	public static matriz add_final(matriz c, matriz nuevo){
		matriz aux=c;
		nuevo.sgte=null;
		if(c==null)
			c=nuevo;
		else{
			while(aux.sgte!=null){
				aux=aux.sgte;
			}
			aux.sgte=nuevo;
		}
		return(c);
	}
	public static double traza(matriz cab){
		double s=0;
		while(cab!=null){
			if(cab.fila==cab.columna){
				s+=cab.dato;
			}
			cab=cab.sgte;
		}
		return s;
	}
	public static matriz multiplica(matriz a,matriz b,int grado){
		matriz cab=null, aux=new matriz();
		for(int i=1;i<=grado;i++){
			for(int j=1;j<=grado;j++){
				double s=0;
				for(int k=1;k<=grado;k++)
					s+=buscar(a,i,k)*buscar(b,k,j);
				aux=new matriz();
				aux.dato=Math.round(s*100)/100;
				aux.fila=i;
				aux.columna=j;
				aux.sgte=null;
				cab=add_final(cab,aux);
			}
		}
		return cab;
	}
	 public static double buscar(matriz cab,int i,int j){ 
		 double p=0;
		 while (cab!=null){  
			 if(cab.fila==i && cab.columna==j){
				 p=cab.dato;
			 }
			 cab=cab.sgte;
		 }
		 return(p);
	 }
}
