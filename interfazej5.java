import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class interfazej5 {
	public static void main(String[] args) throws IOException {
		for (; true;) {
			String[] menu = { "Almacenar datos", "Reporte de todos los productos", "Analizar productos vencidos",
					"Ver productos vencidos", "Salir" };
			String valor = (String) JOptionPane.showInputDialog(null, "Seleccione la opcion:", "SAlARIOS",
					JOptionPane.DEFAULT_OPTION, null, menu, menu);
			switch (valor) {
				case "Almacenar datos":
					crear();
					break;
				case "Reporte de todos los productos":
					leer("productos.txt");
					break;
				case "Analizar productos vencidos":
					Fecha_venc();
					break;
				case "Ver productos vencidos":
					leer("vencidos.txt");
					break;
				case "Salir":
					System.exit(0);
			}
		}
	}

	public static void Fecha_venc() throws IOException {
		try {
			BufferedReader in = new BufferedReader(new FileReader("productos.txt"));
			FileWriter fichero = new FileWriter("vencidos.txt");
			PrintWriter pw = new PrintWriter(fichero);
			String nom = "", aux = "";
			String Fa = JOptionPane.showInputDialog(null, "Ingrese la fecha actual");
			int da = Integer.parseInt(Fa.split("/")[0]);
			int ma = Integer.parseInt(Fa.split("/")[1]);
			int aa = Integer.parseInt(Fa.split(";")[2]);
			for (; (nom = in.readLine()) != null;) {
				String[] parts = nom.split(";");
				String FV = parts[4];
				int d = Integer.parseInt(FV.split("/")[0]);
				int m = Integer.parseInt(FV.split("/")[1]);
				int a = Integer.parseInt(FV.split(";")[2]);
				if (a > aa) {
					aux = parts[0] + ";" + parts[1] + ";" + parts[2] + "" + parts[3];
				} else if (m > ma) {
					aux = parts[0] + ";" + parts[1] + ";" + parts[2] + "" + parts[3];
				} else if (d > da) {
					aux = parts[0] + ";" + parts[1] + ";" + parts[2] + "" + parts[3];
				}
				aux = parts[0] + ";" + parts[1] + ";" + parts[2] + "" + parts[3];
				pw.println(aux);
			}
			in.close();
			fichero.close();
			JOptionPane.showMessageDialog(null, "Productos vencidos");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se encontro el archivo: " + e);
		}
	}

	public static void crear() throws IOException {
		try {
			FileWriter fichero = new FileWriter("productos.txt", true);
			PrintWriter pw = new PrintWriter(fichero);
			String aux = "";
			int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Cuantos productos?:"));
			for (int i = 0; i < n; i++) {
				String CI = JOptionPane.showInputDialog(null, "Ingrese el codigo del producto");
				String Nom = JOptionPane.showInputDialog(null, "Ingrese el nombre del producto");
				String Pu = JOptionPane.showInputDialog(null, "Ingrese el precio unitario");
				String St = JOptionPane.showInputDialog(null, "Ingrese el numero de items");
				String Fv = JOptionPane.showInputDialog(null, "Ingrese la fecha de vencimiento del producto");
				aux = CI + ";" + Nom + ";" + Pu + ";" + St + ";" + Fv + ";";
				pw.println(aux);
			}
			fichero.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Hubo un error al crear el archivo de tipo: " + e);
		}
	}

	public static void leer(String i) throws IOException {
		try {
			BufferedReader in = new BufferedReader(new FileReader(i));
			String nom = "", aux = "Codigo\tNombre\tPrecio Unitario\tStock\tPrecio Total\n";
			aux = aux + "-----------------------------------------\n";
			double total = 0, punitotal = 0;
			for (; (nom = in.readLine()) != null;) {
				String ds = nom;
				String[] parts = ds.split(";");
				punitotal = Integer.parseInt(parts[3]) * Double.parseDouble(parts[2]);
				aux = aux + parts[0] + "\t" + parts[1] + "\t" + parts[2] + "\t" + parts[3] + "\t" + punitotal + "\n";
				total = total + punitotal;
			}
			aux = aux + "-----------------------------------------\n" + "total\t\t" + total;
			JTextArea area = new JTextArea();
			area.setText(aux);
			JOptionPane.showMessageDialog(null, area);
			in.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se encontro el archivo: " + e);
		}
	}
}
