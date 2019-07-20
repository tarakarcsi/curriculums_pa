package com.codecool.web.service;

import com.codecool.web.model.Topic;

import java.sql.SQLException;
import java.util.List;

public interface TopicService {

    List<Topic> getTopics() throws SQLException;
}
