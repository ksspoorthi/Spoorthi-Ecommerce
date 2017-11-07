package com.niit.trendBackend.Dao;

import java.util.List;

import com.niit.trendBackend.model.Cart;

public interface CartDao {
	public boolean saveupdate(Cart cart);// true if succesful else false
													// s returned

	public boolean delete(Cart cart);

	public Cart get(String cartid); // returns a category given id

	public List<Cart> list(); // returns list of categories
}
