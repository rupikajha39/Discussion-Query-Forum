package com.auproject.rest.model;

import javax.persistence.*;

@Entity
@Table(name = "keywordquestion")
public class KeywordQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int keywordid;
    private int questionid;
    private String keywordname;

    public String getKeywordName() {
        return keywordname;
    }

    public void setKeywordName(String keywordname) {
        this.keywordname = keywordname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKeywordid() {
        return keywordid;
    }

    public void setKeywordid(int keywordid) {
        this.keywordid = keywordid;
    }

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public KeywordQuestion() {
    }

    public KeywordQuestion(int id, int keywordid, int questionid,String keywordname) {
        this.id = id;
        this.keywordid = keywordid;
        this.questionid = questionid;
        this.keywordname =  keywordname;
    }

    @Override
    public String toString() {
        return "KeywordQuestion{" +
                "id=" + id +
                ", keywordid=" + keywordid +
                ", questionid=" + questionid +
                ", keywordname='" + keywordname + '\'' +
                '}';
    }
}