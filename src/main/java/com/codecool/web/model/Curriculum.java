package com.codecool.web.model;

public class Curriculum extends AbstractModel {

    private String title;
    private String content;
    private int price;

    public Curriculum(int id, String title, String content, int price) {
        super(id);
        this.title = title;
        this.content = content;
        this.price = price;
    }

    public Curriculum(String title, String content, int price) {
        this.title = title;
        this.content = content;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getPrice() {
        return price;
    }
}
