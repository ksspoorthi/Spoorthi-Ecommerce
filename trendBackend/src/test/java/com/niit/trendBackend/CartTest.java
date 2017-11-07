package com.niit.trendBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.trendBackend.Dao.CartDao;
import com.niit.trendBackend.Dao.CartItemsDao;
import com.niit.trendBackend.Dao.ProductDao;
import com.niit.trendBackend.Dao.UserDao;
import com.niit.trendBackend.model.Cart;
import com.niit.trendBackend.model.CartItems;
import com.niit.trendBackend.model.Product;
import com.niit.trendBackend.model.User;


public class CartTest {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		CartDao cartDao = (CartDao) context.getBean("cartDao");
		Cart cart= (Cart) context.getBean("cart");
		Product product =(Product) context.getBean("product");
		ProductDao productDao = (ProductDao) context.getBean("productDao");
		User user = (User) context.getBean("user");
		UserDao userDao = (UserDao) context.getBean("userDao");
		CartItemsDao cartItemsDao = (CartItemsDao) context.getBean("cartItemsDao");
		CartItems cartItems= (CartItems) context.getBean("cartItems");
		
        
        cart.setGrand_total(0.0);
        cart.setTotal_items(0);
//        save and update
        if(cartDao.saveupdate(cart)==true)
        {
        	System.out.println("saved");
        }
        else
        	System.out.println("Sorry");
        
        
          user = userDao.get("USEREB9003");
          cart = user.getCart();
          if(cart.getCart_id()==null)
          {
        	  System.out.println("no data existing");
          }
          else
          {
        	  System.out.println("data existing with id "+cart.getCart_id());
          }
          
          product = productDao.get("PROD19B37");
          cartItems.setCart(cart);
          cartItems.setProduct(product);
          cartItems.setPrice(product.getProd_price());
         // cartItemsDao.saveupdate(cartItems);
          
          cart.setTotal_items(cart.getTotal_items()+1);
          cart.setGrand_total(cart.getGrand_total()+product.getProd_price());
          cartDao.saveupdate(cart);
          
        
       // delete
          cart= cartDao.get("CART4BE35");
     if(cartDao.delete(cart)==true){
        	System.out.println("Delete successfull");
        }
        else{
        	System.out.println("Sorry");
        }
        Cart c=cartDao.get("CART7FE6C");
        System.out.println(c.getCart_id());
        System.out.println(c.getGrand_total());
        System.out.println(c.getTotal_items());
        
        List<Cart> li=cartDao.list();
        for(Cart c1:li){
        	System.out.println(c1.getCart_id());
        	System.out.println(c1.getGrand_total());
        	System.out.println(c1.getTotal_items());
        }
       
	}
}
