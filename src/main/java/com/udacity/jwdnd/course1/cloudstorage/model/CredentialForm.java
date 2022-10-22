package com.udacity.jwdnd.course1.cloudstorage.model;

public class CredentialForm {
    private String url;
    private String userName;
    private String credentialId;
    private String password;

    //Getters
    public String getPassword() {
        return password;
    }

    public String getCredentialId() {
        return credentialId;
    }

    public String getUrl() {
        return url;
    }

    public String getUserName() {
        return userName;
    }

    //Setters
    public void setPassword(String password) {
        this.password = password;
    }

    public void setCredentialId(String credentialId) {
        this.credentialId = credentialId;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
