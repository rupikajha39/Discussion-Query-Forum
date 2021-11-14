package com.auproject.rest.controller;

import com.auproject.rest.model.Topic;
import com.auproject.rest.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;


    @GetMapping("")
    @CrossOrigin("*")
    public List<Topic> getTopics() {
        return this.topicService.getAllTopics();
    }

    @PostMapping("/create")
    @CrossOrigin("*")
    public Optional<Topic> createTopic(@RequestBody Topic topic){
        return this.topicService.create(topic);
    }

    @GetMapping("/subscribe/get/{userid}")
    @CrossOrigin("*")
    public List<Topic> subscribe(@PathVariable int userid){
       return this.topicService.subscribe(userid);
    }

    @GetMapping("/unsubscribe/get/{userid}")
    @CrossOrigin("*")
    public List<Topic> unSubscribe(@PathVariable int userid){
        return this.topicService.unSubscribe(userid);
    }

}
