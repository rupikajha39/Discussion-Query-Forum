package com.auproject.rest.controller;

import com.auproject.rest.model.Answer;
import com.auproject.rest.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/question/answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping("")
    @CrossOrigin("*")
    public Optional<Answer> addAnswer(@RequestBody Answer answer){

        return this.answerService.addAnswer(answer);
    }

    @GetMapping("/{questionId}")
    @CrossOrigin("*")
    public List<Answer> getAllAnswer(@PathVariable int questionId) {
        return this.answerService.getAllAnswerByQuestionId(questionId);
    }

    @PutMapping("/update")
    @CrossOrigin("*")
    public Boolean updateAnswer(@RequestBody Answer answer){

        return this.answerService.updateAnswer(answer);
    }

    @PostMapping("/delete")
    @CrossOrigin("*")
    public Boolean deleteAnswer(@RequestBody Answer answer){

        return this.answerService.deleteAnswer(answer);
    }

}
