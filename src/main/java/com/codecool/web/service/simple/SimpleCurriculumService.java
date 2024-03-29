package com.codecool.web.service.simple;

import com.codecool.web.dao.database.CurriculumDao;
import com.codecool.web.model.Curriculum;
import com.codecool.web.service.CurriculumService;

import java.sql.SQLException;
import java.util.List;

public class SimpleCurriculumService implements CurriculumService {

    private CurriculumDao curriculumDao;

    public SimpleCurriculumService(CurriculumDao curriculumDao) {
        this.curriculumDao = curriculumDao;
    }

    @Override
    public List<Curriculum> getCurriculumsByTopic(int topicId) throws SQLException {
        return curriculumDao.findCurriculumsByTopic(topicId);
    }

    @Override
    public Curriculum getCurriculumById(int id) throws SQLException {
        return curriculumDao.getCurriculumById(id);
    }

    @Override
    public void addCurriculum(String title, String content, int price, int topicId) throws SQLException {
        curriculumDao.addCurriculum(title, content, price, topicId);
    }
}
