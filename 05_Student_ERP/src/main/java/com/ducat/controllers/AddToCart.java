package com.ducat.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import com.ducat.dao.OrderDao;
import com.ducat.dao.impl.OrderDaoImpl;
import com.ducat.dao.util.ConnectionProvider;
import com.ducat.modal.Order;
import com.ducat.modal.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		try {
		int p_id = Integer.parseInt(request.getParameter("id"));
	    HttpSession session = request.getSession(false);
	    Student stu = (Student) session.getAttribute("user");
	    int u_id= 0;
	    if(stu!=null) {		   
	    	 u_id = stu.getId();
	    }
	    
	    Connection con= ConnectionProvider.getMySqlConnection();
		PreparedStatement ps = con.prepareStatement("insert into orders (p_id,u_id,o_quantity,o_date) values(?,?,1,?);");
		ps.setInt(1, p_id);
		ps.setInt(2, u_id);
		ps.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
	    ps.executeUpdate();
	    System.out.println(ps);
		
		ps.close();
		con.close();
		response.sendRedirect("CartController?id="+p_id);
	}	catch(Exception e) {
		e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
