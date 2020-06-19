import java.util.Scanner;

class ruffini {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int g, i, n, m, j;
		int radice = 0, divisori = 0;
		do {
			System.out.print("inserire il grado del polinomio: ");
			g = in.nextInt();
		} while (g < 3 || g > 9);
		int P[] = new int[g + 1];
		int Q[] = new int[g]; // acquis. dei coefficienti del polinomio P(x)
		for (i = 0; i <= g; i++) {
			System.out.print("ins.coeff.grado " + (g - i) + ":");
			P[i] = in.nextInt();
		}
		for (i = 0; i < P.length; i++)
			System.out.print(P[i] + " ");
		System.out.println("\n");
		n = P[P.length - 1]; // conta i divisori del termine noto
		for (i = 2; i <= Math.abs(n / 2); i++)
			if (n % i == 0)
				divisori++;

		int T[] = new int[2 * (divisori + 2)];// istanzia il vettore T dei divisori
		T[0] = 1;// il 1°elem. è 1
		T[1] = -1;// il 2°elem. è -1
		T[T.length - 2] = n;// il penultimo elem. è n coefficiente di grado 0
		T[T.length - 1] = -n;// l'ultimo elem. è -n

		j = 2;// memorizza i restanti divisori nel vettore T
//calcola il vettore dei coefficienti del quoziente Q(x)
		for (i = 2; i <= Math.abs(n / 2); i++)
			if (n % i == 0) {
				T[j] = i;
				T[j + 1] = -i;
				j += 2;
			}
		;
		for (j = 0; j < T.length; j++) {
			n = T[j];
			m = Q[0] = P[0];
			for (i = 1; i < P.length; i++) {
				m = n * m + P[i];
				if (i < P.length - 1)
					Q[i] = m;
			}
			if (m == 0) {
				radice = T[j];
				break;
			}
		} // fine for j

		if (radice != 0) {
			System.out.println("ha una radice:" + radice + "\n");
			System.out.println("i coefficienti del polinomio di grado " + (g - 1) + " sono:");
			for (i = 0; i < Q.length; i++)
				System.out.print(Q[i] + " ");
		} else
			System.out.println("nessuna radice trovata");
	}// fine main
}// fine classe