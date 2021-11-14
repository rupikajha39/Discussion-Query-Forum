package com.auproject.rest;

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
                    System.out.println(to);
                    System.out.println("sending email ......");
                    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
                    System.out.println("1  email ......");
                    simpleMailMessage.setFrom("demotestemail10@gmail.com");
                System.out.println("2 email ......");
                    simpleMailMessage.setTo(to);
                System.out.println("3 email ......");
                    simpleMailMessage.setSubject(topic);
                System.out.println("4 email ......");
                    simpleMailMessage.setText(body);
                System.out.println("5 email ......");
                    javaMailSender.send(simpleMailMessage);
                System.out.println("5 email ......");
                    System.out.println("sent email :)");
            }
                return true;
            } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public EmailService() {};
}
