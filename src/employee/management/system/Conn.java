/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

/**
 *
 * @author shahz
 */

import java.sql.*; // Import SQL package for database connection and operations

public class Conn {
    
    Connection c; // Declare Connection object
    Statement s;  // Declare Statement object

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC driver
            c = DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem", "root", "root"); // Establish connection to database
            s = c.createStatement(); // Create statement object to execute queries
        } catch (Exception e) {
            e.printStackTrace(); // Print exception details if any error occurs
        }
    }
}
