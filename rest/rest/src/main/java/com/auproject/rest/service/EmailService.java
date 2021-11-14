package com.auproject.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public boolean sendEmail(List<String> emails, String body, String topic) {
        try {
            for(int i=0;i<emails.size();i++)
            {
                    String to = emails.get(i);
                    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
                    simpleMailMessage.setFrom("demotestemail10@gmail.com");
                    simpleMailMessage.setTo(to);
                    simpleMailMessage.setSubject(topic);
                    simpleMailMessage.setText(body);
                    javaMailSender.send(simpleMailMessage);
            }
                return true;
            } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }


}
