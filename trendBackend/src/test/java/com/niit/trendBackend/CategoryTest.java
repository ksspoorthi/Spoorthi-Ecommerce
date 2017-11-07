package com.niit.trendBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.trendBackend.Dao.CategoryDao;
import com.niit.trendBackend.Dao.ProductDao;
import com.niit.trendBackend.model.Category;
import com.niit.trendBackend.model.Product;

public class CategoryTest {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		CategoryDao categoryDao = (CategoryDao) context.getBean("categoryDao");//@Component in model class creates object with class name with start letter in small 
		Category category = (Category) context.getBean("category");
		Product product = (Product) context.getBean("product");
		ProductDao productDao = (ProductDao)context.getBean("productDao");
		
       // category.setCat_id("001");
        category.setCat_name("stock2");
        category.setCat_desc("old trend");
//        save and update
        if(categoryDao.saveupdate(category)==true)
        {
        	System.out.println("saved");
        }
        else
        {
        	System.out.println("Sorry");
        }
        
        category = categoryDao.get("CAT60503");
        List<Product> P = productDao.GetProductByCategory(category.getCat_id());
        if(P == null || P.isEmpty())
        {
        	categoryDao.delete(category);
        }
        else
        {
         for(Product pr:P)
         {
        	 productDao.delete(pr);
         }
         if(categoryDao.delete(category)==true)
        	 System.out.println("category deleted");
         else
        	 System.out.println("category not deleted");
        }
        
          
       // delete
//     if(categoryDao.delete("001")==true){
//        	System.out.println("Delete successfull");
//        }
//        else{
//        	System.out.println("Sorry");
//        }
        Category c=categoryDao.get("");
        System.out.println(c.getCat_id());
        System.out.println(c.getCat_name());
        System.out.println(c.getCat_desc());
        
        List<Category> li=categoryDao.list();
        for(Category c1:li){
        	System.out.println(c1.getCat_id());
        	System.out.println(c1.getCat_name());
        	System.out.println(c1.getCat_desc());
        }
       
	}
}
