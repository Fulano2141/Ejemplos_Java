import java.util.ArrayList;
import java.util.Scanner;
import factorizacion.Factorizar;

public class testFactores {

	private static Factorizar f;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s;
		int g = 0;
		ArrayList<Integer> c;
		s = new Scanner(System.in);
		System.out.println("grado");
		g = s.nextInt();
		c = new ArrayList<Integer>();

		for (int i = 0; i <= g; i++) {
			System.out.println("x^[" + i + "]");
			int co = s.nextInt();
			c.add(co);
		}
		f = new Factorizar(g, c);
	}

	public static void setF(Factorizar f) {
		testFactores.f = f;
	}

	public static Factorizar getF() {
		return f;
	}

}