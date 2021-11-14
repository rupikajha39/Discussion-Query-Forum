package com.auproject.rest.repoTest;


import com.auproject.rest.model.Topic;
import com.auproject.rest.model.UserInformation;
import com.auproject.rest.model.UserTopic;
import com.auproject.rest.repository.TopicRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TopicRepoTest {


    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private TopicRepo topicRepo;

    @Test
    public void getSubTest(){
        UserInformation user = new UserInformation(1001, "Niket Jain", "niket.jain@accolitedigital.com", "qwerty", "Delhi");
        UserTopic userTopic=new UserTopic(1,1,1001,"testing");
        Topic topic = new Topic(1,1001,"Test","2021-02-04");

        UserInformation userInformation=this.testEntityManager.merge(user);
        Topic topicDb= this.testEntityManager.merge(topic);
        UserTopic userTopicdb=this.testEntityManager.merge(userTopic);
        List<Topic> topicList=new ArrayList<>();
        topicList.add(topicDb);
        List<Topic> topidReturnDb=this.topicRepo.getSub(userInformation.getId());
        assertNotNull(topidReturnDb);
        assertThat(topidReturnDb).isEqualTo(topicList);
    }

}
