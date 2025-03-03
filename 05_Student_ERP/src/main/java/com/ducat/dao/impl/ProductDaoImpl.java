package com.ducat.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ducat.dao.ProductDao;
import com.ducat.dao.util.ConnectionProvider;
import com.ducat.modal.Product;

public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Product> getAllProducts() {

		List<Product> products = new ArrayList<>();
		try {
		Connection con=	ConnectionProvider.getMySqlConnection();
        PreparedStatement ps = con.prepareStatement("select * from products;");
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
        	Product pro = new Product();
        	pro.setId(rs.getInt(1));
        	pro.setTitle(rs.getString(2));
        	pro.setDescription(rs.getString(3));
        	pro.setPrice(rs.getDouble(4));
        	pro.setImage(rs.getString(5));
        	products.add(pro);
        }
		
        rs.close();
        ps.close();
        con.close();
        
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}
}
