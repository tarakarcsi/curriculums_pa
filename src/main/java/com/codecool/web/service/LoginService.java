package com.codecool.web.service;

import com.codecool.web.model.Admin;
import com.codecool.web.model.User;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;

public interface LoginService {

    User loginUser(String email, String password) throws ServiceException, SQLException;
    Admin loginAdmin(String email, String password) throws ServiceException, SQLException;
}
