public class Permanente extends Empleado {
   double salario;
   int diasT;

public Permanente(int ci, String nombre, String cargo, double salario, int diasT) {
 super(ci, nombre, cargo);
 this.salario = salario;
 this.diasT = diasT;
}
public double getSalario() {
 return salario;
}
public int getDiasT() {
 return diasT;
}
public double TotalGanado(){
 return (getSalario()*getDiasT())/30.0;
}
public double TotalDescuento(){
 if (TotalGanado()>4000)
  return TotalGanado()*0.1;
 else
  return 0.0;
}
public double PagoNeto(){
 return TotalGanado()-TotalDescuento();
 
}
public String toString() {
 return super.toString()+"\nSalario basico:"+getSalario()+"\nDias Trabajados:" +getDiasT()+"\nTotalGanado :"
   + (Math.rint(TotalGanado()*10)/10)+ "\nTotalDescuento :"+(Math.rint(TotalDescuento()*10)/10)+ "\nPagoNeto :" 
   + (Math.rint(PagoNeto()*10)/10);
}

}
