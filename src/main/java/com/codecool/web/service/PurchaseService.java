package com.codecool.web.service;

import com.codecool.web.model.Curriculum;
import com.codecool.web.model.Purchase;

import java.sql.SQLException;
import java.util.List;

public interface PurchaseService {
    List<Curriculum> getCurriculumsByUserId(int userId) throws SQLException;
    void addNewPurchase(int userId, int curriculumId) throws SQLException;
    boolean checkIfPurchased(int curriculumID, int userId) throws SQLException;
}
