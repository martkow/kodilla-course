package com.kodilla.jdbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@DisplayName("Tests for DbManager enum responsible for connection with DB")
public class DbManagerTests {
    @DisplayName("Test case for connection with MySql DB")
    @Test
    void testCaseForConnection() throws SQLException {
        // Given
        // When
        DbManager dbManager = DbManager.getInstance();
        // Then
        Assertions.assertNotNull(dbManager);
    }

    @DisplayName("Test case for SQL query: retrieving data from USERS table")
    @Test
    void testCaseForQueryUsers() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();
        // When
        String sqlQuery = "SELECT * FROM USERS;";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        // Then
        int counter = 0;
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("ID") + ", " +
                    resultSet.getString("FIRSTNAME") + ", " +
                    resultSet.getString("LASTNAME"));
            counter++;
        }
        resultSet.close();
        statement.close();
        Assertions.assertEquals(5, counter);
    }

    @DisplayName("Test case for SQL query: retrieving data from USERS and ISSUES tables")
    @Test
    void testCaseForQueryUsersAndIssues() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();
        // When
        String sqlQuery = """
                SELECT U.FIRSTNAME, U.LASTNAME, I.SUMMARY 
                FROM USERS U JOIN ISSUES I ON U.ID = I.USER_ID_ASSIGNEDTO;
                """;
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        // Then
        int counter = 0;
        while (resultSet.next()) {
            System.out.println(resultSet.getString("FIRSTNAME") + ", " +
                    resultSet.getString("LASTNAME") + ", " +
                    resultSet.getString("SUMMARY"));
            counter++;
        }
        resultSet.close();
        statement.close();
        Assertions.assertEquals(13, counter);
    }

    @DisplayName("Test tace for SQL query: retrieving data for USERS and POSTS tables")
    @Test
    void testCaseForQueryUsersAndPosts() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();
        // When
        Statement statement = dbManager.getConnection().createStatement();
        String sqlQuery = """
        SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS POSTS_NUMBER 
        FROM USERS U JOIN POSTS P ON U.ID = P.USER_ID
        GROUP BY U.ID
        HAVING POSTS_NUMBER >= 2;
        """;
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        // Then
        int counter = 0;
        while (resultSet.next()) {
            System.out.println(resultSet.getString("FIRSTNAME") + ", " +
                    resultSet.getString("LASTNAME") + ", " +
                    resultSet.getInt("POSTS_NUMBER"));
            counter++;
        }
        resultSet.close();
        statement.close();
        Assertions.assertEquals(1, counter);
    }
}
