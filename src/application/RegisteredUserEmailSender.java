package application;

public class RegisteredUserEmailSender extends BaseEmailSender {
    @Override
    public void send(String recipient) {
        String subject = "Welcome to CarPoolSystem!!";
        String body = "you have been successful registered. Please allow us 24-48 hours, for verifying your details. if you have any issue please contact customer care.";
        sendEmail(recipient, subject, body);
    }
}