package com.abak.utility;

import java.io.IOException;
import java.util.Properties;

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
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import org.springframework.stereotype.Component;

@Component
public class EmailSend{

public void SendEmail(String to,String ccemails,String subject,String htmldatas,String filename) throws IOException{
	
	
		String from = "";// change accordingly
		final String username = "";// change accordingly
		final String password = "";// change accordingly

		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "25");

		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			if(ccemails!=null && !ccemails.equals("")){
				message.addRecipient(RecipientType.CC, new InternetAddress(ccemails));
			}
			
			message.setSubject(subject);

	
			Multipart emailContent = new MimeMultipart();
			
			//Text body part
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText("Please find attachment");
			
			//Attachment body part.
			MimeBodyPart pdfAttachment = new MimeBodyPart();
			pdfAttachment.attachFile(filename);
			
			//Attach body parts
			emailContent.addBodyPart(textBodyPart);
			emailContent.addBodyPart(pdfAttachment);
			
			//Attach multipart to message
			message.setContent(emailContent);
			
			
			System.out.print(htmldatas);
			//message.setContent(htmldatas, "text/html");
			Transport.send(message);

			System.out.println("Sent email successfully....");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}