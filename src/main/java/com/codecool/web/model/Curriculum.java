package com.codecool.web.model;

public class Curriculum extends AbstractModel {

    private String title;
    private String content;
    private int price;
    private int topicId;

    public Curriculum(int id, String title, String content, int price, int topicId) {
        super(id);
        this.title = title;
        this.content = content;
        this.price = price;
        this.topicId = topicId;
    }

    public Curriculum(String title, String content, int price, int topicId) {
        this.title = title;
        this.content = content;
        this.price = price;
        this.topicId = topicId;
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

    public int getTopicId() {
        return topicId;
    }
}
