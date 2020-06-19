package fabri;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class Frame1 extends JFrame implements ActionListener {
 private JTextField txt;
 private JButton boton;
 private JPanel panel;
 
 public Frame1() {
  super("VENTANA 1");
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  init();
  this.setSize(450, 450);
  this.setLocationRelativeTo(null);
  this.setVisible(true);
 }
 
 public void init() {
  txt = new JTextField(15);
  boton = new JButton("Enviar Texto");
  boton.addActionListener(this);
  panel = new JPanel(new FlowLayout());
  panel.add(txt);
  panel.add(boton);
  add(BorderLayout.CENTER, panel);
 }
 
 public String obtenerTexto() {
  return txt.getText();
 }
 
 public void actionPerformed(ActionEvent e) {
  if (e.getSource() == boton) {
   this.dispose();
   frame2 frame2 = new frame2();
   frame2.asignarTexto(obtenerTexto());
  }
 }
}
