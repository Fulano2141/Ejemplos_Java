import java.util.Scanner;

public class Main
{

	static short N, E;
	static String [] nombresN, relacionesE;
	static float [] datosN;
	static float promedio;

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args)
	{	
		
		datosNumericos();
		
		nombresN = new String [N];
		relacionesE = new String [E];
		datosN = new float [N];
		
		amigos();
		
		relaciones();
		
		promedio = promedio();
		
		if(promedio >= 4.5)
		{
			
			System.out.println("LO LOGRARAS");
			
		}
		else
		{
			
			System.out.println("QUEDATE EN TU ANTIGUA CASA");
			
		}

	}
	
	static void datosNumericos()
	{	
		
		do
		{
			
			System.out.println("Ingrese N y E");
			
			N = scanner.nextShort();
			
			E = scanner.nextShort();
			
		}
		while(N < 3 || N > 1000);
		
	}
	
	static void amigos()
	{
		
		for(int i = 0; i < datosN.length; i ++)
		{
			
			System.out.println("Ingrese el nombre y puntaje de su amigo");
			
			nombresN [i] = scanner.next();
			
			datosN [i] = scanner.nextFloat();
			
		}
		
	}
	
	static void relaciones()
	{
		
		for(int i = 0; i < relacionesE.length; i ++)
		{
			
			System.out.println("Ingrese el nombre de la presona relacionada");
			
			relacionesE [i] = scanner.next();

		}
		
	}
	
	static float promedio()
	{
		
		float contador = 0;
		
		for(int i = 0; i < datosN.length; i ++)
		{
			
			contador += datosN [i];
			
		}
		
		return (contador/datosN.length);
		
	}

}
