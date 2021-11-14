package com.auproject.rest.model;

import javax.persistence.*;

@Entity
@Table(name="topic")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int topicid;

    private int userid;
    private String topicname;
    private String timestamp;

    public Topic (){

    }

    public Topic(int topicid, int userid, String topicname, String timestamp) {
        this.topicid = topicid;
        this.userid = userid;
        this.topicname = topicname;
        this.timestamp = timestamp;
    }

    public int getId() {
        return topicid;
    }

    public void setId(int topicid) {
        this.topicid = topicid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getTopicname() {
        return topicname;
    }

    public void setTopicname(String topicname) {
        this.topicname = topicname;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicid=" + topicid +
                ", userid=" + userid +
                ", topicname='" + topicname + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
