//package com.ikiseh.My_Task_Management_System.service.impl;
//
//
//import jakarta.mail.MessagingException;
//import jakarta.mail.internet.MimeMessage;
//import lombok.RequiredArgsConstructor;
//import org.springframework.mail.MailException;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestBody;
//
//@Service
//@RequiredArgsConstructor
//public class EmailSer implements com.ikiseh.My_Task_Management_System.service.EmailSer {
//
//    private final JavaMailSender javaMailSender;
//    @Override
//    @Async
//    public void sendEmail(String toEmail, String subject, String content) {
//
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(toEmail);
//        message.setSubject(subject);
//        message.setText(content);
//        try{
//            javaMailSender.send(message);
//        } catch (MailException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public void sendHTMLEmail(String toEmail, String subject, String content) throws MessagingException {
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
//        helper.setTo(toEmail);
//        helper.setSubject(subject);
//        helper.setText(content, true);
//        try{
//            javaMailSender.send(mimeMessage);
//        } catch (MailException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
