package com.ducat.dao;

import java.util.List;
import com.ducat.modal.Order;

public interface OrderDao {

	List<Order> getAllCartProducts();
	
}
