package com.auproject.rest.serviceTest;


import com.auproject.rest.dao.QuestionList;
import com.auproject.rest.model.KeywordQuestion;
import com.auproject.rest.model.Question;
import com.auproject.rest.repository.KeywordQuestionRepo;
import com.auproject.rest.repository.QuestionRepo;
import com.auproject.rest.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class QuestionServiceTest {

    @MockBean
    private QuestionRepo questionRepo;

    @MockBean
    private KeywordQuestionRepo keywordQuestionRepo;

    @Autowired
    private QuestionService questionService;

    @Test
    public void testCreateQuestion() {

        Question ques = new Question(1,"What is Angular", false, "2021-02-04",1,1);

        List<KeywordQuestion> keywordQuestions = new ArrayList<>();
        keywordQuestions.add(new KeywordQuestion(1,1,1,"Angular"));
        keywordQuestions.add(new KeywordQuestion(1,1,1,"React"));

        QuestionList questionList = new QuestionList();
        questionList.setQuestion(ques);
        questionList.setKeywordQuestionList(keywordQuestions);

        Mockito.when(questionRepo.save(ques)).thenReturn(ques);
        assert(questionService.createQuestion(questionList)).equals(true);
    }


}