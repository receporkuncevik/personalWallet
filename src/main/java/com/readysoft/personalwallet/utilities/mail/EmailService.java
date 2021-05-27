package com.readysoft.personalwallet.utilities.mail;

import com.readysoft.personalwallet.model.Payment;
import com.readysoft.personalwallet.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements EmailSender{

    @Autowired
    private JavaMailSender mailSender;

    public void send(User user,Payment payment) {
        String fullName = user.getFirstName() + " " + user.getLastName();
        String email = "receporkuncevik@gmail.com";
        String subject = "Yaklaşan Ödeme";
        String content=null;

             content = fullName + " " + payment.getDescription() + " Açıklamalı Ödemeniz "
                    + payment.getBuyingDate() + " tarihinde " + payment.getAmount() + " fiyatla bütçenizden alınacaktır";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("info@personalwallet.com");
        message.setTo("d2e01c3c277016");

        String mailSubject = fullName + " Ödeme Yaklaştı";
        String mailContent = content;

        message.setSubject(mailSubject);
        message.setText(mailContent);

        mailSender.send(message);

        System.out.println("Email Gönderimi Başarılı");

    }
}
