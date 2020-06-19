// Ejemplo del uso de 3 tipos de eventos:
// KeyListener, ActionListener  y MouseListener
// Se usan 3 componentes para demostrar la funcionalidad de los eventos
// El boton para el ActionListener
// La etiqueta para el MouseListener
// La caja de texto para el KeyListener

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class KeyAction extends JFrame implements KeyListener,MouseListener
{
   // JButton jb=new JButton("Boton1"); // Permitira ejecutar a ActionListener
    JLabel jl=new JLabel("Texto de la etiqueta"); // Permitira ejecutar a MouseListener
    JTextField jt=new JTextField(20); // Permitira ejecutar e KeyListener
    
 //@Override
    public KeyAction()
  {
 
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     this.setSize(400,400);
            this.setLocationRelativeTo(null);  // pone la ventana al centro
            this.setLayout(new FlowLayout());
     //       this.add(jb);
            this.add(jl);
            this.add(jt);

            jl.addMouseListener(this);
            jt.addKeyListener(this);
            
            
            
  }     
 public void keyPressed(KeyEvent e) {
       JOptionPane.showMessageDialog(null,"Se pulso "+e.getKeyChar()+"\nCodigo numerico:"+e.getKeyCode());
                      
   
  }
 //@Override
 public void keyReleased(KeyEvent e) {
   // TODO Auto-generated method stub
   
 }
 //@Override
 public void keyTyped(KeyEvent e) {
              
   
 }
 //  @Override


   // @Override
    public void mouseClicked(MouseEvent e) {
    
    }

    //@Override
    public void mousePressed(MouseEvent e) {
         //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    public void mouseReleased(MouseEvent e) {
        
    }

    //@Override
    public void mouseEntered(MouseEvent e) {
        jl.setText("Estoy dentro de la etiqueta");
    }

    //@Override
    public void mouseExited(MouseEvent e) {
        jl.setText("Estoy fuera de la etiqueta");
    
    }
public static void main(String[] args) 
{
    
    KeyAction x=new KeyAction();
    x.setVisible(true);
}

}