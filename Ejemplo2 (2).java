// 2.- Guardar en un archivo de texto los telefonos de varias 
//     personas, y dar funcionlidad a los metodos descritos
package ArchivosTexto;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
public class Ejemplo2 {
	public static void main(String[] args) throws IOException {
		
		for(;true;){
            String [] menu1 = {"Adicion","Busqueda","Reporte","Salir"};
            String valor1 = (String) JOptionPane.showInputDialog(null, "Seleccione la opcion","Opciones",JOptionPane.DEFAULT_OPTION,null,menu1,menu1[0]);
            switch(valor1){
            case "Adicion": adicion();
            				break;
            case "Busqueda":busqueda();
            				break;
            case "Reporte": reporte();
            				break;
            case "Salir": System.exit(0);
            break;
               }
        }
	}
	public static void adicion() throws IOException{
		
		PrintWriter x=new PrintWriter(new FileWriter("Fonos1.txt",true));
		int n=(Integer.parseInt(JOptionPane.showInputDialog("Cuantos telefonos:")));
		for (int i=0;i<n;i++){
			String fono=JOptionPane.showInputDialog("Telefono:");
			x.println(fono);
		}
		x.close();
	}
	
	public static void busqueda() throws IOException{
		BufferedReader x=new BufferedReader(new FileReader("Fonos1.txt"));
		String fono="",cad="";
		int flag=0;
		try {
			String fonobus=JOptionPane.showInputDialog("Telefono a buscar en el archivo:");
			while (x.ready()){
				fono=x.readLine();
				if (fono.equals(fonobus)){
					flag=1;
					break;}
			}
			if (flag==0)
				JOptionPane.showMessageDialog(null,"Telefono inexistente");
			else
				JOptionPane.showMessageDialog(null,"Telefono encontrado");
					
		} catch (IOException e) {
			System.out.println("No existe el archivo");
		}
			
		x.close();
	}
	public static void reporte() throws IOException{
		BufferedReader in=new BufferedReader(new FileReader("Fonos1.txt"));
		String fono="",cad="";
		try {
			while (in.ready()){
				fono=in.readLine();
				cad+=fono+"\n";
			}
			in.close();
			JTextArea area=new JTextArea();
			area.setText(cad);
			JOptionPane.showMessageDialog(null,area,"TELEFONOS", 2);
		} catch (IOException e) {
			System.out.println("No existe el archivo");
		}
	}
}



