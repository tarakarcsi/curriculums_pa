package com.codecool.web.service.simple;

import com.codecool.web.dao.database.DatabaseUserDao;
import com.codecool.web.dao.database.UserDao;
import com.codecool.web.model.User;
import com.codecool.web.service.UserService;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public class SimpleUserService implements UserService {

    private UserDao userDao;

    public SimpleUserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void updateUser(User user, int credit) throws SQLException {
        userDao.updateUser(user, credit);
    }

    public List<User> getByRole(String role) throws SQLException, ServiceException {
        try {
            return userDao.findByRole(Boolean.parseBoolean(role));
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }
}
