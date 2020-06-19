/* 1.- La loter�a nacional ha decidido efectuar el sorteo de n n�meros de loter�a que ser�n premiados por orden de sorteo, 
 * la instituci�n dispone del registro de m�ltiples n�meros de loter�a que tienen 5 d�gitos del (10000 al 99999).
 * La simulaci�n de este proceso debe considerar:
 * -	Almacenamiento de los n�meros de loter�a (emplear un archivo binario con n�meros al azar  que no se repitan).     
 * -	Efectuar el sorteo de 10  n�meros de loter�a
 * -	Publicar estos n�meros  para su difusi�n de la forma:   
 * Ej:
 *        Premio 	     N�mero
 *        1	12345
 *        2	93835
 *        3	28346
 *            ��                 ���.
 *        10	          94353
 * -	Guardar en un archivo de texto estos n�meros premiados.
 * -	Se premian todas las terminaciones, por lo tanto generar una salida indicando 
 *      cuantos n�meros terminados en el n�mero ganador existen. 
 */
import java.io.*;
import java.util.*;
import javax.swing.*;
public class Ejercicio1 {
	public static void main(String[] args) throws IOException {
		for(;true;){
			String[] menu1 = {"Generar numeros nuevos","Reporte de todos los numeros","Reporte de los ganadores","Extraer Ganadores en archivo de texto","Numero de boletos premiados", "Salir"};
			String valor1 = (String) JOptionPane.showInputDialog(null, "Seleccione la opcion", "Opciones", JOptionPane.DEFAULT_OPTION, null, menu1,menu1[0]);
			switch(valor1){
			case "Generar numeros nuevos": escri("Azar.dat");break;
			case "Reporte de todos los numeros": leer("Azar.dat",1);break;
			case "Reporte de los ganadores": leer("Azar.dat",2);break;
			case "Extraer Ganadores en archivo":ord("Azar.dat");break;
			case "Numero de boletos premiados":pre("Azar.dat");break;
			case "Salir": System.exit(0);
			}
		}
	}
	public static void pre(String string) throws IOException {
		DataInputStream dis=new DataInputStream(new FileInputStream(string));
		int i=0,nume=1,c=10,first=1;
		while(dis.available()!=0){
			i++;
			if(i==1)
				first=dis.readInt();
			else
				nume=dis.readInt();
			if((first%10)==(nume%10))
				c++;
		}
		JOptionPane.showMessageDialog(null,"Numero de boletos premiados: "+c);
	}
	public static void ord(String fich) {
		try{
			DataInputStream dis=new DataInputStream(new FileInputStream(fich));
			File f2=new File("Ganadores.txt");
			BufferedWriter bw=new BufferedWriter(new FileWriter(f2));
			int i=0,nume;
			while(dis.available()!=0){
				i++;
				nume=dis.readInt();
				if(i!=10) {
					bw.write(Integer.toString(nume));
					bw.newLine();
				}
			}
			bw.close();
			dis.close();
		    JOptionPane.showMessageDialog(null, "Archivo extraido");
        }
		catch(EOFException e){
            System.out.println("Fin del fichero");
        }
		catch(IOException e){
            System.out.println("Error E/S"+e);
        }
	}
	public static void leer(String fich, int x) throws IOException {
		try{
			DataInputStream dis=new DataInputStream(new FileInputStream(fich));
			String cad="Premio\tNumero de Boleto\n";
			int i=0,nume;
			
			while(dis.available()!=0){
				i++;
				nume=dis.readInt();
				if(x==1)
					cad=cad+i+"\t"+nume+"\n";
				if(x==2 && i<=10)
					cad=cad+i+"\t"+nume+"\n";
			}
			JTextArea are=new JTextArea();
		    are.setText(cad);
		    JOptionPane.showMessageDialog(null, are,"Datos", 1);
		    dis.close();
        }
		catch(EOFException e){
            System.out.println("Fin del fichero");
        }
		catch(IOException e){
            System.out.println("Error E/S"+e);
        }
	}
	public static void escri(String fich) throws IOException {
		 try{
			 DataOutputStream dos=new DataOutputStream(new FileOutputStream(fich));
			 Random rnd = new Random(); 
			 int c=0;
			 int n=Math.abs(Integer.parseInt(JOptionPane.showInputDialog("Cuantos numeros al azar desea agregar al archivo:")));
			 while(n>c) {				 
				 c++;
				 int nume=Math.abs((int)(rnd.nextInt(89999))+10000);
				 dos.writeInt(nume);
			 }
			 dos.close();
			 JOptionPane.showMessageDialog(null,"Archivo generado");
		 }catch(IOException e){
			 System.out.println("Error E/S");
		 }
	}
}	