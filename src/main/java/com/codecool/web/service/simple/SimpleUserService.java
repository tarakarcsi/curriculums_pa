package com.codecool.web.service.simple;

import com.codecool.web.dao.database.DatabaseUserDao;
import com.codecool.web.dao.database.UserDao;
import com.codecool.web.model.User;
import com.codecool.web.service.UserService;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;

public class SimpleUserService implements UserService {

    private DatabaseUserDao userDao;

    public SimpleUserService(UserDao userDao) {
    }

    @Override
    public User findUserByEmail(String email, String password) throws SQLException, ServiceException {
        try {
            User user = userDao.findUserByEmail(email);
            if (user == null || !user.getPassword().equals(password)) {
                throw new ServiceException("Login Error");
            }
            return user;
        } catch (IllegalArgumentException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
