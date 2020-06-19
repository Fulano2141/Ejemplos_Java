import java.io.*;

public class listacircular {
	public static class circular {
		int dato;
		circular sgte;
	}

	public static void main(String[] args) throws IOException {
		circular cab = null;
		int op;
		do {
			menu();
			op = leer("?");
			switch (op) {
			case 1:
				cab = add_nodos_circular(cab);
				break;
			case 2:
				listado("\nDatos de la lista ", cab);
				break;
			case 3:
				int dato;
				dato = leer("Dato a buscar");
				buscar(cab, dato);
				break;
			}
		} while (op != 10);
	}

	public static void buscar(circular c, int dato) {
		circular z = c;
		int con = 0;
		boolean dat = false;
		do {
			con++;
			if (z.dato == dato) {
				System.out.println("Dato encontrado en posicion: " + con);
				dat = true;
				break;
			}
			z = z.sgte;
		} while (z != c);
		if (dat == false)
			System.out.println("Dato no encontrado");
	}

	public static void listado(String h, circular c) {
		circular z = c;
		System.out.println(h);
		if (c != null) {
			do {
				System.out.print(z.dato + "\t");
				z = z.sgte;
			} while (z != c);
		}
	}

	public static void menu() {
		System.out.println("\n_______Listas_circulares_______");
		System.out.println("1.- Lectura");
		System.out.println("2.- Listado");
		System.out.println("3.- Buscar");
		System.out.println("10.- Salir");
	}

	public static circular add_nodos_circular(circular x) throws IOException {
		circular aux = new circular();
		circular z;
		aux.dato = leer("Dato para el nodo");
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
		return x;
	}

	public static int leer(String z) throws IOException {
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(z);
		int r = Integer.parseInt(s.readLine());
		return r;
	}
}
