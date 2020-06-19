import java.io.*;

public class TareaPolinomios {
	public static class pol {
		float coe, exp;
		pol sig;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		pol pa = null, pb = null, res = null;
		int gra, opc;
		do {
			opc = menu();
			switch (opc) {
				case 1:
					pa = null;
					do {
						System.out.println("Grado de polinomio A:");
						gra = lee_ent();
					} while (gra <= 0);
					for (int i = gra; i >= 0; i--) {
						System.out.println("Coeficiente para x^" + i + ":");
						pa = agregar(pa, i);
					}
					break;
				case 2:
					pb = null;
					do {
						System.out.println("Grado de polinomio B:");
						gra = lee_ent();
					} while (gra <= 0);
					for (int i = gra; i >= 0; i--) {
						System.out.println("Coeficiente para x^" + i + ":");
						pb = agregar(pb, i);
					}
					break;
				case 3:
					imp(pa);
					break;
				case 4:
					imp(pb);
					break;
				case 5:
					res = null;
					res = cop(res, pa);
					res = cop(res, pb);
					sem(res);
					ord(res);
					imp(res);
					break;
				case 6:
					res = null;
					res = cop(res, pa);
					res = copmen(res, pb);
					sem(res);
					ord(res);
					imp(res);
					break;
				case 7:
					res = null;
					res = mul(pa, pb);
					sem(res);
					ord(res);
					imp(res);
					break;
				case 8:
					div(pa, pb);
					break;
			}
		} while (opc != 9);

	}

	public static int menu() throws IOException {
		System.out.println("MENU");
		System.out.println("1. Lectura de polinomio A");
		System.out.println("2. Lectura de polinomio B");
		System.out.println("3. Listado de polinomio A");
		System.out.println("4. Listado de polinomio B");
		System.out.println("5. Suma de polinomios");
		System.out.println("6. Resta de polinomios");
		System.out.println("7. Multiplicaci�n de polinomios");
		System.out.println("8. Divisi�n de polinomios");
		System.out.println("9. Salir");
		return lee_ent();
	}

	public static int lee_ent() throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		return (Integer.parseInt(buf.readLine()));
	}

	public static pol agregar(pol x, int gra) throws IOException {
		pol nue, cop;
		float coe = lee_flo();
		if (coe != 0) {
			nue = new pol();
			nue.coe = coe;
			nue.exp = (float) gra;
			nue.sig = null;
			if (x == null) {
				x = nue;
			} else {
				cop = x;
				while (cop.sig != null) {
					cop = cop.sig;
				}
				cop.sig = nue;
			}
		}
		return x;
	}

	public static float lee_flo() throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		return (Float.valueOf(buf.readLine()));
	}

	public static void imp(pol x) {
		while (x != null) {
			if (x.exp != 0) {
				System.out.print(x.coe + "x^" + x.exp + " ");
			} else {
				System.out.print(x.coe);
			}
			x = x.sig;
		}
		System.out.println();
	}

	public static pol cop(pol x, pol y) {
		pol aux = null;
		while (y != null) {
			aux = new pol();
			aux.coe = y.coe;
			aux.exp = y.exp;
			aux.sig = x;
			x = aux;
			y = y.sig;
		}
		return x;
	}

	public static void sem(pol x) {
		pol y, z;
		while (x != null && x.sig != null) {
			y = x;
			z = x.sig;
			while (z != null) {
				if (x.exp == z.exp) {
					x.coe = x.coe + z.coe;
					y.sig = z.sig;
				}
				y = z;
				z = z.sig;
			}
			x = x.sig;
		}
	}

	public static void ord(pol x) {
		pol aux, au2 = new pol();
		while (x.sig != null) {
			aux = x.sig;
			while (aux != null) {
				if (x.exp < aux.exp) {
					au2.coe = aux.coe;
					au2.exp = aux.exp;
					aux.coe = x.coe;
					aux.exp = x.exp;
					x.coe = au2.coe;
					x.exp = au2.exp;
				}
				aux = aux.sig;
			}
			x = x.sig;
		}
	}

	public static pol copmen(pol x, pol y) {
		pol aux = null;
		while (y != null) {
			aux = new pol();
			aux.coe = (y.coe) * (-1);
			aux.exp = y.exp;
			aux.sig = x;
			x = aux;
			y = y.sig;
		}
		return x;
	}

	public static pol mul(pol x, pol y) {
		pol res = null, aux, au2, au3;
		while (x != null) {
			au3 = y;
			while (au3 != null) {
				aux = new pol();
				aux.coe = x.coe * au3.coe;
				aux.exp = x.exp + au3.exp;
				aux.sig = null;
				if (res == null) {
					res = aux;
				} else {
					au2 = res;
					while (au2.sig != null) {
						au2 = au2.sig;
					}
					au2.sig = aux;
				}
				au3 = au3.sig;
			}
			x = x.sig;
		}
		return res;
	}

	public static void div(pol x, pol y) {
		pol res = null, aux, au2, au3, au4;
		while ((x != null && y != null && x.exp >= y.exp)) {
			aux = new pol();
			aux.coe = x.coe / y.coe;
			aux.exp = x.exp - y.exp;
			aux.sig = null;
			if (res == null) {
				res = aux;
			} else {
				au2 = res;
				while (au2.sig != null) {
					au2 = au2.sig;
				}
				au2.sig = aux;
			}
			au3 = y;
			while (au3 != null) {
				au4 = new pol();
				au4.coe = (aux.coe * au3.coe) * (-1);
				au4.exp = aux.exp + au3.exp;
				au4.sig = x;
				x = au4;
				au3 = au3.sig;
			}
			sem(x);
			ord(x);
			x = cer(x);
		}
		System.out.println("Cociente:");
		imp(res);
		System.out.println("Resto:");
		imp(x);
	}

	public static pol cer(pol x) {
		pol aux = x;
		while (x != null && x.sig != null) {
			if (x.sig.coe == 0) {
				x.sig = x.sig.sig;
			}
			x = x.sig;
		}
		if (aux.coe == 0) {
			aux = aux.sig;
		}
		return aux;
	}
}
