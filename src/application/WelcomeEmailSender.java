package application;
 
public class WelcomeEmailSender extends BaseEmailSender {
    @Override
    public void send(String recipient) {
        String subject = "Welcome to CarPoolSystem!!";
        String body = "you have been successful registered. if you have any issue please contact customer care.";
        sendEmail(recipient, subject, body);
    }
}