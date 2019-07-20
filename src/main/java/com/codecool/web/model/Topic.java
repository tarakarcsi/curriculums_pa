package com.codecool.web.model;

public class Topic extends AbstractModel{
    String title;

    public Topic(int topicId, String title) {
        super(topicId);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
