
public class Vector3d {
 double x,y,z;

 public Vector3d(double x, double y, double z) {
  this.x = x;
  this.y = y;
  this.z = z;
 }

 public double getX() {
  return x;
 }

 public double getY() {
  return y;
 }

 public double getZ() {
  return z;
 }

 public Vector3d suma(Vector3d aux) {
  double totx = this.getX() + aux.getX();
  double toty = this.getY() + aux.getY();
  double totz = this.getZ() + aux.getZ();
  return (new Vector3d(totx,toty,totz));
 }

 public String toString() {
  return "Vector resultante [x=" + x + ", y=" + y + ", z=" + z + "]";
 }
}
