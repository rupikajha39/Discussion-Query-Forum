package com.auproject.rest.controller;

import com.auproject.rest.model.Keyword;
import com.auproject.rest.service.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/keyword")
public class KeywordController {

    @Autowired
    private KeywordService keywordService;

    @GetMapping("")
    @CrossOrigin("*")
    public List<Keyword> getAllKeywords() {
        return this.keywordService.getAllKeywords();
    }

    @PostMapping("/add")
    @CrossOrigin("*")
    public Optional<Keyword> createKeyword(@RequestBody Keyword keyword) {

        return this.keywordService.create(keyword);
    }
}
