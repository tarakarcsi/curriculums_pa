package com.codecool.web.model;

abstract class AbstractModel {

    private int id;

    public AbstractModel(int id) {
        this.id = id;
    }

    public AbstractModel() {
    }

    public int getId() {
        return id;
    }
}
