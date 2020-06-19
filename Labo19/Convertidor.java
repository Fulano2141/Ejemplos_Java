import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


	public class Convertidor extends JFrame implements ActionListener{
		private JMenuBar mb;
		 private JMenu menu1;
		 private JMenuItem mi1,mi2,mi3;
		 
		public Convertidor() {
			super("BdasdO");
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

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
}
