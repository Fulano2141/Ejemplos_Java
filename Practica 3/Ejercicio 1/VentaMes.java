import java.util.ArrayList;
import javax.swing.JOptionPane;
public class VentaMes{
	double venta;
	 String mes;
	 public VentaMes(double venta,String mes){
	  this.venta=venta;
	  this.mes=mes;
	 }
	 public double getVenta(){
	  return venta;
	 }
	 public String getMes(){
	  return mes;
	 }
	 public static void añadir(ArrayList<VentaMes> lista){
		  String m[]={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
		  JOptionPane.showMessageDialog(null,"Escriba las ventas del año");
		  for(int i=1;i<=12;i++){
			  double v=Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese la venta de "+m[i]));
			  VentaMes obj1=new VentaMes(v,m[i-1]);
			  lista.add(obj1);
	  }
	 }
	 public static void max(ArrayList<VentaMes> lista){
	  double venta=lista.get(0).getVenta(),temp;
	  String mes=lista.get(0).getMes();
	  for(VentaMes tmp:lista){
	   temp=tmp.getVenta();
	   if(temp>=venta){
	    venta=temp;
	    mes=tmp.getMes();
	   }
	  }
	  JOptionPane.showMessageDialog(null, "La venta maxima fue de "+venta+" Bs en "+mes);
	 }
	 public static void total(ArrayList<VentaMes> lista){
	  double tot=0;
	  for(VentaMes tmp:lista){
	   tot+=tmp.getVenta();
	  }
	  JOptionPane.showMessageDialog(null, "El total de las ventas es de "+tot+" Bs");
	 }
	 public static void min(ArrayList<VentaMes> lista){
	  double venta=lista.get(0).getVenta(),temp;
	  String mes=lista.get(0).getMes();
	  for(VentaMes tmp:lista){
	   temp=tmp.getVenta();
	   if(temp<=venta){
	    venta=temp;
	    mes=tmp.getMes();
	   }
	  }
	  JOptionPane.showMessageDialog(null, "La minima venta fue de "+venta+" Bs en "+mes);
	 }
}
