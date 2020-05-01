package com.org.qa.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
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
 * @author Gopal Pandey
 *
 */
public class ReadMail {
	
	public static void email() {

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "587");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.starttls.required", "true");
		props.put("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("yours1onlynvi@gmail.com", "*******");
					}
				});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("yours1onlynvi@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("pandey.gopal212@gmail.com"));
			message.setSubject("Testing Subject");
			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setText("Here all test Case data");
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yy_HH_mm_ss");
			LocalDateTime now = LocalDateTime.now();
			// String filename = "Reports\\" + dtf.format(now) + ".html";
			String filename = ExtentReport.getFile();
			// Create data source and pass the filename
			DataSource source = new FileDataSource(filename);
			messageBodyPart2.setDataHandler(new DataHandler(source));
			messageBodyPart2.setFileName(filename);
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart2);
			multipart.addBodyPart(messageBodyPart1);
			message.setContent(multipart);
			Transport.send(message);
			System.out.println("=====Email Sent=====");

		} catch (MessagingException e) {

			throw new RuntimeException(e);

		}
	}
}
