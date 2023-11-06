package Assesment;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

//to send emails
public class EmailSender implements Serializable {
    private String toAddress;
    private String subject;
    private String content;
    private Email email;

    //to know the current date
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
    String date = simpleDateFormat.format(new Date());

    public EmailSender(String toAddress, String subject, String content) {
        this.toAddress = toAddress;
        this.subject = subject;
        this.content = content;
        Email email = new Email(this.getToAddress(),this.getSubject(),this.getContent(),this.getDate());

    }

    public  void sendMails(){
        final String username = "hirujavamail@gmail.com";
        final String password = "smkihifukiivtxmi";
        final String host = "localhost";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session;
        session = Session.getInstance(prop,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        MimeMessage message = null;
        try {
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(toAddress));
            message.setSubject(subject);
            message.setText(content);
            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    public String getToAddress() {
        return toAddress;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }
    public String getDate() {
        return date;
    }

    public Email getEmail() {
        return email;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
}
