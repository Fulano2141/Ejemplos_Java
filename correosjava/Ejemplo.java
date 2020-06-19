import javax.swing.JOptionPane;

public class Ejemplo {
	
	public static void main(String[] args) {
		Correo c=new Correo("","","","","","","");
		c.setContrasena("2142qwerty");
		c.setUsuarioCorreo("correos.para.agenda@gmail.com");
		c.setAsunto("Test");
		c.setMensaje("El troche es un gay");
		c.setDestino("cosme2142dt@gmail.com");
	//	c.setNobreArchivo("qwe.png");
		//c.setRutaArchivo("qwe.png");
		Controlador co=new Controlador();
		if(co.enviarCorreo(c)) {
			JOptionPane.showMessageDialog(null,"Exito");
		}
	}
}
