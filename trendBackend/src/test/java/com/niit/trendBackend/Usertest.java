package com.niit.trendBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.trendBackend.Dao.UserDao;
import com.niit.trendBackend.model.BillingAddress;
import com.niit.trendBackend.model.Cart;
import com.niit.trendBackend.model.Supplier;
import com.niit.trendBackend.model.User;

public class Usertest {

	public static void main(String args[]) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		UserDao userDao = (UserDao) context.getBean("userDao");
		User user = (User) context.getBean("user");
		Cart cart=(Cart) context.getBean("cart");
		BillingAddress billingAddress = (BillingAddress) context.getBean("billingAddress");
		
		user.setBillingAddress(billingAddress);
		user.setCart(cart);
		
		//user.setUser_id("1");
		user.setUser_name("K V");
		user.setUser_emailid("kv@gm.cpm");
		user.setUser_phno("855395");
		user.setUser_password("12348888");
		//user.setUser_enable("yes");
		user.setUser_role("admin");
		user.setUser_address("rajnr,blore");
		
		if (userDao.saveupdate(user) == true)
			System.out.println("saved");
		else
			System.out.println("sorry");
		//if (userDao.delete("1") == true)
			//System.out.println("deleted");
	//	else
		//	System.out.println("sorry");

		User u = userDao.get("USERA12268");
		System.out.println(u.getUser_id());
		System.out.println(u.getUser_name());
		System.out.println(u.getUser_emailid());
		System.out.println(u.getUser_password());
		//System.out.println(u.getUser_enable());
		System.out.println(u.getUser_role());
		System.out.println(u.getUser_address());
		System.out.println(u.getUser_phno());

//		List<User> li = userDao.list();
//		for (User c1 : li) {
//			System.out.println(c1.getUser_id());
//			System.out.println(c1.getUser_name());
//			System.out.println(c1.getUser_address());
//			System.out.println(c1.getUser_emailid());
//			System.out.println(c1.getUser_enable());
//			System.out.println(c1.getUser_password());
//			System.out.println(c1.getUser_role());
//			System.out.println(c1.getUser_phno());
//		}
		if(userDao.isvalid("kv@gm.cpm", "12348888")==null)
			System.out.println("unsuccess");
		else
			System.out.println("successfull");
		
		

	}
}
