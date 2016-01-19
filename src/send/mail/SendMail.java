/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package send.mail;

import Class.MailUtil;

/**
 *
 * @author DIEGO CASALLAS
 */
public class SendMail {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*  //Recipient´s email ID needs to  be  mentioned
         String sTo = "diehercasvan@gmail.com";
         //Sender's email ID needs to be mentioned
         String sFrom = "diehercasvan@hotmail.com";
         // Assuming you are sending email from localhost
         String sHost = "localhost";
         //Get system properties 
         Properties properties = System.getProperties();

         //Setup mail server
         properties.setProperty("mail.smtp.host", sHost);
         // Get the default Session object.
         Session session = Session.getDefaultInstance(properties);
        
         try{
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(sFrom));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(sTo));

         // Set Subject: header field
         message.setSubject("This is the Subject Line!");

         // Now set the actual message
         message.setText("This is actual message");

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
         }catch (MessagingException mex) {
         mex.printStackTrace();
         }*/
        String[] recipients = new String[]{"dhcasallas@unipanamericana.edu.co"};
        //String[] recipients = new String[]{"lmgrisales@unipanamericana.edu.co"};
        //String[] recipients = new String[]{"dfquiroga56@misena.edu.co"};
        String[] bccRecipients = new String[]{"diehercasvan@gmail.com"};
        String subject = "Reporter test email";
        String messageBody = "<html>"
                + "<body>"
                + "<H1>ARIES</H1>"
                + "<H3>Informati-k S.A.S</H3>"
                + "<img src=\"cid:image\">"
                + "<p><a href='http://www.aries-informati-k.com'>Visit Aries-informati-k!</a></p>"
                + "</body>"
                + "</html>";

        new MailUtil().sendMail(recipients, bccRecipients, subject, messageBody);

    }

}
