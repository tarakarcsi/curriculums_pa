package com.codecool.web.servlet;

import com.codecool.web.dao.database.DatabaseTopicDao;
import com.codecool.web.dao.database.TopicDao;
import com.codecool.web.model.Topic;
import com.codecool.web.service.TopicService;
import com.codecool.web.service.simple.SimpleTopicService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/topics")
public class TopicServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Connection connection = getConnection(req.getServletContext())) {
            TopicDao topicDao = new DatabaseTopicDao(connection);
            TopicService topicService = new SimpleTopicService(topicDao);

            List<Topic> topics = topicService.getTopics();

            sendMessage(resp, HttpServletResponse.SC_OK, topics);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
