//2.-  Crear una interfaz que simule la entrada a un sistema
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Ej2 extends JFrame implements ActionListener{
 JButton bot1,bot2;
 JLabel l1,l2,l3,l4;
 JTextField t1;
 JPasswordField t2;
 static int i = 0;
  public Ej2() {
   super("CAMBIADOR");
   setDefaultCloseOperation(EXIT_ON_CLOSE);
   setSize(50,200);
   setLocationRelativeTo(null);
   FlowLayout layout = new FlowLayout();
   setLayout(layout);
   l3 = new JLabel("Inicio de Sesion");
   l1 = new JLabel("Usuario: ");
   t1 = new JTextField(10);
   l2 = new JLabel("Contraseña: ");
   t2 = new JPasswordField(10);
   bot2 = new JButton("LOGIN");
   
   add(l3);add(l1);add(t1);add(l2);add(t2);
   add(bot2);
   bot2.addActionListener(this);
   setVisible(true);
  }
 public void actionPerformed(ActionEvent e) {
  if(e.getSource() == bot2) {
   if(auth(t1.getText(),t2.getPassword())) {
    i = 3;
    JOptionPane.showMessageDialog(null, "Login Exitoso", "LOGIN", JOptionPane.OK_OPTION);
    new PLogin();
    //System.exit(0);
   }
   else {
    JOptionPane.showMessageDialog(null, "Login Fallido", "LOGIN", JOptionPane.ERROR_MESSAGE);
    i++;
    if(i == 3) {
     JOptionPane.showMessageDialog(null, "PERMISO DENEGADO", "ERROR", JOptionPane.NO_OPTION);
     System.exit(0);
    }
   }
  }
 }
 
 public boolean auth(String log, char[] pass) {
  String passw = String.valueOf(pass);
  if(log.equals("pepito") && passw.equals("1234")) {
   return true;
  }
  else {
   return false;
  }
 }
 
 public static void main(String[] args) {
   new Ej2();
   
 }
 
}
