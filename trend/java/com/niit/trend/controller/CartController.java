package com.niit.trend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.trendBackend.Dao.CartDao;
import com.niit.trendBackend.Dao.CartItemsDao;
import com.niit.trendBackend.Dao.ProductDao;
import com.niit.trendBackend.Dao.UserDao;

import com.niit.trendBackend.model.Cart;
import com.niit.trendBackend.model.CartItems;
import com.niit.trendBackend.model.Product;
import com.niit.trendBackend.model.User;



@Controller
@Transactional
public class CartController {
	@Autowired
	Cart cart;
	@Autowired
	CartDao cartDao;
	@Autowired
	User user;
	@Autowired
	ProductDao productDao;
	@Autowired
	CartItemsDao cartItemsDao;
	@Autowired
	Product product;
	@Autowired
	CartItems cartItems;
	@Autowired
	UserDao userDao;
	
	@Autowired
	HttpSession session;
	
	
	

	@RequestMapping("/CartForm")
	public ModelAndView cartform() {
		List<Cart> carts = cartDao.list();
		ModelAndView obj = new ModelAndView("CartForm");
		obj.addObject("cart", new Cart());
		obj.addObject("carts",carts);
		
		return obj;
	}

	@RequestMapping(value = "/addcart", method = RequestMethod.POST)
	public ModelAndView addcart(@ModelAttribute("cart") Cart cart) {
		System.out.println();
		ModelAndView obj = new ModelAndView("redirect:/CartForm");
		if (cartDao.saveupdate(cart) == true) {
			obj.addObject("mesg1", "cart added successfully");
		} else {
			obj.addObject("mesg2", "cart adding failed");
		}
		return obj;
	}
	
	@RequestMapping("/addtocart/{prod_id}")
    public ModelAndView cart(@PathVariable("prod_id") String id){
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	if(!(authentication instanceof AnonymousAuthenticationToken)){
		String currusername = authentication.getName();
		User u = userDao.getUseremail(currusername);
		if(user == null)
		{
			System.out.println("\t user Null");
			return new ModelAndView(currusername);
		}
		else
		{
			cart = u.getCart();
										
			product = productDao.get(id);
														
			CartItems cartItems = new CartItems();
																
			cartItems.setCart(cart);
														
			cartItems.setProduct(product);
														
			cartItems.setPrice(product.getProd_price());
															
			cartItemsDao.saveupdate(cartItems);
																
			cart.setGrand_total(u.getCart().getGrand_total() + productDao.get(id).getProd_price());
																
																				
			cart.setTotal_items(cart.getTotal_items() + 1);
																				
																					
			cartDao.saveupdate(cart);
																		
			session.setAttribute("items", cart.getCartitems());
																	
			session.setAttribute("total", cart.getGrand_total());
																		
			return new ModelAndView("redirect:/");
			
			
		}
	}
	else
	{
		return new ModelAndView("redirect:/");
		
	}
	}
	
	@RequestMapping("/ViewYourCart")
	public String viewcart(Model model, HttpSession session) {
		System.out.println(1223);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			User u = userDao.getUseremail(currusername);
		        Cart c=u.getCart();
		        System.out.println("\t Cart Intialized ");
				List<CartItems> cartItems = cartItemsDao.getCartItembyCartId(c.getCart_id());
//				List<CartItems> cartItems = cartItemsDao.list(c.getCart_id());
				System.out.println("List Of Cart Items Intialized");
				if(cartItems==null ||cartItems.isEmpty())
				{
					session.setAttribute("items",0);
					model.addAttribute("gtotal",0.0);
					model.addAttribute("msg", "no Items is added to cart");
					return "CartForm";		
				}
				System.out.println("\t Sending the secound viewYour Cart");
				model.addAttribute("cartItems", cartItems);
				model.addAttribute("gtotal",c.getGrand_total());
				session.setAttribute("items",c.getTotal_items());
			    session.setAttribute("cartId", c.getCart_id());
				return "CartForm";		
			
		}
		else
		{
			return "redirect:/";
		}
		
	}
    
    
  
	
	
       @RequestMapping("/deletecartItem/{cartitid}")
        public ModelAndView deletecartItem(@PathVariable("cartitid") String cartitid){
    	CartItems cartItem = cartItemsDao.get(cartitid);
    	Cart c = cartItem.getCart();
    	c.setGrand_total(c.getGrand_total() - cartItem.getPrice());
        c.setTotal_items(c.getTotal_items()-1);
        cartItemsDao.delete(cartItem);
  	    String url = "/ViewYourCart";
	    ModelAndView obj = new ModelAndView("redirect:" + url);
		return obj;
    	
    }
       
       @RequestMapping(value="/RemoveAll")
       public ModelAndView deleteAll(HttpSession session){
    	   System.out.println(11);
    	   Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
   		   if (!(authentication instanceof AnonymousAuthenticationToken)) {
   		   String currusername = authentication.getName();
   		   User u = userDao.getUseremail(currusername);
   		   Cart c=u.getCart();
    	   List<CartItems> cartItems = cartItemsDao.getCartItembyCartId(c.getCart_id());
    	   if(cartItems==null || cartItems.isEmpty())
			{
    		   String url = "/ViewYourCart";
        	   ModelAndView obj = new ModelAndView("redirect:" + url);
				return obj;
			}
    	   else
    	   {
    	   for(CartItems g:cartItems)
    	   {
    		   cartItemsDao.delete(g);
    	   }
    	   c.setGrand_total(0.0);
    	   c.setTotal_items(0);
    	   cartDao.saveupdate(c);
    	   session.setAttribute("items", c.getTotal_items());
    	   String url = "/ViewYourCart";
    	   ModelAndView obj = new ModelAndView("redirect:" + url);
    	   return obj;
    	   
       }
   		   }
   		   else
   		   {
   			String url = "/ViewYourCart";
   		    ModelAndView obj = new ModelAndView("redirect:" + url);
   			return obj;
   		   }
   			   
   		   }

}


