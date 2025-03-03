package com.ducat.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ducat.dao.OrderDao;
import com.ducat.dao.impl.OrderDaoImpl;
import com.ducat.dao.util.ConnectionProvider;
import com.ducat.modal.Order;


@WebServlet("/updateQuantity")
public class updateQuantity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
        Connection con = ConnectionProvider.getMySqlConnection();
		
        try {
		int o_id = Integer.parseInt(request.getParameter("o_id"));
		System.out.println("o_id"+o_id);
        int newQuantity = Integer.parseInt(request.getParameter("orderQuantity"));  
		
        String updateSQL = "UPDATE orders SET o_quantity = ? WHERE o_id = ?";
        PreparedStatement updateStmt = con.prepareStatement(updateSQL);
        updateStmt.setInt(1, newQuantity);  // Set the updated quantity
        updateStmt.setInt(2, o_id);
        updateStmt.executeUpdate();
        
        response.sendRedirect("creditcard.jsp");
    } catch (SQLException e) {
        e.printStackTrace();
    }

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}




















////String selectSQL = "SELECT o_quantity, p_id FROM orders WHERE o_id = ?";
////PreparedStatement selectStmt = con.prepareStatement(selectSQL);
////selectStmt.setInt(1, o_id);
////ResultSet rs = selectStmt.executeQuery();
////if (rs.next()) {
////int currentQuantity = rs.getInt("o_quantity");
////int p_id = rs.getInt("p_id");
//if("increment".equals(action) && currentQuantity==1) {
//System.out.println("id is correct");
// String updateSQL = "UPDATE orders SET o_quantity = o_quantity + 1 WHERE o_id = ?";
// PreparedStatement updateStmt = con.prepareStatement(updateSQL);
// updateStmt.setInt(1, o_id);
// updateStmt.executeUpdate();
//}
//else if ("decrement".equals(action) && currentQuantity > 1) {
//System.out.println("id is not  correct");
//String updateSQL = "UPDATE orders SET o_quantity = o_quantity - 1 WHERE o_id = ?";
//PreparedStatement updateStmt = con.prepareStatement(updateSQL);
//updateStmt.setInt(1, o_id);
//updateStmt.executeUpdate();
//}
//
//response.sendRedirect("cart.jsp");
//}
//}
//catch (SQLException e) {
//
//e.printStackTrace();
//}


//String strid = request.getParameter("id");
//String strquantity = request.getParameter("orderQuantity");
//if(strid!=null && strquantity!=null) {
//int id = Integer.parseInt(strid);
//int quantity = Integer.parseInt(strquantity);
//
//OrderDao dao = new OrderDaoImpl();
//boolean update = dao.updateQuantity(id, quantity);
//if(update) {
//	System.out.println("quantity updated successfully.....");
//   response.sendRedirect("cart.jsp");
//}
//else {
//	System.out.println("quantity is not updated......");
//}
//}
//else {
//System.out.println("strid and strquantity is null");
//}