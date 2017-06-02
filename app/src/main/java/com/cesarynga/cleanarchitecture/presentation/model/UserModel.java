package com.cesarynga.cleanarchitecture.presentation.model;

public class UserModel {

    private final int id;
    private String username;

    public UserModel(int id) {
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
