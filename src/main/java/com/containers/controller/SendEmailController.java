package com.containers.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/sendMail")
public class SendEmailController {

    private JavaMailSender mailSender;

    public SendEmailController(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doSendEmail(HttpServletRequest request, MultipartFile attachFile) {

        String emailTo = request.getParameter("emailTo");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");

        System.out.println("To: " + emailTo);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
        System.out.println("Attach: " + attachFile.getOriginalFilename());

        String attachName = attachFile.getOriginalFilename();

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            helper.setTo(emailTo);
            helper.setSubject(subject);
            helper.setText(message);
            if ((attachName != null) && (!attachName.equals(""))) {
                helper.addAttachment(attachName, new InputStreamSource() {
                    @Override
                    public InputStream getInputStream() throws IOException {
                        return attachFile.getInputStream();
                    }
                });
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        mailSender.send(mimeMessage);

        return "ResultSendMail";
    }
}
