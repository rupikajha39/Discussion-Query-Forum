package com.auproject.rest.controller;

import com.auproject.rest.dao.QuestionGetList;
import com.auproject.rest.dao.QuestionList;
import com.auproject.rest.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/topic/{topicId}")
    @CrossOrigin("*")
    public List<QuestionGetList> getQuestion(@PathVariable int topicId){
        return this.questionService.getQuestion(topicId);
    }

    @GetMapping("/all/{userId}")
    @CrossOrigin("*")
    public List<QuestionGetList> getAllQuestion(@PathVariable int userId){
        return this.questionService.getAllQuestion(userId);
    }


    @PostMapping("")
    @CrossOrigin("*")
    public ResponseEntity<Boolean> insertQuestion(@RequestBody  QuestionList questionList){
        return new ResponseEntity<>(this.questionService.createQuestion(questionList), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/{topicId}")
    @CrossOrigin("*")
    public List<QuestionGetList> getQuestion(@PathVariable int userId, @PathVariable int topicId){
        return this.questionService.getQuestionByUserIdTopicId(userId,topicId);
    }

    @GetMapping("/user/{userId}")
    @CrossOrigin("*")
    public List<QuestionGetList> getQuestionByUser(@PathVariable int userId){
        return this.questionService.getAllQuestionByUserId(userId);
    }

    @GetMapping("/{quesId}")
    @CrossOrigin("*")
    public Boolean setQuestionAnswered(@PathVariable int quesId){
        return this.questionService.setQuestionAnswered(quesId);
    }

}
