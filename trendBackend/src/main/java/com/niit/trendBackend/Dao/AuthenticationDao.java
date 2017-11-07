package com.niit.trendBackend.Dao;

import java.util.List;

import com.niit.trendBackend.model.Authentication;



public interface AuthenticationDao {
	public boolean saveupdate(Authentication authentication);// true if succesful else false
													// s returned

	public boolean delete(Authentication authentication);

	public Authentication get(String aid); // returns a authentication given id

	public List<Authentication> list(); // returns list of categories
}
