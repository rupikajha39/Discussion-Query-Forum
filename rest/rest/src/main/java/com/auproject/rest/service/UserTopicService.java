package com.auproject.rest.service;

import com.auproject.rest.model.Topic;
import com.auproject.rest.repository.UserTopicRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class UserTopicService {

    @Autowired
    private UserTopicRepo userTopicRepo;


    public Boolean set(List<Topic> userTopic, int userid) {

        try {
            this.userTopicRepo.deleteByUserId(userid);
            for (Topic topic : userTopic) {
                this.userTopicRepo.insert(topic.getId(), userid, topic.getTopicname());
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
