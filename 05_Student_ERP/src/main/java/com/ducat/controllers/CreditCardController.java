package com.ducat.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import com.ducat.dao.CreditCardDao;
import com.ducat.dao.impl.CreditCardImpl;
import com.ducat.modal.CreditCard;


@WebServlet("/CreditCardController")
public class CreditCardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("fname");
		int number = Integer.parseInt(request.getParameter("num"));
		String month = request.getParameter("month");
		int year =Integer.parseInt(request.getParameter("year"));
		int cvv =Integer.parseInt(request.getParameter("cvv"));

		CreditCard cc = new CreditCard(name, number, month, year, cvv);
		CreditCardDao dao = new CreditCardImpl();
        int k = dao.addDetails(cc);		
        if(k>0) {
        	System.out.println("creditcard details added successfully");
            out.println("""
				    <div class="alert alert-danger d-flex p-1" style="font-size: 18px; line-height: 1; height:50px; width:600px;">
					<svg class="bi flex-shrink-0 me-2" role="img" aria-label="danger:"><use xlink:href="#check-circle-fill"/></svg>
					<div>
						Order placed successfully !......
				    </div>
				    </div>
        		   """);
        	request.getRequestDispatcher("index.jsp").include(request, response);        }
        else {
        	System.out.println("creditcard details not added");
        	request.getRequestDispatcher("cart.jsp").include(request, response);
        }
	}
}
