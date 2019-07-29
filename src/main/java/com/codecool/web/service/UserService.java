package com.codecool.web.service;

import com.codecool.web.model.User;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    void updateUser(User user, int credit) throws SQLException;
    List<User> getByRole(String role) throws SQLException, ServiceException;
}
