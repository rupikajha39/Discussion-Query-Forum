package com.auproject.rest.repoTest;

import com.auproject.rest.model.Topic;
import com.auproject.rest.model.UserInformation;
import com.auproject.rest.model.UserTopic;
import com.auproject.rest.repository.UserTopicRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserTopicRepoTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserTopicRepo userTopicRepo;

    @Test
    public void getUserIdByTopicIdTest(){
        UserInformation user = new UserInformation(1001, "Niket Jain", "niket.jain@accolitedigital.com", "qwerty", "Delhi");
        UserTopic userTopic=new UserTopic(1,1,1001,"testing");
        Topic topic = new Topic(1,1001,"Test","2021-02-04");

        UserInformation userTest= testEntityManager.merge(user);

        UserTopic userTopic1= testEntityManager.merge(userTopic);

        Topic topicTest= testEntityManager.merge(topic);

            Optional<UserTopic> result=this.userTopicRepo.findById(userTopic1.getId());

            assertNotNull(result);
            assertThat(result).isEqualTo(Optional.of(userTopic1));
    }


    @Test
    public void deleteByUserIdTest(){
        UserInformation user = new UserInformation(1001, "Niket Jain", "niket.jain@accolitedigital.com", "qwerty", "Delhi");
        UserTopic userTopic=new UserTopic(1,1,1001,"testing");
        Topic topic = new Topic(1,1001,"Test","2021-02-04");

        UserInformation userTest= testEntityManager.merge(user);

        UserTopic userTopic1= testEntityManager.merge(userTopic);

        Topic topicTest= testEntityManager.merge(topic);

        this.userTopicRepo.deleteByUserId(userTest.getId());
        Optional<UserTopic> result=this.userTopicRepo.findById(userTest.getId());

        assertThat(result).isEqualTo(Optional.empty());
    }

    @Test
    public void insertTest(){
        UserInformation user = new UserInformation(1001, "Niket Jain", "niket.jain@accolitedigital.com", "qwerty", "Delhi");
        UserTopic userTopic=new UserTopic(1,1,1001,"testing");
        Topic topic = new Topic(1,1001,"Test","2021-02-04");

        UserInformation userTest= testEntityManager.merge(user);

        UserTopic userTopic1= testEntityManager.merge(userTopic);

        Topic topicTest= testEntityManager.merge(topic);

        this.userTopicRepo.insert(userTopic1.getTopicid(),userTest.getId(),userTopic1.getTopicname());
        Optional<UserTopic> result=this.userTopicRepo.findById(userTopic1.getId());
        assertNotNull(result);
        assertThat(result).isEqualTo(Optional.of(userTopic1));
    }
}
