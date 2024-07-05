package com.ikiseh.My_Task_Management_System.service.impl;

import com.ikiseh.My_Task_Management_System.payLoad.request.EmailDetails;
import com.ikiseh.My_Task_Management_System.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String senderEmail;



    @Override
    public void sendVerificationEmail(EmailDetails emailDetails) {

        try{
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(senderEmail);
            simpleMailMessage.setTo(emailDetails.getRecipient());
            simpleMailMessage.setSubject(emailDetails.getSubject());
            simpleMailMessage.setText(emailDetails.getMessageBody());

            javaMailSender.send(simpleMailMessage);

        } catch (MailException e) {
            throw new RuntimeException(e);
        }

    }
}
