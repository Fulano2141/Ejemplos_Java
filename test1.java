import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test1 {

	public static void main(String[] args) {
		// java.util.Date fecha = new Date();
		// System.out.println(fecha.getDay());
		// System.out.println(fecha.getMonth());
		// System.out.println(fecha);
		Date date = new Date();
		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(hourFormat.format(date));

		System.out.println(dateFormat.format(date));
	}
}
