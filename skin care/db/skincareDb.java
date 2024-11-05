/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skincare.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author mhmha
 */
public class skincareDb {
    
    // Static fields for database connection details
    static Connection con;
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost/skincare";
    static String uname = "root"; 
    static String pass = "";
    
    
    public static Connection getConnection() throws Exception {
        // If the connection is not established, create a new connection
        if (con == null) {
            // Load the JDBC driver class
            Class.forName(driver);

            // Establish a connection to the database
            con = DriverManager.getConnection(url, uname, pass);
        }
        // Return the existing or newly created connection
        return con;
    }
}
