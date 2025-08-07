/* file name            :- BankService.java
 * Author               :- A.A.G
 * Created/Updated Date :- 22/06/2025
 * Version              :- java 24.0.1
 * Description          :- This code will communicate with the DB.
 */
package com.web_app.service;
//getting the imports
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.webapp.domain.CustomerReg;
import com.bank.util.JDBCConUtil;


public class BankServiceReg {

	public static void createBank(CustomerReg customer) throws SQLException {
		Connection conn = null;// assign the object to a null value.
		PreparedStatement ps = null;// assign the prepared statement to a null value.
		try {
			String insertSql = "INSERT INTO customerBank VALUES (?,?);";// sql command
			conn = JDBCConUtil.getConnection();//making the connection
			ps = conn.prepareStatement(insertSql);
			ps.setString(1, customer.getFirstName());
			ps.setString(2,customer.getLastName());
			
			int rowcount = ps.executeUpdate(); // getting the row count that is impacted.
			System.out.println("Impacted row count = "+rowcount); // print the row count
			
		}catch(SQLException e){
			System.out.println(e.getMessage()); // error handling 
		}finally {
			conn.close(); // close the connection
			ps.close(); //close the prepared statement 
		}
	}
	
}
