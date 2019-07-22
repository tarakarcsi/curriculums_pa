package com.codecool.web.dao.database;

import com.codecool.web.model.Curriculum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseCurriculumDao extends AbstractDao implements CurriculumDao{

    public DatabaseCurriculumDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Curriculum> findCurriculumsByTopic(int topicId) throws SQLException {
        List<Curriculum> curriculumList = new ArrayList<>();
        String sql = "SELECT * FROM curriculums WHERE topicId = ?;";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, topicId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    curriculumList.add(fetchCurriculum(resultSet));
                }
                return curriculumList;
            }
        }
    }

    public Curriculum fetchCurriculum(ResultSet resultSet) throws SQLException {
        String title = resultSet.getString("title");
        String content = resultSet.getString("content");
        int price = resultSet.getInt("price");
        int topicId = resultSet.getInt("topicId");
        return new Curriculum(title, content, price, topicId);
    }
}
