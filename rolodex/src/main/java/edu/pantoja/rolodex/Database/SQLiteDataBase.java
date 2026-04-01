/***********************
 * Name: Geovanny Pantoja
 * Date 31 March 2026
 * Description: Set up connection to database
 */
package edu.pantoja.rolodex.Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDataBase {

   public static Connection connect(String database) {
        String url = "jdbc:sqlite:" + database;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

}
