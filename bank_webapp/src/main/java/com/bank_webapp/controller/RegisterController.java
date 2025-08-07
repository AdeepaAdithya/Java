package com.bank_webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.domain.CustomerReg;
import com.web_app.service.BankServiceReg;



@WebServlet(description = "This is used to control the register requests.", urlPatterns = { "/register2" })
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		System.out.println("F name = "+firstName+" , L Name = "+lastName);
		
		PrintWriter pr = response.getWriter();
		pr.print("F Name = "+firstName+" , L Name = "+lastName);
		pr.close();
		response.getWriter().append("Served at: ").append(request.getContextPath());	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		System.out.println("POST");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		System.out.println("F name = "+firstName+" , L Name = "+lastName);
		CustomerReg customer = new CustomerReg();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		try {
			BankServiceReg.createBank(customer);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		PrintWriter pr = response.getWriter();
		pr.print("F Name = "+firstName+" , L Name = "+lastName);
		pr.close();
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
