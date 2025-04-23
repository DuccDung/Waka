package com.example.waka.Model;

public class Review {
    private String Name;
    private String Comment;

    public Review(String name, String comment) {
        Name = name;
        Comment = comment;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }
}
