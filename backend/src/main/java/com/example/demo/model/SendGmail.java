package com.example.demo.model;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class SendGmail {
    /**
     * Outgoing Mail (SMTP) Server
     * requires TLS or SSL: smtp.gmail.com (use authentication)
     * Use Authentication: Yes
     * Port for TLS/STARTTLS: 587
     */
    public static void sendGmail(String gName, String toEmail, String message) {
        final String fromEmail = "gifter4you@gmail.com"; //requires valid gmail id
        final String password = "Gifter1234you"; // correct password for gmail id

        System.out.println("TLSEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getInstance(props, auth);

        com.example.demo.model.EmailUtil.sendEmail(session, toEmail, "Kiri Gifter´ilt!", "Tere, see on e-mail Gifter´ilt! " + gName + "\n" + message);
    }
}
