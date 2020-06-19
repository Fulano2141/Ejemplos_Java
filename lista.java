import java.io.*;

public class lista {
	public static class nodo {
		int dato;
		nodo sgte;
	}

	public static void main(String arg[]) throws IOException {
		nodo cab = null;
		int opciones, dato1;
		do {
			menu();
			opciones = leer("?");
			switch (opciones) {
			case 1:
				cab = agregar_nodo(cab);
				break;
			case 2:
				listado("Datos de la lista\n", cab);
				break;
			case 3:
				System.out.println(" la sumatoria es " + sumatoria(cab));
				break;
			case 4:
				cab = borrar_cab(cab);
				break;
			case 5:
				borrar_ultimo(cab);
				break;
			case 6:
				dato1 = leer("dato a borrar?");
				cab = borrar_nodo_dato_x(cab, dato1);
				break;
			}
		} while (opciones != 10);
	}

	public static nodo borrar_nodo_dato_x(nodo c, int db) {
		nodo q = null, z = null;
		if (c != null) {
			// analisis cabecera
			while (c.dato == db && c != null) {
				c = borrar_cab(c);
			}
			// lo que queda
			z = c.sgte;
			q = c;
			while (z != null) {
				if (z.dato == db) {
					q.sgte = z.sgte;
					z = q;
				}
				q = z;
				z = z.sgte;
			}
		}
	}

	public static void borrar_ultimo(nodo c) {
		nodo x = c;
		if (c != null && c.sgte != null) {
			while (x.sgte != null) {
				c = x;
				x = x.sgte;
			}
			c.sgte = null;
		}
	}

	public static nodo borrar_cab(nodo c) {
		if (c != null)
			c = c.sgte;
		return (c);
	}

	public static int sumatoria(nodo c) {
		int s = 0;
		while (c != null) {
			s = s + c.dato;
			c = c.sgte;
		}
		return (s);
	}

	public static void listado(String t, nodo c) {
		System.out.println(t);
		while (c != null) {
			System.out.println(c.dato);
			c = c.sgte;
		}
	}

	public static nodo agregar_nodo(nodo c) throws IOException {
		nodo aux = new nodo();
		aux.dato = leer("dato?");
		aux.sgte = c;
		c = aux;
		return (c);
	}

	public static void menu() {
		System.out.println("listas enlazadas");
		System.out.println("1. agregar nodos");
		System.out.println("2. listado");
		System.out.println("3. sumatoria");
		System.out.println("4. Borrar dato de la cabecera");
		System.out.println("5. Borrar ultimo nodo");
		System.out.println("6. borrar nodo con dato x");
		System.out.println("5.salir");
	}

	public static int leer(String t) throws IOException {
		BufferedReader y = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(t);
		int p = Integer.parseInt(y.readLine());
		return (p);
	}
}