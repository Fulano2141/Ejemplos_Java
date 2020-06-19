import java.io.*;

import javax.swing.JOptionPane;

public class a {
	public static class nodo {
		double dato;
		nodo sgte;
	}

	public static void main(String[] args) throws IOException {
		nodo cab = null, cabb = null, cabcola = null;
		int op;
		do {
			op = leer(
					"**listas**\n1.Agregar nodo\n2.Listado\n3.contar nodos.\n4.Dividir lista\n5. Agregar cola\n6. Media\n7. Mediana\n8. Desviacion media\n9. Ordenar\n 10. Salir");
			switch (op) {
				case 1:
					cab = adicionar_nodo(cab);
					break;
				case 2:
					listado(cab);
					break;
				case 3:
					System.out.println("total de nodos de la lista " + contar_nodos(cab));
					break;
				case 4:
					cabb = dividir_lista(cab);
					listado(cabb);
					break;
				case 5:
					cabcola = agregar_cola(cabcola);
					listado(cabcola);
					break;
				case 6:
					media(cab);
					break;
				case 7:
					mediana(cab);
					break;
				case 8:
					// desviacionmedia(cab);
					break;
				case 9:
					ordenar(cab);
					break;
			}
		} while (op != 10);

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

	public static int leer(String t) throws IOException {
		BufferedReader h = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(t);
		int p = Integer.parseInt(h.readLine());
		return (p);
	}

	public static void media(nodo k) {
		int c = 0;
		double aux = 0;
		while (k != null) {
			c++;
			aux = aux + k.dato;
			k = k.sgte;
		}
		System.out.println(aux / c);

	}

	public static void ordenar(nodo c) {
		nodo copia;
		double aux;
		while (c != null) {
			copia = c;
			while (copia != null) {
				if (c.dato > copia.dato) {
					aux = c.dato;
					c.dato = copia.dato;
					copia.dato = aux;
				}
				copia = copia.sgte;
			}
			c = c.sgte;
		}
	}

	public static void mediana(nodo c) {
		// El algoritmo de mediana deberia ordenar antes de ejecutar el proeso.
		int i, cn = contar_nodos(c);
		double r = 0;
		if (cn % 2 != 0) {
			i = (cn + 1) / 2;
			r = buscar(c, i);
		} else {
			r = (buscar(c, cn / 2) + buscar(c, (cn / 2) + 1)) / 2;

		}
		System.out.println("Mediana: " + r);
	}

	public static double buscar(nodo p, int np) {
		for (int i = 1; i < np; i++) {
			p = p.sgte;
		}
		return p.dato;
	}
	/*
	 * public static void desviacionmedia(nodo k) { int c=0; double aux=0;
	 * while(k!=null) { c++; aux=aux+k.dato; k=k.sgte; } System.out.println(aux/c);
	 * 
	 * }
	 */

}
