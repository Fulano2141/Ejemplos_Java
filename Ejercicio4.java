/* 4.- Se debe almacenar los datos de las transacciones bancarias de clientes que tienen su caja de 
 * ahorros en un banco, para lo cual se debe crear un archivo de objetos que guarde los siguientes datos:
 * - Número de cuenta
 * - Nombre del cliente
 * - Fecha de apertura de cuenta
 * - Saldo actual
 * Se deben crear funciones para:
 * -	Añadir nuevos clientes
 * -	Efectuar la búsqueda por número de cliente
 * -	Generar un reporte de todos los clientes
 * -	Generar un grafico tipo barras con los saldos de por lo menos 10 clientes
 */
import java.io.*; 
import java.util.*;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
public class Ejercicio4 {
	public static void main(String[] args) throws IOException {
		for(;true;){
			String [] menu = {"Añadir nuevos clientes","Buscar por numero de cuenta","Reporte","Graficar saldos","Salir"};
			String valor = (String) JOptionPane.showInputDialog(null, "Seleccione la opcion","Opciones",JOptionPane.DEFAULT_OPTION,null,menu,menu[0]);
			switch(valor){
			case "Añadir nuevos clientes": adicionar("Banco.dat"); break;
			case "Reporte": reporte("Banco.dat"); break;
			case "Buscar por numero de cuenta": buscar("Banco.dat"); break;
			case "Graficar saldos":grafi("Banco.dat");break;
			case "Salir": System.exit(0); break;
			}
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
			String fec = fi.readUTF();
			double sal = fi.readDouble();
			String graf=nom+";"+sal;
			list.add(graf);
			c++;
		}
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(int i=0;i<c;i++) {
			String aux=list.get(i);
			String k[]=aux.split(";");
			double aux1=Double.parseDouble(k[1]);
			dataset.setValue(aux1,"2018", k[0]);
		}
		JFreeChart chart = ChartFactory.createBarChart("Saldos","Nombre", "Saldo", dataset, PlotOrientation.VERTICAL,
	                true,false,false);
		 ChartFrame frame = new ChartFrame("Grafica de saldos", chart);
	        frame.pack();
	        frame.setVisible(true);
		fi.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "El archivo no pudo ser creado");
		}
	}
	public static void buscar(String string) throws IOException{
		try {
			DataInputStream fi = new DataInputStream(new FileInputStream(string));
			int bus=Integer.parseInt(JOptionPane.showInputDialog("Numero de cuenta a buscar"));
			String cad="Codigo\tNombre\tFecha de apertura\tSaldo Actual\n";
			boolean full=false;
			while(fi.available()!=0){
				int cod = fi.readInt();
				String nom = fi.readUTF();
				String fec = fi.readUTF();
				double sal = fi.readDouble();
				if(cod==bus) {
					cad+=cod+"\t"+nom+"\t"+fec+"\t\t"+sal+"\t"+"\n";
					full=true;
					}
			}if(full) {
				JTextArea jta=new JTextArea(20,50);
				jta.setText(cad);
				JScrollPane barra = new JScrollPane(jta);
				JOptionPane.showMessageDialog(null,barra);
			}
			else
				JOptionPane.showMessageDialog(null, "Numero no encontrado");
			fi.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "no se pudo leer el archivo");
		}
	}
	public static void adicionar(String string) throws IOException {
		try {
			DataOutputStream fs = new DataOutputStream(new FileOutputStream(string,true));
			int x, cod=0;
			String nom,fec;
			double sal;
			x=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el de clientes:"));
			for(int i=0; i<x; i++){
				while(cod==0){
					try {
						cod=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de cuenta: "));
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Ingrese numeros");
					}
				}
				nom=JOptionPane.showInputDialog(null,"Ingrese el nombre");
				fec=JOptionPane.showInputDialog(null,"Fecha de apertura");
				sal = Double.parseDouble(JOptionPane.showInputDialog("Saldo:"));
				fs.writeInt(cod);
				fs.writeUTF(nom);
				fs.writeUTF(fec);
				fs.writeDouble(sal);
				cod=0;
			}
			fs.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "El archivo no pudo ser creado");
		}
	}
	public static void reporte(String string) throws IOException {
		try {
			DataInputStream fi = new DataInputStream(new FileInputStream(string));
			String cad="Codigo\tNombre\tFecha de apertura\tSaldo Actual\n";
			double sum=0.0;
			while(fi.available()!=0){
				int cod = fi.readInt();
				String nom = fi.readUTF();
				String fec = fi.readUTF();
				double sal = fi.readDouble();
				cad+=cod+"\t"+nom+"\t"+fec+"\t\t"+sal+"\t"+"\n";
				sum+=sal;
			}
			cad+="\nTotal en banco\t\t\t\t"+sum;
			JTextArea jta=new JTextArea(20,50);
			jta.setText(cad);
			JScrollPane barra = new JScrollPane(jta);
			JOptionPane.showMessageDialog(null,barra);
			fi.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "no se pudo leer el archivo");
		}
	} 
}
