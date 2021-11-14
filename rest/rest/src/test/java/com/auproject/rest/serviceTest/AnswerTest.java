package com.auproject.rest.serviceTest;

import com.auproject.rest.model.Answer;
import com.auproject.rest.repository.AnswerRepo;
import com.auproject.rest.service.AnswerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class AnswerTest {

    @MockBean
    private AnswerRepo answerRepo;

    @Autowired
    private AnswerService answerService;


    @Test
    void testGetAllQuestionById() {
        List<Answer> answer = new ArrayList<>();
        answer.add(new Answer(1,"Hello",1,1,"2021/02/04",false));
        answer.add(new Answer(1,"Hello",1,1,"2021/02/04",false));

        Mockito.when(answerRepo.getAnswersByQuestion(1)).thenReturn(answer);

        assert(answerService.getAllAnswerByQuestionId(1)).equals(answer);
    }

    @Test
    void testUpdateAnswer() {
        Answer answer = new Answer(1,"Hello",1,1,"2021/02/04",false);

        Mockito.when(answerRepo.getAnswersByQuestion(1)).thenReturn(null);

        assert(answerService.updateAnswer(answer)).equals(true);
    }

    @Test
    void testDeleteAnswer() {
        Answer answer = new Answer(1,"Hello",1,1,"2021/02/04",false);

        Mockito.when(answerRepo.getAnswersByQuestion(1)).thenReturn(null);

        assert(answerService.deleteAnswer(answer)).equals(true);
    }
}
