/*1.- En un AL(ArrayList) agregar las estaturas en cm de varias personas y
 *   determinar la mayor estatura, la estatura más baja y el promedio de 
 *   estaturas. */
import java.util.*;
public class Ejercicio1 {
 ArrayList<Integer> altura=new ArrayList<Integer>();
 public Ejercicio1(ArrayList<Integer>altura) {
  this.altura=altura;
 }
 public int mayor(){
  int may=altura.get(0);
  for(int i:altura){
   if(i>=may)
    may=i;
  } 
  return may;
 }
 public ArrayList<Integer> getAltura(){
  return altura;
 }
 public int menor(){
  int men=altura.get(0);
  for(int i:altura) {
   if(i<=men)
    men=i;
  } 
  return men;
 }
 public int promedio() {
  int prom,n=0,s=0;
  for(int i:altura)  {
   s+=i;
   n++;
  } 
  prom=s/n;
  return prom;
 }
 public String toString(){
  return "Mayor Altura: "+mayor()+" cm\nAltura Menor: "+menor()+" cm\nPromedio: "+promedio()+" cm";
 }
}
