package com.kodilla.jdbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.OptionalInt;

@DisplayName("Tests for calling procedures from code")
public class StoredProcTests {
    @Test
    void ShouldUpdateVipLevels() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();

        Statement statement = dbManager.getConnection().createStatement();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL='Not set'";
        statement.executeUpdate(sqlUpdate);

        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL='Not set'";
        String sqlProcCall = "CALL UpdateVipLevels";
        // When
        Statement statement1 = dbManager.getConnection().createStatement();
        statement1.execute(sqlProcCall); // Can be used for stored procedures

        Statement statement2 = dbManager.getConnection().createStatement();
        ResultSet rs = statement2.executeQuery(sqlCheckTable);
        // Then
        OptionalInt howMany = rs.next() ? OptionalInt.of(rs.getInt("HOW_MANY")) : OptionalInt.empty();
        Assertions.assertTrue(howMany.isPresent() && howMany.getAsInt() == 0);

        rs.close();
        statement.close();
        statement1.close();
        statement2.close();
    }

    @Test
    void ShouldUpdateBestsellers() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();

        Statement statement = dbManager.getConnection().createStatement();
        String sqlQuery = "SELECT COUNT(*) AS HOW_MANY FROM BOOKS WHERE BESTSELLER = 1";
        ResultSet rsBefore = statement.executeQuery(sqlQuery);
        int howManyBefore = rsBefore.next() ? rsBefore.getInt("HOW_MANY") : 0;
        rsBefore.close();

        String sqlProcCall = "CALL UpdateBestsellers()";
        // When
        Statement statement1 = dbManager.getConnection().createStatement();
        statement1.execute(sqlProcCall); // Can be used for stored procedures

        ResultSet rsAfter = statement.executeQuery(sqlQuery);
        int howManyAfter = rsAfter.next() ? rsAfter.getInt("HOW_MANY") : 0;
        rsAfter.close();
        // Then
       Assertions.assertTrue(howManyAfter >= howManyBefore);

        statement.close();
        statement1.close();
    }
}
