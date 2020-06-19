/*
 Calcular el tiempo de vuelo de una aeronave de cual se dispone como datos los siguientes:
 N° Vuelo, hora salida(hh:mm),hora llegada(hh:mm)
 probar con los siguientes casos
 */
public class Vuelo {
 int nVuelo;
 String h;

 public int getVuelo() {
  return nVuelo;
 }
 public String getH() {
  return h;
 }

 public Vuelo(int nVuelo, String h) {
  this.nVuelo = nVuelo;
  this.h = h;
 }
 public Vuelo generar(Vuelo aux) {
  String sal[] = (this.getH()).split(":");
  String lle[] = (aux.getH()).split(":");
  int hrs = Integer.parseInt(sal[0]);
  int mis = Integer.parseInt(sal[1]);
  int hrl = Integer.parseInt(lle[0]);
  int mil = Integer.parseInt(lle[1]);
  String tot = "";
  if(hrs < hrl && mis < mil) {
   int ht = hrl-hrs;
   int mt = mil-mis;
   tot = ht + ":" + mt;
  }
  else if(hrs < hrl && mis > mil) {
   int ht = (hrl-hrs)-1;
   int mt = 60-(mis-mil);
   tot = ht + ":" + mt;
  }
  else if(hrs > hrl && mis < mil) {
   int ht = 24-(hrs-hrl);
   int mt = (mil-mis);
   tot = ht + ":" + mt;
  }
  else if(hrs > hrl && mis > mil) {
   int ht = 24-(hrs-hrl)-1;
   int mt = 60-(mis-mil);
   tot = ht + ":" + mt;
  }
  
  return (new Vuelo(this.getVuelo(),tot));
 }
 
 
}
