/* file name            :- BankService.java
 * Author               :- A.A.G
 * Created/Updated Date :- 22/06/2025
 * Version              :- java 24.0.1
 * Description          :- This code is temporary file to show the behavior of the front end.
 */
package com.jdbc.main;

import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.List;
import com.jdbc.domain.Bank;
import com.jdbc.service.BankService;

public class JDBCMain {

	public static void main(String[] args) {
		// calling the service methods
		
		// comment code is for statement insert in the service file
		/*
		try {
			BankService.createBank(11, "HNB","Hatton national bank" , "A", 15000, 150);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}*/
		
		
		Bank bank = new Bank(); //create a object
		
		//use setters to put data into the object
		bank.setBankId(13);
		bank.setCode("BOC");
		bank.setName("Bank of cylone");
		bank.setStatus("A");
		bank.setTotalStaff(15000);
		bank.setTotalBranch(1500);
		//delete
		try {
			BankService.deleteBank(bank);
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		//create
		try {
			BankService.createBank(bank);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		//update
		bank.setName("hello_world");
		
		try {
			BankService.updateBank(bank);
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
		//show how the list works quick reminder.
		
		/*
		List<Bank> banklist = new ArrayList<Bank>();
		Bank b1 = new Bank();
		b1.setBankId(125);
		
		banklist.add(b1);
		for(Bank b: banklist) {
			System.out.println(b);
		}*/
		
		//select
		try {
			List<Bank> bank1 = BankService.selectALLBank();
			
			for(Bank bank_var : bank1) {
				System.out.println(bank_var);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Bank bank_var = BankService.selectIdBank(12L);
			System.out.println("-----------------------------");
			System.out.println(bank_var);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		

	}

}
