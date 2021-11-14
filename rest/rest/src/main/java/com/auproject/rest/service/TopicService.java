package com.auproject.rest.service;

import com.auproject.rest.model.Topic;
import com.auproject.rest.repository.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepo topicRepo;

    public List<Topic> getAllTopics() {
        return this.topicRepo.findAll();
    }

    public Optional<Topic> create(Topic topic){
        int id=this.topicRepo.save(topic).getId();
        return this.topicRepo.findById(id);
    }

    public List<Topic> subscribe(int userid) {
        return this.topicRepo.getSub(userid);
    }

    public List<Topic> unSubscribe(int userid) {
        return this.topicRepo.unsubscribeTopic(userid);
    }
}
