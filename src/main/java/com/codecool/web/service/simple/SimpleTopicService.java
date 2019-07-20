package com.codecool.web.service.simple;

import com.codecool.web.dao.database.TopicDao;
import com.codecool.web.model.Topic;
import com.codecool.web.service.TopicService;

import java.sql.SQLException;
import java.util.List;

public class SimpleTopicService implements TopicService {

    private TopicDao topicDao;

    public SimpleTopicService(TopicDao topicDao) {
        this.topicDao = topicDao;
    }

    @Override
    public List<Topic> getTopics() throws SQLException {
        return topicDao.findTopics();
    }
}
