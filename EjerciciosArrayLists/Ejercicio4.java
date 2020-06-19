
/*4. – Dada una clase denominada VentasMes, que contiene el valor de una 
 * venta y además el nombre del mes en donde se produjo la misma, se debe 
 * obtener:
- Constructor de la clase
- Getters
- Una función que pueda añadir a un AL de objetos por las ventas de un año.
- Una función me indique el mes en donde se dieron las ventas máximas de la 
empresa
- Una función que obtenga el total de ventas en el año 
- Una función que muestre la venta menor y el mes respectivo
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
