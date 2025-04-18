package com.example.waka.Model;

import java.util.ArrayList;
import java.util.List;

public class Comment {
    private int id;
    private String nameUser;
    private String content;

    public Comment(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public int getId() { return id; }
    public String getContent() { return content; }
}

