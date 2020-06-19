/* 1.-  Una clase contiene el tiempo expresada en horas, minutos y segundos con valores arbitrarios, 
 * luego de la creación del constructor, agregar una función que transforme dicha medida en una 
 * expresión correcta. Por ejemplo, dada la medida 3h 118m 195s, el programa deberá obtener como 
 * resultado 5h 1m 15s.  */
import javax.swing.JOptionPane;
public class Ejercicio1 {
	int hora,minu,segu;
	public Ejercicio1(int hora, int minu, int segu) {
		this.hora = hora;
		this.minu = minu;
		this.segu = segu;
	}
	public int getHora() {
		return hora;
	}
	public int getMinu() {
		return minu;
	}
	public int getSegu() {
		return segu;
	}
	public void salida() {
		int segtot=segu+minu*60+hora*60*60;
		if(segtot>0){
			segtot=getHora()*3600+getMinu()*60+getSegu();
		    System.out.println("El resutaldo de: "+getHora()+"HH "+getMinu()+"MM "+getSegu()+"SS");
		    hora=(segtot/3600);
		    minu=(segtot-hora*3600)/60;
		    segu=segtot-(hora*3600+minu*60);
		    System.out.printf("Es: "+hora+"HH "+minu+"MM "+segu+"SS");
		}else {
			
		}
			
		}
	public static void main(String[] args) {
		int a=(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese las horas")));
		int b=(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese los minutos")));
		int c=(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese los segundos")));
		Ejercicio1 x=new Ejercicio1(a,b,c);
		x.salida();
	}
}
