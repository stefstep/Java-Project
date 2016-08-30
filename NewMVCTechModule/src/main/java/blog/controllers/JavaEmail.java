package blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Controller
public class JavaEmail{
    Session mailSession;

    @RequestMapping("/javaemail")
    public  String Users(Model model) {
       // public static void main (String args[])throws AddressException, MessagingException
       // {
            JavaEmail javaEmail = new JavaEmail();
            javaEmail.setMailServerProperties();
        try {
            javaEmail.draftEmailMessage();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            javaEmail.sendEmail();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        // }
        return "javaemail";
    }
    private void setMailServerProperties()
    {
        Properties emailProperties = System.getProperties();
        emailProperties.put("mail.smtp.port", "586");
        emailProperties.put("mail.smtp.auth", "true");
        emailProperties.put("mail.smtp.starttls.enable", "true");
        mailSession = Session.getDefaultInstance(emailProperties, null);
    }

    private MimeMessage draftEmailMessage() throws AddressException, MessagingException
    {
        //String[] toEmails = { "howtodoinjava@gmail.com" };
        //email na poluchatelia triabva da e gmail
        String[] toEmails = { "stefan.lesikov@gmail.com" };
       // String[] toEmails = { "stefstep@abv.bg" };
        String emailSubject = "Test email subject";
        String emailBody = "This is an email sent by intellij project.";
        MimeMessage emailMessage = new MimeMessage(mailSession);
        /**
         * Set the mail recipients
         * */
        for (int i = 0; i < toEmails.length; i++)
        {
            emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
        }
        emailMessage.setSubject(emailSubject);
        /**
         * If sending HTML mail
         * */
        emailMessage.setContent(emailBody, "text/html");
        /**
         * If sending only text mail
         * */
        //emailMessage.setText(emailBody);// for a text email
        return emailMessage;
    }

    private void sendEmail() throws AddressException, MessagingException
    {
        /**
         * Sender's credentials
         * */
       // String fromUser = "user-email@gmail.com";
       // String fromUser = "stefan.lesikov@gmail.com";
        String fromUser = "stefan.prmldj@abv.bg";
        String fromUserEmailPassword = "pleven77";

        String emailHost = "smtp.gmail.com";
        Transport transport = mailSession.getTransport("smtp");
        transport.connect(emailHost, fromUser, fromUserEmailPassword);
        /**
         * Draft the message
         * */
        MimeMessage emailMessage = draftEmailMessage();
        /**
         * Send the mail
         * */
        transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
        transport.close();
        System.out.println("Email sent successfully.");
    }
}