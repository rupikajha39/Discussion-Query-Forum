package com.auproject.rest.model;

import javax.persistence.*;

@Entity
@Table(name="notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int userid;
    private String description;
    private String timestamp;
    private Boolean visited;

    public Notification() {}
    public Notification(int id, int userid, String description, String timestamp, Boolean visited) {
        this.id = id;
        this.userid = userid;
        this.description = description;
        this.timestamp = timestamp;
        this.visited = visited;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", userid=" + userid +
                ", description='" + description + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", visited=" + visited +
                '}';
    }
}
