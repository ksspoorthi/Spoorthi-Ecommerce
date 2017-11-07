package com.niit.trendBackend.Dao;

import java.util.List;

import com.niit.trendBackend.model.OrderItems;

public interface OrderItemsDao {
	public boolean saveupdate(OrderItems orderItems);// true if succesful else false
	// s returned

public boolean delete(OrderItems orderItems);

public OrderItems get(String orderItem_Id); 

public List<OrderItems> list(); 



}