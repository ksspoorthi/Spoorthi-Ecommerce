package com.niit.trend.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.trendBackend.Dao.CategoryDao;
import com.niit.trendBackend.Dao.ProductDao;
import com.niit.trendBackend.model.Category;
import com.niit.trendBackend.model.Product;


@Controller
@Transactional
public class CategoryController {
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	ProductDao productDao;

	@RequestMapping("/CategoryForm")
	public ModelAndView categoryform() {
		List<Category> categories = categoryDao.list();
		ModelAndView obj = new ModelAndView("CategoryForm");
		obj.addObject("category", new Category());
		obj.addObject("categories",categories);
		return obj;
	}

	@RequestMapping(value = "/addcategory", method = RequestMethod.POST)
	public ModelAndView addcategory(@ModelAttribute("category") Category category) {
		System.out.println();
		ModelAndView obj = new ModelAndView("redirect:/CategoryForm");
		if (categoryDao.saveupdate(category) == true) {
			obj.addObject("mesg1", "category added successfully");
		} else {
			obj.addObject("mesg2", "category adding failed");
		}
		return obj;
	}

	@RequestMapping("/editcategory/{catid}")
	public ModelAndView editcategory(@PathVariable("catid") String catid) {
		List<Category> clist = categoryDao.list();
		category= categoryDao.get(catid);
		ModelAndView obj = new ModelAndView("CategoryForm");
		categoryDao.saveupdate(category);
		obj.addObject("category", category);
		obj.addObject("clist", clist);

		return obj;
	}

	@RequestMapping("/deletecategory/{catid}")
	public ModelAndView deletecategory(@PathVariable("catid") String catid) {
		ModelAndView obj=new ModelAndView("redirect:/CategoryForm");
		Category category = categoryDao.get(catid);
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
        	 obj.addObject("mesg1", "category deleted successfully");
         else
        	 obj.addObject("msg2","category not deleted");
        }

		
		
		return obj;
	}

}
