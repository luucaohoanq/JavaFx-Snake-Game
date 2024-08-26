package com.lcaohoanq.formhandling.services;

import com.lcaohoanq.formhandling.constants.ErrorMessages;
import com.lcaohoanq.formhandling.exceptions.DBException;
import com.lcaohoanq.formhandling.utils.EnvUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {

    public Connection getConnection() throws SQLException {
        try {
            String dbUrl = EnvUtils.get("DB_URL_DOCKER");
            String dbUsername = EnvUtils.get("MYSQL_USER");
            String dbPassword = EnvUtils.get("MYSQL_PASSWORD");
            return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (Exception e) {
            throw new DBException(ErrorMessages.ERROR_READ_FILE_ENV + e.getMessage());
        }
    }

}
