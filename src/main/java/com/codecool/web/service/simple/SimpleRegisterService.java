package com.codecool.web.service.simple;

import com.codecool.web.dao.database.UserDao;
import com.codecool.web.model.User;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;

public class SimpleRegisterService {

    private UserDao userDao;

    public User registerUser(String email, String name, String password, boolean isAdmin) throws SQLException, ServiceException {
        try{
            User user = new User(email, name, password, isAdmin);
            userDao.addNewUser(user.getEmail(), user.getPassword(), user.isAdmin());
            if (user == null || !user.getPassword().equals(password)){
                throw new ServiceException("Login Error");
            }
            return user;
        }catch (IllegalArgumentException e){
            throw new ServiceException(e.getMessage());
        }
    }
}
