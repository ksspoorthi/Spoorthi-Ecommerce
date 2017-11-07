package com.niit.trend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.trendBackend.Dao.CategoryDao;
import com.niit.trendBackend.Dao.ProductDao;
import com.niit.trendBackend.model.Category;
import com.niit.trendBackend.model.Product;
import com.niit.trendBackend.model.Supplier;
import com.niit.trendBackend.model.User;

@Controller
public class HomeController {
	@Autowired
	ProductDao productDao;
	@Autowired
	CategoryDao categoryDao;

	@RequestMapping("/")
	public ModelAndView index() {

		String url = "/myhompg";
		ModelAndView obj = new ModelAndView("redirect:" + url);
		return obj;
	}

	@RequestMapping("/myhompg")
	public ModelAndView homepg() {
		List<Category> categories = categoryDao.list();
		List<Product> products = productDao.list();

		ModelAndView obj = new ModelAndView("myhompg");
		obj.addObject("categories", categories);
		obj.addObject("products", products);
		return obj;
	}

	@RequestMapping("/Thanku")
	public ModelAndView typg() {
		return new ModelAndView("Thanku");
	}
	
	@RequestMapping("/loginpage")
	public ModelAndView loginpg() {
		return new ModelAndView("loginpage");
	}

	@RequestMapping("/PaymentMode")
	public ModelAndView paymentp() {
		return new ModelAndView("PaymentMode");
	}

	@RequestMapping("/contactus")
	public ModelAndView contactus() {
		return new ModelAndView("contactus");
	}

	@RequestMapping("/aboutus")
	public ModelAndView aboutus() {
		return new ModelAndView("aboutus");
	}

	@RequestMapping("/register")
	public ModelAndView register() {
		ModelAndView obj = new ModelAndView("register");// we are adding
														// register page to
														// model and view object
		obj.addObject("user", new User());// we are adding oject of User.java to
											// model and view object...
		return obj;

	}

	@RequestMapping("/Supplier")
	public ModelAndView supplier() {
		ModelAndView obj = new ModelAndView("Supplier");// we are adding
														// register page to
														// model and view object
		obj.addObject("supplier", new Supplier());// we are adding oject of
													// Supplier.java to model
													// and view object...
		return obj;

	}

	@RequestMapping("/getproductbycategory/{catid}")
	public ModelAndView getproductbycategory(@PathVariable("catid") String catid) {
		System.out.println(143);
		ModelAndView obj = new ModelAndView("myhompg");
		List<Product> pro = productDao.GetProductByCategory(catid);
		List<Category> categories = categoryDao.list();
		obj.addObject("pro", pro);
		obj.addObject("categories",categories);
		System.out.println(143333);

		return obj;
	}

}
