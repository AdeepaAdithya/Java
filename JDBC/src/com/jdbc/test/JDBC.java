/*content:- this document is to show the connection between the database.
 *author:-AAG
 *date:- 08/06/2025
 *purpose:- practice JDBC
 *file_name:- JDBC.java */

//import the necessary libraries.
package com.jdbc.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
// crating a class called JDBC
public class JDBC {
	//main method. used to build the connection.
	public static void main(String[] args) {
		//use try catch to exception handling. 
		try {
			//validating the the class is there before connection established.
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}
		catch(ClassNotFoundException e){
			//give a error if the Diver missing.
			System.out.println("Driver class is not found");
			return;
		}
		//defining a variable. where the data type is "Connection".
		Connection connection;
		//use try catch to exception handling.
		try {
			 //making a connection object by calling to DriverManager static method by passing IP,User name,Password.
			 connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aag","AAG","AAG");
		//if the connection failed.	 
		}catch(SQLException e){
			//display this error message if the configuration fail.
			System.out.println("Check database config again! "+e.getCause()/*get the error from the object e.*/);
			return;
		}
		// check the connection object is null or not.
		if(connection != null) {
			//if the connection is not null.
			System.out.println("Connection is established successfully!");
			
			//insert operation -SQL
			// try and catch used for the error handling part.
			try {
				
				 
				//single record insert.
				
				//creating a statement.
				Statement stat = connection.createStatement();
				//Query
				String insertQuery = "INSERT INTO bank_tbl VALUES (2,'HNB','Hatton National Bank','A',3400,345);";
				//insert the data to database and get the number of rows that effect.
				int value = stat.executeUpdate(insertQuery);
				System.out.println(value);
				
				
				
				// insert multiple records. - using a for loop.
				Statement stat2 = connection.createStatement();
				for(int i=3;i<11;i++) {
					String status = "A";
					int staff = 2000;
					int branch = 200;
					if(i%3==0) {
						status = "I";
						staff = 300*i;
						branch = 200+10*i;
					}
					String insertQuery2 = "INSERT INTO bank_tbl VALUES ("+i+",'C"+i+"','Bank"+i+"','"+status+"',"+staff+","+branch+");";
					int value2 = stat2.executeUpdate(insertQuery2);
					System.out.println(value2);
					
				}
				
				//update the table- SQL
				Statement stat3 = connection.createStatement();
				String Q = "UPDATE bank_tbl SET totall_staff = 1 WHERE status = 'I'";
				int value3 = stat3.executeUpdate(Q);
				System.out.println(value3);
				
				// delete the table - SQL
				Statement stat4 = connection.createStatement();
				String Q1 = "DELETE FROM bank_tbl where status = 'I'"; 
				int value4 = stat4.executeUpdate(Q1);
				System.out.println(value4);
				
				//select all from the table - SQL
				Statement stat5 = connection.createStatement();
				String Q2 = "SELECT * FROM bank_tbl;"; 
				ResultSet value5 = stat5.executeQuery(Q2);//getting data as a bulk.
				// getting a set of results so need to use a loop and get the values to print.
				while(value5.next()) {
					System.out.println(value5.getInt("bank_id")+","+value5.getString("code")+","+value5.getString("name")+","+value5.getString("status")+","+value5.getInt("totall_staff")+","+value5.getInt("totall_branch"));
				}
				
				//select two columns from the table - SQL
				Statement stat6 = connection.createStatement();
				String Q3 = "SELECT code,name FROM bank_tbl;"; 
				ResultSet value6 = stat6.executeQuery(Q3);//getting data as a bulk.
				// getting a set of results so need to use a loop and get the values to print.
				while(value6.next()) {
					System.out.println(value6.getString(1)+" "+value6.getString(2));
				}
				//getting a value from only the specific column and then get the value and print it.
				Statement stat7 = connection.createStatement();
				String Q4 = "SELECT code,name FROM bank_tbl WHERE status = 'A';";
				ResultSet value7 = stat7.executeQuery(Q4); // getting data as a bulk
				//use a loop to get the values one by one.
				while(value7.next()) {
					//print the values
					System.out.println(value7.getString(1)+""+value7.getString(2));
				}
				
			} catch (SQLException e) {
				System.out.println("Statement creation "+e.getCause()+" "+ e.getMessage());//getting the error messages.
			}
		}
		else {
			//display if the connection is null.
			System.out.println("Connection failed.");
		}
		

	}

}