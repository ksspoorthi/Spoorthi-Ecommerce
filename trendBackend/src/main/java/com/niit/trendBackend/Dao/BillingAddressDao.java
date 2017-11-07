package com.niit.trendBackend.Dao;

import java.util.List;

import com.niit.trendBackend.model.BillingAddress;





public interface BillingAddressDao {
	public boolean saveupdate(BillingAddress billingAddress);// true if succesful else false
													// s returned

	public boolean delete(BillingAddress billingAddress);

	public BillingAddress get(String bill_id); 

	public List<BillingAddress> list();
}
