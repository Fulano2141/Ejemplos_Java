/* 6.- Obtener la suma de la serie de Fibonacci para n términos */
import javax.swing.JOptionPane;
public class Ejercicio6 {
	int n;
	public Ejercicio6(int n) {
		this.n = n;
	}
	public void resultado() {
		for(int i = 1; i<=n; i++)
            System.out.print(fibo(i) + ", ");
	}
	public int fibo(int num){
        if(num == 0 || num==1)
             return num;
        else
             return fibo(num-1) + fibo(num-2);
   }
	public void salida() {
		resultado();
	}
	public static void main(String[] args) {
		int num=(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero de elementos a mostrar ")));
		Ejercicio6 x=new Ejercicio6(num);
		x.salida();
	}
}
