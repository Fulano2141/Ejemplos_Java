import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Poblacion {
	int Pobla;
	String Depa;
	public Poblacion(int pobla, String depa) {
		super();
		Pobla = pobla;
		Depa = depa;
	}
	public String getDepa() {
		return Depa;
	}
	public int getPobla() {
		return Pobla;
	}
	public static void añadir(ArrayList<Poblacion> list){
		  String m[]={"Beni","Chuquisaca","Cochabamba","La Paz","Oruro","Pando","Potosi","Santa Cruz","Tarija"};
		  JOptionPane.showMessageDialog(null,"Escriba las poblaciones de cada departamento");
		  for(int i=0;i<9;i++){
			  int v=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la poblacion de "+m[i]));
			  Poblacion obj1=new Poblacion(v,m[i]);
			  list.add(obj1);
	  }
	 }
	public static void maxmin(ArrayList<Poblacion> list){
		  int venta=list.get(0).getPobla(),temp;
		  String mes=list.get(0).getDepa();
		  for(Poblacion tmp:list){
		   temp=tmp.getPobla();
		   if(temp<=venta){
		    venta=temp;
		    mes=tmp.getDepa();
		   }
		  }
		  int ven=list.get(0).getPobla(),tem;
		  String ms=list.get(0).getDepa();
		  for(Poblacion tmp:list){
			   tem=tmp.getPobla();
			   if(tem>=ven){
			    ven=tem;
			    ms=tmp.getDepa();
			   }
			  }
		  JOptionPane.showMessageDialog(null, "La poblacion minima es de "+venta+" personas en "+mes+ "\nLa poblacion maxima es de "+ven+" personas en "+ms);
	}
}