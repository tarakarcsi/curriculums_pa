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
        int id = resultSet.getInt("userId");
        String email = resultSet.getString("email");
        String password = resultSet.getString("password");
        String name = resultSet.getString("name");
        int credit = resultSet.getInt("credit");
        return new User(id, email, name, password, credit);
    }

    public void addNewUser(String email, String name, String password) throws SQLException {
        String sql = "INSERT INTO users(email, name, password, role) VALUES (?,?,?,?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, password);
            executeInsert(preparedStatement);
        }
    }

    @Override
    public void updateUser(User user, int credit) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET credit = ? WHERE userId = ?")){
            preparedStatement.setInt(1,credit);
            preparedStatement.setInt(2, user.getId());
            preparedStatement.executeUpdate();
        }
    }
}
