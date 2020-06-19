import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Formulario5 extends JFrame implements ActionListener{
    private JMenuBar mb;
    private JMenu menu1,menu2,menu3;
    private JMenuItem mi1,mi2,mi3,mi4;
    public Formulario5() {
        setLayout(null);
        mb=new JMenuBar();
        setJMenuBar(mb);
        menu1=new JMenu("Opciones");
        mb.add(menu1);
        menu2=new JMenu("Tamaño de la ventana");
        menu1.add(menu2);
        menu3=new JMenu("Color de fondo");
        menu1.add(menu3);
        mi1=new JMenuItem("640*480");
        menu2.add(mi1);
        mi1.addActionListener(this);
        mi2=new JMenuItem("1024*768");
        menu2.add(mi2);
        mi2.addActionListener(this);
        mi3=new JMenuItem("Rojo");
        menu3.add(mi3);
        mi3.addActionListener(this);
        mi4=new JMenuItem("Verde");
        menu3.add(mi4);
        mi4.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==mi1) {
            setSize(640,480);
        }
        if (e.getSource()==mi2) {
            setSize(1024,768);
        }
        if (e.getSource()==mi3) {
            getContentPane().setBackground(new Color(255,0,0));
        }
        if (e.getSource()==mi4) {
            getContentPane().setBackground(new Color(0,255,0));
        }
    }
    
    public static void main(String[] ar) {
        Formulario5 f=new Formulario5();
        f.setBounds(0,0,300,200);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }     
}