package com.niit.trendBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.trendBackend.Dao.ProductDao;
import com.niit.trendBackend.Dao.SupplierDao;
import com.niit.trendBackend.model.Category;
import com.niit.trendBackend.model.Product;
import com.niit.trendBackend.model.Supplier;

public class SupplierTest {
	public static void main(String args[]){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		SupplierDao supplierDao = (SupplierDao)context.getBean("supplierDao");
		Supplier supplier = (Supplier)context.getBean("supplier");
		Product product = (Product) context.getBean("product");
		ProductDao productDao = (ProductDao)context.getBean("productDao");	
	
		supplier.setSup_name("Mack");
		supplier.setSup_address("1st cros,blore");
		supplier.setSup_phno("33334444");
		supplier.setSup_sid("200");
		if(supplierDao.saveupdate(supplier)==true){
			System.out.println("supplier details saved");
		}
	else
		System.out.println("sorry");
		
		supplier = supplierDao.get("200");
        List<Product> P = productDao.GetProductBySupplier(supplier.getSup_sid());
//        if(P==null || P.isEmpty())
//        {
//        	supplierDao.delete(supplier);
//        }
//        else
//        {
//         for(Product pr:P)
//         {
//        	 productDao.delete(pr);
//         }
//         if(supplierDao.delete(supplier)==true)
//        	 System.out.println("supplier deleted");
//         else
//        	 System.out.println("supplier not deleted");
//        }
        
        
//		if(supplierDao.delete("200")==true){
//			System.out.println("delete success");
//		}
//		else
//	    System.out.println("sorry");
		Supplier s=supplierDao.get("200");
		System.out.println(s.getSup_sid());
		System.out.println(s.getSup_phno());
		System.out.println(s.getSup_name());
		System.out.println(s.getSup_address());	
		
		List<Supplier> li= supplierDao.list();
        for(Supplier c1:li){
        	System.out.println(c1.getSup_sid());
        	System.out.println(c1.getSup_name());
        	System.out.println(c1.getSup_phno());
        	System.out.println(c1.getSup_address());
        	
				}

}
}
