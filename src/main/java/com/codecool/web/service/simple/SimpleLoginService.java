package com.codecool.web.service.simple;

import com.codecool.web.dao.database.AdminDao;
import com.codecool.web.dao.database.UserDao;
import com.codecool.web.model.Admin;
import com.codecool.web.model.User;
import com.codecool.web.service.LoginService;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;

public class SimpleLoginService implements LoginService {

    private UserDao userDao;
    private AdminDao adminDao;

    public SimpleLoginService(UserDao userDao) {
        this.userDao = userDao;
    }

    public SimpleLoginService(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
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
    @Override
    public Admin loginAdmin(String email, String password) throws ServiceException, SQLException {
        try{
            Admin admin = adminDao.findAdminByEmail(email);
            if (admin == null || !admin.getPassword().equals(password)){
                throw new ServiceException("Login Error");
            }
            return admin;
        }catch (IllegalArgumentException e){
            throw new ServiceException(e.getMessage());
        }
    }
}
