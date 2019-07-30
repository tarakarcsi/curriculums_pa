package com.codecool.web.dao.database;

import com.codecool.web.model.Curriculum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseCurriculumDao extends AbstractDao implements CurriculumDao {

    public DatabaseCurriculumDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Curriculum> findCurriculumsByTopic(int topicId) throws SQLException {
        List<Curriculum> curriculumList = new ArrayList<>();
        String sql = "SELECT * FROM curriculums WHERE topicId = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, topicId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    curriculumList.add(fetchCurriculum(resultSet));
                }
                return curriculumList;
            }
        }
    }

    @Override
    public Curriculum getCurriculumById(int id) throws SQLException {
        String sql = "SELECT * FROM curriculums WHERE curriculumId = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return fetchCurriculum(resultSet);
                }
            }
            return null;
        }
    }

    public Curriculum fetchCurriculum(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("curriculumId");
        String title = resultSet.getString("title");
        String content = resultSet.getString("content");
        int price = resultSet.getInt("price");
        int topicId = resultSet.getInt("topicId");
        return new Curriculum(id, title, content, price, topicId);
    }

    @Override
    public void addCurriculum(String title, String content, int price, int topicId) throws SQLException {
        String sql = "INSERT INTO curriculums (title, content, price, topicId) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, title);
            statement.setString(2, content);
            statement.setInt(3, price);
            statement.setInt(4, topicId);
            statement.execute();
        }
    }
}
