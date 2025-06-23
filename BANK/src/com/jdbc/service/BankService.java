/* file name            :- BankService.java
 * Author               :- A.A.G
 * Created/Updated Date :- 22/06/2025
 * Version              :- java 24.0.1
 * Description          :- This code will communicate with the DB.
 */
package com.jdbc.service;
//getting the imports
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.jdbc.domain.Bank;
import com.jdbc.util.JDBCConUtil;
/* this class is build to communicate with the DB this class will help to:
 * 			insert the values
 * 			update the values
 * 			delete the values
 * 			select the values
 */
public class BankService {
	//statements are not secure when it comes so we have to use prepared statements.
	//sample insert code with statements.
	
	/*
	public static void createBank(int bank_id,String code, String name, String status,int totall_staff,int totall_branch) throws SQLException {
		Connection conn = JDBCConUtil.getConnection();
		Statement stat = null;
		
		try {
			//creating a statement.
			stat= conn.createStatement();
			//Query
			String insertQuery = "INSERT INTO bank_tbl VALUES ("+bank_id+",'"+code+"','"+name+"','"+status+"',"+totall_staff+","+totall_branch+");";
			//insert the data to database and get the number of rows that effect.
			stat.executeUpdate(insertQuery);
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			stat.close();
			conn.close();
		}
		
	}
	*/
	
	/*This method will help to insert the values to the DB.
	 * This method will take bank object as the input and it will throw any exceptions.
	 * There is no output from this method. */
	public static void createBank(Bank bank) throws SQLException {
		Connection conn = null;// assign the object to a null value.
		PreparedStatement ps = null;// assign the prepared statement to a null value.
		try {
			String insertSql = "INSERT INTO bank_tbl(bank_id,code,name,status,totall_staff,totall_branch) VALUES (?,?,?,?,?,?);";// sql command
			conn = JDBCConUtil.getConnection();//making the connection
			ps = conn.prepareStatement(insertSql);
			ps.setLong(1, bank.getBankId());
			ps.setString(2, bank.getCode());
			ps.setString(3, bank.getName());
			ps.setString(4, bank.getStatus());
			ps.setInt(5, bank.getTotalStaff());
			ps.setInt(6, bank.getTotalBranch()); //assign values for the (?)
			int rowcount = ps.executeUpdate(); // getting the row count that is impacted.
			System.out.println("Impacted row count = "+rowcount); // print the row count
			
		}catch(SQLException e){
			System.out.println(e.getMessage()); // error handling 
		}finally {
			conn.close(); // close the connection
			ps.close(); //close the prepared statement 
		}
	}
	
	/*This method will help to update the values to the DB.
	 * This method will take bank object as the input and it will throw SQL exceptions.
	 * There is no output from this method. */
	public static void updateBank(Bank bank) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			String insertSql = "UPDATE bank_tbl SET code = ?, name = ?,status = ?, totall_staff = ?, totall_branch = ? WHERE bank_id = ?;";
			conn = JDBCConUtil.getConnection(); //making the connection 
			ps = conn.prepareStatement(insertSql);
			ps.setLong(6, bank.getBankId());
			ps.setString(1, bank.getCode());
			ps.setString(2, bank.getName());
			ps.setString(3, bank.getStatus());//assigning the values
			ps.setInt(4, bank.getTotalStaff());
			ps.setInt(5, bank.getTotalBranch());
			int rowcount = ps.executeUpdate();// getting the row count that is impacted.
			System.out.println("Impacted row count = "+rowcount);// print the row count
			
		}catch(SQLException e){
			System.out.println(e.getMessage());// error handling 
		}finally {
			conn.close(); // close the connection
			ps.close(); //close the prepared statement 
		}
	}
	
	/*This method will help to delete the values to the DB.
	 * This method will take bank object as the input and it will throw SQL exceptions.
	 * There is no output from this method. */
	public static void deleteBank(Bank bank) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			String insertSql = "DELETE FROM bank_tbl WHERE bank_id = ?;";
			conn = JDBCConUtil.getConnection(); //making the connection 
			ps = conn.prepareStatement(insertSql);
			ps.setLong(1, bank.getBankId());//assigning the values
			int rowcount = ps.executeUpdate();// getting the row count that is impacted.
			System.out.println("Impacted row count = "+rowcount);// print the row count
			
		}catch(SQLException e){
			System.out.println(e.getMessage());// error handling
		}finally {
			conn.close(); // close the connection
			ps.close(); //close the prepared statement 
		}
	}
	
	/*This method will help to select all the values in the DB.
	 * This method has no input and it will throw SQL exceptions.
	 * There is output from this method which is a object list.*/
	public static List<Bank> selectALLBank() throws SQLException {
		Connection conn = null;
		Statement statment = null;
		List<Bank> banklist = new ArrayList<Bank>(); // making a object list
		try {
			String selectSql = "SELECT * FROM bank_tbl"; //SQL command
			conn = JDBCConUtil.getConnection(); //making the connection
			statment = conn.createStatement(); // using statement because there is no input for this method.
			ResultSet value_all = statment.executeQuery(selectSql); // getting a result set
			
			while(value_all.next()) { // need to go one by one
				Bank bank = new Bank();
				bank.setBankId(value_all.getInt(1));
				bank.setCode(value_all.getString(2));
				bank.setName(value_all.getString(3));//assigning values for new object.
				bank.setStatus(value_all.getString(4));
				bank.setTotalStaff(value_all.getInt(5));
				bank.setTotalBranch(value_all.getInt(6));
				
				banklist.add(bank); //adding every object into the list.
				
			}
			
			
			
		}catch(SQLException e){
			System.out.println(e.getMessage()); //error handling
		}finally {
			conn.close(); // close the connection 
			statment.close(); // close the statement
		}
		return banklist; // return the object list
	}
	
	/*This method will help to select all the values by ID in the DB.
	 * This method has a input which is bank id and it will throw SQL exceptions.
	 * There is output from this method which is a object.*/
	public static Bank selectIdBank(Long bankId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		Bank bank = new Bank(); //create a new object
		try {
			String selectIdSql = "SELECT * FROM bank_tbl where bank_id=?;"; //SQL command
			conn = JDBCConUtil.getConnection(); // make the connection with DB
			ps = conn.prepareStatement(selectIdSql);
			ps.setLong(1, bankId); //assign the bank id to the SQL command
			ResultSet value_all = ps.executeQuery(); // execute that and get the result set
			while(value_all.next()) { // need a loop to go through the result set
				
				bank.setBankId(value_all.getLong(1));
				bank.setCode(value_all.getString(2));
				bank.setName(value_all.getString(3)); // assign values to the new object
				bank.setStatus(value_all.getString(4));
				bank.setTotalStaff(value_all.getInt(5));
				bank.setTotalBranch(value_all.getInt(6));
			}
			
		}catch(SQLException e){
			System.out.println(e.getMessage()); //error handling
		}finally {
			conn.close(); // close the connection
			ps.close(); // close prepared statement
		}
		return bank; // return the object
	}
	
	
	
	
		
}
