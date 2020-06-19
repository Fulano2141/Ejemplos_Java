/* 2.- Un archivo tipo Objeto contiene el código de un producto farmacéutico, su nombre comercial,  
 * su presentación (tableta, jarabe,gotas..etc), el nombre de la firma distribuidora (Inti, Lab.Vita, 
 * TecnoFarma, Alcos…) y el país de procedencia
 * •	Añadir nuevos datos al archivo (en donde la presentación, el nombre de la distribuidora  y el país de procedencia sean elegidos de una lista).
 * •	Reporte general del archivo
 * •	Reporte por distribuidora
 * •	Reporte por país de procedencia
 * •	Copiar a un segundo archivo los datos de los productos que sean de laboratorios nacionales
 */
import java.io.*;
import java.util.*;
import javax.swing.*;
public class Ejercicio2{
	public static void main(String[] args) throws IOException {
		for(;true;){
			String[] menu1 = {  "Agregar productos","Reporte","Reporte por distribuidora","Reporte por pais","Copiar reporte","Salir"};
			String valor1 = (String) JOptionPane.showInputDialog(null, "Seleccione la opcion", "Opciones", JOptionPane.DEFAULT_OPTION, null, menu1,menu1[0]);
			switch(valor1){
			case "Agregar productos": escri("Productos.dat");break;
			case "Reporte": leer("Productos.dat",1);break;
			case "Reporte por distribuidora": leer("Productos.dat",2);break;
			case "Reporte por pais":leer("Productos.dat",3);break;
			case "Copiar reporte":pre("Productos.dat","Nacionales.txt");break;
			case "Salir": System.exit(0);
			}
		}
	}
	public static void pre(String string, String string2) throws IOException {
		try{
			DataInputStream dis=new DataInputStream(new FileInputStream(string));
			File f2=new File(string2);
			BufferedWriter bw=new BufferedWriter(new FileWriter(f2));
			while(dis.available()!=0){
				String Cod=""+dis.readInt();
				String Nom=dis.readUTF();
				String Pre=dis.readUTF();
				String Dis=dis.readUTF();
				String Pai=dis.readUTF();
				if(Pai.equals("Bolivia")) {
					String cad="Codigo: "+Cod+" Nombre: "+Nom+" Presentacion: "+Pre+" Distribuidora: "+Dis+" Pais: "+Pai;
					bw.write(cad);
					bw.newLine();
				}
			}
			JOptionPane.showMessageDialog(null,"Archivo generado");
			dis.close();
			bw.close();
		}
		catch(IOException e){
			System.out.println("Error E/S"+e);
		}		
	}
	public static void leer(String fich,int flag) throws IOException {
		try{
			DataInputStream dis=new DataInputStream(new FileInputStream(fich));
			String cad="Codigo\tNombre\tPresentacion\tDistribuidora\tProcedencia\n";
			ArrayList<String> list=new ArrayList<String>();
			if(flag==1) {
				while(dis.available()!=0){
					String Cod=""+dis.readInt();
					String Nom=dis.readUTF();
					String Pre=dis.readUTF();
					String Dis=dis.readUTF();
					String Pai=dis.readUTF();
					cad=cad+Cod+"\t"+Nom+"\t"+Pre+"\t"+Dis+"\t"+Pai+"\n";
				}
			}
			if(flag==2) {
				int c=0;
				while(dis.available()!=0){
					String Cod=""+dis.readInt();
					String Nom=dis.readUTF();
					String Pre=dis.readUTF();
					String Dis=dis.readUTF();
					String Pai=dis.readUTF();
					list.add(Dis+";"+Cod+";"+Nom+";"+Pre+";"+Pai);
					c++;
				}
				Collections.sort(list);
				for(int i=0;i<c;i++) {
					String aux=list.get(i);
					String k[]=aux.split(";");
					cad+=k[1]+"\t"+k[2]+"\t"+k[3]+"\t"+k[0]+"\t"+k[4];
				}
			}
			if(flag==3) {
				int c=0;
				while(dis.available()!=0){
					String Cod=""+dis.readInt();
					String Nom=dis.readUTF();
					String Pre=dis.readUTF();
					String Dis=dis.readUTF();
					String Pai=dis.readUTF();
					list.add(Pai+";"+Cod+";"+Nom+";"+Pre+";"+Dis);
					c++;
				}
				Collections.sort(list);
				for(int i=0;i<c;i++) {
					String aux=list.get(i);
					String k[]=aux.split(";");
					cad+=k[1]+"\t"+k[2]+"\t"+k[3]+"\t"+k[4]+"\t"+k[0];
				}
				
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
			 DataOutputStream dos=new DataOutputStream(new FileOutputStream(fich,true));
			 int c=0;
			 int n=Math.abs(Integer.parseInt(JOptionPane.showInputDialog("Cuantos productos desea agregar:")));
			 while(n>c) {				 
				 c++;
				 int Cod=Integer.parseInt(JOptionPane.showInputDialog("Codigo del producto:"));
				 dos.writeInt(Cod);
				 String Nom=JOptionPane.showInputDialog("Nombre del producto:");
				 dos.writeUTF(Nom);
				 String Pre=JOptionPane.showInputDialog("Presentacion:");
				 dos.writeUTF(Pre);
				 String Dis=JOptionPane.showInputDialog("Distribuidora:");
				 dos.writeUTF(Dis);
				 String Pai=JOptionPane.showInputDialog("Procedencia:");
				 dos.writeUTF(Pai);
			 }
			 dos.close();
		 }catch(IOException e){
			 System.out.println("Error E/S");
		 }
	}
}
