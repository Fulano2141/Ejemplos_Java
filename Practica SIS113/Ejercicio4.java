/* 4.- Escribir un programa que permita adivinar un número que sea genere 
 * internamente al azar (Math.Random), el cual está en el rango entre a y b.
 * El usuario debe adivinar este número en base a aproximaciones, para lo 
 * cual se dispone de  n  intentos. Veamos un ejemplo: 
 * Supongamos que el número “pensado” por la computadora sea el 33 en el intervalo 0 a 50, en 5 intentos.
 */
import java.util.Scanner;
public class Ejercicio4 {
	static Scanner in=new Scanner(System.in);
	public static void main (String[] x){
	int limit=50,usrInput, i=1,aprox=0;
	int valRandom=(int)(Math.random()*50)+1;
	System.out.println("Estoy pensando un numero entre 0 y 50");
	System.out.println("Ingrese numero: ");
	do{
		System.out.printf("Intento "+i+": ");
		usrInput=in.nextInt();
		if(usrInput>aprox && usrInput<valRandom){
			aprox=usrInput;
		}
		else{
			if(usrInput>valRandom)
			{
			limit=usrInput;
			}
		}		
		if(usrInput==valRandom)			
			System.out.printf("Felicitaciones Adivinaste, el ");
		else
			System.out.println("\nEl numero esta entre "+aprox+" y "+limit+" \n");
		i++;}
	while(i<=5 && usrInput!=valRandom);
	System.out.println("Numero generado es: "+valRandom);	
	}
}
