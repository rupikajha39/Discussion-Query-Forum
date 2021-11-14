package com.auproject.rest.dao;


import java.util.List;

public class QuestionGetList {

    private int id;

    private String description;
    private boolean answeredflag;
    private int userid;
    private String timestamp;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    private List<String> keywordList;

    public QuestionGetList(){

    }

    public QuestionGetList(int id, String description, boolean answeredflag, int userid, String timestamp, List<String> keywordList) {
        this.id = id;
        this.description = description;
        this.answeredflag = answeredflag;
        this.userid = userid;
        this.timestamp = timestamp;
        this.keywordList = keywordList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAnsweredflag() {
        return answeredflag;
    }

    public void setAnsweredflag(boolean answeredflag) {
        this.answeredflag = answeredflag;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }



    public List<String> getKeywordList() {
        return keywordList;
    }

    public void setKeywordList(List<String> keywordList) {
        this.keywordList = keywordList;
    }

}
