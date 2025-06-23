/* file name            :- BankService.java
 * Author               :- A.A.G
 * Created/Updated Date :- 22/06/2025
 * Version              :- java 24.0.1
 * Description          :- This code will help to build a connection with DB.
 */
package com.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConUtil {
	// Assigning the variables.
	private static final String DB = "jdbc:mysql://127.0.0.1:3306/";
	private static final String USERNAME = "";
	private static final String PASSWORD = "";
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static Connection getConnection() {
		 
		//use try catch to exception handling. 
				try {
					//validating the the class is there before connection established.
					Class.forName(DB_DRIVER);
					
				}
				catch(ClassNotFoundException e){
					//give a error if the Diver missing.
					System.out.println("Driver class is not found");
				
				}
				//defining a variable. where the data type is "Connection".
				Connection connection = null;
				//use try catch to exception handling.
				try {
					 //making a connection object by calling to DriverManager static method by passing IP,User name,Password.
					 connection = DriverManager.getConnection(DB,USERNAME,PASSWORD);
				//if the connection failed.	 
				}catch(SQLException e){
					//display this error message if the configuration fail.
					System.out.println("Check database config again! "+e.getCause()/*get the error from the object e.*/);
				}
				// check the connection object is null or not.
				if(connection != null) {
					//if the connection is not null.
					System.out.println("Connection is established successfully!");
				}else {
					System.out.println("Connection up and running.");
				}
				return connection;
					
	 }
}
