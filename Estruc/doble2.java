import java.io.*;

public class doble2 {
	public static class doble {
		int dato;
		doble sgte, ant;
	}

	public static void main(String[] args) throws IOException {
		doble cab_d = null, cab_i = null;
		doble nuevo = null;
		int op, op2;
		int A = 0, B = 0;
		do {
			menu1();
			op = leer("?");
			switch (op) {
			case 1:
				int datos = leer("Cuantos datos desea ingresar?");
				for (int i = 1; i <= datos; i++) {
					nuevo = new doble();
					nuevo.dato = leer("Dato?");
					nuevo.sgte = null;
					nuevo.ant = null;
					if (cab_d == null) {
						cab_d = nuevo;
						cab_i = nuevo;
					} else {
						menu2();
						op2 = leer("?");
						if (op2 == 1) {
							cab_d = agregar_d(cab_d, nuevo);
						} else {
							cab_i = agregar_i(cab_i, nuevo);
						}
					}
				}
				break;
			case 2:
				System.out.println("De izquierda a derecha");
				listado_i_d(cab_i);
				break;
			case 3:
				System.out.println("De derecha a izquierda");
				listado_d_i(cab_d);
				break;
			case 4:
				agregar_centro(cab_i, cab_d);
			}
		} while (op != 10);

	}

	@SuppressWarnings("null")
	public static void agregar_centro(doble cab_i, doble cab_d) throws IOException {
		doble aux1 = null, aux2 = null;
		int dato = leer("?");
		aux1.dato = dato;
		aux1.ant = null;
		aux1.sgte = null;
		aux2.dato = dato;
		aux2.ant = null;
		aux2.sgte = null;
		if (cab_i != null && cab_d != null) {
			while (cab_d.sgte != null) {
				aux1 = agregar_d(aux1, cab_d);
				cab_d = cab_d.sgte;
			}
			while (cab_i.sgte != null) {
				aux2 = agregar_d(aux2, cab_i);
				cab_i = cab_i.sgte;
			}
		}
		listado_i_d(aux1);
		listado_d_i(aux2);
	}

	public static void listado_d_i(doble cab) {
		while (cab != null) {
			System.out.print(cab.dato + "\t");
			cab = cab.ant;
		}
		System.out.println();
	}

	public static void listado_i_d(doble cab) {
		while (cab != null) {
			System.out.print(cab.dato + "\t");
			cab = cab.sgte;
		}
		System.out.println();
	}

	public static doble agregar_i(doble cab, doble n) {
		n.sgte = cab;
		cab.ant = n;
		cab = n;
		return cab;
	}

	public static doble agregar_d(doble cab, doble n) {
		cab.sgte = n;
		n.ant = cab;
		cab = n;
		return cab;
	}

	public static void menu2() {
		System.out.println("Agregar:");
		System.out.println("1.- Por derecha");
		System.out.println("2.- Por la izquierda");
	}

	public static void menu1() {
		System.out.println("***LISTA DOBLEMENTE ENLAZADAS***");
		System.out.println("1.- Agregar nodos");
		System.out.println("2.- Listado i_d");
		System.out.println("3.- Listado d_i");
		System.out.println("4.- Agregar nodo en centro");
		System.out.println("10.- Salir");
	}

	public static int leer(String p) throws IOException {
		BufferedReader y = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(p);
		int r = Integer.parseInt(y.readLine());
		return (r);
	}

	public static boolean buscar(doble a, int dato) {
		boolean flag = false;
		while (a != null) {
			if (dato == a.dato) {
				flag = true;
				break;
			}
			a = a.sgte;
		}
		return flag;
	}

	public static doble Union(doble A, doble B, doble C) {
		doble aux = null, aux1 = null;
		aux = A;
		while (B != null) {
			aux1 = A;
			while (aux1 != null) {
				if (B.dato == aux1.dato && buscar(aux, B.dato) == false) {
					aux = agregar(aux, B.dato);
				}
				aux1 = aux1.sgte;
			}
			B = B.sgte;
		}
		while (C != null) {
			aux1 = C;
			while (aux1 != null) {
				if (C.dato == aux1.dato && buscar(aux, C.dato) == false) {
					aux = agregar(aux, C.dato);
				}
				aux1 = aux1.sgte;
			}
			C = C.sgte;
		}
		return aux;
	}

	public static doble UnionA_B(doble A, doble B) {
		doble aux = null, aux1 = null;
		aux = A;
		while (B != null) {
			aux1 = A;
			while (aux1 != null) {
				if (B.dato == aux1.dato && buscar(aux, B.dato) == false) {
					aux = agregar(aux, B.dato);
				}
				aux1 = aux1.sgte;
			}
			B = B.sgte;
		}
		return aux;
	}

	public static doble Interseccion(doble A, doble B) {
		doble aux = null, aux1 = null;
		while (A != null) {
			aux1 = B;
			while (aux1 != null) {
				if (A.dato == aux1.dato && buscar(aux, A.dato) == false) {
					aux = agregar(aux, B.dato);
				}
				aux1 = aux1.sgte;
			}
			A = A.sgte;
		}
		return aux;
	}

	public static doble diferencia_S(doble A, doble B) {
		doble aux = null, aux1 = null, aux2 = Interseccion(A, B);
		while (A != null) {
			aux1 = B;
			while (aux1 != null) {
				if (A.dato != aux1.dato && buscar(aux2, A.dato) == false) {
					aux = agregar(aux, B.dato);
				}
				aux1 = aux1.sgte;
			}
			A = A.sgte;
		}
		return aux;
	}

	public static doble diferencia_L(doble A, doble B) {
		doble aux = null, aux1 = null;
		while (A != null) {
			aux1 = B;
			while (aux1 != null) {
				if (A.dato != aux1.dato && buscar(B, A.dato) == false) {
					aux = agregar(aux, B.dato);
				}
				aux1 = aux1.sgte;
			}
			A = A.sgte;
		}
		return aux;
	}

	public static doble agregar(doble c, int dato) {
		doble aux = null;
		aux.dato = dato;
		aux.sgte = c;
		c = aux;
		return c;
	}

}
