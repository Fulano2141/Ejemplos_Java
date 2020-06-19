import java.io.*;

public class listas1 {
	public static class nodo {
		int dato;
		nodo sgte;
	}

	public static class persona {
		String nombre;
		persona sgte;
	}

	public static void main(String[] args) throws IOException {
		nodo cab = null, cabb = null, cabcola = null;
		persona p = null;
		boolean b;
		int op, x;
		do {
			op = leer(
					"**listas**\n1.Agregar nodo\n2.Listado\n3.contar nodos.4. Agregar personas \n5. intercambiar nodos\n 10.Salir");
			// \n4.Dividir lista\n 5. Agregar cola 10. Salir");

			switch (op) {
				case 1:
					cab = adicionar_nodo(cab);
					break;
				case 2:
					listado(cab);
					break;
				case 3:
					// MARIANA CARDOZO COSTA
					x = leer("Ingrese un dato: ");
					b = encontrar_x(cab, x);
					if (b) {
						System.out.println("ELEMENTO ENCONTRADO");
					} else {
						System.out.println("ELEMENTO NO ENCONTRADO");
					}
					break;
				case 4:

					p = agregar_persona(p);
					listado2("Lista de personas", p);
					break;
				case 5:
					if (contar_nodos(cab) < 3) {
						System.out.println("no se puede");
					} else {
						intercambiar(cab);
					}

					break;
				case 6:
					break;
			}
		} while (op != 10);

	}

	public static void intercambiar(nodo c) {
		nodo m, w, x;
		m = c.sgte;
		c.sgte = c.sgte.sgte;
		x = c;
		w = c;
		while (x.sgte != null) {
			w = x;
			x = x.sgte;
		}
		x.sgte = c.sgte;
		c.sgte = x;
		w.sgte = m;
		m.sgte = null;
	}

	public static void listado2(String z, persona k) {
		System.out.println(z);
		while (k != null) {
			System.out.println("Nombre=" + k.nombre);
			k = k.sgte;
		}
	}

	public static persona agregar_persona(persona z) throws IOException {
		persona nuevo, copia;
		nuevo = new persona();
		nuevo.nombre = leer2("Nombre? ");
		nuevo.sgte = null;
		if (z == null) {
			z = nuevo;
		} else {
			copia = z;
			while (copia.sgte != null) {
				copia = copia.sgte;
			}
			copia.sgte = nuevo;
		}
		return (z);
	}

	public static boolean encontrar_x(nodo cab, int x) {
		boolean b = false;
		while (cab != null) {
			if (cab.dato == x) {
				b = true;
			}
			cab = cab.sgte;
		}
		return b;
	}

	public static nodo agregar_cola(nodo z) throws IOException {
		nodo nuevo, copia;
		nuevo = new nodo();
		nuevo.dato = leer("Dato para el nuevo nodo ");
		nuevo.sgte = null;
		if (z == null) {
			z = nuevo;
		} else {
			copia = z;
			while (copia.sgte != null) {
				copia = copia.sgte;
			}
			copia.sgte = nuevo;
		}
		return (z);
	}

	public static nodo dividir_lista(nodo z) {
		nodo p;
		int r = contar_nodos(z);
		System.out.println("Total de nodos " + r);
		for (int i = 1; i < r / 2; i++)
			z = z.sgte;
		p = z.sgte;
		System.out.println("nueva cabecer " + p.dato);
		z.sgte = null;
		return (p);
	}

	public static int contar_nodos(nodo k) {
		int c = 0;
		while (k != null) {
			c++;
			k = k.sgte;
		}
		return (c);
	}

	public static void listado(nodo k) {
		while (k != null) {
			System.out.println("dato=" + k.dato);
			k = k.sgte;
		}
	}

	public static nodo adicionar_nodo(nodo c) throws IOException {
		nodo nuevo = new nodo();
		nuevo.dato = leer("dato para el nuevo nodo?");
		nuevo.sgte = c;
		return (nuevo);
	}

	public static String leer2(String t) throws IOException {
		BufferedReader h = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(t);
		String p1 = h.readLine();
		return (p1);
	}

	public static int leer(String t) throws IOException {
		BufferedReader h = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(t);
		int p = Integer.parseInt(h.readLine());
		return (p);
	}
}