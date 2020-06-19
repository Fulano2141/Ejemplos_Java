/*6.- Se debe crear un archivo que contenga un diccionario de Ingles a Español, de tal forma que la aplicación permita:
- Añadir nuevas palabras 
- Búsqueda de palabras en ambos idiomas
- Permita desplegar el diccionario por la inicial de la palabra en inglés o español.
*/
import java.io.*;
import java.util.*;
import javax.swing.*;
public class Ejer6 {
	public static void main (String[] args) throws IOException{
		for(;;){
			String []menu = {"Almacenar datos","Ordenar por letra","Ver datos","Buscar","Salir"};
			String valor= (String) JOptionPane.showInputDialog(null, "Seleccione la opcion:","SAlARIOS", JOptionPane.DEFAULT_OPTION,null,menu,menu);
			switch (valor){
			case "Almacenar datos": crear();break;
		    case "Ordenar por letra": ordenar();break;
		    case "Ver datos":leer("Palabras.txt");break;
		    case "Buscar":buscar("Palabras.txt");break;
		    case "Salir": System.exit(0);
		    }
		}
	}
	public static void buscar(String i) {
		try {
			BufferedReader in=new BufferedReader(new FileReader(i));
			String nom="";
			String bus=JOptionPane.showInputDialog("Palabra a buscar:");
			boolean z=true;
			for(;(nom=in.readLine())!=null;){
				String[] parts=nom.split(";");
				if(parts[0].equals(bus) || parts[1].equals(bus)) {
					JOptionPane.showMessageDialog(null, "Palabra encontrada");
					z=false;
				}
				else
					continue;				
					
			}
			if(z)
				JOptionPane.showMessageDialog(null, "Palabra no encontrada");
			in.close();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"No se encontro el archivo: "+e);
		}
	}
	@SuppressWarnings("unlikely-arg-type")
	public static void ordenar()throws IOException {
		try {
			ArrayList<String> nome=new ArrayList<String>();
			BufferedReader in=new BufferedReader(new FileReader("Palabras.txt"));
			String nom="";
			int i=0;
			for(;(nom=in.readLine())!=null;){
				nome.add(nom);
				i++;
			}
			Collections.sort(nome);
			in.close();
			FileWriter fichero=new FileWriter("InEs.txt");
			PrintWriter pw=new PrintWriter(fichero);
			String r=JOptionPane.showInputDialog("Ingrese la letra a desplegar");
			for(int c=0;c<i;c++){
				String x=nome.get(c);
				String[] parts=x.split(";");
				if(r.equals(parts[0].charAt(0)))
					pw.println();
				else
					continue;
			}
			fichero.close();
			BufferedReader on=new BufferedReader(new FileReader("InEs.txt"));
			String om="",aux="Palabras\n";
			for(;(om=on.readLine())!=null;){
				String[] parts=om.split(";");
				aux+=parts[0]+"\t"+parts[1]+"\n";
			}
			JTextArea area=new JTextArea();
			area.setText(aux);
			JOptionPane.showMessageDialog(null, area);
			in.close();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"No se encontro el archivo: "+e);
		}
	}
	public static void crear() throws IOException{
		try {
			FileWriter fichero=new FileWriter("Palabras.txt",true);
			PrintWriter pw=new PrintWriter(fichero);
			int n=Integer.parseInt(JOptionPane.showInputDialog(null,"Cuantas palabras desea agregar: "));
			for(int i=0;i<n;i++){
				String in=JOptionPane.showInputDialog(null,"Ingrese la palabra en ingles");
				String es=JOptionPane.showInputDialog(null,"Ingrese la palabra en espanol");
				String sal=in+";"+es;
				pw.println(sal);
			}
			fichero.close();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Hubo un error al crear el archivo de tipo: "+e);
		  	}
	}
	public static void leer(String i) throws IOException{
		try {
			BufferedReader in=new BufferedReader(new FileReader(i));
			String nom="",aux="Palabras\n";
			for(;(nom=in.readLine())!=null;){
				String[] parts=nom.split(";");
				aux+=parts[0]+"\t"+parts[1]+"\n";
			}
			JTextArea area=new JTextArea();
			area.setText(aux);
			JOptionPane.showMessageDialog(null, area);
			in.close();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"No se encontro el archivo: "+e);
		}
	}
	
}
