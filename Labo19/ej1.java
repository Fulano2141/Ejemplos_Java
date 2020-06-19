import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//-          Fecha del dia (Obtener con la clase Calendar)
public class ej1 extends JFrame implements ActionListener {
	JLabel PlacaLabel = new JLabel("Placa Vehículo");
	 JTextField PlacaText = new JTextField(20);
	 JLabel NitLabel = new JLabel("Nit Cliente");
	 JTextField NitText = new JTextField(20);
	 JLabel HoraILabel = new JLabel("Hora de ingreso");
	 JTextField HoraIText = new JTextField(5);
	 JTextField MinIText = new JTextField(5);
	 JLabel HoraSLabel = new JLabel("Hora de salida");
	 JTextField HoraSText = new JTextField(5);
	 JTextField MinSText = new JTextField(5);
	 JButton b1 = new JButton("Registrar");
	 JButton b2 = new JButton("Volver");
	 JLabel espacio1 = new JLabel(":");
	 JLabel espacio2 = new JLabel(":");
	 public ej1() {
		 super("REGISTRO");
		  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  this.setSize(450,450);
		  this.setLocationRelativeTo(null);
		  this.setVisible(true);
		  setLayout(null);
		  
		  PlacaLabel.setBounds(10, 10, 80, 25);
		  add(PlacaLabel);
		  PlacaText.setBounds(100, 10, 160, 25);
		  add(PlacaText);
		  NitLabel.setBounds(10, 40, 80, 25);
		  add(NitLabel);
		  NitText.setBounds(100, 40, 160, 25);
		  add(NitText);
		  HoraILabel.setBounds(10,70,120,25);
		  add(HoraILabel);
		  HoraIText.setBounds(120, 70, 40, 25);
		  add(HoraIText);
		  espacio1.setBounds(170, 70, 20,25);
		  add(espacio1);
		  MinIText.setBounds(190,70,40,25);
		  add(MinIText);
		  HoraSLabel.setBounds(10,100,120,25);
		  add(HoraSLabel);
		  HoraSText.setBounds(120, 100, 40, 25);
		  add(HoraSText);
		  espacio2.setBounds(170, 100, 20,25);
		  add(espacio2);
		  MinSText.setBounds(190,100,40,25);
		  add(MinSText);
		 
		  b1.setBounds(20,160,110,30);
		  add(b1);
		  b2.setBounds(200,160,110,30);
		  add(b2);
		  
		  b1.addActionListener(this);
		  b2.addActionListener(this);
	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource()==b1) {
				String c="";
				Calendar ca=Calendar.getInstance();
				String placa=PlacaText.getText();
				String nit=NitText.getText();
				String hi=HoraIText.getText();
				String mi=MinIText.getText();
				String hs=HoraSText.getText();
				String ms=MinSText.getText();
				int dia=ca.get(Calendar.DATE);
				int mes=ca.get(Calendar.MONTH);
				int año=ca.get(Calendar.YEAR);
				String d=String.valueOf(dia);
				String m=String.valueOf(mes);
				String a=String.valueOf(año);
				FileWriter fichero = null;
		        PrintWriter pw = null;
		        
		       
		        fichero = new FileWriter("Datos.txt",true);
	            pw = new PrintWriter(fichero);
	           
	            c+=placa+";"+nit+";"+hi+":"+mi+";"+hs+":"+ms+";"+d+"/"+m+"/"+a;
	            pw.println(c);
	            pw.close();
	            JOptionPane.showMessageDialog(null,"Se añadio el dato");
	            this.dispose();
	            menu menu1= new menu();
			}
			if(e.getSource()==b2) {
				this.dispose();
				menu menu1= new menu();
			}
		}
		catch(IOException a) {
			
		}
		
		
	}

}