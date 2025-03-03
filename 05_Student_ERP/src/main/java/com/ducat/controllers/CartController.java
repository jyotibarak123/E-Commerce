package com.ducat.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ducat.dao.OrderDao;
import com.ducat.dao.impl.OrderDaoImpl;
import com.ducat.modal.Order;
import com.ducat.modal.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter print = response.getWriter();
		
		
		
	   OrderDao dao = new OrderDaoImpl();
		
	   int id = Integer.parseInt(request.getParameter("id"));
	   
	   HttpSession session = request.getSession(false);
	   ArrayList<Order> cart = null;
	   
	   if(session.getAttribute("cart")==null) {
		   cart = new ArrayList<>();
		   
	   }
	   else {
		   cart=(ArrayList<Order>)session.getAttribute("cart");
	   }
	   List<Order> cartProducts = dao.getAllCartProducts();

	   for(Order c : cartProducts) {
		   if(c.getP_id()==id) {
		    c.setO_quantity(c.getO_quantity());
			cart.add(c);
			break;
		   }
	   }
			   session.setAttribute("cart", cart);
			   System.out.println("cart product is sent");
			   request.getRequestDispatcher("cart.jsp").forward(request, response);
		   }
	   }


	
