public class Eventual extends Empleado{
 int ht;
 double ph;
 
public Eventual(int ci, String nombre, String cargo, int ht, double ph) {
 super(ci, nombre, cargo);
 this.ht = ht;
 this.ph = ph;
}

public int getHt() {
 return ht;
}
public double getPh() {
 return ph;
}
public double TotalGanado(){
   if (getHt()>40)
	   return (getHt()-40)*(1.5)*getPh()+40*getPh();
   else
	   return getHt()*getPh();

}
public double TotalDescuento(){
  if (TotalGanado()>1500)
	return TotalGanado()*0.1;
  else
   	return 0.0;
 }
 
public double PagoNeto(){
 return TotalGanado()-TotalDescuento();
 
}
public String toString() {
 return super.toString()+"\nHoras Trabajadas: "+getHt()+"\nPago por Hora: "+getPh()+ "\nTotalGanado: "
 + TotalGanado()+ "\nTotalDescuento: "+TotalDescuento()+ "\nPagoNeto: " +PagoNeto();
}

}
