package com.auproject.rest.dao;

import com.auproject.rest.model.KeywordQuestion;
import com.auproject.rest.model.Question;

import java.util.List;

public class QuestionList {

    private List<KeywordQuestion> keywordQuestionList;
    private Question question;

    public QuestionList(){

    }

    public QuestionList(List<KeywordQuestion> keywordQuestionList, Question question) {
        this.keywordQuestionList = keywordQuestionList;
        this.question = question;
    }

    public List<KeywordQuestion> getKeywordQuestionList() {
        return keywordQuestionList;
    }

    public void setKeywordQuestionList(List<KeywordQuestion> keywordQuestionList) {
        this.keywordQuestionList = keywordQuestionList;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
