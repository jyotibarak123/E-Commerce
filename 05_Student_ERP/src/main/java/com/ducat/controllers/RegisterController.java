package com.ducat.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import com.ducat.dao.StudentDao;
import com.ducat.dao.impl.StudentDaoImpl;
import com.ducat.modal.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
//		Student student = new Student();
//		
//		student.setName(request.getParameter("fname"));
//		student.setMobileNo(Long.parseLong(request.getParameter("mobileNo")));
//		student.setGender(request.getParameter("gender").charAt(0));
//		student.setMember(Boolean.parseBoolean(request.getParameter("isMember")));
//		student.setFee(Double.parseDouble(request.getParameter("fee")));
//		student.setJoinedAt(LocalDate.parse(request.getParameter("joinedAt")));
//		student.setEmail(request.getParameter("email"));
//		student.setPassword(request.getParameter("pass"));
//		
//	
//	int k=	new StudentDaoImpl().registerStudent(student);
//		if(k>0)
//		{
//			out.print("added successfully");
//		}
//		else {
//			out.print("not added");
//		}
		 
//		or : 
		
		String fname = request.getParameter("fname").trim();
		Long mobileNo = Long.parseLong(request.getParameter("mobileNo").trim());
		char gender = request.getParameter("gender").trim().charAt(0);
		boolean isMember = false;
		if(request.getParameter("isMember")!=null) {
			isMember = request.getParameter("isMember").trim().equals("yes");            
		}     
		double fee = Double.parseDouble(request.getParameter("fee").trim());
		LocalDate JoinedAt = LocalDate.parse(request.getParameter("joinedAt").trim());
		String email = request.getParameter("email").trim();
		String password = request.getParameter("pass").trim();
		
		Student stu = new Student(0, fname, mobileNo, gender, isMember, fee, JoinedAt, email, password);
		StudentDao dao = new StudentDaoImpl();
		int status = dao.registerStudent(stu);
		
		if(status>0) {
			response.getWriter().append("Student registered successfully");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else {
			response.getWriter().append("unable to register student ! ");

		}	
	}
}
