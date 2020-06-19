import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class lab1 {
	public static class nodo {
		int nota;
		String nombre;
		nodo sgte;
	}

	public static void main(String arg[]) throws IOException {
		nodo cab = null;
		for (; true;) {
			String[] menu1 = { "Agregar nodos", "Listado", "Sumatoria", "Borrar dato de la cabecera",
					"Borrar ultimo nodo", "Borrar nodo con dato x", "Salir" };
			String valor1 = (String) JOptionPane.showInputDialog(null, "Seleccione la opcion", "Opciones",
					JOptionPane.DEFAULT_OPTION, null, menu1, menu1[0]);
			switch (valor1) {
			case "Agregar nodos":
				cab = agregar_nodo(cab);
				break;
			case "Listado":
				listado("Datos de la lista\n", cab);
				break;
			case "Sumatoria":
				JOptionPane.showMessageDialog(null, "La sumatoria es " + sumatoria(cab));
				break;
			case "Borrar dato de la cabecera":
				cab = borrar_cab(cab);
				break;
			case "Borrar ultimo nodo":
				borrar_ultimo(cab);
				break;
//			case "Borrar nodo con dato x":dato1=leer("dato a borrar?");
//			cab=borrar_nodo_dato_x(cab,dato1);break;
			case "Salir":
				System.exit(0);
			}
		}
	}

	public static nodo borrar_nodo_dato_x(nodo c, int db) {
		nodo q = null, z = null;
		if (c != null) {
			// analisis cabecera
			while (c.nota == db && c != null) {
				c = borrar_cab(c);
			}
			// lo que queda
			z = c.sgte;
			q = c;
			while (z != null) {
				if (z.nota == db) {
					q.sgte = z.sgte;
					z = q;
				}
				q = z;
				z = z.sgte;
			}
		}
		return q;
	}

	public static void borrar_ultimo(nodo c) {
		nodo x = c;
		if (c != null && c.sgte != null) {
			while (x.sgte != null) {
				c = x;
				x = x.sgte;
			}
			c.sgte = null;
		}
	}

	public static nodo borrar_cab(nodo c) {
		if (c != null)
			c = c.sgte;
		return (c);
	}

	public static int sumatoria(nodo c) {
		int s = 0;
		while (c != null) {
			s = s + c.nota;
			c = c.sgte;
		}
		return s;
	}

	public static void listado(String t, nodo c) {
		String cad = t + "\n";
		int i = 0;
		while (c != null) {
			i++;
			cad = cad + i + ".-\tNombre: " + c.nombre + "\tNota: " + c.nota + "\n";
			c = c.sgte;
		}
		JTextArea are = new JTextArea();
		are.setText(cad);
		JOptionPane.showMessageDialog(null, are, "Datos", 1);
	}

	public static nodo z(nodo c) throws IOException {
		nodo aux = new nodo();
		aux.nota = Integer.parseInt(JOptionPane.showInputDialog("NOTA:"));
		aux.nombre = JOptionPane.showInputDialog("NOMBRE:");
		aux.sgte = c;
		c = aux;
		return (c);
	}

}
