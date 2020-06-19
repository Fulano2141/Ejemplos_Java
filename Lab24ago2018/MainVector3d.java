import javax.swing.JOptionPane;

public class MainVector3d {
 public static void main(String[] args) {
 double x1 = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el valor de x: "));
 double y1 = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el valor de y: "));
 double z1 = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el valor de z: "));
 Vector3d v1 = new Vector3d(x1,y1,z1);
 double x2 = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el valor de x: "));
 double y2 = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el valor de y: "));
 double z2 = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el valor de z: "));
 Vector3d v2 = new Vector3d(x2,y2,z2);
 Vector3d s = v1.suma(v2);
 JOptionPane.showMessageDialog(null, s, "Resultado", JOptionPane.DEFAULT_OPTION);
 }
}
