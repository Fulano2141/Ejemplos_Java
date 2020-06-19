import javax.swing.*;
import javax.swing.event.*;
public class Formulario7 extends JFrame implements ChangeListener{
    private JCheckBox check1,check2,check3;
    public Formulario7() {
        setLayout(null);
        check1=new JCheckBox("Ingl�s");
        check1.setBounds(10,10,150,30);
        check1.addChangeListener(this);
        add(check1);
        check2=new JCheckBox("Franc�s");
        check2.setBounds(10,50,150,30);
        check2.addChangeListener(this);        
        add(check2);
        check3=new JCheckBox("Alem�n");
        check3.setBounds(10,90,150,30);
        check3.addChangeListener(this);        
        add(check3);        
    }
    
    public void stateChanged(ChangeEvent e){
        String cad="";
        if (check1.isSelected()==true) {
            cad=cad+"Ingl�s-";
        }
        if (check2.isSelected()==true) {
            cad=cad+"Franc�s-";
        }
        if (check3.isSelected()==true) {
            cad=cad+"Alem�n-";
        }
        setTitle(cad);
    }

    public static void main(String[] ar) {
        Formulario7 f=new Formulario7();
        f.setBounds(0,0,300,200);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }    
}