package lab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ej2 extends JFrame implements ActionListener{
	
	

	 JLabel userLabel = new JLabel("User");
	 JTextField userText = new JTextField(20);
	 JLabel passwordLabel = new JLabel("Password");
	 JPasswordField passwordText = new JPasswordField(20);
	 JButton b1 = new JButton("Login");
	 JButton b2 = new JButton("Cancel");



public ej2()
{super("ACCESO AL SISTEMA");



 
 setSize(300, 150);
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 setLayout(null);
 JLabel userLabel = new JLabel("User");
 userLabel.setBounds(10, 10, 80, 25);
 add(userLabel);
 userText.setBounds(100, 10, 160, 25);
 add(userText);
 passwordLabel.setBounds(10, 40, 80, 25);
 add(passwordLabel);
 passwordText.setBounds(100, 40, 160, 25);
 add(passwordText);
 b1.setBounds(10, 80, 80, 25);
 add(b1);
 b2.setBounds(180, 80, 80, 25);
 add(b2);
 pack();
 b1.addActionListener(this);
 b2.addActionListener(this);
 
}





public void actionPerformed(ActionEvent e)
{
boolean flag=false;


	 if (e.getSource()==b1)
    {
		 
		 
		 try {
			 BufferedReader leer = new BufferedReader(new FileReader(new File ("datos.txt")));
			   String linea="";
			   String usuario=userText.getText();
			   String Pass=String.valueOf(passwordText.getPassword());
			  while((linea=leer.readLine())!= null)
			     {
			       String[] array=linea.split(";");
			       
			       if (usuario.compareTo(array[0])==0)
			       {  
			    	  if(Pass.compareTo(array[1])==0)
			    		  
			    		  this.dispose();
			    	  	
				         flag=true;  
				         
			       }
			      
			      
			     }
			  leer.close();
		 }
		 catch(IOException aio){
			 
		 }
		
		  if(!flag) {
			  intento=intento+1;
			  JOptionPane.showMessageDialog(null,"ERROR");
			  System.out.println(intento);
			  if(intento>2) {
				  System.exit(0);
			  }
			 
			  
			  
		  }
     
    }
    
    if (e.getSource()==b2)
    {
         
     System.exit(0);
    }

	
}


static int intento;
public static void main(String[] args) {
 
	  
	   EJ1 x=new EJ1();
	   x.setBounds(10,10,400,300);
	         x.setVisible(true); 
 }


}