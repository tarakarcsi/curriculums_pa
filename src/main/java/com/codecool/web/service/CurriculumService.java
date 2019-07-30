package com.codecool.web.service;

import com.codecool.web.model.Curriculum;

import java.sql.SQLException;
import java.util.List;

public interface CurriculumService {

    List<Curriculum> getCurriculumsByTopic(int topicId) throws SQLException;
    Curriculum getCurriculumById(int id) throws SQLException;
    void addCurriculum(String title, String content, int price, int topicId) throws SQLException;
}
