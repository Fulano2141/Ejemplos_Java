import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class Interfaz extends JFrame 
{

 private JPanel contentPane;
 private JTextField textField;
 private JTable table;
 private JButton btnConsultaBdd;

 public static void main(String[] args) {
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     Interfaz frame = new Interfaz();
     frame.setVisible(true);
    } catch (Exception e) {
     e.printStackTrace();
    }
   }
  });
 }

 /**
  * Create the frame.
  */
 public Interfaz() 
 {
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setBounds(100, 100, 450, 300);
  setLocationRelativeTo(null);
  setResizable(false);
  
  contentPane = new JPanel();
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  setContentPane(contentPane);
  contentPane.setLayout(null);
  
  JLabel JLabel_Mostrar = new JLabel("");
  JLabel_Mostrar.setBounds(90, 83, 260, 16);
  contentPane.add(JLabel_Mostrar);
  
  JButton JButton_Conectar = new JButton("Conectar BDD");
  JButton_Conectar.setToolTipText("Conexi\u00F3n con BDD");
  JButton_Conectar.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent arg0) 
   {
    InterfazConexion.verificar();
    String cad = InterfazConexion.verificar();
    
    JLabel_Mostrar.setText(cad);
    
    /*textField = new JTextField();
    textField.setEditable(false);
    textField.setBounds(85, 173, 252, 22);
    contentPane.add(textField);
    textField.setColumns(10);
    textField.setText(cad);*/
   }
  });
  
  JButton_Conectar.setFont(new Font("SWRomnd", Font.PLAIN, 14));
  JButton_Conectar.setBounds(141, 13, 164, 57);
  contentPane.add(JButton_Conectar);
  
  /*String[] columnNames = 
   { "Código",
                "Descripción",
                "Precio Unitario",
                "Stock"
            };
  String d = Consulta.datos();*/
  
  /*Object[][] data = 
   { "Código",
                "Descripción",
                "Precio Unitario",
                "Stock"
            };*/
  
  /*table = new JTable(data, columnNames);
  table.setBounds(225, 135, 157, 65);
  contentPane.add(table);*/
  
  btnConsultaBdd = new JButton("Consulta BDD");
  btnConsultaBdd.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent arg0) 
   {
    JTextArea jtx = new JTextArea(20,30);
    jtx.setText(Consulta.datos());
    jtx.setBackground(Color.white);
    jtx.setForeground(Color.DARK_GRAY);
    JScrollPane barra = new JScrollPane(jtx);
    JOptionPane.showMessageDialog(null, barra, "Supermercado", JOptionPane.PLAIN_MESSAGE);
   }
  });
  btnConsultaBdd.setToolTipText("Mostrar datos de la Tabla");
  btnConsultaBdd.setFont(new Font("SWRomnd", Font.PLAIN, 14));
  btnConsultaBdd.setBounds(141, 186, 164, 29);
  contentPane.add(btnConsultaBdd);
 }
}
