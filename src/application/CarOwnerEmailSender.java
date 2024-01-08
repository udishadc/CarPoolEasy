package application;

public class CarOwnerEmailSender extends BaseEmailSender {
    @Override
    public void send(String recipient) {
        String subject = "Alert Notification!!";
        String body = "Dear User, Driver has registered as you as a owner and provided your details. if you think it is legimate, please approve it. if you have any issue please contact customer care.";
        sendEmail(recipient, subject, body);
    }
}