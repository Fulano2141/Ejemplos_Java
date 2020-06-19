import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {

		String horaIng=JOptionPane.showInputDialog(null,"ingrese hora de ingreso (hh:mm:ss)");
		String horaSali=JOptionPane.showInputDialog(null,"ingrese hora de salida (hh:mm:ss)");
	    
	     Hora obj=new Hora(horaIng, horaSali);
	     System.out.println("tiempo transcurrido "+obj.tiempo());
	     

	}

}
