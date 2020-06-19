import java.io.*;

public class Pasanaco {
	public static class circular {
		String nombre;
		circular sgte;
	}

	public static void main(String[] args) throws IOException {
		circular cabc = null;
		int op;
		// int n, x;
		do {
			menu();
			op = leer("?");
			switch (op) {
				case 1:
					cabc = add_nodos_circular(cabc);
					break;
				case 2:
					listado("\nDatos de la lista ", cabc);
					break;
				case 3:
					if (cabc != null) {
						cabc = pasa(cabc);
						System.out.println("Ganador: " + cabc.nombre);
					}
					break;
			}
		} while (op != 10);
	}

	public static circular pasa(circular c) {
		int nm = (int) (Math.random() * (tamano(c)) + 1);
		for (int i = 1; i < nm; i++) {
			c = c.sgte;
		}
		return (c);
	}

	public static int tamano(circular c) {
		circular z = c;
		int i = 0;
		if (c != null) {
			do {
				i++;
				z = z.sgte;
			} while (z != c);
		}
		return i;
	}

	public static void listado(String h, circular c) {
		circular z = c;
		if (c != null) {
			do {
				System.out.print(z.nombre + "\t");
				z = z.sgte;
			} while (z != c);
		}
	}

	public static void menu() {
		System.out.println("\n***Listas circulares ****");
		System.out.println("1.- Lectura");
		System.out.println("2.- Listado");
		System.out.println("3.- Pasanaku");
		System.out.println("10.- Salir");
	}

	public static circular add_nodos_circular(circular x) throws IOException {
		circular aux = new circular();
		circular z;
		aux.nombre = leers("Nombre?");
		aux.sgte = aux;
		if (x == null)
			x = aux;
		else {
			z = x;
			while (z.sgte != x)
				z = z.sgte;
			z.sgte = aux;
			aux.sgte = x;
		}
		return (x);
	}

	public static String leers(String z) throws IOException {
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(z);
		String r = s.readLine();
		return (r);
	}

	public static int leer(String z) throws IOException {
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(z);
		int r = Integer.parseInt(s.readLine());
		return (r);
	}
}
