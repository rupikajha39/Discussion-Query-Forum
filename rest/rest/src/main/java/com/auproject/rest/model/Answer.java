package com.auproject.rest.model;


import javax.persistence.*;

@Entity
@Table(name="answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;
    private int userid;
    private int questionid;
    private String timestamp;
    private boolean isarchive;

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

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isIsarchive() {
        return isarchive;
    }

    public void setIsarchive(boolean isarchive) {
        this.isarchive = isarchive;
    }



    public Answer() {};

    public Answer(int id, String description, int userid, int questionid, String timestamp, boolean isarchived) {
        this.id = id;
        this.description = description;
        this.userid = userid;
        this.questionid = questionid;
        this.timestamp = timestamp;
        this.isarchive = isarchive;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", userid=" + userid +
                ", questionid=" + questionid +
                ", timestamp='" + timestamp + '\'' +
                ", isarchived=" + isarchive +
                '}';
    }
}
