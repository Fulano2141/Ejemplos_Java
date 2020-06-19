
import java.util.Scanner;

public class Division {

	public static class polinomio{
		int coef ;
		int expo;
		polinomio sig;
	}
	public static void main(String[] args) {
		polinomio A=null;
		polinomio B=null;
		polinomio F=null;
		polinomio C,D;
		
		int g1,g2;

		int opcion;
		System.out.println("\nESCOJA UNA OPCION: \n\n");
		do {
			System.out.println(""
					+ "1. Crear polinomio a \n"
					+ "2. Crear polinomio b  \n"
					+ "3. Listado del polinomio a \n"
					+ "4. Listado del polinomio b \n"
					+ "5. Division a/b=c \n"
					+ "0. Salir\n");

			
			
			opcion = leer("opcion");
			switch (opcion) {
			case 1:
				do{
					g1=leer("GRADO DEL POLINOMIO A");
					
				}while(g1<=0);
				A=crear_poli(g1);
				System.out.println("\n");
				break;
				
			case 2:
				do{
					g2=leer("GRADO DEL POLINOMIO B");
					
				}while(g2<=0);
				B=crear_poli(g2);
				System.out.println("\n");
				break;
				
			case 3:
				System.out.println("POLINOMIO A ");
				listado_polinomio(A);
				System.out.println("\n");
				break;
				
			case 4:
				System.out.println("POLINOMIO B ");
				listado_polinomio(B);
				System.out.println("\n");
				break;
				
			case 5:
				C=null;
				D=null;
				C=division(A,B,C,D);
				F=limpiar_expo(C);
				System.out.println("COCIENTE A/B ");
				listado_polinomio(F);
				System.out.println("\n");
				break;	
			case 6:
				F=limpiar_expo(A);
				listado_polinomio(F);
			case 0: 
				System.exit(0);
				break;

			}
		} while (opcion != 0);


	}
	
	public static polinomio crear_poli (int m){
		
		polinomio p = null, aux;
		int t;
		
		for(int i =0; i<=m; i++ ){
			t=leer("Coeficiente de x "+i);
			if(t!=0){
				aux=new polinomio();
				aux.coef=t;
				aux.expo=i;
				aux.sig=p;
				p=aux;
			}
		}
		return p;
	}
	
	public static int leer(String msg) {
		Scanner lee = new Scanner(System.in);
		System.out.println(msg);
		return lee.nextInt();

	}
	
	public static void listado_polinomio(polinomio z){
		if(z!=null){
			while(z!=null){
				if(z.expo>0){
					System.out.print(z.coef +"x"+z.expo+" + ");
				}
				else{
					
				
					if(z.expo<=-1){
						System.out.println("");
					}else{
						System.out.print(z.coef);
					}
				}
				
				z=z.sig;	
			}
		}
		else{
			  System.out.println("Polinomio vacio");
		}
		
	}
	
	public static polinomio division(polinomio A, polinomio B, polinomio C, polinomio D)
	{
		int a=A.expo;
		int b=B.expo;
		int co,e;
		
		if(a>b)
		{
			while(A!=null){
				co=A.coef/B.coef;
				e=A.expo-B.expo;
				C=coeficiente(C,co,e);
				D=multiplicar(C,B);
				D=mult_escalar(D);
				D=suma(A,D);
				A=D;
				A=A.sig;
						
			}
				
		}
		else
		{
			System.out.println("NO SE PUEDE DIVIDIR YA EL EXPONENTE MAXIMO DE A ES MENOR AL EXPONENTE DE B ...");
		}
		
		
		return C;
	}
	
	public static polinomio limpiar(polinomio C){
		polinomio copia=null;
		copia=C;
		while(copia!=null){
			if(copia.coef==0){
				copia=copia.sig;
			}else{
				copia=copia.sig;
			}
		}
		return C;
	}
	public static polinomio limpiar_expo(polinomio C){
		polinomio n=null;
		n=C;
		while(n!=null){
			
			if(n.expo<=-1){
				System.out.println("Exponente:"+n.expo+"\n");
				n.sig=null;
			}
			
				n=n.sig;;
			
		}
		return C;
	}
	
	
	public static polinomio coeficiente (polinomio C, int co, int e){
		
		polinomio x;
		polinomio nuevo = new polinomio();		
		nuevo.coef=co;
		nuevo.expo=e;
		nuevo.sig=null;
		
		if(C == null)
		{
			C=nuevo;
		}
		else
		{
			x=C;
			for(;x.sig !=null;)
			{
				x=x.sig;
			}
			x.sig=nuevo;
		}
		
		return C;
	}
	public static polinomio multiplicar(polinomio cab,polinomio cabb){
		 polinomio auxa = cab, auxb = null, c = null;
	        int coe,ex;
	        while (auxa != null) {
	            auxb = cabb;
	            while (auxb != null) {
	               
	                coe=auxa.coef*auxb.coef;
	                ex=auxa.expo+auxb.expo;
	                c=coeficiente(c,coe,ex);
	                auxb = auxb.sig;              
	            }
	            auxa = auxa.sig;
	        }
	        return c;
	}
	public static polinomio mult_escalar(polinomio p){
		int esc=(-1);
		polinomio c=null;
		c=p;
		while(c!=null){
			c.coef=c.coef*esc;
			c=c.sig;
		}
		return p;
	}
	public static polinomio suma(polinomio cab, polinomio cabb) {
		 polinomio auxa = cab, auxb = null, c = null;
	        int coe = 0,ex = 0;
	        while (auxa != null) {
	            auxb = cabb;
	            while (auxb != null) {
	            	//coe=0;
	               if(auxa.expo==auxb.expo){
	            	   coe=auxa.coef+auxb.coef;
	            	   ex=auxa.expo;
	            	   auxa.coef=coe;
	               }
	               else{
	            	   coe=auxa.coef;
	            	   ex=auxa.expo;
	               }
	              
	                auxb = auxb.sig;              
	            }
	            c=coeficiente(c,coe,ex);
	            auxa = auxa.sig;
	        }
	        return c;
	}
}
