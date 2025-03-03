package com.ducat.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.ducat.dao.OrderDao;
import com.ducat.dao.util.ConnectionProvider;
import com.ducat.modal.Order;

public class OrderDaoImpl implements OrderDao{

	@Override
	public List<Order> getAllCartProducts() {
		
			List<Order> list = new ArrayList<Order>();
			try {
				Connection con = ConnectionProvider.getMySqlConnection();
				PreparedStatement ps = con.prepareStatement("select p.id,p.title,p.description,p.price,o.o_id,o.u_id,o.o_quantity,o.o_date from products p left join orders o on p.id=o.p_id;");
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					Order pro = new Order();
					pro.setP_id(rs.getInt(1));
					pro.setTitle(rs.getString(2));
					pro.setDescription(rs.getString(3));
					pro.setPrice(rs.getDouble(4));
					pro.setO_id(rs.getInt(5));
					pro.setU_id(rs.getInt(6));
				    pro.setO_quantity(rs.getInt(7));
				    pro.setO_date(rs.getDate(8) != null ? rs.getDate(8).toLocalDate() : java.time.LocalDate.now());

					list.add(pro);
				 }
					
				rs.close();
				ps.close();
				con.close();

	          }catch (Exception e) {
				System.out.println("not added in add to cart");
				e.printStackTrace();
	        }		
			return list;
		}
	}
	
