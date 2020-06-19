/* 2.- Escriba un programa que verifique si un número es primo emplear una función.
 */
import javax.swing.*;
import java.util.*;
public class Ejercicio2 {
	static Scanner in=new Scanner(System.in);
	public static void main (String[] x){
		System.out.printf("Ingrese un numero: ");
		int num=in.nextInt();
		if(Primo(num))
			System.out.printf("Es un numero primo");
		else 
			System.out.printf("No es un numero primo");
	}
	public static boolean Primo(int num) {
		 int c=0;
	        for(int i=1; i <= num; i++){
	            if((num% i) == 0)
	                c++;
	        }
	        if(c<=2)
	            return true;
	        else
	            return false;
	}
}
