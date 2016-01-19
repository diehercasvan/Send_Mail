package Class;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author DIEGO CASALLAS
 */
public class MailUtil {

    private String SMTP_HOST = "smtp.gmail.com";
    private String FROM_ADDRESS = "diehercasvan@gmail.com";
    //private String PASSWORD = "qjfzhiihiydvnmpe";
    private String PASSWORD = "xkheqkrjxrfudzgw";
    private String FROM_NAME = "Diehercasvan";

    public boolean sendMail(String[] recipients, String[] bccRecipients, String subject, String message) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", SMTP_HOST);
            props.put("mail.smtp.auth", "true");
            props.put("mail.debug", "false");
            props.put("mail.smtp.ssl.enable", "true");

            Session session = Session.getInstance(props, new SocialAuth());
            Message msg = new MimeMessage(session);

            InternetAddress from = new InternetAddress(FROM_ADDRESS, FROM_NAME);
            msg.setFrom(from);

            InternetAddress[] toAddresses = new InternetAddress[recipients.length];
            for (int i = 0; i < recipients.length; i++) {
                toAddresses[i] = new InternetAddress(recipients[i]);
            }
            msg.setRecipients(Message.RecipientType.TO, toAddresses);

            InternetAddress[] bccAddresses = new InternetAddress[bccRecipients.length];
            for (int j = 0; j < bccRecipients.length; j++) {
                bccAddresses[j] = new InternetAddress(bccRecipients[j]);
            }

            // Set Subject: header field
            msg.setSubject(subject);

            // This mail has 2 part, the BODY and the embedded image
            Multipart multipart = new MimeMultipart("related");

            // first part (the html)
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(message, "text/html");
            // add it
            multipart.addBodyPart(messageBodyPart);

            // second part (the image)
            messageBodyPart = new MimeBodyPart();
            //DataSource fds = new FileDataSource("C:\\Users\\Dell\\Google Drive\\Libro_prueba.txt");
            DataSource fds = new FileDataSource("C:\\Users\\Dell\\Google Drive\\LOGO.png");
            messageBodyPart.setDataHandler(new DataHandler(fds));
            messageBodyPart.setHeader("Content-ID", "<image>");

            // add image to the multipart
            multipart.addBodyPart(messageBodyPart);

            messageBodyPart = new MimeBodyPart();

            /*DataSource source=new FileDataSource("C:\\Users\\Dell\\Google Drive\\Libro_prueba.pdf");
             messageBodyPart.setDataHandler(new DataHandler(source));
             messageBodyPart.setFileName("New File.pdf");
            
             messageBodyPart= new MimeBodyPart();
             DataSource source1=new FileDataSource("C:\\Users\\Dell\\Google Drive\\Libro_prueba.txt");
             messageBodyPart.setDataHandler(new DataHandler(source1));
             messageBodyPart.setFileName("New File.txt");*/
            for (int i = 0; i < 2; i++) {
                MimeBodyPart messageBodyPart1 = new MimeBodyPart();

                String sRoute = "";
                if (i == 0) {
                    sRoute = "C:\\Users\\Dell\\Google Drive\\Libro_prueba.pdf";
                } else {
                    sRoute = "C:\\Users\\Dell\\Google Drive\\Libro_prueba.txt";
                }
                DataSource source = new FileDataSource(sRoute);
                messageBodyPart1.setDataHandler(new DataHandler(source));
                messageBodyPart1.setFileName(source.getName());
                multipart.addBodyPart(messageBodyPart1);
                source = null;
            }

            //multipart.addBodyPart(messageBodyPart);
            // put everything together
            msg.setContent(multipart);
            // Send message
            Transport.send(msg);

            System.out.println("Sent message successfully....");
            return true;
        } catch (UnsupportedEncodingException | MessagingException ex) {
            Logger.getLogger(MailUtil.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }
    }

    class SocialAuth extends Authenticator {

        @Override
        protected PasswordAuthentication getPasswordAuthentication() {

            return new PasswordAuthentication(FROM_ADDRESS, PASSWORD);

        }
    }
}
