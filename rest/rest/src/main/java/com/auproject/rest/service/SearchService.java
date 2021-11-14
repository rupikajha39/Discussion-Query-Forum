package com.auproject.rest.service;


import com.auproject.rest.dao.QuestionGetList;
import com.auproject.rest.model.Keyword;
import com.auproject.rest.repository.KeywordQuestionRepo;
import com.auproject.rest.repository.KeywordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
public class SearchService {

    @Autowired
    private KeywordRepo keywordRepo;
    @Autowired
    private KeywordQuestionRepo keywordQuestionRepo;
    @Autowired
    private QuestionService questionService;

    public List<QuestionGetList> searchQuestion(String question, int topicId){
        question=question.toLowerCase();
        List<Keyword> keywordList= this.keywordRepo.findAll();

        List<Integer> matchedKeyword=new ArrayList<>();
        List<QuestionGetList> questionGetLists= new ArrayList<>();

        for(Keyword keyword : keywordList){
            String keywordName=keyword.getName().toLowerCase();
            if(question.contains(keywordName)){
                matchedKeyword.add(keyword.getId());
            }
        }

        List<Integer> questionIds=this.keywordQuestionRepo.getQuestionIdByKeyword(matchedKeyword,topicId);

        for(int i:questionIds){
            questionGetLists.add(this.questionService.getSpecificQuestion(i));
        }
        return questionGetLists;
    }
}
