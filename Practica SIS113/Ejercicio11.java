/* 11. Dadas las edades y alturas de n alumnos, mostrar la edad y la estatura media, la 
 *  cantidad de alumnos mayores de 18 años, y la cantidad de alumnos que miden más de 1.75 cm
 */
import java.util.Scanner;
public class Ejercicio11 {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int n,altu,edad,altume=0,edadme=0;
		System.out.println("Ingrese la cantidad de alumnos: ");
		n=in.nextInt();
		int[][] vec = new int[n][2];
		for(int i=0;i<n;i++) {
			System.out.println("Ingrese la edad: ");
			edad=in.nextInt();
			System.out.println("Ingrese la estatura(en cm): ");
			altu=in.nextInt();
			vec[i][0]=edad;
			vec[i][1]=altu;
			altume+=altu;
			edadme+=edad;
		}
		altume=altume/n;
		edadme=edadme/n;
		int mayoed=0,masaltu=0;
		for(int i=0;i<n;i++) {
			if(vec[i][0]>18)
				mayoed++;
			if(vec[i][1]>175)
				masaltu++;
		}
		System.out.println("La edad media es: "+edadme);
		System.out.println("La estatura media es: "+altume);
		System.out.println("Numero de personas mayores de edad: "+mayoed);
		System.out.println("Numero de personas con altura mayor a 175[cm]: "+masaltu);
		System.out.println("      Edad     Altura");
		for(int i=0;i<n;i++){
			System.out.println((i+1)+"      "+vec[i][0]+"     "+vec[i][1]);
		}
		
	}
}
