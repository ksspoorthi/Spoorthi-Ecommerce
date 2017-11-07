package com.niit.trendBackend.Dao;

import java.util.List;

import com.niit.trendBackend.model.Order;

public interface OrderDao {
	public boolean saveupdate(Order order);// true if succesful else false
	// s returned

public boolean delete(Order order);

public Order get(String order_Id); 

public List<Order> list(); 



}