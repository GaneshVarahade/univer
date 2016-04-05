package com.Univerclassroom.services;

import java.io.UnsupportedEncodingException;
import java.util.Properties;  

import javax.mail.*;  
import javax.mail.internet.*;  
  
public class Mailer {  
 public static void main(String[] args) {  
	  Properties propsSSL = new Properties();
System.out.println(args[0]);
	String email = args[0];
	String msg = args[1];
	String header = args[2];
      // EVEN IF YOU SKIP THESE TWO PROP IT WOULD WORK
      propsSSL.put("mail.transport.protocol", "smtps");
      propsSSL.put("mail.smtps.host", "smtp.gmail.com");

      // THIS IS THE MOST IMPORTANT PROP --> "mail.smtps.auth"
      propsSSL.put("mail.smtps.auth", "true");

      Session sessionSSL = Session.getInstance(propsSSL);
      sessionSSL.setDebug(true);

      Message messageSSL = new MimeMessage(sessionSSL);
      try{
      messageSSL.setFrom(new InternetAddress("aniket.deshmukh.fidel@gmail.com", "Aniket Deshmukh"));
      messageSSL.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email)); // real recipient
      messageSSL.setSubject(header);
      messageSSL.setText(msg);

      Transport transportSSL = sessionSSL.getTransport();
      // EVEN IF YOU SKIP PORT NUMBER , IT WOULD WORK
      transportSSL.connect("smtp.gmail.com", 465, "aniket.deshmukh.fidel@gmail.com", "aniket@123"); // account used
      transportSSL.sendMessage(messageSSL, messageSSL.getAllRecipients());
      transportSSL.close();

      System.out.println("SSL done."); 
      }
      catch(MessagingException | UnsupportedEncodingException e) {throw new RuntimeException(e);}  
}  
}