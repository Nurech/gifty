package com.example.demo.service;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class SendGmail {
    /**
     * Outgoing Mail (SMTP) Server
     * requires TLS or SSL: smtp.gmail.com (use authentication)
     * Use Authentication: Yes
     * Port for TLS/STARTTLS: 587
     */
    public static void sendGmail(long userId, String guestName, long eventId, String eventName, String email, String messageEmail, String eventAuthor, String eventDate, String generateLink) {
        final String fromEmail = "gifter4you@gmail.com"; //requires valid gmail id
        final String password = "Gifter1234you"; // correct password for gmail id

        System.out.println("TLSEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };

        //TODO generatedlink
        //static info
        String subject = "Kiri Gifter´ilt! Tere, see on e-mail Gifter´ilt!";
        String message = "Hello " +guestName+ "!\n\nYou have been invited to "+eventName+ ". The event will take place on "+eventDate+".\nYour personal link is " +generateLink+" to choose the Gift.\nYour personal message from " + eventAuthor + " is:\n\""+
                messageEmail+"\"\n\nYour Gifter";

        Session session = Session.getInstance(props, auth);
        EmailUtil.sendEmail(session, email, subject, message);
    }
}
