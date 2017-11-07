package com.niit.trendBackend.Dao;

import java.util.List;

import com.niit.trendBackend.model.Category;

public interface CategoryDao {
	public boolean saveupdate(Category category);// true if succesful else false
													// s returned

	public boolean delete(Category category);

	public Category get(String cid); // returns a category given id

	public List<Category> list(); // returns list of categories
}
