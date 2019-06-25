package com.codecool.web.dao.database;

import com.codecool.web.model.User;

import java.sql.SQLException;

public interface UserDao {

    User findUserByEmail(String email) throws SQLException;
}
