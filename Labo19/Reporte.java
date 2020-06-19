
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Reporte extends JFrame implements ActionListener{
	JButton b1= new JButton("Volver al menu");
	public Reporte() throws IOException {
		super("REPORTE");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  this.setSize(450, 450);
		  this.setLocationRelativeTo(null);
		  this.setVisible(true);
		  setLayout(null);
		b1.setBounds(100,225,200,30);
		add(b1);
		  b1.addActionListener(this);
		String cad="Placa\tNit\tHora de Entrada\tHora de Salida\tTiempo en minutos\tPago total\n";
		   cad+="===========================================================================================================\n";
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  this.setSize(450,450);
		  this.setLocationRelativeTo(null);
		  this.setVisible(true);
		  setLayout(null);
		  String linea;
		  int toths,tothi,tot,htot,mintot;
		  int pago=0;
		  int general=0;
  		File archivo = new File ("Datos.txt");
  		FileReader fr = new FileReader (archivo);
  		BufferedReader fi = new BufferedReader(fr);
  		while((linea=fi.readLine())!=null) {
  			String[] datos=linea.split(";");
  			String placa=datos[0];
  			String nit=datos[1];
  			String entrada=datos[2];
  			String salida=datos[3];
  			String[] HoraI=entrada.split(":");
  			int hi=Integer.parseInt(HoraI[0]);
  			int mi=Integer.parseInt(HoraI[1]);
  			String[] HoraS=salida.split(":");
  			int hs=Integer.parseInt(HoraS[0]);
  			int ms=Integer.parseInt(HoraS[1]);
  			if(hs<hi) {
  				toths=(hs*60)+1440+ms;
  				tothi=(hi*60)+mi;
  				tot=toths-tothi;
  				htot=tot/60;
  				mintot=tot%60;
  				if(htot<1) {
  					pago=5;
  				}
  				if(htot>=1 &&htot<3) {
  					pago=10;
  				}
  				if(htot>=3 &&htot<6) {
  					pago=15;
  				}
  				if(htot>6) {
  					pago=20;
  				}
  			}
  			else {
  				toths=(hs*60)+ms;
  				tothi=(hi*60)+mi;
  				tot=toths-tothi;
  				htot=tot/60;
  				mintot=tot%60;
  				if(htot<1) {
  					pago=5;
  				}
  				if(htot>=1 &&htot<3) {
  					pago=10;
  				}
  				if(htot>=3 &&htot<6) {
  					pago=15;
  				}
  				if(htot>6) {
  					pago=20;
  				}
  				
  			}
  			cad+=placa+"\t"+nit+"\t"+entrada+"\t\t"+salida+"\t\t"+tot+"\t"+pago+"\n";
  			general=general+pago;
  		}
  		cad+="\n TOTAL GENERAL: "+general;
  		JTextArea jta=new JTextArea(20,50);
	      jta.setText(cad);
	      JScrollPane barra = new JScrollPane(jta);
	      JOptionPane.showMessageDialog(null,barra);
	      fi.close();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			this.dispose();
			menu menu3=new menu();
		}
		
	}
	

}