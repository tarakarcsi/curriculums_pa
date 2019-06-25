package com.codecool.web.service.simple;

import com.codecool.web.dao.database.UserDao;
import com.codecool.web.model.User;
import com.codecool.web.service.LoginService;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;

public class SimpleLoginService implements LoginService {

    private UserDao userDao;

    public User loginUser(String email, String password) throws SQLException, ServiceException {
        try{
            User user = userDao.findUserByEmail(email);
            if (user == null || !user.getPassword().equals(password)){
                throw new ServiceException("Login Error");
            }
            return user;
        }catch (IllegalArgumentException e){
            throw new ServiceException(e.getMessage());
        }
    }
}
