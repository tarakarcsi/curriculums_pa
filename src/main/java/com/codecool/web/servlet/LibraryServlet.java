package com.codecool.web.servlet;

import com.codecool.web.dao.database.DatabasePurchaseDao;
import com.codecool.web.dao.database.PurchaseDao;
import com.codecool.web.model.Curriculum;
import com.codecool.web.model.Purchase;
import com.codecool.web.model.User;
import com.codecool.web.service.PurchaseService;
import com.codecool.web.service.simple.SimplePurchaseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/library")
public class LibraryServlet extends AbstractServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Connection connection = getConnection(req.getServletContext())) {
            PurchaseDao purchaseDao = new DatabasePurchaseDao(connection);
            PurchaseService purchaseService = new SimplePurchaseService(purchaseDao);

            User user = (User) req.getSession().getAttribute("user");

            List<Curriculum> curriculums = purchaseService.getCurriculumsByUserId(user.getId());

            if(curriculums != null) {
                sendMessage(resp, HttpServletResponse.SC_OK, curriculums);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
