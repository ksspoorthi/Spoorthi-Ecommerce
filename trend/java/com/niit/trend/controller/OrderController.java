package com.niit.trend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.otp.Otpganarater;
import com.niit.trendBackend.Dao.BillingAddressDao;
import com.niit.trendBackend.Dao.CardDao;
import com.niit.trendBackend.Dao.CartDao;
import com.niit.trendBackend.Dao.CartItemsDao;
import com.niit.trendBackend.Dao.OrderDao;
import com.niit.trendBackend.Dao.OrderItemsDao;
import com.niit.trendBackend.Dao.PaymentDao;
import com.niit.trendBackend.Dao.ProductDao;
import com.niit.trendBackend.Dao.ShippingAddressDao;
import com.niit.trendBackend.Dao.UserDao;
import com.niit.trendBackend.model.BillingAddress;
import com.niit.trendBackend.model.Card;
import com.niit.trendBackend.model.Cart;
import com.niit.trendBackend.model.CartItems;
import com.niit.trendBackend.model.Order;
import com.niit.trendBackend.model.OrderItems;
import com.niit.trendBackend.model.Payment;
import com.niit.trendBackend.model.Product;
import com.niit.trendBackend.model.ShippingAddress;
import com.niit.trendBackend.model.User;



@Controller
public class OrderController {


	@Autowired
	Cart cart;
	@Autowired
	CartDao cartDao;
	@Autowired
	CartItems cartItem;
	@Autowired
	CartItemsDao cartItemDao;
	@Autowired
	Card card;
	@Autowired
	CardDao cardDao;
	@Autowired
	BillingAddress billingAddress;
	@Autowired
	BillingAddressDao billingAddressDao;
	@Autowired
	ShippingAddress shippingAddress;
	@Autowired
	ShippingAddressDao shippingAddressDao;
	@Autowired
	Payment payment;
	@Autowired
	PaymentDao paymentDao;
	@Autowired
	Order order;
	@Autowired
	OrderDao orderDao;
	@Autowired
	OrderItems orderItems;
	@Autowired
	OrderItemsDao orderItemsDao;
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	@Autowired
	User user;
	@Autowired
	UserDao userDao;
	@Autowired
	List<CartItems> cartItems;
	
	@Autowired
    private JavaMailSender mailSender;
	
	String o;
	

	@RequestMapping("/Buyall")
	public String orderall(Model model,HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			user = userDao.getUseremail(currusername);
			cart = user.getCart();
			product=null;
			cartItems = cartItemDao.getCartItembyCartId(cart.getCart_id());
			if(cartItems==null || cartItems.isEmpty())
			{
				return "redirect:/ViewYourCart";
			}
			else
			{
				billingAddress = billingAddressDao.get(user.getBillingAddress().getB_id());
				List<ShippingAddress> shippingAddress = shippingAddressDao.getaddbyuser(user.getUser_id());
				
				model.addAttribute("billingAddress", billingAddress);
				model.addAttribute("user", user);
				model.addAttribute("shippingAddress", shippingAddress);
				model.addAttribute("shippingAddress", new ShippingAddress());
				session.setAttribute("p", product);
			}
			return "AddressOrder";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping("/Buy/{p_id}/{ci_id}")
	public String order(@PathVariable("p_id") String id, Model model,HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			user = userDao.getUseremail(currusername);
			cart = user.getCart();
			cartItems=null;
			product = productDao.get(id);
			billingAddress = billingAddressDao.get(user.getUser_id());
			List<ShippingAddress> shippingAddress = shippingAddressDao.getaddbyuser(user.getUser_id());
			
			model.addAttribute("billingaddress", billingAddress);
			model.addAttribute("user", user);
			model.addAttribute("shippingAddress", shippingAddress);
			model.addAttribute("shippingAddress", new ShippingAddress());
			session.setAttribute("p", product);
			return "AddressOrder";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping("/orderConfirm")
	public String payment(@ModelAttribute("shippingAddress") ShippingAddress sh, Model model) {
	
//		if(cartItems==null || cartItems.isEmpty())
//		{
//			System.out.println("sorry");
//		}
		sh.setUser(user);
		shippingAddress = sh;
		model.addAttribute("billingaddress", billingAddress);
		model.addAttribute("shippingAddress", shippingAddress);
		model.addAttribute("product", product);
		model.addAttribute("shippingAddress",new ShippingAddress());
		
		model.addAttribute("cartItems",cartItems);
		model.addAttribute("cart",cart);
		
		if(shippingAddressDao.saveupdate(shippingAddress)==true)
		{
			System.out.println("SA saved");
		}
		
		return "orderconfirm";
	}

	
	@RequestMapping("/previous")
	public String previous(Model model, @ModelAttribute("user")User user) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			user = userDao.getUseremail(currusername);
			
//		List<ShippingAddress> shippingAddress = shippingAddressDao.getaddbyuser(user.getUser_id());
		model.addAttribute("shippingAddress", new ShippingAddress());
		model.addAttribute("shippingAddress", shippingAddress);
		model.addAttribute("billingAddress", billingAddress);
		model.addAttribute("user", user);
		
		model.addAttribute("product", product);
		return "AddressOrder";
		} else {
			return "redirect:/";
		}
	
		
	}

	@RequestMapping("/pay")
	public String pay(Model model) {
		List<Card> cards = cardDao.getcardbyuser(user.getUser_id());
		model.addAttribute("cards", cards);
		model.addAttribute("card", new Card());
		model.addAttribute("cart",cart);
		return "PaymentMode";
	}

	@RequestMapping("/payment")
	public String payment(@ModelAttribute("card")Card c, @RequestParam("otp")String otp,  Model model) {
 		System.out.println(1324);
		int a;
		if(otp==null)
		{
			
			System.out.println("Move to 2nd condition");
			a=2;
		}
		else
			a=1;
//		System.out.println(str);
				
//		if (str.equalsIgnoreCase("Start Subscription")) {
//			a = 2;
//		} else {
//			a = Integer.parseInt(str);
//		}
		System.out.println(a);
		
		switch (a) {
		case 1:
				if(otp.equals(o))
				{
					payment.setPay_method("COD");
					payment.setPay_status("no");
				}
				else
				{
					return "redirect:/pay";
				}
			 
			break;
		case 2:
			if(a==2)
			{
			payment.setPay_method("card");
			payment.setPay_status("yes");
			paymentDao.saveupdate(payment);
			cardDao.saveupdate(c);
			}
			else
			{
				return "Thanku";
			}

			break;
		}
		return "redirect:/Thankyou";
	}

	@RequestMapping("/Thankyou")
	public String orderconformation(HttpSession session) {
		System.out.println(32);
		order.setBillingAddress(billingAddress);
		order.setShippingAddress(shippingAddress);
		order.setPayment(payment);
		order.setUser(user);
		System.out.println(524);
		if (cartItems == null || cartItems.isEmpty()) 
		{
//			order.setGrand_total(product.getProd_price());
			orderDao.saveupdate(order);
			orderItems.setOrder(order);
			orderItems.setP_id(product.getProd_id());
			orderItemsDao.saveupdate(orderItems);
			cart.setGrand_total(cart.getGrand_total() - cartItem.getPrice());
			cart.setTotal_items(cart.getTotal_items() - 1);
			session.setAttribute("items", cart.getTotal_items());
			cartDao.saveupdate(cart);
			cartItemDao.delete(cartItemDao.getlistall(cart.getCart_id(),product.getProd_id()));
			System.out.println(324);
		}
		else
		{ 
			System.out.println(656);
			order.setGrand_total(cart.getGrand_total());
			orderDao.saveupdate(order);
			 
			for(CartItems c:cartItems)
			{
				System.out.println(3444);
				orderItems.setOrder(order);
				orderItems.setP_id(c.getProduct().getProd_id());
				System.out.println(3443);
				orderItemsDao.saveupdate(orderItems);
				
				cartItemDao.delete(c);
			}
			cart.setGrand_total(0.0);
			cart.setTotal_items(0);
			System.out.println(346);
			session.setAttribute("items", cart.getTotal_items());
			cartDao.saveupdate(cart);
		}
		cartItems=null;
		cartItem=null;
		product=null;
		order=new Order();
		orderItems=new OrderItems();
		System.out.println(565);
		return "Thanku";
	}

@RequestMapping(value="/SendMail")
public void SendMail() {
	System.out.println(21312);
Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
if (!(authentication instanceof AnonymousAuthenticationToken)) {
	String currusername = authentication.getName();
	user = userDao.getUseremail(currusername);      
	Otpganarater ot=new Otpganarater();
//	String o=ot.Otpga();
	o=ot.Otpga();
	String recipientAddress = user.getUser_emailid();
	String subject="OTP";
//String subject = request.getParameter("subject");
String message = "your one time password is "+o+" ";

// prints debug info
System.out.println("To:" + recipientAddress);
System.out.println("Subject: " + subject);
System.out.println("Message: " + message);

    
//System.out.println("OTP:"+ otp);
// creates a simple e-mail object
SimpleMailMessage email = new SimpleMailMessage();
email.setTo(recipientAddress);
email.setSubject(subject);
email.setText(message);
//email.setSubject(otp);
// sends the e-mail
mailSender.send(email);

}
// forwards to the view named "Result"
//return "Result";
}


@RequestMapping(value="/ConfirmationMail")
public String SendMsg(Model model) {
	System.out.println(21312);
Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
if (!(authentication instanceof AnonymousAuthenticationToken)) {
	String currusername = authentication.getName();
	user = userDao.getUseremail(currusername);      
//	Otpganarater ot=new Otpganarater();
//	String o=ot.Otpga();
//	o=ot.Otpga();
	String recipientAddress = user.getUser_emailid();
	String subject="OTP";
//String subject = request.getParameter("subject");
//String message = "your one time password is "+o+" ";
String message="Your order is been confirmed";
// prints debug info
System.out.println("To:" + recipientAddress);
System.out.println("Subject: " + subject);
System.out.println("Message: " + message);

    
//System.out.println("OTP:"+ otp);
// creates a simple e-mail object
SimpleMailMessage email = new SimpleMailMessage();
email.setTo(recipientAddress);
email.setSubject(subject);
email.setText(message);
//email.setSubject(otp);
// sends the e-mail
mailSender.send(email);

 
// forwards to the view named "Result"
}

return "process";
}
}