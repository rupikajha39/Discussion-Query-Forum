package com.auproject.rest.model;



import javax.persistence.*;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;
    private boolean answeredflag;
    private String timestamp;
    private int topicid;
    private int userid;

    public Question() {
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

    public boolean getAnsweredflag() {
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

    public int getTopicid() {
        return topicid;
    }

    public void setTopicid(int topicid) {
        this.topicid = topicid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Question(int id, String description, boolean answeredflag, String timestamp, int topicid, int userid) {
        this.id = id;
        this.description = description;
        this.answeredflag = answeredflag;
        this.timestamp = timestamp;
        this.topicid = topicid;
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", answeredflag=" + answeredflag +
                ", timestamp='" + timestamp + '\'' +
                ", topicid=" + topicid +
                ", userid=" + userid +
                '}';
    }
}