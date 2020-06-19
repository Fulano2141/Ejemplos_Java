public class Cilindro extends Circulo
{
  double altura;
  public Cilindro (double radio,double altura)
  {
    super(radio);
    this.altura=altura;
  }
  public double getAltura()
  {
    return altura;
  }
  public double superficie()
  {
    return Math.rint((2.0*getRadio()*(Math.PI)*(getRadio()+getAltura()))*100)/100;
  }

public String toString()
{
 String c="";
 c="Superficie cilindro: "+superficie();
 return c;
}

}
