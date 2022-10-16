package com.udacity.jwdnd.course1.cloudstorage.model;

public class User {
    private Integer userId;
    private String userName;
    private String salt;
    private String password;
    private String firstName;
    private String lastName;

    public User(Integer userId, String userName, String salt, String password, String firstName, String lastName) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.salt = salt;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //////////////////////////////////////////////////
    //Setters
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public void setUsername(String userName) {
        this.userName = userName;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //////////////////////////////////////////////////
    //Getters
    public Integer getUserId() {
        return this.userId;
    }

    public String getUsername() {
        return this.userName;
    }

    public String getSalt() {
        return this.salt;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
