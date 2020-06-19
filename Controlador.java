import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
public class Controlador {
//	Correo c=new Correo();
	
	public boolean enviarCorreo(Correo c) {
		try {
			Properties p=new Properties();
			p.put("mail.smtp.host", "smtp.gmail.com");
			p.setProperty("mail.smtp.starttls.enable", "true");
			p.setProperty("mail.smtp.port", "587");
			p.setProperty("mail.smtp.user", c.getUsuarioCorreo());
			p.setProperty("mail.smtp.auth", "true");
			
			Session s=Session.getDefaultInstance(p,null);
			BodyPart texto=new MimeBodyPart();
			texto.setText(c.getMensaje());
			BodyPart adjunto = new MimeBodyPart();
			if(!c.getRutaArchivo().equals("")) {
				adjunto.setDataHandler(new DataHandler(new FileDataSource(c.getRutaArchivo())));
				adjunto.setFileName(c.getNobreArchivo());	
			}
			MimeMultipart m=new MimeMultipart();
			m.addBodyPart(texto);
			if(!c.getRutaArchivo().equals("")) {
				m.addBodyPart(adjunto);
			}
			MimeMessage men=new MimeMessage(s);		
			men.setFrom(new InternetAddress(c.getUsuarioCorreo()));
			men.addRecipient(Message.RecipientType.TO, new InternetAddress(c.getDestino()));
			men.setSubject(c.getAsunto());
			men.setContent(m);
			
			Transport t=s.getTransport("smtp");
			t.connect(c.getUsuarioCorreo(),c.getContrasena());
			t.sendMessage(men, men.getAllRecipients());
			t.close();
			return true;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return false;
		}
		
	}
}
