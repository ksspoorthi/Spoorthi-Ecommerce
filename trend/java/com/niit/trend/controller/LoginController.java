package com.niit.trend.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.trendBackend.Dao.UserDao;
import com.niit.trendBackend.model.User;

@Controller
@Transactional
public class LoginController {
	@Autowired
	UserDao userDao;
	@Autowired
	User user;

	@RequestMapping("/loginpg")
	public ModelAndView login(@RequestParam(value="error",required=false)String error,
	@RequestParam(value="logout",required=false)String logout)
	{
		ModelAndView obj= new ModelAndView("redirect:/myhompg");
		if(error!=null)
			obj.addObject("msg1","invalid username or password");
		else
			obj.addObject("msg2","login success");
		return obj;
	}

	@RequestMapping(value = "/j_spring_security_check")
	public String processRegistration(@RequestParam("j_username") String email, @RequestParam("j_password") String pwd,
			Model model, HttpSession session) {
		System.out.println("sgsgsg");

		User u = userDao.isvalid(email, pwd);
		if (u == null) {
			System.out.println("skdkk");
			model.addAttribute("msg", "invalid user and password");
			return "redirect:/";
		} else {
			session.setAttribute("user", u);
			session.setAttribute("name", u.getUser_name());
			session.setAttribute("items", u.getCart().getTotal_items());
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/j_spring_security_logout")
	public String logout(HttpServletRequest request, HttpSession Session, Model model) {
		Session.invalidate();//
		Session = request.getSession(true);
		model.addAttribute("logout", "logout successfull");
		return "redirect:/";
	}
}
