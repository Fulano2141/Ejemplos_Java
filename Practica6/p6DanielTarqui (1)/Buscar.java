package Ejercicio6; 
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Buscar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private static JTextArea textArea;		
	public Buscar() {
		setTitle("Buscar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngreseElNumero = new JLabel("Ingrese el numero de cuenta:");
		lblIngreseElNumero.setBounds(60, 37, 190, 27);
		contentPane.add(lblIngreseElNumero);
		
		textField = new JTextField();
		textField.setBounds(265, 36, 178, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBounds(27, 85, 524, 52);
		contentPane.add(textArea);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1=Integer.parseInt(textField.getText());
				try {
					reporte("Usuarios.bin",num1);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBuscar.setBounds(382, 150, 97, 25);
		contentPane.add(btnBuscar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(87, 150, 97, 25);
		contentPane.add(btnCancelar);
	}
	public static void reporte(String string, int num1) throws IOException {
		try {
			DataInputStream fi = new DataInputStream(new FileInputStream(string));
			String cad="Numero de cuenta\tNombre\tFecha de apertura\tSaldo\n";
			boolean con=false;
			while(fi.available()!=0){
				int num=fi.readInt();
				String nom=fi.readUTF();
				String fe=fi.readUTF();
				double sal=fi.readDouble();
				if(num1==num) {
					cad+=num+"\t\t"+nom+"\t"+fe+"\t\t"+sal+"\t"+"\n";
					con=true;
				}
			}
			if(con)
				textArea.setText(cad);
			else
				textArea.setText("Cuanta no encontrada");
			fi.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "no se pudo leer el archivo");
		}
	}
}
