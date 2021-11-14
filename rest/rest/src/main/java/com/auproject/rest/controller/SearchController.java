package com.auproject.rest.controller;

import com.auproject.rest.dao.QuestionGetList;
import com.auproject.rest.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/search/{question}/{topicId}")
    @CrossOrigin("*")
    public List<QuestionGetList> searchQuestion(@PathVariable String question,@PathVariable int topicId){
        return this.searchService.searchQuestion(question,topicId);
    }

}
