package com.auproject.rest.model;

import javax.persistence.*;

@Entity
@Table(name="usertopic")
public class UserTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int topicid;
    private int userid;
    private String topicname;

    public UserTopic(){

    }

    public UserTopic(int id, int topicid, int userid, String topicname) {
        this.id = id;
        this.topicid = topicid;
        this.userid = userid;
        this.topicname = topicname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTopicname() {
        return topicname;
    }

    public void setTopicname(String topicname) {
        this.topicname = topicname;
    }

    @Override
    public String toString() {
        return "UserTopic{" +
                "id=" + id +
                ", topicid=" + topicid +
                ", userid=" + userid +
                ", topicname='" + topicname + '\'' +
                '}';
    }
}

