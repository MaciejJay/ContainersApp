package com.containers.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sendMail")
public class SendEmailController {

    private JavaMailSender mailSender;

    public SendEmailController(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doSendEmail(HttpServletRequest request) {

        String emailTo = request.getParameter("emailTo");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");

        System.out.println("To: " + emailTo);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);

        SimpleMailMessage sendMail = new SimpleMailMessage();
        sendMail.setTo(emailTo);
        sendMail.setSubject(subject);
        sendMail.setText(message);

        try {
            mailSender.send(sendMail);
            return "ResultSendMail";
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }

        return "ResultSendMail";
    }
}
