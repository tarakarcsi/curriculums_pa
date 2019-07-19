package com.codecool.web.service.simple;

import com.codecool.web.dao.database.UserDao;
import com.codecool.web.model.User;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;

public class SimpleRegisterService {

    private UserDao userDao;

    public SimpleRegisterService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User registerUser(String email, String name, String password) throws SQLException, ServiceException {
        try{
            User user = new User(email, name, password);
            userDao.addNewUser(user.getEmail(), user.getName(), user.getPassword());
            if (user == null || !user.getPassword().equals(password)){
                throw new ServiceException("Login Error");
            }
            return user;
        }catch (IllegalArgumentException e){
            throw new ServiceException(e.getMessage());
        }
    }
}
