package com.auproject.rest.service;

import com.auproject.rest.dao.QuestionGetList;
import com.auproject.rest.dao.QuestionList;
import com.auproject.rest.model.KeywordQuestion;
import com.auproject.rest.model.Question;
import com.auproject.rest.repository.KeywordQuestionRepo;
import com.auproject.rest.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//changes
@Service
public class QuestionService {

    @Autowired
    private QuestionRepo questionRepo;
    @Autowired
    private KeywordQuestionRepo keywordQuestionRepo;

    private QuestionGetList questionInsert(Question ques){
        QuestionGetList list= new QuestionGetList();
        list.setId(ques.getId());
        list.setAnsweredflag(ques.getAnsweredflag());
        list.setKeywordList(this.keywordQuestionRepo.getKeywordId(ques.getId()));
        list.setDescription(ques.getDescription());
        list.setTimestamp(ques.getTimestamp());
        list.setUserid(ques.getUserid());
        return  list;
    }

    public List<QuestionGetList> getAllQuestion(int userId){

        List<Question> questionList= this.questionRepo.getAllQuestion(userId);
        List<QuestionGetList> mainList=new ArrayList<>();
        for(Question ques : questionList){
            mainList.add(questionInsert(ques));
        }
        return mainList;

    }

    public List<QuestionGetList> getQuestion(int topicId){

        List<Question> questionList= this.questionRepo.getQuestionByTopic(topicId);
        List<QuestionGetList> mainList=new ArrayList<>();
        for(Question ques : questionList){
            mainList.add(questionInsert(ques));

        }
        return mainList;
    }

    public Boolean createQuestion(QuestionList questionList) {
        Question question = questionList.getQuestion();
        List<KeywordQuestion> keywordList = questionList.getKeywordQuestionList();

        int quesId= this.questionRepo.save(question).getId();

        for(KeywordQuestion keywordQuestion: keywordList){

            this.keywordQuestionRepo.insert(keywordQuestion.getKeywordid(),quesId,keywordQuestion.getKeywordName());
        }

        return true;

    }

    public QuestionGetList getSpecificQuestion(int quesId){

        Question ques=  this.questionRepo.getQuestionById(quesId);
        return questionInsert(ques);

    }


    public List<QuestionGetList> getAllQuestionByUserId(int userId) {
        List<Question> questionList= this.questionRepo.getQuestionByUserId(userId);
        List<QuestionGetList> mainList=new ArrayList<>();
        for(Question ques : questionList){
            mainList.add(questionInsert(ques));
        }
        return mainList;
    }

    public List<QuestionGetList> getQuestionByUserIdTopicId(int userId,int topicId) {
        List<Question> questionList= this.questionRepo.getQuestionByTopicUser(userId,topicId);
        List<QuestionGetList> mainList=new ArrayList<>();
        for(Question ques : questionList){
            mainList.add(questionInsert(ques));
        }
        return mainList;
    }

    public Boolean setQuestionAnswered(int quesId) {
        try {
            Optional<Question> ques = this.questionRepo.findById(quesId);
            ques.get().setAnsweredflag(true);
            this.questionRepo.save(ques.get());
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
