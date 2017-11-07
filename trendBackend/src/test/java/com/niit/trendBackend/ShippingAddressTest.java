package com.niit.trendBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.trendBackend.Dao.ShippingAddressDao;
import com.niit.trendBackend.model.ShippingAddress;



public class ShippingAddressTest {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		ShippingAddressDao shippingAddressDao = (ShippingAddressDao) context.getBean("shippingAddressDao");
		ShippingAddress shippingAddress = (ShippingAddress) context.getBean("shippingAddress");
		
		
        shippingAddress.setS_id("001");
        shippingAddress.setS_dno("gsdhgfdsh");
        shippingAddress.setS_street("latest trend");
        shippingAddress.setS_locality("my locality1");
        shippingAddress.setS_city("my city1");
        shippingAddress.setS_state("my state1");
        shippingAddress.setS_pincode("my pincode1");
//        save and update
        if(shippingAddressDao.saveupdate(shippingAddress)==true)
        {
        	System.out.println("saved");
        }
        else
        	System.out.println("Sorry");
          
       // delete
//     if(shippingAddressDao.delete("001")==true){
//        	System.out.println("Delete successfull");
//        }
//        else{
//        	System.out.println("Sorry");
//        }
        ShippingAddress c=shippingAddressDao.get("001");
        System.out.println(c.getS_id());
        System.out.println(c.getS_dno());
        System.out.println(c.getS_street());
        System.out.println(c.getS_locality());
        System.out.println(c.getS_city());
        System.out.println(c.getS_state());
        System.out.println(c.getS_pincode());
        
        
        List<ShippingAddress> li=shippingAddressDao.list();
        for(ShippingAddress c1:li){
        	System.out.println(c1.getS_id());
        	System.out.println(c1.getS_dno());
        	System.out.println(c1.getS_street());
        	System.out.println(c1.getS_locality());
            System.out.println(c1.getS_city());
            System.out.println(c1.getS_state());
            System.out.println(c1.getS_pincode());
        }
       
	}
}
