import java.io.*;
import java.util.*;
import javax.swing.*;

public class Ejemplo2 {
	public static void main(final String[] args) throws IOException {
		for (; true;) {
			final String[] menu1 = { "Generar numeros nuevos", "Reporte de todos los numeros",
					"Reporte de los ganadores", "Salir" };
			final String valor1 = (String) JOptionPane.showInputDialog(null, "Seleccione la opcion", "Opciones",
					JOptionPane.DEFAULT_OPTION, null, menu1, menu1[0]);
			switch (valor1) {
				case "Generar numeros nuevos":
					escri("Azar.dat");
					break;
				case "Reporte de todos los numeros":
					leer("Azar.dat", 1);
					break;
				case "Reporte de los ganadores":
					leer("Azar.dat", 2);
					break;
				case "Salir":
					System.exit(0);
			}
		}
	}

	public static void leer(final String fich, final int x) throws IOException {
		try {
			final DataInputStream dis = new DataInputStream(new FileInputStream(fich));
			String cad = "Premio\tNumero de Boleto\n";
			int i = 1;
			while (dis.available() != 0) {
				final int num = dis.readInt();
				if (x == 1)
					cad = cad + i + "\t" + num + "\n";
				else {
					if (i <= 10)
						cad = cad + i + "\t" + num + "\n";
				}
				i++;
			}
			final JTextArea are = new JTextArea();
			are.setText(cad);
			JOptionPane.showMessageDialog(null, are, "Datos", 0);
			dis.close();
		} catch (final EOFException e) {
			System.out.println("Fin del fichero");
		} catch (final IOException e) {
			System.out.println("Error E/S" + e);
		}
	}

	public static void escri(final String fich) throws IOException {
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fich));) {
			final Random rnd = new Random();
			int c = 0;
			final int n = Math.abs(
					Integer.parseInt(JOptionPane.showInputDialog("Cuantos numeros al azar desea agregar al archivo:")));
			while (n > c) {
				final int nume = Math.abs((int) (rnd.nextInt(90000)));
				dos.writeDouble(nume);
				c++;
			}
			dos.close();
			JOptionPane.showMessageDialog(null, "Archivo generado");
		} catch (final IOException e) {
			System.out.println("Error E/S");
		}
	}
}
