package com.niit.trendBackend.Dao;

import java.util.List;


import com.niit.trendBackend.model.Product;

public interface ProductDao {

	public boolean saveupdate(Product product);// true if succesful else false
													// s returned

	public boolean delete(Product product);

	public Product get(String pid); 

	public List<Product> list(); 
	
	public List<Product> GetProductByCategory(String id);
	
	public List<Product> GetProductBySupplier(String id);
}
