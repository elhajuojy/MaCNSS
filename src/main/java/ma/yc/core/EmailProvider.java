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

    public void sendEmail(String to, String subject, String body) {
        Properties props = new Properties();
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", String.valueOf(smtpPort));
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2"); // Use the appropriate version




        try {
        Session session = Session.getInstance(props, new Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        session.setDebug(true);

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
            System.out.println("Email sent successfully.");
            Transport transport = session.getTransport("smtp");
            transport.close();
            System.out.println("SMTP session terminated.");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.err.println("Error sending email: " + e.getMessage());
        }
    }

}
