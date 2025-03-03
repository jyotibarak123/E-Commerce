package com.ducat.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.ducat.dao.StudentDao;
import com.ducat.dao.impl.StudentDaoImpl;
import com.ducat.modal.Student;

import jakarta.servlet.http.HttpSession;


@WebServlet("/LoginHandler")
public class LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
		    String email =	request.getParameter("username");
		    String password =  request.getParameter("password");
			
		    StudentDao dao = new StudentDaoImpl();
			Student studentByEmail = dao.getStudentByEmail(email);
			
			HttpSession session = request.getSession(true);  //if no session exist create them
			session.setAttribute("user", studentByEmail);
			session.setMaxInactiveInterval(5*60);
		
			 if(studentByEmail!=null) {
				 if(studentByEmail.getPassword().equals(password)) {
					 out.print("login successfully");
					 request.getRequestDispatcher("adminDashboard.jsp").forward(request, response);
				 }
				 else {
					 out.print("incorrect password");
					 request.getRequestDispatcher("login.jsp").include(request, response);
				 }
			 }
			 else {
				 out.print("email not found in database");
				 request.getRequestDispatcher("login.jsp").include(request, response);
			 }
		}
}
