import java.util.ArrayList;
import java.util.Scanner;

public class Factorizar1 {
	int gradoEq, a0, an;
	ArrayList<Integer> coef, copiaCoef, raices, posibleRaiz, multiploA0, multiploAn, coefInv;
	Scanner s;
	int g;

	public Factorizar1(int grado, ArrayList<Integer> c) {
		gradoEq = grado;
		coef = new ArrayList<Integer>();
		copiaCoef = new ArrayList<Integer>();
		raices = new ArrayList<Integer>();
		posibleRaiz = new ArrayList<Integer>();
		multiploA0 = new ArrayList<Integer>();
		multiploAn = new ArrayList<Integer>();
		coefInv = new ArrayList<Integer>();
		coef = c;
		wCopia(coef);
		a0 = Math.abs(c.get(0));
		an = Math.abs(c.get(grado));
		this.setRaices();
		for (int i = 0; i < this.raices.size(); i++) {
			System.out.print("r" + i + ": " + raices.get(i) + " ");
		}
	}

	public ArrayList<Integer> getRaices() {
		return raices;
	}

	public ArrayList<Integer> getCopiaCoef() {
		return copiaCoef;
	}

	public void setCopiaCoef(ArrayList<Integer> copiaCoef) {
		this.copiaCoef = copiaCoef;
	}

	private void setRaices() {
		this.setPosiblesRaices(a0, an);
		ArrayList<Integer> residuo = new ArrayList<Integer>();
		residuo = coef;
		for (int j = 0; j < posibleRaiz.size(); j++) {
			ArrayList<Integer> cResiduo = (ArrayList) residuo.clone();
			for (int i = residuo.size() - 1; i >= 0; i--) {

				if (i != residuo.size() - 1) {
					residuo.set(i, (residuo.get(i + 1) * posibleRaiz.get(j)) + residuo.get(i));
				}
			}
			if ((residuo.get(0)) == 0) {
				raices.add(posibleRaiz.get(j));
				j--;
			} else {
				residuo.clear();
				residuo = cResiduo;
			}
		}

	}

	private void wCopia(ArrayList<Integer> original) {
		copiaCoef.clear();
		for (int i = 0; i < original.size(); i++) {
			int k = original.get(i);
			copiaCoef.add(k);
		}
	}

	public void setPosiblesRaices(int A0, int An) {

		for (int i = 1; i <= A0; i++) {
			if ((A0 % i) == 0) {
				multiploA0.add(i);
			}
		}
		for (int i = 1; i <= An; i++) {
			if ((An % i) == 0) {
				multiploAn.add(i);
			}
		}

		for (int m = 0; m < multiploA0.size(); m++) {
			for (int i = 0; i < multiploAn.size(); i++) {
				posibleRaiz.add(multiploA0.get(m) / multiploAn.get(i));
				posibleRaiz.add(-1 * multiploA0.get(m) / multiploAn.get(i));
			}
		}
	}

	public void doCycle(int ultimoi, int j) {
		for (int i = 1; i <= gradoEq; i++) {
			coefInv.set(i, coefInv.get(ultimoi) * posibleRaiz.get(j) + coefInv.get(i));
			ultimoi = i;
		}
	}

	public void invertirArrayCoef() {
		coefInv.clear();
		for (int i = coef.size() - 1; i >= 0; i--) {
			coefInv.add(coef.get(i));
		}
	}
}
