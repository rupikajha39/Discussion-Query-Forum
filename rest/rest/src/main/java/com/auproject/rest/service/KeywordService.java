package com.auproject.rest.service;

import com.auproject.rest.model.Keyword;
import com.auproject.rest.model.KeywordQuestion;
import com.auproject.rest.repository.KeywordQuestionRepo;
import com.auproject.rest.repository.KeywordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KeywordService {
    @Autowired
    private KeywordRepo keywordRepo;
    @Autowired
    private KeywordQuestionRepo keywordQuestionRepo;

    public Optional<Keyword> create(Keyword keyword){

            int id =this.keywordRepo.save(keyword).getId();
            return this.keywordRepo.findById(id);

    }

    public List<Keyword> getAllKeywords() {
        return this.keywordRepo.findAll();
    }

    public List<KeywordQuestion> getKeywords(){return this.keywordQuestionRepo.findAll();}
}
