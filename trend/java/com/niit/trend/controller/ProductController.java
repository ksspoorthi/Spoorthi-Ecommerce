package com.niit.trend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.trendBackend.Dao.CategoryDao;
import com.niit.trendBackend.Dao.ProductDao;
import com.niit.trendBackend.Dao.SupplierDao;
import com.niit.trendBackend.model.Category;
import com.niit.trendBackend.model.Product;
import com.niit.trendBackend.model.Supplier;

import Fileinput.FileInput;

@Controller
@Transactional
public class ProductController{
	@Autowired 
	Product product;
	@Autowired
	ProductDao productDao;
	@Autowired
	SupplierDao supplierDao;
	@Autowired
	CategoryDao categoryDao;
	
	String path="C:\\Users\\SPOORTHI\\workspace\\trend\\src\\main\\webapp\\resources\\images\\";
	 
	@RequestMapping("/ProductForm")
	public ModelAndView productform(){
		List<Product> products = productDao.list();
		List<Supplier> suppliers = supplierDao.list();
		List<Category> categories = categoryDao.list();
		
		
		ModelAndView obj = new ModelAndView("ProductForm");
		obj.addObject("product",new Product());
		obj.addObject("products", products);
		obj.addObject("suppliers",suppliers);
		obj.addObject("categories",categories);
		
		
		return obj;
	}
	
	@RequestMapping(value="/addproduct", method = RequestMethod.POST)
	public ModelAndView addproduct(@ModelAttribute("product") Product product){
		ModelAndView obj = new ModelAndView("redirect:/ProductForm");
		if(productDao.saveupdate(product)==true){
			FileInput.upload(path,product.getProd_image(),product.getProd_id()+".jpg");
			obj.addObject("msg1","product added succesfully");
			
		}
		else
			obj.addObject("msg2","product adding failed");
		return obj;
	}
	
	@RequestMapping("/editproduct/{prodid}")
	public ModelAndView editproduct(@PathVariable("prodid") String prodid) {
		List<Product> plist = productDao.list();
		List<Supplier> suppliers = supplierDao.list();
		List<Category> categories = categoryDao.list();
		product= productDao.get(prodid);
		ModelAndView obj = new ModelAndView("ProductForm");
		productDao.saveupdate(product);
		obj.addObject("product", product);
		obj.addObject("plist", plist);
		obj.addObject("suppliers",suppliers);
		obj.addObject("categories",categories);

		return obj;
	}

	@RequestMapping("/deleteproduct/{prodid}")
	public ModelAndView deleteproduct(@PathVariable("prodid") String prodid) {
		Product pro = productDao.get(prodid);
		productDao.delete(pro);
		String url = "/ProductForm";
		ModelAndView obj = new ModelAndView("redirect:" + url);
		return obj;
	}
	
	
		
	}
	
