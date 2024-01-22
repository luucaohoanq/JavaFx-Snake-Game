package services;

import models.Account;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBServices {
    public static final String ENV_FILE_PATH = ".env";

    public static void main(String[] args) {
        // day la mot connection toi db
        // selectAll();
        // insert();
        //selectUsernameAndScore();
    }

    public static Connection getConnection() throws SQLException {
        try {
            Properties properties = loadEnv();
            String dbUrl = properties.getProperty("DB_URL");
            String dbUsername = properties.getProperty("DB_USERNAME");
            String dbPassword = properties.getProperty("DB_PASSWORD");
            return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (IOException e) {
            throw new SQLException("Error read file .env: " + e.getMessage());
        }
    }

    private static Properties loadEnv() throws IOException {
        Properties properties = new Properties();
        try (BufferedReader reader = new BufferedReader(new FileReader(ENV_FILE_PATH))) {
            properties.load(reader);
        }
        return properties;
    }

    // !my query
    public static void selectAll() {
        try {
            Connection connection = getConnection();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS");
            while (resultSet.next()) {
                System.out.println("username: " + resultSet.getString("username") + " password: "
                        + resultSet.getString("password") + " score: " + resultSet.getInt("score"));
            }
        } catch (SQLException e) {
            System.out.println("Error Select All: " + e.getMessage());
        }
    }

    public static List<String> selectUsernameAndScore(){
        List<String> resultList = new ArrayList<>();
        try {
            Connection connection = getConnection();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT username, score FROM USERS");
            while (resultSet.next()) {
                resultList.add(resultSet.getString("username") + " " + resultSet.getInt("score"));
            }
        } catch (SQLException e) {
            System.out.println("Error Select Username and Password: " + e.getMessage());
        }
        return resultList;
    }

    public static Account selectUsernameAndPasswordByUsername(String username) {
        try {
            Connection connection = getConnection();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT username, password FROM users WHERE username = '" + username + "'");
            while (resultSet.next()) {
                return new Account(resultSet.getString("username"), resultSet.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println("Error Select Username and Password: " + e.getMessage());
        }
        return null;
    }

    public static void insert() {
        try {
            Connection connection = getConnection();

            Statement statement = connection.createStatement();
            int rowsAffected = statement
                    .executeUpdate(
                            "INSERT INTO `users_schema`.`users` (`username`,`password`,`score`) VALUES ('admin', 'admin', 999)");
            if (rowsAffected > 0) {
                System.out.println("Insert success");
            } else {
                System.out.println("Insert fail");
            }
        } catch (SQLException e) {
            System.out.println("Error insert: " + e.getMessage());
        }
    }

    public static void insert(String username, String password, int score) {
        try {
            Connection connection = getConnection();

            Statement statement = connection.createStatement();
            String sql = "INSERT INTO `users_schema`.`users` (`username`,`password`,`score`) VALUES ('" + username
                    + "', '" + password + "', " + score + ")";
            int rowsAffected = statement.executeUpdate(sql);
            if (rowsAffected > 0) {
                System.out.println("Insert success");
            } else {
                System.out.println("Insert fail");
            }
        } catch (SQLException e) {
            System.out.println("Error insert: " + e.getMessage());
        }
    }

    public static void excuteOther(){
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("SET SQL_SAFE_UPDATES = 0");
        } catch (SQLException e) {
            System.out.println("Error delete: " + e.getMessage());
        }
    }
    public static void updateUsernameScore(String username, String score){
        try {
            Connection connection = getConnection();

            Statement statement = connection.createStatement();
            String sql = "UPDATE `users_schema`.`users` SET `score` = '" + score + "' WHERE (`username` = '" + username + "')";
            int rowsAffected = statement.executeUpdate(sql);
            if (rowsAffected > 0) {
                System.out.println("Update success");
            } else {
                System.out.println("Update fail");
            }
        } catch (SQLException e) {
            System.out.println("Error update: " + e.getMessage());
        }
    }

}
