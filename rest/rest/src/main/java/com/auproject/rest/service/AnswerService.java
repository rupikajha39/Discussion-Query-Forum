package com.auproject.rest.service;

import com.auproject.rest.model.Answer;
import com.auproject.rest.repository.AnswerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepo answerRepo;

    public Optional<Answer> addAnswer(Answer answer) {

            int id=this.answerRepo.save(answer).getId();

            return this.answerRepo.findById(id);

    }

    public List<Answer> getAllAnswerByQuestionId(int questionId) {
        return this.answerRepo.getAnswersByQuestion(questionId);
    }

    public Boolean updateAnswer(Answer answer) {
        try{
            this.answerRepo.save(answer);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public Boolean deleteAnswer(Answer answer) {

        try{
            answer.setIsarchive(true);
            this.answerRepo.save(answer);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
