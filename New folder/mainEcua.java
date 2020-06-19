import javax.swing.JOptionPane;

public class mainEcua {
	public static void main(String[] X) {
		
		int a=(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el coheficiente a ")));
		int b=(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el coheficiente b ")));
		int c=(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el coheficiente c ")));
		Ecua x=new Ecua(a,b,c,x,y);
		x.salida();
	}
}
