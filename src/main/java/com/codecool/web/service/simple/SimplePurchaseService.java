package com.codecool.web.service.simple;

import com.codecool.web.dao.database.PurchaseDao;
import com.codecool.web.model.Curriculum;
import com.codecool.web.model.Purchase;
import com.codecool.web.service.PurchaseService;

import java.sql.SQLException;
import java.util.List;

public class SimplePurchaseService implements PurchaseService {

    public PurchaseDao purchaseDao;

    public SimplePurchaseService(PurchaseDao purchaseDao) {
        this.purchaseDao = purchaseDao;
    }

    @Override
    public List<Curriculum> getCurriculumsByUserId(int userId) throws SQLException {
        return purchaseDao.getCurriculumsByUserId(userId);
    }

    @Override
    public void addNewPurchase(int userId, int curriculumId) throws SQLException {
        purchaseDao.addNewPurchase(userId, curriculumId);
    }

    @Override
    public boolean checkIfPurchased(int curriculumID, int userId) throws SQLException {
        return purchaseDao.checkIfPurchased(curriculumID, userId);
    }
}
