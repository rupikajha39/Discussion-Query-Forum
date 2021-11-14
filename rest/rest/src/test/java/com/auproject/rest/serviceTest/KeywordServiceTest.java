package com.auproject.rest.serviceTest;

import com.auproject.rest.model.Keyword;
import com.auproject.rest.model.KeywordQuestion;
import com.auproject.rest.repository.KeywordQuestionRepo;
import com.auproject.rest.repository.KeywordRepo;
import com.auproject.rest.service.KeywordService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class KeywordServiceTest {

    @MockBean
    private KeywordRepo keywordRepo;

    @Autowired
    private KeywordService keywordService;

    @MockBean
    private KeywordQuestionRepo keywordQuestionRepo;


    @Test
    void testGetAllKeywords() {
        List<Keyword> keywords = new ArrayList<>();
        keywords.add(new Keyword(1,"Angular","2021-02-04",1));
        keywords.add(new Keyword(1,"React","2021-02-04",1));

        Mockito.when(keywordRepo.findAll()).thenReturn(keywords);

        assert (keywordService.getAllKeywords()).equals(keywords);
    }

    @Test
    void testGetKeywordAccordingToQuestion() {
        List<KeywordQuestion> keywordQuestions = new ArrayList<>();
        keywordQuestions.add(new KeywordQuestion(1,1,1,"Angular"));
        keywordQuestions.add(new KeywordQuestion(1,1,1,"React"));

        Mockito.when(keywordQuestionRepo.findAll()).thenReturn(keywordQuestions);

        assert (keywordService.getKeywords()).equals(keywordQuestions);
    }

    @Test
    void testCreateKeyword() {
        Keyword keyword = new Keyword(1,"Angular","2021-02-04",1);

        Mockito.when(keywordRepo.findById(1)).thenReturn(Optional.of(keyword));
        Mockito.when(keywordRepo.save(keyword)).thenReturn(keyword);

        assert (keywordService.create(keyword)).isPresent();
    }
}