package com.codecool.web.servlet;

import com.codecool.web.dao.database.CurriculumDao;
import com.codecool.web.dao.database.DatabaseCurriculumDao;
import com.codecool.web.dao.database.DatabaseUserDao;
import com.codecool.web.dao.database.UserDao;
import com.codecool.web.model.Curriculum;
import com.codecool.web.model.User;
import com.codecool.web.service.CurriculumService;
import com.codecool.web.service.UserService;
import com.codecool.web.service.simple.SimpleCurriculumService;
import com.codecool.web.service.simple.SimpleUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/purchase")
public class PurchaseServlet extends AbstractServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Connection connection = getConnection(req.getServletContext())) {
            UserDao userdao = new DatabaseUserDao(connection);
            UserService userService = new SimpleUserService(userdao);
            CurriculumDao curriculumDao = new DatabaseCurriculumDao(connection);
            CurriculumService curriculumService = new SimpleCurriculumService(curriculumDao);

            int id = Integer.parseInt(req.getParameter("id"));
            Curriculum curriculum = curriculumService.getCurriculumById(id);
            User user = (User) req.getSession().getAttribute("user");

            int price = curriculum.getPrice();
            int credit = user.getCredit();

            if((credit - price) >= 0) {
                userService.updateUser(user, credit-price);
                sendMessage(resp, HttpServletResponse.SC_OK, null);
            }else {
                sendMessage(resp, HttpServletResponse.SC_BAD_REQUEST, null);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
