import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class PLogin extends JFrame{
 JLabel l3;
 public PLogin() {
 super("ACCESO AL SISTEMA");
 setDefaultCloseOperation(EXIT_ON_CLOSE);
 setSize(50,200);
 setLocationRelativeTo(null);
 FlowLayout layout = new FlowLayout();
 setLayout(layout);
 l3 = new JLabel("Bienvenido Pepito");
 
 add(l3);
 setVisible(true);
}
}