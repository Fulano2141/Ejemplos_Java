import javax.swing.*;
import java.awt.event.*;
public class Formulario1 extends JFrame implements ItemListener{
    private JComboBox combo1;
    public Formulario1() {
        setLayout(null);
        combo1=new JComboBox();
        combo1.setBounds(10,10,80,20);
        add(combo1);
        combo1.addItem("rojo");
        combo1.addItem("vede");
        combo1.addItem("azul");
        combo1.addItem("amarillo");
        combo1.addItem("negro");
        combo1.addItemListener(this);
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getSource()==combo1) {
            String seleccionado=(String)combo1.getSelectedItem();
            setTitle(seleccionado);
        }
    }
    
    public static void main(String[] ar) {
        Formulario1 f=new Formulario1();
        f.setBounds(0,0,200,150);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }    
}