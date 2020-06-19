/* 6.- Desarrollar un proyecto que calcule los salarios de cada empleado, para lo cual debe tomar en cuenta las siguientes especificaciones:
 * • Dependencia: Indica la Facultad a la que pertenece (Economía, Ingeniería, Derecho)
 * • Calificación Asignada: Es la calificación promedio que tiene cada profesor en base a las evaluaciones de los cursos que ha dictado.
 * • El salario de los profesores hora cátedra se calcula considerando que por hora asignada se reconocen 50 Bs. 
 * • Para los profesores tiempo completo, se considera que si el nivel estudio es pregrado se tiene un salario base de 10.000 Bs, si es de maestría: 18.000 y doctorado 25.000. Además, si tiene docencia destacada, se aumenta a este salario base 2000. Para obtener la docencia destacada su calificación debe superar la nota 4.5
 * • El salario base del personal administrativo es 5.000 Bs.
 * • De acuerdo al tipo de recursos humanos, se aumenta el salario base 1000 si se es de tesorería y 700 si es de secretaria.
 * • El personal de mantenimiento tiene una lista con los nombres de los bloques de aulas que tiene asignado.
 * • Puede trabajar horas extra, por cada hora extra se aumenta 40 Bs. al salario*/
import javax.swing.JOptionPane;
public class mainEmpleado {
	public static void main(String[] args) {
		String Nomem=JOptionPane.showInputDialog("Nombre: ");
		int ci=Integer.parseInt(JOptionPane.showInputDialog("Celula de Identida"));
		String Depen=JOptionPane.showInputDialog("Depependencia");
		String DoAm=JOptionPane.showInputDialog("Docente o Administracion");
		switch(DoAm) {
		case"Docente":
			double CalAsi=Double.parseDouble(JOptionPane.showInputDialog("Calificacion Asignada"));
			Docente fu=new Docente(Nomem,ci,Depen,CalAsi);
			JOptionPane.showMessageDialog(null,fu.calcularSalario()); break;
		case "Administracion":
			double Salba=5000.0;
		Administrativo la=new Administrativo(Nomem,ci,Depen,Salba);
		JOptionPane.showMessageDialog(null,la.calcularSalario());break;
		}
	}
}
