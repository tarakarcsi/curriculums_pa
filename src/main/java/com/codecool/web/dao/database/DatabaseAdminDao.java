package com.codecool.web.dao.database;

import com.codecool.web.model.Admin;
import com.codecool.web.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseAdminDao extends AbstractDao implements AdminDao {

    DatabaseAdminDao(Connection connection) {
        super(connection);
    }

    @Override
    public Admin findAdminByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM admins WHERE email = ?;";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return fetchAdmin(resultSet);
                }
            }
        }
        return null;
    }

    public Admin fetchAdmin(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("adminId");
        String email = resultSet.getString("email");
        String password = resultSet.getString("password");
        String name = resultSet.getString("name");
        return new Admin(id, email, name, password);
    }
}
