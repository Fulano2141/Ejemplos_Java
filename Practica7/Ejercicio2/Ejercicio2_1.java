/* 2.- Crear una aplicación que permita gestionar las ventas realizadas por una  tienda de productos electrónicos,  utilizando para ello una base de datos que tenga tres tablas: la primera que contenga los datos del cliente y otra que almacene los productos y finalmente la tercera que registre las ventas.
	La tabla del cliente debe contener:
		-	Nit
		-	Nombre
	La tabla del producto debe contener:
		-	Codigo producto
		-	Nombre del producto
		-	Precio unitario de venta
		-	Stock
	La tabla de las ventas  debe contener:
		-	Código producto
		-	Nit
		-	Cantidad
		-	Precio de venta
		-	Fecha 
Las tablas deben estar relacionadas por código, además la aplicación debe contener las clases de cada entidad (Cliente, Producto y Venta).
Los métodos asociados a cada entidad son:
-	Altas, Bajas y Modificaciones de las tablas Cliente y Producto
-	Factura de venta 
-	Reporte total de ventas por día  */
package Ejercicio2;   
import javax.swing.JFrame; 
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Ejercicio2_1 extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;	
	public static void main(String[] args) {
		try {
			Ejercicio2_1 frame = new Ejercicio2_1();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Ejercicio2_1() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl1 = new JLabel("Conexion de BD:");
		lbl1.setBounds(49, 42, 114, 24);
		contentPane.add(lbl1);
		
		JLabel label = new JLabel("");
		label.setBounds(175, 42, 114, 24);
		contentPane.add(label);
		
		InterfazConexion.verificar();
	    String cad = InterfazConexion.verificar();
	    label.setText(cad);
	    
	    JButton btnVenta = new JButton("Venta");
	    btnVenta.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try {
					VentaEjer2 frame = new VentaEjer2();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception eq) {
					eq.printStackTrace();
				}
	    	}
	    });
		btnVenta.setBounds(246, 107, 128, 30);
		contentPane.add(btnVenta);
		
		JButton btnAniadirCliente = new JButton("Anadir Cliente");
		btnAniadirCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					AnadirEjer2 frame = new AnadirEjer2();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnAniadirCliente.setToolTipText("ingresa un nuevo cliente");
		btnAniadirCliente.setBounds(49, 107, 128, 30);
		contentPane.add(btnAniadirCliente);
		
		JButton btnProductos = new JButton("Productos");
		btnProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ProductosEjer2 frame = new ProductosEjer2();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception eq) {
					eq.printStackTrace();
				}
			}
		});
		btnProductos.setToolTipText("Muestra la lista de productos");
		btnProductos.setBounds(49, 177, 128, 30);
		contentPane.add(btnProductos);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setToolTipText("Salir");
		btnSalir.setBounds(246, 177, 128, 30);
		contentPane.add(btnSalir);
	}
}