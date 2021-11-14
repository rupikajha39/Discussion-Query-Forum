package com.auproject.rest.service;

import com.auproject.rest.model.Notification;
import com.auproject.rest.model.Question;
import com.auproject.rest.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EmailNotificationService {

    @Autowired
    private NotificationRepo notificationRepo;

    @Autowired
    private UserInformationRepo userInformationRepo;

    @Autowired
    private UserTopicRepo userTopicRepo;

    @Autowired
    private EmailRepo emailRepo;

    @Autowired
    QuestionRepo questionRepo;

    @Autowired
    EmailService emailService;

    private final String  dateFormat="yyyy-MM-dd";
    private final String newQuestionMessage="New question has been added to %s";
    private final String newAnswerMessage = "New Answer is added to question %s";

    public void newQuestion(int topicId, String topicName) {
        List<Integer> userIdSet=this.userTopicRepo.getUserIdByTopicId(topicId);
        String date = new SimpleDateFormat(this.dateFormat).format(new Date());
        String text=String.format(newQuestionMessage,topicName);

        userIdSet.forEach(i->{
            this.notificationRepo.insert(text,i,date,false);
        });


        List<String> emailList=this.userInformationRepo.getEmailByUserId(userIdSet);

        Boolean result=true;
        try {

            result=this.emailService.sendEmail(emailList,text,topicName);
        }
        catch(Exception e) {
            result=false;
        }
        finally {

            for (int i = 0; i < userIdSet.size(); i++) {
                this.emailRepo.insert(emailList.get(i), date, result, text, "New Question", userIdSet.get(i));
            }
        }

    }

    public void addAnswerNotification(int questionId) {

        Question question =this.questionRepo.search(questionId);

        String questionName = question.getDescription();
        int topicId=question.getTopicid();

        String text = String.format(newAnswerMessage,questionName);//changes

        String subject = "New Answer";
        List<Integer> userIds = this.userTopicRepo.getUserIdByTopicId(topicId);
        String date = new SimpleDateFormat(this.dateFormat).format(new Date());

        for(int i=0;i<userIds.size();i++) {
            this.notificationRepo.insert(text,userIds.get(i),date,false);
        }

        List<String> emails = this.userInformationRepo.getEmailByUserId(userIds);
        Boolean result = true;
        try {
            result=this.emailService.sendEmail(emails, text, subject);
        } catch (Exception e) {
            result = false;
        } finally {
            for(int i=0;i<userIds.size();i++) {
                this.emailRepo.insert(emails.get(i),date,result,text,subject,userIds.get(i));
            }
        }
    }

    public List<Notification> showNotifications(int userId) {
        return this.notificationRepo.findByUserId(userId);
    }
}
