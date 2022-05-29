package com.example.boyoung.teamproject.Material;

/**
 * Created by boyoung on 2017. 11. 25..
 */

public class User {
    String usernum;
    String password;
    String username;
    String userphone;

    public void setUsernum(String usernum) {
        this.usernum = usernum;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }



    public String getUsernum() {
        return usernum;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getUserphone() {
        return userphone;
    }



    public User(String usernum, String password, String username, String userphone) {
        this.usernum = usernum;
        this.password = password;
        this.username = username;
        this.userphone = userphone;
    }



}
