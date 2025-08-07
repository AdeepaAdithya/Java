package com.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dto.domain.UserDto;
import com.service.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		System.out.println("POST");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username = "+username+" , password = "+password);
		UserDto customer = new UserDto();
		customer.setUserName(username);
		customer.setPasswordName(password);
		try {
			if(LoginService.userValidate(username,password)) {
				response.sendRedirect("home.html");
			}else {
				response.sendRedirect("login.html");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		PrintWriter pr = response.getWriter();
		pr.print("F Name = "+username+" , L Name = "+password);
		pr.close();
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	}

	

}
