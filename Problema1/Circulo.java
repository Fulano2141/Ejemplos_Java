public class Circulo
{
  protected double radio;
  public Circulo (double radio)
  {
    this.radio=radio;
  }
  public double getRadio()
  {
    return radio;
  }
  public double superficie()
  {
    return Math.rint((getRadio()*getRadio()*(Math.PI))*100)/100;
  }

public String toString()
{
  String c1="";
  c1="Superficie circulo:"+superficie();
  return c1;
}
}
