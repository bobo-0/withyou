package com.example.boyoung.teamproject.Material;

/**
 * Created by boyoung on 2017. 11. 27..
 */

public class Board {

    String postnum;
    String name;
    String title;
    String content;
    String date;

    public Board(String postnum, String name, String title, String content, String date) {
        this.postnum = postnum;
        this.name = name;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public String getPostnum() {
        return postnum;
    }

    public void setPostnum(String board) {
        this.postnum = board;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
