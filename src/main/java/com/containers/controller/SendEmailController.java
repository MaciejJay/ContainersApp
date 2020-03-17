package com.containers.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import com.containers.model.User;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/sendMail")
public class SendEmailController {

    private JavaMailSender mailSender;

    @RequestMapping(method = RequestMethod.POST)
    public String sendMail(HttpServletRequest request, final @RequestParam CommonsMultipartFile attachFile) {

        final String emailTo = request.getParameter("mailTo");
        final String subject = request.getParameter("subject");
        final String message = request.getParameter("message");

        System.out.println("emailTo: " + emailTo);
        System.out.println("subject: " + subject);
        System.out.println("message: " + message);
        System.out.println("attachFile: " + attachFile.getOriginalFilename());

        mailSender.send(new MimeMessagePreparator() {

            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper messageHelper = new MimeMessageHelper(
                        mimeMessage, true, "UTF-8");
                messageHelper.setTo(emailTo);
                messageHelper.setSubject(subject);
                messageHelper.setText(message);

                String attachName = attachFile.getOriginalFilename();
                if (!attachFile.equals("")) {

                    messageHelper.addAttachment(attachName, new InputStreamSource() {

                        @Override
                        public InputStream getInputStream() throws IOException {
                            return attachFile.getInputStream();
                        }
                    });
                }

            }

        });
        return "ResultSendMail";
    }
}
