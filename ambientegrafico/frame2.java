package fabri;
	import java.awt.BorderLayout;
	import java.awt.FlowLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.JTextField;
	 
	public class frame2 extends JFrame implements ActionListener {
	 private JTextField texto;
	 private JButton btn;
	 private JPanel pan;
	 
	 public frame2() {
	  super("VENTANA 2");
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  init();
	  this.setSize(450, 450);
	  this.setLocationRelativeTo(null);
	  this.setVisible(true);
	 }
	 
	 public void init() {
	  texto = new JTextField(20);
	  btn = new JButton("Regresa a Ventana 1");
	  btn.addActionListener(this);
	  pan = new JPanel(new FlowLayout());
	  pan.add(texto);
	  pan.add(btn);
	  this.add(BorderLayout.CENTER, pan);
	 }
	 
	 public void asignarTexto(String a) {
	  texto.setText(a);
	 }
	 
	 public void actionPerformed(ActionEvent e) {
	  if (e.getSource() == btn) {
	   texto.setText("");
	   this.dispose();
	   Frame1 frame1 = new Frame1();
	  }
	 }
	 
	
	}
	
