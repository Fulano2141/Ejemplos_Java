/* 10.- Un arreglo contiene las calificaciones de un examen dado por 
 * un grupo de estudiantes, otro arreglo contiene los nombres de los 
 * mismos y un tercer arreglo contiene la sigla de la carrera. 
 * Escribir un programa que permita obtener el nombre del alumno que 
 * obtuvo la mayor y el nombre del alumno que obtuvo la nota menor, 
 * además mostrar que carrera tuvo un desempeño mayor con relación al promedio   del curso. */
import javax.swing.*;
import java.util.*;
class Problema10{
  public static void main (String [] Fulano){
    int cal[]={3,6,4,5,10,2,8,9,1,7};
    String nom[]={"A","B","C","D","F","G","H","I","J","K"};
    String car[]={"INS","INM","INC","ADM","ECO"};
    int x=0,a=0,menor=10,mayor=0;
    for (int i=0;i<9;i++){
      if(cal[i]<menor){
        menor=cal[i];
        a=i;}
    }
    System.out.println("La menor nota es del estudiante: "+nom[a]+" con "+cal[a]);x=0;a=0;
    for (int i=0;i<9;i++){
      if(cal[i]>mayor){
        mayor=cal[i];
        a=i;}}
    System.out.println("La mayor nota es del estudiante: "+nom[a]+" con "+cal[a]);
  }
}