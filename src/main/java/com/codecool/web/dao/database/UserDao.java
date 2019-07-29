package com.codecool.web.dao.database;

import com.codecool.web.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    User findUserByEmail(String email) throws SQLException;
    void addNewUser(String email, String name, String password) throws SQLException;
    void updateUser(User user, int credit) throws SQLException;
    List<User> findByRole(boolean role) throws SQLException;
}
