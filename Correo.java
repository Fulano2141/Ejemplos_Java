
public class Correo {
	String usuarioCorreo;
	String contrasena;
	String rutaArchivo;
	String nobreArchivo;
	String destino;
	String asunto;
	String mensaje;
	public Correo(String usuarioCorreo, String contrasena, String rutaArchivo, String nobreArchivo, String destino,
			String asunto, String mensaje) {
		super();
		this.usuarioCorreo = usuarioCorreo;
		this.contrasena = contrasena;
		this.rutaArchivo = rutaArchivo;
		this.nobreArchivo = nobreArchivo;
		this.destino = destino;
		this.asunto = asunto;
		this.mensaje = mensaje;
	}
	public String getUsuarioCorreo() {
		return usuarioCorreo;
	}
	public void setUsuarioCorreo(String usuarioCorreo) {
		this.usuarioCorreo = usuarioCorreo;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getRutaArchivo() {
		return rutaArchivo;
	}
	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}
	public String getNobreArchivo() {
		return nobreArchivo;
	}
	public void setNobreArchivo(String nobreArchivo) {
		this.nobreArchivo = nobreArchivo;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
