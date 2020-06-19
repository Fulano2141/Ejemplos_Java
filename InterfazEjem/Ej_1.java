//1. Crear una interfaz de usuario sin layouts que permita efectuar el cambio de moneda
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Ej_1 extends JFrame implements ActionListener{
 JButton bot1,bot2;
 JLabel l1,l2,l3,l4;
 JTextField t1,t2,t3;
  public Ej_1() {
   super("CAMBIADOR");
   setDefaultCloseOperation(EXIT_ON_CLOSE);
   setLayout(null);
   setSize(500,250);
   setLocationRelativeTo(null);
   
   l1 = new JLabel("Ingrese Bolivianos:");
   l1.setBounds(20,20,120,20);
   t1 = new JTextField(20);
   t1.setBounds(140,20,100,20);
   l2 = new JLabel("Dolares: ");
   l2.setBounds(20,60,100,20);
   t2 = new JTextField(20);
   t2.setBounds(80,60,100,20);
   l3 = new JLabel("Euros: ");
   l3.setBounds(20,100,100,20);
   t3 = new JTextField(20);
   t3.setBounds(80,100,100,20);
   t2.setEditable(false);
   t3.setEditable(false);
   bot1 = new JButton("Convertir");
   bot1.setBounds(250,20,80,20);
   bot2 = new JButton("Limpiar");
   bot2.setBounds(250,60,80,20);
   
   add(l1);add(t1);add(l2);add(t2);add(l3);add(t3);add(bot1);add(bot2);
   bot1.addActionListener(this);
   bot2.addActionListener(this);
   setVisible(true);
  }
 public void actionPerformed(ActionEvent e) {
  if(e.getSource() == bot1) {
   double bol = Double.parseDouble(t1.getText());
   double dol = bol/6.96;
   double eur = bol/9.2;
   double dol1 = Math.round(dol*100d) / 100d;
   double eur2 = Math.round(eur*100d) / 100d;
   t2.setText(""+dol1);
   t3.setText(""+eur2);
  }
  if(e.getSource() == bot2) {
   t1.setText("");
   t2.setText("");
   t3.setText("");
  }
 }
 
 public static void main(String[] args) {
  new Ej_1();
 }
 
}

