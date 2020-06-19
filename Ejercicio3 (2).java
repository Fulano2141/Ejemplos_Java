/* 3.  Un archivo de tipo binario en JAVA contiene los datos de los productos que se venden en un supermercado:
 * - Código del producto
 * - Nombre 
 * - Tipo de producto (Lácteos, Carnes, Frutas, Cereales, …etc)
 * - Precio unitario de venta
 * - Stock
 * - Fecha de vencimiento
 * Se debe realizar funciones que añadan nuevos productos, también se debe obtener el siguiente reporte 
 * de todos los productos que vencen hoy 
 * Detalle de productos que vencen hoy:  5 de Octubre 2015
 * Código		Nombre	                 Precio Unitario	Stock	
 * Además se debe generar un gráfico tipo torta (emplear JFREECHART) que muestre el stock 
 * por tipo de producto y también un gráfico lineal que muestre el precio unitario por el mismo criterio. 
 */
import java.io.*;
import java.util.*;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
public class Ejercicio3 {
	public static void main(String[] args) throws IOException {
		for(;true;){
			String [] menu = {"Adicion","Reporte","Vencimiento","Graficar stock","Graficar precios","Salir"};
			String valor = (String) JOptionPane.showInputDialog(null, "Seleccione la opcion","Opciones",JOptionPane.DEFAULT_OPTION,null,menu,menu[0]);
			switch(valor){
			case "Adicion": adicionar("Super.dat"); break;
			case "Reporte": reporte("Super.dat"); break;
			case "Vencimiento": vencimiento("Super.dat"); break;
			case "Graficar stock":grafi("Super.dat");break;
			case "Graficar precios":grefo("Super.dat");break;
			case "Salir": System.exit(0); break;
			}
		} 
	}	
	public static void grefo(String string) throws IOException {
		 XYSeries series = new XYSeries("Producto A");
		 try {
		 DataInputStream fi = new DataInputStream(new FileInputStream(string));
			ArrayList<String> list=new ArrayList<String>();
			int c=0;
			while(fi.available()!=0){
				int cod = fi.readInt();
				String nom = fi.readUTF();
				String tip = fi.readUTF();
				double pr = fi.readDouble();
				int st = fi.readInt();
				String fec = fi.readUTF();
				String graf=st+";"+pr;
				list.add(graf);
				c++;
			}
			for(int i=0;i<c;i++) {
				String aux=list.get(i);
				String k[]=aux.split(";");
				series.add(Double.parseDouble(k[1]),Integer.parseInt(k[0]));
			}
	        XYSeriesCollection dataset = new XYSeriesCollection();
	        dataset.addSeries(series);
	        JFreeChart chart = ChartFactory.createXYLineChart("Productos","Stock","Precio",dataset,PlotOrientation.VERTICAL,true,false,false);	
	        ChartFrame frame = new ChartFrame("Grafica de precios y stock", chart);
	        frame.pack();
	        frame.setVisible(true);
			fi.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "El archivo no pudo ser creado");
		}
	}
	public static void adicionar(String string) throws IOException {
		try {
			DataOutputStream fs = new DataOutputStream(new FileOutputStream(string,true));
			int x;
			int cod=0,st;
			String nom,fec,tip;
			double pr;
			x=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de productos:"));
			for(int i=0; i<x; i++){
				while(cod==0){
					try {
						cod=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el codigo: "));
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Ingrese numeros");
					}
				}
				nom=JOptionPane.showInputDialog(null,"Ingrese el nombre");
				tip=JOptionPane.showInputDialog(null,"Tipo de producto");
				pr = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio unitario:"));
				st = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el stock: "));
				fec = JOptionPane.showInputDialog("Ingrese fecha de vencimiento: (dd/mm/aaaa)");
				fs.writeInt(cod);
				fs.writeUTF(nom);
				fs.writeUTF(tip);
				fs.writeDouble(pr);
				fs.writeInt(st);
				fs.writeUTF(fec);
				cod=0;
			}
			fs.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "El archivo no pudo ser creado");
		}
	}
	public static void grafi(String string) throws IOException  {
		try {
		DataInputStream fi = new DataInputStream(new FileInputStream(string));
		ArrayList<String> list=new ArrayList<String>();
		int c=0,u=0;
		while(fi.available()!=0){
			int cod = fi.readInt();
			String nom = fi.readUTF();
			String tip = fi.readUTF();
			double pr = fi.readDouble();
			int st = fi.readInt();
			String fec = fi.readUTF();
			String graf=nom+";"+st;
			list.add(graf);
			c++;
			u=u+st;
		}
		DefaultPieDataset dataset = new DefaultPieDataset();
		for(int i=0;i<c;i++) {
			String aux=list.get(i);
			String k[]=aux.split(";");
			dataset.setValue(k[0], new Double(Double.parseDouble(k[1])/u));
		}
		JFreeChart chart = ChartFactory.createPieChart("Productos Supermercado",dataset,true,true, false);
		ChartPanel panel= new ChartPanel(chart);
		JFrame ventana = new JFrame("Grafica de productos");
		ventana.setVisible(true);
		ventana.setSize(800, 600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.add(panel);
		fi.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "El archivo no pudo ser creado");
		}
	}
	public static void reporte(String string) throws IOException {
		try {
			DataInputStream fi = new DataInputStream(new FileInputStream(string));
			String cad="Codigo\tNombre\tTipo\tPrecio\tStock\tVencimiento\tTotal\n";
			double sum=0.0;
			while(fi.available()!=0){
				int cod = fi.readInt();
				String nom = fi.readUTF();
				String tip = fi.readUTF();
				double pr = fi.readDouble();
				int st = fi.readInt();
				String fec = fi.readUTF();
				cad+=cod+"\t"+nom+"\t"+tip+"\t"+pr+"\t"+st+"\t"+fec+"\t"+(pr*st)+"\n";
				sum+=pr*st;
			}
			cad+="\nTotal\t\t\t\t\t"+sum;
			JTextArea jta=new JTextArea(20,50);
			jta.setText(cad);
			JScrollPane barra = new JScrollPane(jta);
			JOptionPane.showMessageDialog(null,barra);
			fi.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "no se pudo leer el archivo");
		}
	} 
	public static boolean calcular(String fec){
		Calendar fecha = new GregorianCalendar();
		int anio = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH);
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		String fechita=dia +"/" + (mes+1) + "/" + anio;
		boolean m=false;
		String k[]=fec.split("/");
		int k3 = Integer.parseInt(k[0]);
		int k2 = Integer.parseInt(k[1]);
		int k1 = Integer.parseInt(k[2]);
		if (anio<=k1){
			if (anio==k1){
				if (mes<=k2){
					if (mes==k2){
						if (dia<=k3)
							m=true;
					}
				}
				else
					m=true;
			}
		}
		else
			m=true;
		return m;
	}
	public static void vencimiento(String string) throws IOException {
		try {
			Calendar fecha = new GregorianCalendar();
			int anio = fecha.get(Calendar.YEAR);
			int mes = fecha.get(Calendar.MONTH);
			int dia = fecha.get(Calendar.DAY_OF_MONTH);
			String fechita=dia +"/" + (mes+1) + "/" + anio;
			DataInputStream fi = new DataInputStream(new FileInputStream(string));
			String cad="\nFecha actual: "+fechita+"\nCodigo\tNombre\tTipo\tPrecio\tStock\tVencimiento\n";
			boolean a;
			while(fi.available()!=0){
				int cod = fi.readInt();
				String nom = fi.readUTF();
				String tip = fi.readUTF();
				double pr = fi.readDouble();
				int st = fi.readInt();
				String fec = fi.readUTF();
				a = calcular(fec);
				if (a){
					cad+=cod+"\t"+nom+"\t"+tip+"\t"+pr+"\t"+st+"\t"+fec+"\n";
				}
			}
			JTextArea jta=new JTextArea(20,50);
			jta.setText(cad);
			JScrollPane barra = new JScrollPane(jta);
			JOptionPane.showMessageDialog(null,barra);
			fi.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "No se pudo leer el archivo");
		}		
	}	 
}
