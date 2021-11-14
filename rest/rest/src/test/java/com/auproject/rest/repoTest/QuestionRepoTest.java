package com.auproject.rest.repoTest;


import com.auproject.rest.model.Question;
import com.auproject.rest.model.Topic;
import com.auproject.rest.model.UserInformation;
import com.auproject.rest.model.UserTopic;
import com.auproject.rest.repository.QuestionRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class QuestionRepoTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private QuestionRepo questionRepo;

    @Test
    @Transactional
    public void getQuestionByTopicTest() {
        UserInformation user = new UserInformation(1001, "Niket Jain", "niket.jain@accolitedigital.com", "qwerty", "Delhi");
        UserTopic userTopic=new UserTopic(1,1,1001,"testing");
        Topic topic = new Topic(1,1001,"Test","2021-02-04");
        Question ques= new Question(1,"testing purpose",false,"2021-02-01",1,1001);

        UserInformation userDb=this.testEntityManager.merge(user);
        Topic topicDb=this.testEntityManager.merge(topic);
        UserTopic userTopicDb= this.testEntityManager.merge(userTopic);
        Question questionDb=this.testEntityManager.merge(ques);

        List<Question> questionList=this.questionRepo.getQuestionByTopic(questionDb.getTopicid());
        assertNotNull(questionList);
    }

    @Test
    public void getAllQuestionTest(){
        UserInformation user = new UserInformation(1001, "Niket Jain", "niket.jain@accolitedigital.com", "qwerty", "Delhi");
        UserTopic userTopic=new UserTopic(1,1,1001,"testing");
        Topic topic = new Topic(1,1001,"Test","2021-02-04");
        Question ques= new Question(1,"testing purpose",false,"2021-02-01",1,1001);

        UserInformation userDb=this.testEntityManager.merge(user);
        Topic topicDb=this.testEntityManager.merge(topic);
        UserTopic userTopicDb= this.testEntityManager.merge(userTopic);
        Question questionDb=this.testEntityManager.merge(ques);

        List<Question> questionList=this.questionRepo.getAllQuestion(questionDb.getUserid());
        assertNotNull(questionList);
    }

    @Test
    public void getQuestionByIdTest(){
        UserInformation user = new UserInformation(1001, "Niket Jain", "niket.jain@accolitedigital.com", "qwerty", "Delhi");
        UserTopic userTopic=new UserTopic(1,1,1001,"testing");
        Topic topic = new Topic(1,1001,"Test","2021-02-04");
        Question ques= new Question(1,"testing purpose",false,"2021-02-01",1,1001);

        UserInformation userDb=this.testEntityManager.merge(user);
        Topic topicDb=this.testEntityManager.merge(topic);
        UserTopic userTopicDb= this.testEntityManager.merge(userTopic);
        Question questionDb=this.testEntityManager.merge(ques);

        Question questionList=this.questionRepo.getQuestionById(questionDb.getId());
        assertNotNull(questionList);
    }


    @Test
    public void getQuestionByUserIdTest(){
        UserInformation user = new UserInformation(1001, "Niket Jain", "niket.jain@accolitedigital.com", "qwerty", "Delhi");
        UserTopic userTopic=new UserTopic(1,1,1001,"testing");
        Topic topic = new Topic(1,1001,"Test","2021-02-04");
        Question ques= new Question(1,"testing purpose",false,"2021-02-01",1,1001);

        UserInformation userDb=this.testEntityManager.merge(user);
        Topic topicDb=this.testEntityManager.merge(topic);
        UserTopic userTopicDb= this.testEntityManager.merge(userTopic);
        Question questionDb=this.testEntityManager.merge(ques);

        List<Question> questionList=this.questionRepo.getQuestionByUserId(userDb.getId());
        assertNotNull(questionList);
    }


    @Test
    public void searchTest(){
        UserInformation user = new UserInformation(1001, "Niket Jain", "niket.jain@accolitedigital.com", "qwerty", "Delhi");
        UserTopic userTopic=new UserTopic(1,1,1001,"testing");
        Topic topic = new Topic(1,1001,"Test","2021-02-04");
        Question ques= new Question(1,"testing purpose",false,"2021-02-01",1,1001);

        UserInformation userDb=this.testEntityManager.merge(user);
        Topic topicDb=this.testEntityManager.merge(topic);
        UserTopic userTopicDb= this.testEntityManager.merge(userTopic);
        Question questionDb=this.testEntityManager.merge(ques);

        Question questionList=this.questionRepo.search(questionDb.getId());
        assertNotNull(questionList);
    }

    @Test
    public void getQuestionByTopicUserTest(){
        UserInformation user = new UserInformation(1001, "Niket Jain", "niket.jain@accolitedigital.com", "qwerty", "Delhi");
        UserTopic userTopic=new UserTopic(1,1,1001,"testing");
        Topic topic = new Topic(1,1001,"Test","2021-02-04");
        Question ques= new Question(1,"testing purpose",false,"2021-02-01",1,1001);

        UserInformation userDb=this.testEntityManager.merge(user);
        Topic topicDb=this.testEntityManager.merge(topic);
        UserTopic userTopicDb= this.testEntityManager.merge(userTopic);
        Question questionDb=this.testEntityManager.merge(ques);

        List<Question> questionList=this.questionRepo.getQuestionByTopicUser(userDb.getId(),questionDb.getId());
        assertNotNull(questionList);
    }

}
