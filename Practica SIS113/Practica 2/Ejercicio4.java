import javax.swing.JOptionPane;

/* 4.- Una empresa efectúa el control de asistencia de sus empleados mediante un lector biométrico, 
 * el horario en la entrada es a las 8:00 a.m y la salida es a las 16:00 p.m. El empleado tiene una 
 * tolerancia de 10 minutos en la entrada, si llega más allá de los 10 minutos de tolerancia se penaliza 
 * todos los minutos de atraso (es decir si llega a las 8:12 se penalizan los 12 minutos). De igual 
 * forma no puede salir antes del horario establecido en la salida,  (si lo hace se penaliza los minutos 
 * faltantes), pero si el empleado entra antes o sale después de sus horarios el sistema solo toma en 
 * cuenta las 8 horas laborales de trabajo. 
 * El problema consiste en determinar los minutos de penalización para el empleado en cualquier día laboral. 
 * Para tal propósito debe crear constructores y funciones, verifique el funcionamiento con los siguientes datos de prueba:
 *        Código Empleado      Hora Entrada         Hora Salida      Penalización          Fecha
 *        	101045					7:55				16:15	           0			12/01/2011	
 *        	223032					8:11				16:00	          11			12/01/2011
 *        	334009					8:30				16:20	          30			12/01/2011
 *        	443283	           		8:05                16:10              0			12/01/2011  */
public class Ejercicio4 {
	private int HorEn,MinEn,HorSa,MinSal,Cod;
	String Fecha; 
	public Ejercicio4(int horEn, int minEn, int horSa, int minSal, int cod, String fecha) {
		super();
		HorEn = horEn;
		MinEn = minEn;
		HorSa = horSa;
		MinSal = minSal;
		Cod = cod;
		Fecha = fecha;
	}
	public void salida() {
		int aux=biomeent(HorEn,MinEn)+biomesal(HorSa,MinSal);
		JOptionPane.showMessageDialog(null,"Codigo Empleado____Hora Entrada____Hora Salida____Penalizacion____Fecha____"+"\n		"+Cod+"________________"+HorEn+":"+MinEn+"_________"+HorSa+":"+MinSal+"_____________"+aux+"________"+Fecha);
	}
	public static void main(String[] args) {
		int Cod=(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese su codigo")));
		int HorEn=(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la hora de entrada")));
		int MinEn=(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el minuto de entrada")));
		int HorSa=(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la hora de salida")));
		int MinSa=(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el minuto de salida")));
		String Fecha=JOptionPane.showInputDialog(null,"Ingrese la fecha");
		Ejercicio4 obj=new Ejercicio4(HorEn,MinEn,HorSa,MinSa,Cod,Fecha);
		obj.salida();
	}
	public int biomeent(int hor1,int min1){
		if(hor1==8){
			if (min1<=10 && min1>=0)
			return 0;
			else 
			return min1;
		}	
		if(hor1<=7)
			return 0;
		else 
			return 0;

	}
	public int biomesal(int hor2,int min2){
		int x=0;
		if(hor2==16)
		return x;
		if (hor2==15){
			x=60-min2;
			return x;
		}
		else 
			return x;
		
	}
		
}
