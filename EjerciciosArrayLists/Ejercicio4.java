
/*4. � Dada una clase denominada VentasMes, que contiene el valor de una 
 * venta y adem�s el nombre del mes en donde se produjo la misma, se debe 
 * obtener:
- Constructor de la clase
- Getters
- Una funci�n que pueda a�adir a un AL de objetos por las ventas de un a�o.
- Una funci�n me indique el mes en donde se dieron las ventas m�ximas de la 
empresa
- Una funci�n que obtenga el total de ventas en el a�o 
- Una funci�n que muestre la venta menor y el mes respectivo
 */

public class Ejercicio4 {
 double venta;
 String mes;
 public Ejercicio4(double venta,String mes)
 {
  this.venta=venta;
  this.mes=mes;
 }
 public double getVenta()
 {
  return venta;
 }
 public String getMes()
 {
  return mes;
 }
 
}
