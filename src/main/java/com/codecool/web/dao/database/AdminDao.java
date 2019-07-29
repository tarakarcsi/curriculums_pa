package com.codecool.web.dao.database;

import com.codecool.web.model.Admin;

import java.sql.SQLException;

public interface AdminDao {
    Admin findAdminByEmail(String email) throws SQLException;
}
