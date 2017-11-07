package com.niit.trendBackend.Dao;

import java.util.List;

import com.niit.trendBackend.model.User;

public interface UserDao {
	public boolean saveupdate(User user);

	public boolean delete(User user);

	public User get(String uid);
	 
	public User isvalid(String email,String pwd);

	public List<User> list();
	
	public User getUseremail(String email);
}
