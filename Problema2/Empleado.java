public class Empleado {
    int ci;
    String nombre,cargo;
    public Empleado(int ci, String nombre, String cargo) {
   this.ci = ci;
   this.nombre = nombre;
   this.cargo = cargo;
 }
 public int getCi() {
  return ci;
 }
 public String getNombre() {
  return nombre;
 }
 public String getCargo() {
  return cargo;
 }
 public String toString()
 { 
 return "\n\nCI: "+getCi() + "\nNombre: "+getNombre()+"\nCargo: "+getCargo();

 }
}