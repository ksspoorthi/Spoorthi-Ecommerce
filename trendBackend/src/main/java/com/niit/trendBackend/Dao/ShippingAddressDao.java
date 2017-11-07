package com.niit.trendBackend.Dao;



import java.util.List;

import com.niit.trendBackend.model.ShippingAddress;



public interface ShippingAddressDao {
	public boolean saveupdate(ShippingAddress shippingAddress);// true if succesful else false
													// s returned

	public boolean delete(ShippingAddress shippingAddress);

	public ShippingAddress get(String ship_id);

	public List<ShippingAddress> list(); 
	
	public List<ShippingAddress> getaddbyuser(String user_id);
}
