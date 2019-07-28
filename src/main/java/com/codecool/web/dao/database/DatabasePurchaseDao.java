package com.codecool.web.dao.database;

import com.codecool.web.model.Curriculum;
import com.codecool.web.model.Purchase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabasePurchaseDao extends AbstractDao implements PurchaseDao {

    public DatabasePurchaseDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Curriculum> getCurriculumsByUserId(int userId) throws SQLException {
        String sql = "SELECT * from curriculums INNER JOIN purchases ON curriculums.curriculumId = purchases.curriculumId WHERE userId = ?;";
        List<Curriculum> curriculums = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    curriculums.add(fetchCurriculum(resultSet));
                }
                return curriculums;
            }
        }
    }

    @Override
    public void addNewPurchase(int userId, int curriculumId) throws SQLException {
        String sql = "INSERT INTO purchases(userId, curriculumId) VALUES (?,?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, curriculumId);
            executeInsert(preparedStatement);
        }
    }

    public Purchase fetchPurchase(ResultSet resultSet) throws SQLException {
        int purchaseId = resultSet.getInt("purchaseId");
        int userId = resultSet.getInt("userId");
        int curriculumId = resultSet.getInt("curriculumId");
        return new Purchase(purchaseId, userId, curriculumId);
    }

    public Curriculum fetchCurriculum(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("curriculumId");
        String title = resultSet.getString("title");
        String content = resultSet.getString("content");
        int price = resultSet.getInt("price");
        int topicId = resultSet.getInt("topicId");
        return new Curriculum(id, title, content, price, topicId);
    }
}
