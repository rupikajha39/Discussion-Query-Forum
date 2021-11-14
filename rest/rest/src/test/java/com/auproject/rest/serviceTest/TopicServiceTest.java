package com.auproject.rest.serviceTest;


import com.auproject.rest.model.Topic;
import com.auproject.rest.repository.TopicRepo;
import com.auproject.rest.service.TopicService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class TopicServiceTest {
    @MockBean
    private TopicRepo topicRepo;

    @Autowired
    private TopicService topicService;

    @Test
    public void getAllTopicsTest(){
        List<Topic> topic=new ArrayList<>();
        topic.add(new Topic(1,2,"Angular","2020-02-01"));
        topic.add(new Topic(1,1,"Java","2020-02-01"));

        Mockito.when(topicRepo.findAll()).thenReturn(topic);

        assert(topicService.getAllTopics()).equals(topic);

    }

    @Test
    public void subscribeTest(){
        List<Topic> topic=new ArrayList<>();
        topic.add(new Topic(1,1,"Angular","2020-02-01"));
        topic.add(new Topic(1,1,"Java","2020-02-01"));

        Mockito.when(topicRepo.getSub(1)).thenReturn(topic);
        assert(topicService.subscribe(1)).equals(topic);
    }

    @Test
    public void unSubscribeTest() {
        List<Topic> topic = new ArrayList<>();
        topic.add(new Topic(1, 2, "Angular", "2020-02-01"));
        topic.add(new Topic(1, 2, "Java", "2020-02-01"));

        Mockito.when(topicRepo.unsubscribeTopic(1)).thenReturn(topic);
        assert(topicService.unSubscribe(1)).equals(topic);
    }

    @Test
    public void createTest(){
        Topic topic=new Topic(1, 2, "Angular", "2020-02-01");

        Mockito.when(topicRepo.save(topic)).thenReturn(topic);
        Mockito.when(topicRepo.findById(topic.getId())).thenReturn(Optional.of(topic));
        assert(topicService.create(topic)).equals(Optional.of(topic));
    }
}
