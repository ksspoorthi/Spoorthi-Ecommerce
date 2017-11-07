package com.niit.trendBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.trendBackend.Dao.BillingAddressDao;
import com.niit.trendBackend.model.BillingAddress;


public class BillingAddressTest {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		BillingAddressDao billingAddressDao = (BillingAddressDao) context.getBean("billingAddressDao");
		BillingAddress billingAddress = (BillingAddress) context.getBean("billingAddress");//the bean here is the classname with first letter in lowercase(Its not object name)
		
		
        //billingAddress.setB_id("00100");
        billingAddress.setB_dno("gsdhgfdsh");
        billingAddress.setB_street("latest trend");
        billingAddress.setB_locality("my locality");
        billingAddress.setB_city("my city");
        billingAddress.setB_state("my state233");
        billingAddress.setB_pincode("my pincode");
//        save and update
        if(billingAddressDao.saveupdate(billingAddress)==true)
        {
        	System.out.println("saved");
        }
        else
        	System.out.println("Sorry");
          
       // delete
//     if(billingAddressDao.delete("001")==true){
//        	System.out.println("Delete successfull");
//        }
//        else{
//        	System.out.println("Sorry");
//        }
        BillingAddress c=billingAddressDao.get("BID8F92B");
        System.out.println(c.getB_id());
        System.out.println(c.getB_dno());
        System.out.println(c.getB_street());
        System.out.println(c.getB_locality());
        System.out.println(c.getB_city());
        System.out.println(c.getB_state());
        System.out.println(c.getB_pincode());
        
        
        List<BillingAddress> li=billingAddressDao.list();
        for(BillingAddress c1:li){
        	System.out.println(c1.getB_id());
        	System.out.println(c1.getB_dno());
        	System.out.println(c1.getB_street());
        	System.out.println(c1.getB_locality());
            System.out.println(c1.getB_city());
            System.out.println(c1.getB_state());
            System.out.println(c1.getB_pincode());
        }
       
	}
}
