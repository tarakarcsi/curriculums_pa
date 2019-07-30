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
import java.util.List;

@WebServlet("/curriculums")
public class CurriculumServlet extends AbstractServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try(Connection connection = getConnection(req.getServletContext())) {
            CurriculumDao curriculumDao = new DatabaseCurriculumDao(connection);
            CurriculumService curriculumService = new SimpleCurriculumService(curriculumDao);

            int topicId = Integer.parseInt(req.getParameter("topicId"));

            List<Curriculum> curriculumList = curriculumService.getCurriculumsByTopic(topicId);

            if(req.getParameter("title") != null) {

                String cTitle = req.getParameter("title");
                String cUrl = req.getParameter("url");
                int cPrice = Integer.parseInt(req.getParameter("price"));
                int cTopicId = Integer.parseInt(req.getParameter("topicId"));

                curriculumService.addCurriculum(cTitle, cUrl, cPrice, cTopicId);
            }

            sendMessage(resp, HttpServletResponse.SC_OK, curriculumList);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
