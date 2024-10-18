package com.easyrents;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DatabaseConnection implements ILoadEnv {    

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            // Log exception (consider using a logging framework)
            System.err.println("Connection failed: " + e.getMessage());
            throw new RuntimeException("Database connection error", e);
        }
    }
}