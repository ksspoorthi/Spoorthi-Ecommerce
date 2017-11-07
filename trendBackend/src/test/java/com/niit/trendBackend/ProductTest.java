package com.niit.trendBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.trendBackend.Dao.CategoryDao;
import com.niit.trendBackend.Dao.ProductDao;
import com.niit.trendBackend.Dao.SupplierDao;
import com.niit.trendBackend.model.Category;
import com.niit.trendBackend.model.Product;
import com.niit.trendBackend.model.Supplier;

public class ProductTest {
	public static void main(String args[]) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		ProductDao productDao = (ProductDao) context.getBean("productDao");
		Product product = (Product) context.getBean("product");
		
		SupplierDao supplierDao = (SupplierDao) context.getBean("supplierDao");
		Supplier supplier = (Supplier)context.getBean("supplier");
		
		CategoryDao categoryDao = (CategoryDao)context.getBean("categoryDao");
		Category category = (Category)context.getBean("category");
		
        category=categoryDao.get("CATEB097");
        product.setCategory(category);
        
        supplier=supplierDao.get("200");
        product.setSupplier(supplier);
        
        
		//product.setProd_id("010");
		product.setProd_name("west");
		product.setProd_qty("4");
		product.setProd_price(5000);
		product.setProd_desc("redoran");
		if (productDao.saveupdate(product) == true)
			System.out.println("saved");
		else
			System.out.println("sorry");
//		if (productDao.delete("01") == true)
//			System.out.println("delete successfull");
//		else
//			System.out.println("sorry");

//		
		Product p =productDao.get("");
		 
		if(p==null)
		{
			System.out.println("product not found");
			
		}
		else
		{
		System.out.println(p.getProd_id());
		System.out.println(p.getProd_name());
		System.out.println(p.getProd_qty());
		System.out.println(p.getProd_price());
		System.out.println(p.getProd_desc());
		System.out.println(p.getProd_image());
		
	}
}
}
