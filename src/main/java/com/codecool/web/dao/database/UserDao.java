package com.codecool.web.dao.database;

import com.codecool.web.model.User;

import java.sql.SQLException;

public interface UserDao {

    User findUserByEmail(String email) throws SQLException;
    void addNewUser(String email, String name, String password) throws SQLException;
}
