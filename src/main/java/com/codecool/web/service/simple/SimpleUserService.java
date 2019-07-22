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
    public void updateUser(User user, int credit) throws SQLException {
        userDao.updateUser(user, credit);
    }
}
