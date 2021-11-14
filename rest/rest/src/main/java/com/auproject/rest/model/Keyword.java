package com.auproject.rest.model;



import javax.persistence.*;

@Entity
@Table(name = "keyword")

public class Keyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String timestamp;
    private int userid;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public int getUserid() {
        return userid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Keyword() {
    }

    public Keyword(int id, String name, String timestamp, int userid) {
        this.id = id;
        this.name = name;
        this.timestamp = timestamp;
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Keyword{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", userid=" + userid +
                '}';
    }
}
