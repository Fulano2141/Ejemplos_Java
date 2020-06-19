import java.io.*;
import java.util.*;
import javax.swing.*;
public class Ejer2 {
	public static void main(String[] args) throws IOException {
		for(;true;){
			String[] menu1 = {"Generar numeros nuevos","Reporte de todos los numeros","Reporte de los ganadores","Ordenado", "Salir"};
			String valor1 = (String) JOptionPane.showInputDialog(null, "Seleccione la opcion", "Opciones", JOptionPane.DEFAULT_OPTION, null, menu1,menu1[0]);
			switch(valor1){
			case "Generar numeros nuevos": escri("Azar.dat");break;
			case "Reporte de todos los numeros": leer("Azar.dat",1);break;
			case "Reporte de los ganadores": leer("Azar.dat",2);break;
			case "Ordenado":ord("Azar.dat");break; //Funcion para ordenar los numeros y verificar que no se hayan repetido
			case "Salir": System.exit(0);
			}
		}
    }
	public static void ord(String fich) {
		try{
			DataInputStream dis=new DataInputStream(new FileInputStream(fich));
			String cad="Premio\tNumero de Boleto\n";
			ArrayList<Integer> list=new ArrayList<Integer>();
			int i=0,nume;
			while(dis.available()!=0){
				i++;
				nume=dis.readInt();
				list.add(nume);
			}
			dis.close();
			Collections.sort(list);
		    DataInputStream di=new DataInputStream(new FileInputStream(fich));
		    int c=0;
		    while(i>c){
				cad=cad+(c+1)+"\t"+list.get(c)+"\n";
				c++;
			}
		    JTextArea are=new JTextArea();
		    are.setText(cad);
		    JOptionPane.showMessageDialog(null, are,"Datos", 1);
		    di.close();
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
				 //int nume=(int)(Math.random()*8999+1000);
				 //JOptionPane.showMessageDialog(null, nume);
				 dos.writeInt(nume);
			 }
			 dos.close();
			 JOptionPane.showMessageDialog(null,"Archivo generado");
		 }catch(IOException e){
			 System.out.println("Error E/S");
		 }
	}
}
