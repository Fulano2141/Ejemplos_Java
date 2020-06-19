import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class textoLogs extends JFrame implements KeyListener{
  public static void main(String[] ar) {
    textoLogs f=new textoLogs();
    f.setBounds(0,0,350,230);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }  
  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JTextField txtFIntro= new JTextField();
  public JTextArea txtALog = new JTextArea();
  public textoLogs() {
//  System.out.println("Estoy construido");    
    setTitle("Logs");
    setBounds(50, 50, 400, 300);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(new BorderLayout(0, 0));
    setContentPane(contentPane);
    
    txtFIntro.setBorder(new LineBorder(new Color(0, 0, 0)));
    contentPane.add(txtFIntro, BorderLayout.SOUTH);
    txtFIntro.setColumns(10);
    txtFIntro.addKeyListener(this);
    
    txtALog.setBorder(new LineBorder(new Color(0, 0, 0)));
    txtALog.setBackground(new Color(225, 225, 225));
    txtALog.setEditable(false);
    contentPane.add(txtALog, BorderLayout.CENTER);
    
    setVisible(true);
  }
  public void keyPressed(KeyEvent arg0) {
    if (arg0.getKeyCode() == KeyEvent.VK_ENTER)
      txtALog.setText(txtFIntro.getText());
  }
  public void keyReleased(KeyEvent arg0) {}
  public void keyTyped(KeyEvent arg0) {
   // if (arg0.getKeyCode() == KeyEvent.VK_ENTER)System.out.println("He presionado enter");
 }
}