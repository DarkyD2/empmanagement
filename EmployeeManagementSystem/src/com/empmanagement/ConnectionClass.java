package com.empmanagement;

import java.sql.*;



public class ConnectionClass {
    Connection c;
    Statement s;
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/employeemanagement";
    String user = "root";
    String password = "admin";

    ConnectionClass() {
        try {
            // Load the JDBC driver
            Class.forName(driver);

            // Establish the database connection
            c = DriverManager.getConnection(url, user, password);

            // Create a Statement object
            s = c.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}







//public class ConnectionClass {
//	Connection c;
//	Statement s;
//	String driver = "com.mysql.jdbc.Driver";
//	String url ="jdbc:mysql://localhost:3306/employeemanagement";
//	String user="root";
//	String password="admin";
//	ConnectionClass(){
//		try {
//			Class.forName(driver);
//			c = DriverManager.getConnection(url,user,password);
//			s = c.createStatement();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//}

//Steps in setting a jdbc connection
//1.Register a driver class
//2.Creating a connection string
//3.Creating a statement
//4.Executing mysql queries
//5.Closing the connections