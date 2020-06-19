import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class pru1 {

	public static void main(String[] args) throws IOException {
		for(;;) {
			String [] menu= {"Agregar","Reporte","Vence","Salir"};
			String valor=(String) JOptionPane.showInputDialog(null,"Seleccione una opcion: ","Mensaje",JOptionPane.DEFAULT_OPTION,null,menu,menu[0]);
			switch(valor) {
			case "Agregar":agregar();break;
			case "Reporte":lectura();break;
			case "Vence":vence();break;
			case "Salir":System.exit(0);
			}
		}

	}
	
	public static void agregar() throws IOException {
	
		DataOutputStream fs = new DataOutputStream(new FileOutputStream("productos.dat",true));
		String c1= JOptionPane.showInputDialog("Ingrese el codigo del producto");
		String c2= JOptionPane.showInputDialog("Ingrese la descripcion del producto");
		String c3= JOptionPane.showInputDialog("Ingrese el precio unitario del producto");
		String c4= JOptionPane.showInputDialog("Ingrese el Stock");
		String c5= JOptionPane.showInputDialog("Ingrese la fecha de vencimiento(dd/mm/aaaa)");
		int cod= Integer.parseInt(c1);
		double precio=Double.parseDouble(c3);
		int stock= Integer.parseInt(c4);
		fs.writeInt(cod);
		fs.writeUTF(c2);
		fs.writeDouble(precio);
		fs.writeInt(stock);
		fs.writeUTF(c5);
		fs.close();
	}

	public static void lectura() throws IOException{
		DataInputStream fi= new DataInputStream(new FileInputStream("productos.dat"));
		try {
			double tot=0;
			String cad="Codigo\t\tDescripcion\t\t Precio unitario\t\t Stock\t\tPrecio parcial \t\tFecha de vencimiento \n";  
			cad+="----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
			while(fi.available()!=0) {
				int cod=fi.readInt();
				String des=fi.readUTF();
				double precio=fi.readDouble();
				int stock=fi.readInt();
				double pp=precio*stock;
				String fecha=fi.readUTF();
				tot=tot+pp;
				cad+=cod+"\t\t"+des+"\t\t"+precio+"\t\t"+stock+"\t\t"+pp+"\t\t"+fecha+"\n"; 
			}
			
			cad+="\n";
			cad+="total: "+tot;
			JTextArea ob = new JTextArea(20,50);
		      ob.setText(cad);
		      JScrollPane ob1 = new JScrollPane(ob);
		      JOptionPane.showMessageDialog(null, ob1);
		      fi.close();
			
			
		}
		catch(IOException ioe){
			
		}
		
	}
	public static void vence() throws IOException{
		DataInputStream fi= new DataInputStream(new FileInputStream("productos.dat"));
		try {
			String cad="Codigo\t\tDescripcion\t\t Fecha de vencimiento \n";  
			cad+="-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
			while(fi.available()!=0) {
				int cod=fi.readInt();
				String des=fi.readUTF();
				double precio=fi.readDouble();
				int stock=fi.readInt();
				double pp=precio*stock;		
				String fecha=fi.readUTF();
				String[] fec=fecha.split("/");
				int dia=Integer.parseInt(fec[0]);
				int mes=Integer.parseInt(fec[1]);
				int año=Integer.parseInt(fec[2]);
				System.out.println(dia+" "+mes+" "+año);
				if(año<2017 ||año==2017&&mes<9||año==2017&&mes<=9&&dia<29) {
					cad+=cod+"\t\t"+des+"\t\t"+fecha+"\n";
				}
			}
				JTextArea ob = new JTextArea(20,50);
			      ob.setText(cad);
			      JScrollPane ob1 = new JScrollPane(ob);
			      JOptionPane.showMessageDialog(null, ob1);
			      fi.close();

				
				
			
		}
		catch(IOException ioe){
			
		}
		
	}
}
