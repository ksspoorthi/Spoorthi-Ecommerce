package com.niit.trendBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.trendBackend.Dao.PaymentDao;
import com.niit.trendBackend.model.Payment;


public class PaymentTest {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		PaymentDao paymentDao = (PaymentDao) context.getBean("paymentDao");
		Payment payment = (Payment) context.getBean("payment");
		
		
        payment.setPay_id("001");
        payment.setPay_method("COD");
        payment.setPay_status("success");
//        save and update
        if(paymentDao.saveupdate(payment)==true)
        {
        	System.out.println("saved");
        }
        else
        	System.out.println("Sorry");
          
       // delete
//     if(paymentDao.delete("001")==true){
//        	System.out.println("Delete successfull");
//        }
//        else{
//        	System.out.println("Sorry");
//        }
        Payment c=paymentDao.get("001");
        System.out.println(c.getPay_id());
        System.out.println(c.getPay_method());
        System.out.println(c.getPay_status());
        
        List<Payment> li=paymentDao.list();
        for(Payment c1:li){
        	System.out.println(c1.getPay_id());
        	System.out.println(c1.getPay_method());
        	System.out.println(c1.getPay_status());
        }
       
	}
}
