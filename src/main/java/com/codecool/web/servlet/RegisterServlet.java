
package com.codecool.web.servlet;

import com.codecool.web.dao.database.DatabaseUserDao;
import com.codecool.web.dao.database.UserDao;
import com.codecool.web.model.User;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimpleRegisterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends AbstractServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            UserDao userDao = new DatabaseUserDao(connection);
            SimpleRegisterService registerService = new SimpleRegisterService(userDao);

            String email = req.getParameter("email");
            String name = req.getParameter("name");
            String password = req.getParameter("password");

            User user = registerService.registerUser(email, name, password);
            req.getSession().setAttribute("user", user);

            sendMessage(resp, HttpServletResponse.SC_OK, user);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}

