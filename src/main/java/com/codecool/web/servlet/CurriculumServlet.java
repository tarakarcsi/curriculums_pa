package com.codecool.web.servlet;

import com.codecool.web.dao.database.CurriculumDao;
import com.codecool.web.dao.database.DatabaseCurriculumDao;
import com.codecool.web.model.Curriculum;
import com.codecool.web.service.CurriculumService;
import com.codecool.web.service.simple.SimpleCurriculumService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CurriculumServlet extends AbstractServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try(Connection connection = getConnection(req.getServletContext())) {
            CurriculumDao curriculumDao = new DatabaseCurriculumDao(connection);
            CurriculumService curriculumService = new SimpleCurriculumService(curriculumDao);

            int topicId = Integer.parseInt(req.getParameter("topicId"));

            List<Curriculum> curriculumList = curriculumService.getCurriculumsByTopic(topicId);

            sendMessage(resp, HttpServletResponse.SC_OK, curriculumList);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
