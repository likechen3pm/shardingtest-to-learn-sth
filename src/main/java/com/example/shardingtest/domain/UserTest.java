package com.example.shardingtest.domain;

import java.sql.Timestamp;

public class UserTest {
    private Integer id;
    private String name;
    private Timestamp timestamp;

    public UserTest(){}

    public UserTest(String name){this.name = name;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString(){
        return "UserTest类 id:" + id + " name:" + name + "timestamp:" + timestamp;
    }
}
