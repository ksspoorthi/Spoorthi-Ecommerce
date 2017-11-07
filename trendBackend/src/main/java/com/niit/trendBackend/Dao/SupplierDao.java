package com.niit.trendBackend.Dao;

import java.util.List;

import com.niit.trendBackend.model.Supplier;

public interface SupplierDao {

	public boolean saveupdate(Supplier supplier);

	public boolean delete(Supplier supplier);

	public Supplier get(String sid);

	public List<Supplier> list();

}
