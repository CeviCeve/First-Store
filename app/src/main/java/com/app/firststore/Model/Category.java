package com.app.firststore.Model;

public class Category {

    int id;
    String title;
    String color;

    public Category(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Category(int id, String title, String color) {
        this.id = id;
        this.title = title;
        this.color = color;
    }


    public String getColor() {return color;}

    public void setColor(String color) {this.color = color;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }





}
