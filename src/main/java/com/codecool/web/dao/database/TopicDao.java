package com.codecool.web.dao.database;

import com.codecool.web.model.Topic;

import java.sql.SQLException;
import java.util.List;

public interface TopicDao {

    List<Topic> findTopics() throws SQLException;
}
