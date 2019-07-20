package com.codecool.web.dao.database;

import com.codecool.web.model.Topic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTopicDao extends AbstractDao implements TopicDao{

    DatabaseTopicDao(Connection connection) {
        super(connection);
    }


    @Override
    public List<Topic> findTopics() throws SQLException {
        List<Topic> topics = new ArrayList<>();
        String sql = "SELECT * FROM topics";
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                topics.add(fetchTopic(resultSet));
            }
        }
        return topics;
    }

    public Topic fetchTopic(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("topicId");
        String title = resultSet.getString("title");

        return new Topic(id, title);
    }
}
