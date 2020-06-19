/* 11.-  Dado un arreglo que contiene la población de los nueve departamentos del 
 * país y otro que contiene los nombres de estos departamentos, genere un básico 
 * grafico estadístico que muestre esta población (utilice un factor de escala), 
 * además indique el nombre del departamento que tiene la mayor población y el nombre 
 * del departamento que tiene la menor población.  */
import javax.swing.*;
import java.util.*;
class Problema11{
  public static void main(String [] Fulano){
    System.out.println("Departamento    Poblacion");
    String nom[]={"Beni      ","Chuquisaca","Cochabamba","La Paz    ","Oruro     ","Pando     ","Potosi    ","Santa Cruz","Tarija    "};
    int[] pob={421196,576153,1758143,2706351,494178,110436,823517,2655084,482196};
    for (int i=0;i<9;i++){
      System.out.println(nom[i]+"      "+pob[i]);
    }int a=0,menor=0,mayor=0;
    for (int i=0;i<9;i++){
      if(pob[i]<menor){
        menor=pob[i];
        a=i;}} 
    System.out.println("La menor poblacion es de: "+nom[a]+" con "+pob[a]);a=0;
    for (int i=0;i<9;i++){
      if(pob[i]>mayor){
        mayor=pob[i];
        a=i;}}
    System.out.println("La mayor poblacion es de: "+nom[a]+" con "+pob[a]);
  }
} 