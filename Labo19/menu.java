
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class menu extends JFrame implements ActionListener{
	private JMenuBar mb;
	 private JMenu menu1;
	 private JMenuItem mi1,mi2,mi3;
	 
	public menu() {
		super("BIENVENIDO");
		  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  this.setSize(450, 450);
		  this.setLocationRelativeTo(null);
		  this.setVisible(true);
		  setLayout(null);
	      mb=new JMenuBar();
	      setJMenuBar(mb);
	      menu1=new JMenu("Opciones");
	      mb.add(menu1);
	      mi1=new JMenuItem("Añadir datos");
	      mi1.addActionListener(this);
	      menu1.add(mi1);
	      mi2=new JMenuItem("Reporte");
	      mi2.addActionListener( this);
	      menu1.add(mi2);
	      mi3=new JMenuItem("Salir");
	      mi3.addActionListener( this);
	      menu1.add(mi3); 
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==mi1) {
      	  this.dispose();
	    	  	ej1 agregar = new ej1();
      }		
		if(e.getSource()==mi2) {
			this.dispose();
			try {
				Reporte reporte=new Reporte();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==mi3) {
			this.dispose();
		}
	}
	 public static void main(String[] args) {
		  
		  
		   menu x=new menu();
		   x.setBounds(10,10,400,300);
		         x.setVisible(true); 
	  }
}