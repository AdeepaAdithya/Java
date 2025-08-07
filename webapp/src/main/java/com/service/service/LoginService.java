package com.service.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.util.utility.JDBCUtil;

public class LoginService {
	
	public static boolean userValidate(String username , String password) throws SQLException {
			boolean isValidate = false;
			Connection conn = null;
			PreparedStatement preStat = null;
			
			try {
				System.out.println(username);
				System.out.println(password);
				String sql = "SELECT * FROM adeepa WHERE username = ? AND password = ?"; //SQL command
				conn = JDBCUtil.getConnection(); //making the connection
				preStat = conn.prepareStatement(sql); // using statement because there is no input for this method.
				preStat.setString(1, username);
				preStat.setString(2, password);
				
				ResultSet value = preStat.executeQuery(); // getting a result set
				
				if (value.next()) { // need a loop to go through the result set
					isValidate = true;
				}
				
				
				}catch(SQLException e){
					System.out.println(e.getMessage()); //error handling
				}finally {
					conn.close(); // close the connection 
					preStat.close(); // close the statement
				}
			return isValidate;
	}
}
