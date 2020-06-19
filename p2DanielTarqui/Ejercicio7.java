/* 7. - Defina una clase que contenga un numero entero, luego desarrolle funciones para obtener 
 * el factorial de este número y otra que obtenga la 
 * combinatoria (en base al factorial previo) de dos objetos de la clase. */
import javax.swing.JOptionPane;
public class Ejercicio7 {
	int num,res,combi;
	public Ejercicio7(int num, int combi) {
		this.combi=combi;
		this.num = num;
	}
	public int resultado() {
		int m=1;
		for(int i=1;i<=num;i++) {
			m=m*i;}
		return m;
	}
	public int facto(int num) {
		int m=1;
		for(int i=1;i<=num;i++) {
			m=m*i;}
		return m;
	}
	public void salida() {
		System.out.println("El factorial es: "+resultado());
		if(combi>num)
			System.out.println("La combinatoria no es posible ");
		else
			System.out.println("La combinatoria es: "+combinato());
	}
	public int combinato(){
		int aux=num-combi;
		int comb=resultado()/(facto(combi)*facto(aux));
		return comb;
	}
	public static void main(String[] X) {
	//	JOptionPane.showMessageDialog(null, "Ingrese el numero ");
		int num=(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese un numero ")));
		int combi=(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese un numero a combinar con el anterior ")));
		Ejercicio7 x=new Ejercicio7(num,combi);
		x.salida();
		x.combinato();
	}

}
