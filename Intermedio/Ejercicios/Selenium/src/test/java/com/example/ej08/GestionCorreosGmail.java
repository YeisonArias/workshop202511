package com.example.ej08;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

public class GestionCorreosGmail {
    String host = "imap.gmail.com";
    String username = "notellmch@gmail.com";
    String password = "okwp hjdk gjly qwcu";
    Properties properties= new Properties();

    @Before
    public void setUp() {
        properties.put("mail.store.protocol", "imap");
        properties.put("mail.imap.host", host);
        properties.put("mail.imap.port", "993");
        properties.put("mail.imap.ssl.enable", "true");
        //smtp para gmail
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
    }

    @Test
    public void testLeerCorreo() {
        try {
            Session session = Session.getDefaultInstance(properties);
            Store store = session.getStore("imap");
            store.connect(host, username, password);

            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            int totalCorreos = inbox.getMessageCount();
            System.out.println("Total de correos: " + totalCorreos);

            //Imprimir los 5 ultimos correos
            int start = Math.max(totalCorreos - 5,1);
            Message[] messages = inbox.getMessages(start, totalCorreos);

            System.out.println("Inicia: "+start);

            for (int i = messages.length-1; i>=0; i--) {
                Message message = messages[i];
                System.out.println("---------------------------------");
                System.out.println("Asunto: "+message.getSubject());
                System.out.println("Remitente: "+message.getFrom()[0]);
                System.out.println("Fecha: "+message.getReceivedDate());
                System.out.println("Contenido: "+message.getContent().toString());
            }

            inbox.close(false);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    @Test
    public void testEnvioDeCorreo() {
        String destinatario = "ecarreno@keralty.com";
        String asunto = "Prueba de correo: Workshop de Automatización";
        String contenido = "Este es un correo de prueba desde el Curso WS Automatización";

        try {
            Session session = Session.getInstance(properties, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setText(contenido);

            Transport.send(message);
            System.out.println("Correo enviado exitosamente al destinatario: "+destinatario);

        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }


}
