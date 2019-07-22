package com.codecool.web.dao.database;

import com.codecool.web.model.Curriculum;

import java.sql.SQLException;
import java.util.List;

public interface CurriculumDao {

    List<Curriculum> findCurriculumsByTopic(int topicId) throws SQLException;

}
