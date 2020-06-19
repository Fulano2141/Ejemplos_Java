import java.io.*;

public class PrimerTrabajoPractico {
	public static class nod {
		int dat;
		nod sig;
	}

	public static class nodcon {
		int dat;
		int num;
		nodcon sig;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		nod no1 = null, no2 = null, no3 = null, no4 = null, no5 = null, no6 = null;
		nodcon nodcon1 = null;
		int opc;
		do {
			opc = menu();
			switch (opc) {
				case 1:
					no1 = null;
					int t;
					do {
						System.out.println("Tama�o de lista A:");
						t = lee_ent();
					} while (t <= 0);
					no1 = lec(no1, t);
					break;
				case 2:
					imp(no1);
					break;
				case 3:
					if (no1 == null) {
						System.out.println("Lista vacia");
					} else {
						sum(no1);
					}
					break;
				case 4:
					nodcon1 = null;
					if (no1 == null || no1.sig == null) {
						System.out.println(
								"Deben existir al menos dos datos en la lista para contar los datos repetidos");
					} else {
						rep(nodcon1, no1);
					}
					break;
				case 5:
					if (no1 == null || no1.sig == null) {
						System.out.println("Deben existir al menos dos datos en la lista para realizar la rotaci�n");
					} else {
						no1 = rud(no1);
					}
					break;
				case 6:
					no3 = null;
					no4 = no1;
					no5 = no2;
					if (no4 == null) {
						System.out.println("Lista A vacia");
					} else {
						if (no5 == null) {
							System.out.println("Lista B vacia");
						} else {
							if (no4.sig != null) {
								ord(no4);
							}
							if (no5.sig != null) {
								ord(no5);
							}
							no3 = res_ord(no3, no4, no5);
							System.out.println("Lista resultante: ");
							imp(no3);
						}
					}
					break;
				case 7:
					if (no1 == null) {
						System.out.println("Lista vacia");
					} else {
						int x;
						t = tam(no1);
						do {
							System.out.println("Posicion del dato a eliminar:");
							x = lee_ent();
						} while (x <= 0 || x > t);
						no1 = eli_pos(no1, x);
					}
					break;
				case 8:
					if (no1 == null) {
						System.out.println("Lista vacia");
					} else {
						int x;
						t = tam(no1);
						do {
							System.out.println("Posici�n de dato a agregar:");
							x = lee_ent();
						} while (x <= 0 || x > t + 1);
						no1 = agr_pos(no1, x);
					}
					break;
				case 9:
					if (no1 == null) {
						System.out.println("Lista vacia");
					} else {
						sum_par(no1);
					}
					break;
				case 10:
					no3 = null;
					if (no1 == null) {
						System.out.println("Lista A vacia");
					} else {
						if (no2 == null) {
							System.out.println("Lista B vacia");
						} else {
							no3 = amb(no3, no1, no2);
							System.out.println("Lista resultante: ");
							imp(no3);
						}
					}
					break;
				case 11:
					if (no1 == null) {
						System.out.println("Lista vacia");
					} else {
						max(no1);
					}
					break;
				case 12:
					if (no1 == null) {
						System.out.println("Lista vacia");
					} else {
						dir_max(no1);
					}
					break;
				case 13:
					if (no1 == null || no1.sig == null) {
						System.out.println("Deben existir al menos dos datos en la lista para el intercambio");
					} else {
						mpm(no1);
					}
					break;
				case 14:
					if (no1 == null) {
						System.out.println("Lista vacia");
					} else {
						min(no1);
					}
					break;
				case 15:
					if (no1 == null) {
						System.out.println("Lista vacia");
					} else {
						rem(no1);
					}
					break;
				case 16:
					if (no1 == null) {
						System.out.println("Lista vacia");
					} else {
						pre(no1);
					}
					break;
				case 17:
					if (no1 == null || no1.sig == null) {
						System.out.println("Deben existir al menos dos datos en la lista para realizar la rotaci�n");
					} else {
						no1 = rui(no1);
					}
					break;
				case 18:
					no6 = null;
					int tt1;
					do {
						System.out.println("Tama�o de lista de numeros primos:");
						tt1 = lee_ent();
					} while (tt1 <= 0);
					no6 = lec_pri(no6, tt1);
					System.out.println("Lista de numeros primos:");
					imp(no6);
					break;
				case 19:
					if (no1 == null || no1.sig == null) {
						System.out.println(
								"Deben existir al menos dos datos en la lista para poder realizar el ordenamiento");
					} else {
						ord(no1);
					}
					break;
				case 20:
					if (no1 == null) {
						System.out.println("Lista vacia");
					} else {
						esc(no1);
					}
					break;
				case 21:
					int tri;
					if (no1 == null || no1.sig == null) {
						System.out.println("Deben existir al menos dos datos en la lista para realizar la rotaci�n");
					} else {
						do {
							System.out.println("Numero de posiciones a rotar:");
							tri = lee_ent();
						} while (tri <= 0);
						no1 = rni(no1, tri);
					}
					break;
				case 22:
					int trd;
					if (no1 == null || no1.sig == null) {
						System.out.println("Deben existir al menos dos datos en la lista para realizar la rotaci�n");
					} else {
						do {
							System.out.println("Numero de posiciones a rotar:");
							trd = lee_ent();
						} while (trd <= 0);
						no1 = rnd(no1, trd);
					}
					break;
				case 23:
					no6 = null;
					int to6;
					do {
						System.out.println("Tama�o de lista:");
						to6 = lee_ent();
					} while (to6 <= 0);
					lec_ord(no6, to6);
					break;
				case 24:
					if (no1 == null || no1.sig == null) {
						System.out.println("Deben existir al menos dos datos en la lista para borrar los duplicados");
					} else {
						dup(no1);
					}
					break;
				case 25:
					no2 = null;
					int t2;
					do {
						System.out.println("Tama�o de lista B:");
						t2 = lee_ent();
					} while (t2 <= 0);
					no2 = lec(no2, t2);
					break;
				case 26:
					imp(no2);
					break;
			}
		} while (opc != 27);
	}

	public static int menu() throws IOException {
		System.out.println("MENU");
		System.out.println("1. Lectura de lista A");
		System.out.println("2. Listado de A");
		System.out.println("3. Sumatoria de elementos de A");
		System.out.println("4. Contar elementos repetidos de A");
		System.out.println("5. Rotar elementos de A una posicion a la derecha moviendo direcciones");
		System.out.println(
				"6. Ingresan dos listas ordenadas; unir las dos listas en una sola lista de tal manera que vaya seleccionando los elementos adecuados para obtener la tercer lista tambi�n ordenada sin aplicar un m�todo de ordenaci�n en la tercera lista");
		System.out.println("7. Borrar el elemento en la posicion x");
		System.out.println("8. Adicion de un elemento z en la posicion k de la lista");
		System.out.println("9. Sumar todos los elementos de las posiciones pares de la lista");
		System.out.println("10. Sumar dos listas obteniendo una lista nueva con una funci�n");
		System.out.println("11. Obtener el elemento m�ximo");
		System.out.println("12. Obtener la direcci�n del elemento m�ximo");
		System.out.println("13. Intercambiar el elemento m�ximo con el m�nimo");
		System.out.println("14. Encontrar el elemento m�nimo");
		System.out.println("15. Reemplazar los elementos x de la lista por el elemento y");
		System.out.println("16. Obtener el promedio de elementos pares e impares de la lista");
		System.out.println("17. Rotar los elemento de la lista una posici�n a la izquierda");
		System.out.println("18. Crear una lista con numeros primos");
		System.out.println("19. Ordenar una lista en orden descendente");
		System.out.println("20. Multiplicar un escalar por los elementos de la lista");
		System.out.println("21. Rotar los elementos de la lista n posiciones a la izquierda");
		System.out.println("22. Rotar a la derecha n posiciones los elementos de la lista");
		System.out.println(
				"23. Crear una lista con datos que ingresa el usuario de tal manera que a medida que se ingresan los datos, estos son ubicados en la posici�n adecuada de la lista obteniendo, a meduda que ingresan los datos una lista ordenada");
		System.out.println("24. Borrar los elementos duplicados de la lista");
		System.out.println("25. Lectura de lista B");
		System.out.println("26. Listado de B");
		System.out.println("27. Salir");
		return lee_ent();
	}

	public static int lee_ent() throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		return (Integer.parseInt(buf.readLine()));
	}

	public static nod lec(nod x, int t) throws IOException {
		nod aux = null, au2 = null;
		for (int i = 1; i <= t; i++) {
			System.out.println("Elemento " + i + ":");
			aux = new nod();
			aux.dat = lee_ent();
			aux.sig = null;
			if (x == null) {
				x = aux;
			} else {
				au2 = x;
				while (au2.sig != null) {
					au2 = au2.sig;
				}
				au2.sig = aux;
			}
		}
		return x;
	}

	public static void imp(nod x) {
		int i = 1;
		while (x != null) {
			System.out.println("Dato " + i + ": " + x.dat);
			i++;
			x = x.sig;
		}
	}

	public static void sum(nod x) {
		int sum = 0;
		while (x != null) {
			sum += x.dat;
			x = x.sig;
		}
		System.out.println("Sumatoria de lista = " + sum);
	}

	public static int tam(nod x) {
		int i = 0;
		while (x != null) {
			i++;
			x = x.sig;
		}
		return i;
	}

	public static nod eli_pos(nod x, int p) {
		if (p == 1) {
			x = x.sig;
		} else {
			nod aux = x, au2 = null;
			for (int i = 1; i < p; i++) {
				au2 = aux;
				aux = aux.sig;
			}
			au2.sig = au2.sig.sig;
		}
		return x;
	}

	public static nod agr_pos(nod x, int p) throws IOException {
		nod aux = null, au2 = new nod(), cop = x;
		System.out.println("Dato: ");
		au2.dat = lee_ent();
		au2.sig = null;
		if (p == 1) {
			au2.sig = x;
			x = au2;
		} else {
			for (int i = 1; i < p; i++) {
				aux = x;
				x = x.sig;
			}
			aux.sig = au2;
			au2.sig = x;
			x = cop;
		}
		return x;
	}

	public static void sum_par(nod x) {
		int sum = 0;
		while (x != null) {
			if (x.dat % 2 == 0) {
				sum += x.dat;
			}
			x = x.sig;
		}
		System.out.println("Sumatoria de datos pares de la lista = " + sum);
	}

	public static void max(nod x) {
		nod aux = x;
		while (x != null) {
			if (x.dat > aux.dat) {
				aux = x;
			}
			x = x.sig;
		}
		System.out.println("Elemento m�ximo = " + aux.dat);
	}

	public static void dir_max(nod x) {
		nod aux = x, au2 = x;
		while (x != null) {
			if (x.dat > aux.dat) {
				aux = x;

			}
			x = x.sig;
		}
		System.out.println("Posici�n del elemento m�ximo = " + pos(au2, aux.dat));
	}

	public static int pos(nod x, int dat) {
		int i = 1;
		while (x.dat != dat) {
			i++;
			x = x.sig;
		}
		return i;
	}

	public static void min(nod x) {
		nod aux = x;
		while (x != null) {
			if (x.dat < aux.dat) {
				aux = x;
			}
			x = x.sig;
		}
		System.out.println("Elemento m�nimo = " + aux.dat);
	}

	public static void rem(nod x) throws IOException {
		System.out.println("Elemento a ser sustituido: ");
		int vie = lee_ent();
		System.out.println("Nuevo elemento: ");
		int nue = lee_ent();
		while (x != null) {
			if (x.dat == vie) {
				x.dat = nue;
			}
			x = x.sig;
		}
	}

	public static void pre(nod x) {
		int np = 0, ni = 0, sp = 0, si = 0;
		while (x != null) {
			if (x.dat % 2 == 0) {
				np++;
				sp += x.dat;
			} else {
				ni++;
				si += x.dat;
			}
			x = x.sig;
		}
		if (np == 0) {
			System.out.println("Promedio de pares = 0");
		} else {
			System.out.println("Promedio de pares = " + Float.valueOf(sp) / np);
		}
		if (ni == 0) {
			System.out.println("Promedio de impares = 0");
		} else {
			System.out.println("Promedio de impares = " + Float.valueOf(si) / ni);
		}
	}

	public static void ord(nod x) {
		int dat;
		nod aux;
		while (x.sig != null) {
			aux = x.sig;
			while (aux != null) {
				if (x.dat < aux.dat) {
					dat = x.dat;
					x.dat = aux.dat;
					aux.dat = dat;
				}
				aux = aux.sig;
			}
			x = x.sig;
		}
	}

	public static void esc(nod x) throws IOException {
		System.out.println("Escalar: ");
		int esc = lee_ent();
		while (x != null) {
			x.dat = x.dat * esc;
			x = x.sig;
		}
	}

	public static nod amb(nod x, nod y, nod z) {
		nod aux = null, au2 = null;
		while (y != null) {
			aux = new nod();
			aux.dat = y.dat;
			if (x == null) {
				x = aux;
			} else {
				au2 = x;
				while (au2.sig != null) {
					au2 = au2.sig;
				}
				au2.sig = aux;
			}
			y = y.sig;
		}
		while (z != null) {
			aux = new nod();
			aux.dat = z.dat;
			au2 = x;
			while (au2.sig != null) {
				au2 = au2.sig;
			}
			au2.sig = aux;
			z = z.sig;
		}
		return x;
	}

	public static void rep(nodcon x, nod y) {
		nodcon aux = null, au2 = null;
		nod au3 = y;
		while (y != null) {
			if (bus(x, y.dat) == false) {
				aux = new nodcon();
				aux.dat = y.dat;
				aux.num = 0;
				aux.sig = x;
				x = aux;
			}
			y = y.sig;
		}
		au2 = x;
		while (x != null) {
			y = au3;
			while (y != null) {
				if (y.dat == x.dat) {
					x.num++;
				}
				y = y.sig;
			}
			x = x.sig;
		}
		x = au2;
		while (au2 != null) {
			if (au2.num > 1) {
				System.out.println("Dato : " + au2.dat + " Cantidad: " + au2.num);
			}
			au2 = au2.sig;
		}
	}

	public static boolean bus(nodcon x, int dat) {
		boolean b = false;
		while (x != null) {
			if (x.dat == dat) {
				b = true;
			}
			x = x.sig;
		}
		return b;
	}

	public static nod rud(nod x) {
		nod aux = x, au2 = null;
		while (x.sig != null) {
			au2 = x;
			x = x.sig;
		}
		x.sig = aux;
		au2.sig = null;
		return x;
	}

	public static nod res_ord(nod x, nod y, nod z) {
		nod aux = null, au2 = null;
		while (y != null || z != null) {
			aux = new nod();
			aux.sig = null;
			if (y == null) {
				aux.dat = z.dat;
				z = z.sig;
			} else {
				if (z == null) {
					aux.dat = y.dat;
					y = y.sig;
				} else {
					if (z.dat > y.dat) {
						aux.dat = z.dat;
						z = z.sig;
					} else {
						aux.dat = y.dat;
						y = y.sig;
					}
				}
			}
			if (x == null) {
				x = aux;
			} else {
				au2 = x;
				while (au2.sig != null) {
					au2 = au2.sig;
				}
				au2.sig = aux;
			}
		}
		return x;
	}

	public static nod rui(nod x) {
		nod aux = x, au2;
		while (aux.sig != null) {
			aux = aux.sig;
		}
		aux.sig = x;
		au2 = x.sig;
		x.sig = null;
		return au2;
	}

	public static nod lec_pri(nod x, int t) throws IOException {
		nod aux = null, au2 = null;
		for (int i = 1; i <= t; i++) {
			System.out.println("Elemento " + i + ":");
			aux = new nod();
			aux.dat = lee_ent();
			while (pri(aux.dat) == false) {
				System.out.println("Solo se aceptan numeros primos");
				System.out.println("Elemento " + i + ":");
				aux.dat = lee_ent();
			}
			aux.sig = null;
			if (x == null) {
				x = aux;
			} else {
				au2 = x;
				while (au2.sig != null) {
					au2 = au2.sig;
				}
				au2.sig = aux;
			}
		}
		return x;
	}

	public static boolean pri(int x) {
		boolean f = false;
		int c = 0;
		if (x > 1) {
			for (int i = 1; i <= x; i++) {
				if (x % i == 0) {
					c++;
				}
			}
			if (c == 2) {
				f = true;
			}
		}
		return f;
	}

	public static nod rni(nod x, int n) {
		nod aux = x, au2 = null;
		int tn = tam_nod(x);
		int s = n % tn;
		if (s != 0) {
			while (aux.sig != null) {
				aux = aux.sig;
			}
			aux.sig = x;
			for (int i = 1; i <= s; i++) {
				au2 = x;
				x = x.sig;
			}
			au2.sig = null;
		}
		return x;
	}

	public static int tam_nod(nod x) {
		int c = 0;
		while (x != null) {
			c++;
			x = x.sig;
		}
		return c;
	}

	public static nod rnd(nod x, int n) {
		nod aux = x, au2 = null;
		int tn = tam_nod(x);
		int s = n % tn;
		if (s != 0) {
			while (aux.sig != null) {
				aux = aux.sig;
			}
			aux.sig = x;
			for (int i = 1; i <= (tn - s); i++) {
				au2 = x;
				x = x.sig;
			}
			au2.sig = null;
		}
		return x;
	}

	public static void dup(nod x) {
		nod aux = null, au2 = null;
		while (x != null) {
			if (x.sig != null) {
				au2 = x;
				aux = x.sig;
				while (aux != null) {
					if (x.dat == aux.dat) {
						aux = aux.sig;
						au2.sig = aux;
					} else {
						au2 = au2.sig;
						aux = aux.sig;
					}
				}
			}
			x = x.sig;
		}
	}

	public static void lec_ord(nod x, int t) throws IOException {
		nod aux = null, ini = x, au2 = null;
		int c;
		for (int i = 1; i <= t; i++) {
			c = 0;
			x = ini;
			System.out.println("Elemento " + i + ":");
			aux = new nod();
			aux.dat = lee_ent();
			aux.sig = null;
			if (ini == null) {
				ini = aux;
			} else {
				while (x != null && c == 0) {
					if (ini.sig == null) {
						c++;
						if (ini.dat >= aux.dat) {
							ini.sig = aux;
						} else {
							aux.sig = ini;
							ini = aux;
						}
					} else {
						if (ini == x) {
							if (ini.dat < aux.dat) {
								c++;
								aux.sig = ini;
								ini = aux;
							} else {
								if (ini.dat >= aux.dat && aux.dat >= ini.sig.dat) {
									c++;
									au2 = ini.sig;
									ini.sig = null;
									ini.sig = aux;
									aux.sig = au2;
								}
							}
						} else {
							if (x.sig == null) {
								c++;
								x.sig = aux;
							} else {
								if (x.dat >= aux.dat && aux.dat >= x.sig.dat) {
									c++;
									au2 = x.sig;
									x.sig = null;
									x.sig = aux;
									aux.sig = au2;
								}
							}
						}
					}
					x = x.sig;
				}
			}
			imp(ini);
		}
	}

	public static void mpm(nod x) {
		int posmax, posmin;
		nod aux = x, au2 = x, au3 = x, au4 = null;
		while (x != null) {
			if (x.dat > aux.dat) {
				aux = x;
			}
			x = x.sig;
		}
		posmax = pos(au2, aux.dat);
		x = au2;
		while (x != null) {
			if (x.dat < aux.dat) {
				aux = x;
			}
			x = x.sig;
		}
		posmin = pos(au2, aux.dat);
		x = au2;
		for (int i = 1; i < posmax; i++) {
			au2 = au2.sig;
		}
		for (int j = 1; j < posmin; j++) {
			au3 = au3.sig;
		}
		au4 = new nod();
		au4.dat = au2.dat;
		au2.dat = au3.dat;
		au3.dat = au4.dat;
	}
}
