package com.codecool.web.model;

public class Purchase extends AbstractModel {

    private int userId;
    private int curriculumId;

    public Purchase(int id, int userId, int curriculumId) {
        super(id);
        this.userId = userId;
        this.curriculumId = curriculumId;
    }

    public int getUserId() {
        return userId;
    }

    public int getCurriculumId() {
        return curriculumId;
    }
}
