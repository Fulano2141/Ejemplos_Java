import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class polinomio {
	public static class nodo {
		float ter;
		float ex;
		nodo sgte;
	}

	private static Factorizar fac;

	public static void main(String arg[]) throws IOException {
		ArrayList<Integer> c = new ArrayList<Integer>();
		nodo cab = null, d = null, I = null, f = null, cabB = null, m = null;
		int e = 0, e1 = 0;
		for (; true;) {
			String[] menu1 = { "Lectura de Polinomio A", "Lista", "Derivadas", "Integrales",
					"Multiplicar por un escalar", "Lectura de Polinomio B", "Listado del polinomio B",
					"Multiplicacion de polinomios", "Dividir polinomios", "Factorizar polinomio", "Salir" };
			String valor1 = (String) JOptionPane.showInputDialog(null, "Selecciones una opcion:", "Polinomios",
					JOptionPane.DEFAULT_OPTION, null, menu1, menu1[0]);
			switch (valor1) {
				case "Lectura de Polinomio A":
					cab = null;
					do {
						e = leer("Grado:");
					} while (e <= 0);
					cab = agregar_nodo(e);
					break;
				case "Lista":
					listado("Datos de la lista\n", cab);
					break;
				case "Derivadas":
					d = derivar(cab);
					listado("\nDatos de la lista\n", cab);
					listado("\nDerivada\n", d);
					break;
				case "Integrales":
					I = Integrar(cab);
					listado("\nDatos de la lista\n", cab);
					listado("\nDerivada\n", I);
					break;
				case "Multiplicar por un escalar":
					float es = leer("Escalar?");
					listado("\nDatos de la lista\n", cab);
					f = multiplicar_escalar(cab, es);
					listado("\nDatos de la lista\n", f);
					break;
				case "Lectura de Polinomio B":
					cabB = null;
					do {
						e1 = leer("Grado:");
					} while (e1 <= 0);
					cabB = agregar_nodo(e1);
					break;
				case "Listado del polinomio B":
					listado("Datos de la lista B\n", cabB);
					break;
				case "Multiplicacion de polinomios":
					m = multiplicar(cab, cabB);
					listado("\nDatos de la lista A\n", cab);
					listado("\nDatos de la lista B\n", cabB);
					listado("\nDatos de la lista M ", m);
					terminos_semejantes(m);
					listado("\nDatos de la lista M ", m);
					break;
				case "Dividir polinomios":
					d = null;
					nodo p = null;
					double sum1 = 0, sum2 = 0;
					sum1 = suma(cab);
					sum2 = suma(cabB);
					if (sum1 >= sum2) {
						d = division(cab, cabB, d, p);
						listado("Resultado", d);
					} else
						JOptionPane.showMessageDialog(null, "La division no puede darse! ");
					break;
				case "Factorizar polinomio":
					nodo auxx = cab;
					for (int i = 0; i <= e; i++) {
						c.add((int) auxx.ter);
						auxx = auxx.sgte;
					}
					System.out.println(c);
					fac = new Factorizar(e, c);
					// System.out.println(fac.invertirArrayCoef());
					break;
				case "Salir":
					System.exit(0);
			}
		}
	}

	public static nodo division(nodo A, nodo B, nodo C, nodo D) throws IOException {
		float co, e;
		while (A != null) {
			co = A.ter / B.ter;
			e = A.ex - B.ex;
			C = coeficiente(C, co, e);
			D = multiplicar(C, B);
			D = mult_escalar(D);
			D = suma(A, D);
			A = D;
			A = A.sgte;
		}
		return C;
	}

	public static nodo suma(nodo cab, nodo cabb) {
		nodo auxa = cab, auxb = null, c = null;
		float coe = 0, ex = 0;
		while (auxa != null) {
			auxb = cabb;
			while (auxb != null) {
				if (auxa.ex == auxb.ex) {
					coe = auxa.ter + auxb.ter;
					ex = auxa.ex;
					auxa.ter = coe;
				} else {
					coe = auxa.ter;
					ex = auxa.ex;
				}
				auxb = auxb.sgte;
			}
			c = coeficiente(c, coe, ex);
			auxa = auxa.sgte;
		}
		return c;
	}

	public static nodo coeficiente(nodo C, float co, float e) {
		nodo x;
		nodo nuevo = new nodo();
		nuevo.ter = co;
		nuevo.ex = e;
		nuevo.sgte = null;
		if (C == null) {
			C = nuevo;
		} else {
			x = C;
			for (; x.sgte != null;) {
				x = x.sgte;
			}
			x.sgte = nuevo;
		}
		return C;
	}

	public static nodo mult_escalar(nodo p) {
		int esc = (-1);
		nodo c = null;
		c = p;
		while (c != null) {
			c.ter = c.ter * esc;
			c = c.sgte;
		}
		return p;
	}

	public static double suma(nodo cab) {
		double aux = 0;
		while (cab != null) {
			aux += cab.ex;
			cab = cab.sgte;
		}
		return aux;
	}

	public static void terminos_semejantes(nodo c) {
		nodo q, s;
		while (c != null) {
			s = c;
			q = c.sgte;
			while (q != null) {
				if (c.ex == q.ex) {
					c.ter = c.ter + q.ter;
					s.sgte = q.sgte;
					q = s;
				}
				s = q;
				q = q.sgte;
			}
			c = c.sgte;
		}
	}

	public static nodo multiplicar(nodo cab, nodo cabb) throws IOException {
		nodo auxa = cab, auxb = null, c = null;
		float coe, ex;
		while (auxa != null) {
			auxb = cabb;
			while (auxb != null) {
				coe = auxa.ter * auxb.ter;
				ex = auxa.ex + auxb.ex;
				c = coeficiente(c, coe, ex);
				auxb = auxb.sgte;
			}
			auxa = auxa.sgte;
		}
		return c;

	}

	public static nodo multiplicar_escalar(nodo c, float x) throws IOException {
		nodo aux = null;
		while (c != null) {
			aux = adicionar_cola(aux, c.ter * x, c.ex);
			c = c.sgte;
		}
		return aux;
	}

	public static nodo Integrar(nodo c) throws IOException {
		nodo aux = null;
		while (c != null) {
			if (c.ex != 0) {
				aux = adicionar_cola(aux, c.ter / (c.ex + 1), c.ex + 1);
			}
			c = c.sgte;
		}
		return aux;
	}

	public static nodo derivar(nodo c) throws IOException {
		nodo aux = null;
		while (c != null) {
			if (c.ex != 0)
				aux = adicionar_cola(aux, c.ter * c.ex, c.ex - 1);
			c = c.sgte;
		}
		return aux;
	}

	public static nodo adicionar_cola(nodo c, float t, float ex) {
		nodo nuevo = new nodo(), copia;
		nuevo.ter = t;
		nuevo.ex = ex;
		nuevo.sgte = null;
		if (c == null)
			c = nuevo;
		else {
			copia = c;
			while (copia.sgte != null) {
				copia = copia.sgte;
			}
			copia.sgte = nuevo;
		}
		return c;
	}

	public static void listado(String t, nodo c) {
		String imp = t + "\n";
		while (c != null) {
			if (c.ex == 0)
				imp = imp + c.ter;
			else
				imp = imp + c.ter + "X^" + c.ex + " + ";
			c = c.sgte;
		}
		JOptionPane.showMessageDialog(null, imp);
	}

	public static nodo agregar_nodo(int e) throws IOException {
		nodo c = null;
		float t;
		for (int i = 0; i <= e; i++) {
			nodo aux = new nodo();
			t = (float) leer("Termino: x^" + i + "? ");
			if (t != 0) {
				aux.ter = t;
				aux.ex = i;
				aux.sgte = c;
				c = aux;
			}
		}
		return c;
	}

	public static int leer(String t) throws IOException {
		int p = Integer.parseInt(JOptionPane.showInputDialog(t));
		return p;
	}
}