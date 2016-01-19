/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Sistemas2
 */
public class NewClass {
    
          /*  String sHtmlBody = "<h1>Hello word</h1>";
            File file = new File("C://Users//Dell//Google Drive//Libro_prueba.txt");
            byte[] attachmentData = new byte[(int) file.length()];;
            
            Multipart mp = new MimeMultipart();
            
            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(sHtmlBody, "text/html");
            mp.addBodyPart(htmlPart);
            
            MimeBodyPart attachment = new MimeBodyPart();
            InputStream attachmentDataStream = new ByteArrayInputStream(attachmentData);
            attachment.setFileName("manual.pdf");
            attachment.setContent(attachmentDataStream, "application/txt");

            /*
             // Create the message part
             BodyPart messageBodyPart = new MimeBodyPart();

             // Now set the actual message
             messageBodyPart.setText("<h1>This is a test message from the desktop application that sends emails</h1>");

             // Create a multipar message
            

             // Set text message part
             multipart.addBodyPart(messageBodyPart);

             // Part two is attachment
             messageBodyPart = new MimeBodyPart();
             String filename = "C://Users//Dell//Google Drive//Libro_prueba.txt";
             DataSource source = new FileDataSource(filename);
             messageBodyPart.setDataHandler(new DataHandler(source));
             messageBodyPart.setFileName("New book ");

            
            mp.addBodyPart(attachment);
           
            msg.setRecipients(Message.RecipientType.BCC, bccAddresses);
            msg.setSubject(subject);
            //msg.setContent(message, "text/html");  
            msg.setContent(mp);
            //Transport.send(msg); */
}
