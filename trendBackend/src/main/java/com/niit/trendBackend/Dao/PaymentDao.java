package com.niit.trendBackend.Dao;

import java.util.List;

import com.niit.trendBackend.model.Category;
import com.niit.trendBackend.model.Payment;

public interface PaymentDao {
	public boolean saveupdate(Payment payment);// true if succesful else false
													// s returned

	public boolean delete(String pid);

	public Payment get(String pid); // returns a category given id

	public List<Payment> list(); // returns list of categories
}
