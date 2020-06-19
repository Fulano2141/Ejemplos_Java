
public class SegundoParcial {
	public class Vec {
		int dato;
		Vec sgte;
	}

	public static boolean buscar(Vec a, int dato) {
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

	public static Vec agregar(Vec c, int dato) {
		Vec aux = null ;
		aux.dato = dato;
		aux.sgte = c;
		c = aux;
		return c;
	}

	public static Vec Union(Vec A, Vec B, Vec C) {
		Vec aux = null, aux1 = null;
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

	public static Vec UnionA_B(Vec A, Vec B) {
		Vec aux = null, aux1 = null;
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

	public static Vec Interseccion(Vec A, Vec B) {
		Vec aux = null, aux1 = null;
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

	public static Vec diferencia_S(Vec A, Vec B) {
		Vec aux = null, aux1 = null, aux2 = Interseccion(A, B);
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

	public static Vec diferencia_L(Vec A, Vec B) {
		Vec aux = null, aux1 = null;
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

}
