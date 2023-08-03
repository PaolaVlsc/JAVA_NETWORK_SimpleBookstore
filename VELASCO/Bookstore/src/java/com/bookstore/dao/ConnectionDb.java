/* cs161020 - UniWa
 * Paola Velasco
 * JAVA Web Programming
 **************************************************************
 * Class for the connection of the MySQL database bookstore_db;
 **************************************************************
 */
package com.bookstore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {

    /**** Initialize all the information regarding ****/
    
    // Database Connection 
    private static String dbDriver = "com.mysql.cj.jdbc.Driver";
    private static String dbURL = "jdbc:mysql://localhost:3306/";

    // Database name to access 
    private static final String dbName = "bookstore_db";
    private static final String dbUsername = "Velasco";
    private static final String dbPassword = "cs161020";

    
    public static Connection getConnection() {

        Connection conn = null;

        try {
            
            // Load class driver in the runtime
            Class.forName(dbDriver);
            System.out.println("Loaded driver");

            // Start connection to DB
            conn = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
            System.out.println("Connected to MySQL Database");

            if (conn != null) {
                return conn;
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver class exception: " + ex);
        } catch (SQLException ex) {
            System.out.println("DB Connection exception: " + ex);
        }
        return null; // Connection failed
    }
}
