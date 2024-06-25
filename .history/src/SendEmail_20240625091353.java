
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {
    public SendEmail() {

    }

    public static void main(String[] args) {

        // Sender's email ID and password needs to be mentioned
        final String from = "anyayap10@gmail.com";
        final String AppPassword = "satw mrfy algh mswi";

        // Recipient's email ID needs to be mentioned.D
        String to = "sn.yap@itapps.com";
        // String to = "sheejen.chen@itapps.com";

        // Assuming you are sending email through Outlook's SMTP server
        String host = "smtp.gmail.com";
        int port = 587; // For TLS

        // Get system properties
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, AppPassword);
            }
        });

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is just a testing!");

            // Now set the actual message
            message.setText("Happy day happy live.");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
