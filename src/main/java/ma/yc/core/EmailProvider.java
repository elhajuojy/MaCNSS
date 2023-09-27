
package ma.yc.core;




import javax.mail.*;
import javax.mail.internet.*;

import java.util.Properties;

public class EmailProvider  {
    private final String username  ; // Your email username
    private final String password; // Your email password
    private final String smtpHost; // SMTP server host
    private final int smtpPort;    // SMTP server port (587 for TLS)

    public EmailProvider(String username, String password, String smtpHost, int smtpPort) {
        this.username = username;
        this.password = password;
        this.smtpHost = smtpHost;
        this.smtpPort = smtpPort;
    }

    public static Boolean sendMail(String body,String subject ,String email) {
        final String username = "obelkadi336@gmail.com";
        final String password = "hbdi wose rkeq qpme";

        Properties properties = System.getProperties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.starttls.enable", "true");
        javax.mail.Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject(subject);
            message.setText("Here is the code of verification authentic: "+body);
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

}


