package edu.uade.appl_interact.services;

import edu.uade.appl_interact.model.entities.GiftList;
import edu.uade.appl_interact.model.entities.Subscription;
import edu.uade.appl_interact.model.entities.User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

// To view message go to https://mailtrap.io/inboxes/411478/messages/836698255
public class EmailService {
    private String host;
    private String smtp;
    private String user;
    private String from;
    private String pass;
    private String port;
    private Session session;
    private Properties mailProperty = System.getProperties();

    private static EmailService instance = null;

    private EmailService() {
    }

    public static EmailService getInstance() {
        if (instance == null) {
            instance = new EmailService();

            FileInputStream fis = null;
            try {
                fis = new FileInputStream("resources/mail.properties");

                Properties props = new Properties();
                props.load(fis);
                instance.host = props.getProperty("mail.host");
                instance.smtp = props.getProperty("mail.smtp");
                instance.from = props.getProperty("mail.from");
                instance.user = props.getProperty("mail.user");
                instance.pass = props.getProperty("mail.pass");
                instance.port = props.getProperty("mail.port");

                instance.configureSmtp();

            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return instance;
    }

    public void subscriptionEmail(GiftList giftList) {
        String subject = "TPO App Interactivas - Subscripción a nueva lista de regalos";
        String body = "Bueno días %s, bienvenido a la lista de regalos %s para %s." +
                "La lista finalizará el día %s con el objetivo de juntar $%s";
        try {
            if (giftList.getGifters().size() >0) {
                for (Subscription s : giftList.getGifters()) {
                    if (s.getId() == null) {
                        sendMail(
                                s.getUser().getEmail(),
                                subject,
                                String.format(body, s.getUser().getName(), giftList.getListName(), giftList.getToName(), giftList.getDueDate(), giftList.getExpectedAmount())
                        );
                    }
                }
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void completitionEmail(GiftList list) {
    }


    public void dueDateEmail(GiftList list) throws Exception {
        if (list == null)
            return;
        String subject = "TPO App Interactivas- Lista está por terminar pronto";
        String body = "Bueno días %s, la lista de regalos %s a la que estas subscripto terminará mañana." +
                "por favor realice el pago antes que sea demasiado tarde!" +
                "Recuerde que el código de pago es %s";

        List<Subscription> subscriptions = list.getGifters();
        for (Iterator<Subscription> j = subscriptions.iterator(); j.hasNext(); ) {
            Subscription subscription = j.next();
            User user = subscription.getUser();
            if (subscription.hasNotPayed()) {
                sendMail(user.getEmail(), subject, String.format(body, user.getName(), list.getListName(), subscription.getId()));
            }
        }
    }

    private void sendMail(String to, String subject, String body) {

        System.out.printf("Sending email to '%s', subject '%s'", to, subject);

        if (to == null)
            return;
        Message msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(from));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setSubject(subject);
            msg.setText(body);

            Transport.send(msg);
        } catch (MessagingException e) {
        }
    }

    private void configureSmtp() {
        Authenticator authenticator = new Authenticator() {
            private PasswordAuthentication authentication;

            {
                authentication = new PasswordAuthentication(instance.user, instance.pass);
            }

            protected PasswordAuthentication getPasswordAuthentication() {
                return authentication;
            }
        };

        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", instance.host);
        props.put("mail.smtp.port", instance.port);
        props.put("mail.smtp.auth", "true");

        session = Session.getDefaultInstance(props, authenticator);
    }
}