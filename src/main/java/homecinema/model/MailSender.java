package homecinema.model;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {
	private final String from = "homecinemapp@gmail.com";
	private final String password = "147741147a";
	private final String host = "smtp.gmail.com";
	private final String port = "587";
	private final String subjectValidacion = "Homecinemapp. Suscripción realizada correctamente";
	//private final String subjectSuscripcion = "Homecinemapp! Suscripción realizada correctamente";
	private String to;
	
	private Properties props;

	public MailSender(String destination) {
		to = destination;
		props = new Properties();
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.debug", "false");
	}

	public void sendMessageValidacion(String text) {
		try {
			Authenticator auth = new SMTPAuthenticator();
			Session session = Session.getInstance(props, auth);
			session.setDebug(true);

			MimeMessage msg = new MimeMessage(session);
			msg.setText(text.trim());
			msg.setSubject(subjectValidacion);
			msg.setFrom(new InternetAddress(from));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			Transport.send(msg);
			System.out.println("Message sent to: " + to);
		} catch (Exception ex) {
			System.err.println(" $ Error sending message: " + ex);
		}
	}
	
	/*public void sendMessageSuscripcion(String text) {
		try {
			Authenticator auth = new SMTPAuthenticator();
			Session session = Session.getInstance(props, auth);
			session.setDebug(true);

			MimeMessage msg = new MimeMessage(session);
			msg.setText(text.trim());
			msg.setSubject(subjectSuscripcion);
			msg.setFrom(new InternetAddress(from));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			Transport.send(msg);
			System.out.println("Message sent to: " + to);
		} catch (Exception ex) {
			System.err.println(" $ Error sending message: " + ex);
		}
	}*/

	private class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(from, password);
		}
	}
}