package Ejercicio6;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
public class Anadir extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnCancelar;
	public Anadir() {
		setTitle("Anadir");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 265);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Date dat = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		JLabel lblNDeCuenta = new JLabel("N# de Cuenta:");
		lblNDeCuenta.setBounds(43, 27, 92, 21);
		contentPane.add(lblNDeCuenta);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(75, 61, 60, 21);
		contentPane.add(lblNombre);
		
		JLabel lblFechaDeApertura = new JLabel("Fecha de Apertura:");
		lblFechaDeApertura.setBounds(12, 95, 123, 21);
		contentPane.add(lblFechaDeApertura);
		
		JLabel lblSaldoActual = new JLabel("Saldo Actual:");
		lblSaldoActual.setBounds(43, 129, 92, 21);
		contentPane.add(lblSaldoActual);
		
		textField = new JTextField();
		textField.setBounds(148, 27, 187, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(147, 60, 187, 21);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(147, 94, 187, 21);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(148, 128, 187, 21);
		contentPane.add(textField_3);
		textField_2.setText(dateFormat.format(dat));
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					DataOutputStream fs = new DataOutputStream(new FileOutputStream("Usuarios.bin",true));
					int num=Integer.parseInt(textField.getText());
					String nom=textField_1.getText();
					String fec=textField_2.getText();
					double sal=Double.parseDouble(textField_3.getText());
					fs.writeInt(num);
					fs.writeUTF(nom);
					fs.writeUTF(fec);
					fs.writeDouble(sal);
					fs.close();
					dispose();
					JOptionPane.showMessageDialog(null, "Datos guardados");
				}catch(IOException e1) {
					JOptionPane.showMessageDialog(null,"Problemas con los datos o el archivo");
				}
			}
		});
		btnNewButton.setBounds(75, 180, 97, 25);
		contentPane.add(btnNewButton);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(265, 180, 97, 25);
		contentPane.add(btnCancelar);
	}

}
