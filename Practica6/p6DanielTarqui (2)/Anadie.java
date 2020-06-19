package Ejercicio7;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Anadie extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Anadie frame = new Anadie();
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
	public Anadie() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(71, 67, 56, 16);
		contentPane.add(lblPlaca);
		
		textField = new JTextField();
		textField.setBounds(172, 64, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNit = new JLabel("Nit");
		lblNit.setBounds(71, 119, 56, 16);
		contentPane.add(lblNit);
		
		textField_1 = new JTextField();
		textField_1.setBounds(172, 116, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Hora Entrada:");
		lblNewLabel.setBounds(41, 167, 86, 16);
		contentPane.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(172, 164, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblHoraSalida = new JLabel("Hora Salida:");
		lblHoraSalida.setBounds(41, 205, 86, 16);
		contentPane.add(lblHoraSalida);
		
		textField_3 = new JTextField();
		textField_3.setBounds(172, 205, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String plac=textField.getText();
				String nit=textField_1.getText();
				String fecha=textField_2.getText();
				String hore=textField_3.getText();
				String horsa=textField_4.getTex
			}
		});
		btnGuardar.setBounds(323, 82, 97, 25);
		contentPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar ");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnCancelar.setBounds(323, 163, 97, 25);
		contentPane.add(btnCancelar);
	}

}
