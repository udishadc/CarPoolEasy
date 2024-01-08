package application;
 
import java.util.Properties;
 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public abstract class BaseEmailSender {
 
    protected String host = "smtp.gmail.com";
 
    protected String senderEmail = "noreplycarpoolsystem@gmail.com";
 
    protected String senderPassword = "";
 
    protected Session createSession() {
 
        Properties properties = new Properties();
 
        properties.put("mail.smtp.auth", "true");
 
        properties.put("mail.smtp.starttls.enable", "true");
 
        properties.put("mail.smtp.host", host);
 
        properties.put("mail.smtp.port", "587");
 
        return Session.getInstance(properties, new javax.mail.Authenticator() {
 
            protected PasswordAuthentication getPasswordAuthentication() {
 
                return new PasswordAuthentication(senderEmail, senderPassword);
 
            }
 
        });
 
    }
 
    protected void sendEmail(String recipient, String subject, String body) {
 
        try {
 
            Session session = createSession();
 
            MimeMessage message = new MimeMessage(session);
 
            message.setFrom(new InternetAddress(senderEmail));
 
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
 
            message.setSubject(subject);
 
            message.setText(body);
 
            Transport.send(message);
 
            System.out.println("Email sent to: " + recipient);
 
        } catch (MessagingException e) {
 
            System.out.println("Failed to send email to: " + recipient);
 
            e.printStackTrace();
 
        }
 
    }
 
    public abstract void send(String recipient);
 
}