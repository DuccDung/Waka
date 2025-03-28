package com.example.waka.Model;

public class Author {
    private String Name;
    private int img;

    public Author(String name, int img) {
        Name = name;
        this.img = img;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
