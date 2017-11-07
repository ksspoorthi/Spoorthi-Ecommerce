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

import com.niit.trendBackend.Dao.ProductDao;
import com.niit.trendBackend.Dao.SupplierDao;
import com.niit.trendBackend.model.Product;
import com.niit.trendBackend.model.Supplier;

@Controller
@Transactional
public class SupplierController {
	@Autowired
	Supplier supplier;
	@Autowired
	SupplierDao supplierDao;
	@Autowired
	ProductDao productDao;

	@RequestMapping("/SupplierForm")
	public ModelAndView supplierform() {
		List<Supplier> suppliers = supplierDao.list();
		ModelAndView obj = new ModelAndView("SupplierForm");
		obj.addObject("supplier", new Supplier());
		obj.addObject("suppliers", suppliers);
		return obj;
	}

	@RequestMapping(value = "/addsupplier", method = RequestMethod.POST)
	public ModelAndView addsupplier(@ModelAttribute("supplier") Supplier supplier) {
		System.out.println();
		ModelAndView obj = new ModelAndView("redirect:/SupplierForm");
		if (supplierDao.saveupdate(supplier) == true) {
			obj.addObject("mesg1", "supplier added successfully");
		} else {
			obj.addObject("mesg2", "supplier adding failed");
		}
		return obj;
	}

	@RequestMapping("/editSupplier/{supid}")
	public ModelAndView editsupplier(@PathVariable("supid") String suid) {
		List<Supplier> slist = supplierDao.list();
		supplier = supplierDao.get(suid);
		ModelAndView obj = new ModelAndView("SupplierForm");
		supplierDao.saveupdate(supplier);
		obj.addObject("supplier", supplier);
		obj.addObject("slist", slist);

		return obj;
	}

	@RequestMapping("/deleteSupplier/{supid}")
	public ModelAndView deletesupplier(@PathVariable("supid") String suid) {
		Supplier sup = supplierDao.get(suid);
		ModelAndView obj = new ModelAndView("redirect:/SupplierForm");
		List<Product> P = productDao.GetProductBySupplier(sup.getSup_sid());
        if(P==null || P.isEmpty())
        {
        	supplierDao.delete(sup);
        	
        }
        else
        {
         for(Product pr:P)
         {
        	 productDao.delete(pr);
         }
         if(supplierDao.delete(sup)==true)
        	 obj.addObject("supplier deleted");
         else
        	 obj.addObject("supplier not deleted");
        }
		
		supplierDao.delete(sup);
		return obj;
	}

}
