package org.example;

import org.example.db.Database;
import org.example.db.ReadSQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseInitService {
    public static void main(String[] args){
        ReadSQL fileSQL = new ReadSQL();
        String textSql = fileSQL.getSQL("init_db.sql");

        Connection connection = Database.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(textSql);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
