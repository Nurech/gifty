package com.example.demo.model;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;

public class EmailUtil {

    /**
     * Utility method to send simple HTML email
     * @param session
     * @param email
     * @param subject
     * @param message
     */
    public static void sendEmail(Session session, String email, String subject, String message) {
        try {
            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress("gifter4you@gmail.com", "Gifter"));

            msg.setReplyTo(InternetAddress.parse("gifter4you@gmail.com", false));

            msg.setSubject(subject, "UTF-8");

            msg.setText(message, "UTF-8");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email, false));
            System.out.println(session);
            System.out.println(email);
            System.out.println(subject);
            System.out.println(message);
            System.out.println("Message is ready");

            Transport.send(msg);
            System.out.println("EMail Sent Successfully!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}