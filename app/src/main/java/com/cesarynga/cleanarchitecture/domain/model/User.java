package com.cesarynga.cleanarchitecture.domain.model;

public class User {

    private final int id;
    private String username;

    public User(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
