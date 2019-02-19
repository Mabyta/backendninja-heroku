package com.lsc.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserCredential {

    @NotNull
    @NotEmpty
    private String username;
    @NotNull
    @NotEmpty
    private String password;

    public UserCredential(){}

    public UserCredential(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserCredential{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
