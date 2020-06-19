import java.io.*;
public class ej {
public static class alumno{
	String nombre;
	int carnet;
	alumno sgte;
}
public static class nota{
	String asig;
	int carnet;
	int calif;
	nota sgte;
}
public static void main(String[] args) throws IOException  {
	int opc;
	alumno als=null;
	nota notas=null;
	do {
		menu();
		opc=leer();
		switch(opc) {
		case 1:
			als=agregar(als);
			break;
		case 2:
			notas=ag_not(notas);
			break;
		case 3:
			ordenar(als);
			break;
		case 4:
			listado(als);
			break;
		case 5:
			obtener(als,notas);
		}
	}while(opc!=6);
}
public static int leer() throws IOException {
	BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
return(Integer.parseInt(buf.readLine()));
}
public static String leer2() throws IOException {
	BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
return(buf.readLine());
}
public static void menu() {
	System.out.println("MENU");
	System.out.println("1. Añadir estudiante");
	System.out.println("2. Añadir nota");
	System.out.println("3. Ordenar estudiantes");
	System.out.println("4. Lista de estudiantes");
	System.out.println("5. Obtener calificaciones de estudiante");
	System.out.println("6. Salir");
}
public static alumno agregar(alumno x) throws IOException {
	alumno aux=new alumno();
	System.out.println("Nombre?");
	aux.nombre=leer2();
	System.out.println("Número de carnet?");
	aux.carnet=leer();
	aux.sgte=x;
	x=aux;
	return x;
}
public static nota ag_not(nota x) throws IOException {
	nota aux=new nota();
	System.out.println("Número de carnet?");
	aux.carnet=leer();
	System.out.println("Asignatura?");
	aux.asig=leer2();
	System.out.println("Nota?");
	aux.calif=leer();
	aux.sgte=x;
	x=aux;
	return x;
}
public static void listado(alumno x) {
	while(x!=null) {
		System.out.println("Nombre: "+x.nombre+" Carnet: "+x.carnet);
		x=x.sgte;
	}
}
public static void ordenar(alumno x) {
	alumno c=null, aux=null;
	while(x!=null) {
		c=x;
		while(c!=null) {
		if(c.nombre.compareTo(x.nombre)<0) {
			aux=new alumno();
			aux.nombre=c.nombre;
			aux.carnet=c.carnet;
			c.nombre=x.nombre;
			c.carnet=x.carnet;
			x.nombre=aux.nombre;
			x.carnet=aux.carnet;
		}
		c=c.sgte;
	}
		x=x.sgte;
	}
}
public static void obtener (alumno x, nota y) throws IOException {
	System.out.println("Nombre?");
	String o=leer2();
	int car=-1;
	while(x!=null) {
		if (o.equals(x.nombre)) {
			car=x.carnet;
			System.out.println("Alumno: "+x.nombre+" Carnet: "+car);
		}
		x=x.sgte;
	}
	if(car==-1) {
		System.out.println("No existe el estudiante ingresado");
	}else {
	while(y!=null) {
		if(car==y.carnet) {
			System.out.println("Asignatura : "+y.asig+" Calificación: "+y.calif);
		}
		y=y.sgte;
	}
	}
}
}