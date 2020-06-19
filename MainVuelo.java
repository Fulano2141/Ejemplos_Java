
public class MainVuelo {
 public static void main(String[] args) {
  Vuelo n11 = new Vuelo (376,"9:30");
  Vuelo n12 = new Vuelo(376,"12:40");
  Vuelo res1 = n11.generar(n12);
  Vuelo n21 = new Vuelo (937,"11:40");
  Vuelo n22 = new Vuelo(937,"12:30");
  Vuelo res2 = n21.generar(n22);
  Vuelo n31 = new Vuelo (864,"23:10");
  Vuelo n32 = new Vuelo(864,"1:20");
  Vuelo res3 = n31.generar(n32);
  Vuelo n41 = new Vuelo (634,"23:30");
  Vuelo n42 = new Vuelo(634,"1:10");
  Vuelo res4 = n41.generar(n42);
  System.out.println("NVuelo\tHora Salida\tHora Llegada\tTiempo de Vuelo");
  System.out.println(n11.getVuelo() + "\t" + n11.getH() + "\t\t" + n12.getH() + " \t\t\t" + res1.getH());
  System.out.println(n21.getVuelo() + "\t" + n21.getH() + "\t\t" + n22.getH() + " \t\t\t" + res2.getH());
  System.out.println(n31.getVuelo() + "\t" + n31.getH() + "\t\t" + n32.getH() + " \t\t\t" + res3.getH());
  System.out.println(n41.getVuelo() + "\t" + n41.getH() + "\t\t" + n42.getH() + " \t\t\t" + res4.getH());
 }
}
