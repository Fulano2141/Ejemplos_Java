/* 7.   A partir de dos vectores constantes que contienen nombres de 7 
 * personas cada uno. Escribir un programa que escriba la palabra “Iguales” 
 * si ambos vectores son iguales y “Diferentes" si no lo son. Serán iguales
 * cuando en la misma posición de ambos vectores se tenga el mismo valor para
 * todos los elementos. */
import javax.swing.*;
import java.util.*;
class Problema07{
  public static void main (String [] Fulano){
    int j=1;
    String nom1[]={"Cosme","FUlano","Alberto","Rufa","Blanca","Cpp","Julio"};
    String nom2[]={"Cosme","Flano","Rufina","Rufa","Alberto","Cpp","Julio"};
    for(int i=0;i<7;i++){
      if(nom1[i]==nom2[i])
        System.out.println("Posicion: "+j+" Iguales");
      else
        System.out.println("Posicion: "+j+" Distintos");
      j++;
    }
  }
}