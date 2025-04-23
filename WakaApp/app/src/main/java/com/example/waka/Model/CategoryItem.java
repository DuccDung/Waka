package com.example.waka.Model;

public class CategoryItem {
    private String name;
    private boolean isSelected;

    public CategoryItem(String name) {
        this.name = name;
        this.isSelected = false;
    }

    public String getName() {
        return name;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}

