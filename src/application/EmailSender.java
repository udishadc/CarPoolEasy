package application;
 
 
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
 
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
 
 
 
 
public class EmailSender {
 
    public static void sendEmail(String recipient) {
        String subject = "Welcome to CarPoolSystem!!";
        String body = "you have been successful registered. if you have any issue please contact customer care.";
 
        String host = "smtp.gmail.com";
        String senderEmail = "noreplycarpoolsystem@gmail.com";
        String senderPassword = "";
 
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587"); // Updated to the correct port for TLS
 
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });
 
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);
            message.setText(body);
 
            Transport.send(message);
            System.out.println("Email sent to: " + recipient);
        } catch (MessagingException e) {
            System.out.println("Failed to send email to: " + recipient);
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }
    
    public static void sendEmailToregistereduser(String recipient) {
        String subject = "Welcome to CarPoolSystem!!";
        String body = "you have been successful registered. Please allow us 24-48 hours, for verifying your details. if you have any issue please contact customer care.";
        String host = "smtp.gmail.com";
        String senderEmail = "noreplycarpoolsystem@gmail.com";
        String senderPassword = "purn cnrs sles hoel";
 
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587"); // Updated to the correct port for TLS
 
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });
 
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);
            message.setText(body);
 
            Transport.send(message);
            System.out.println("Email sent to: " + recipient);
        } catch (MessagingException e) {
            System.out.println("Failed to send email to: " + recipient);
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }
    public static void Carowner(String recipient) {
        String subject = "Alert Notification!!";
        String body = "Dear User, Driver has registered as you as a owner and provided your details. if you think it is legimate, please approve it. if you have any issue please contact customer care.";
        String host = "smtp.gmail.com";
        String senderEmail = "noreplycarpoolsystem@gmail.com";
        String senderPassword = "purn cnrs sles hoel";
 
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587"); // Updated to the correct port for TLS
 
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });
 
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);
            message.setText(body);
 
            Transport.send(message);
            System.out.println("Email sent to: " + recipient);
        } catch (MessagingException e) {
            System.out.println("Failed to send email to: " + recipient);
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }
}