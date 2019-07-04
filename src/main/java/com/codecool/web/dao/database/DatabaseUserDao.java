package com.codecool.web.dao.database;

import com.codecool.web.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUserDao extends AbstractDao implements UserDao {


    public DatabaseUserDao(Connection connection) {
        super(connection);
    }

    @Override
    public User findUserByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM users WHERE email = ?;";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return fetchUser(resultSet);
                }
            }
        }
        return null;
    }

    private User fetchUser(ResultSet resultSet) throws SQLException {
        String email = resultSet.getString("email");
        int credit = resultSet.getInt("credit");
        String password = resultSet.getString("password");
        boolean isAdmin = resultSet.getBoolean("isAdmin");
        return new User(email, credit, password, isAdmin);
    }

    public void addNewUser(String email, String name, String password, boolean isAdmin) throws SQLException {
        String sql = "INSERT INTO users(email, name, password, role) VALUES (?,?,?,?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, password);
            preparedStatement.setBoolean(4, isAdmin);
            executeInsert(preparedStatement);
        }
    }
}
