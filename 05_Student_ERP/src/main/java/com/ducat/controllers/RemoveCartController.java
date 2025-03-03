package com.ducat.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import com.ducat.modal.Order;


@WebServlet("/RemoveController")
public class RemoveCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		String id =request.getParameter("id");
		
		if(id!=null) {
		   ArrayList<Order> cartlist = (ArrayList<Order>) request.getSession().getAttribute("cart");
			if(cartlist!=null) {
				for(Order c:cartlist) {
					if(c.getP_id()==Integer.parseInt(id)) {
						cartlist.remove(cartlist.indexOf(c));
						break;
					}
				}
				request.getRequestDispatcher("cart.jsp").forward(request, response);
			}
			else {
				System.out.println("cartlist is null");
			}
		}
		else {
			System.out.println("id is null");
		}
	}
			
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
