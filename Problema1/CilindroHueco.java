public class CilindroHueco extends Cilindro
{
  double radioi;
  public CilindroHueco (double radio,double h,double radioi)
  {
    super(radio,h);
    this.radioi=radioi;
  }
  public double getRadioi()
  {
    return radioi;
  }
  public double superficie()
  {
    double s1,s2;
    s1=2.0*getRadio()*(Math.PI)*(getRadio()+getAltura());
    s2=2.0*getRadioi()*(Math.PI)*(getRadioi()+getAltura());
    System.out.println(s1+","+s2);
    return Math.rint((s1-s2)*100)/100;
  }

  public String toString()
  {
    String c1="";
    c1="Superficie cilindro hueco:"+superficie();
    return c1;
}
}
