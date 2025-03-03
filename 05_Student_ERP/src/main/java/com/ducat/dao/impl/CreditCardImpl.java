package com.ducat.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ducat.dao.CreditCardDao;
import com.ducat.dao.util.ConnectionProvider;
import com.ducat.modal.CreditCard;

public class CreditCardImpl implements CreditCardDao {

	@Override
	public int addDetails(CreditCard creditcard) {
               int rowsaffected =0;
		try {
			Connection con = ConnectionProvider.getMySqlConnection();
			PreparedStatement ps = con.prepareStatement("insert into creditcard(name,number,month,year,cvv) values(?,?,?,?,?);");
			ps.setString(1, creditcard.getName());
			ps.setInt(2, creditcard.getNumber());
			ps.setString(3, creditcard.getMonth());
			ps.setInt(4, creditcard.getYear());
			ps.setInt(5, creditcard.getCvv());
			
			System.out.println(ps);
			rowsaffected = ps.executeUpdate();
			ps.close();
			con.close();
			
		}
		catch(Exception e) {
			System.out.println("creditcard details not added in db");
			e.printStackTrace();
		}
		return rowsaffected;
	}
}
