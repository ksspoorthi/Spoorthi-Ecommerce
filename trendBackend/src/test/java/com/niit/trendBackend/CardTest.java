package com.niit.trendBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.trendBackend.Dao.CardDao;
import com.niit.trendBackend.model.Card;


public class CardTest {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		CardDao cardDao = (CardDao) context.getBean("cardDao");
		Card card= (Card) context.getBean("card");
		
		
        card.setCard_id("001");
        card.setCard_no("002");
        card.setCard_name("me");
       
        
//        save and update
        if(cardDao.saveupdate(card)==true)
        {
        	System.out.println("saved");
        }
        else
        	System.out.println("Sorry");
          
       // delete
//     if(cardDao.delete("001")==true){
//        	System.out.println("Delete successfull");
//        }
//        else{
//        	System.out.println("Sorry");
//        }
        Card c=cardDao.get("001");
        System.out.println(c.getCard_id());
        System.out.println(c.getCard_no());
        System.out.println(c.getCard_name());
      
        
        
        List<Card> li=cardDao.list();
        for(Card c1:li){
        	System.out.println(c.getCard_id());
            System.out.println(c.getCard_no());
            System.out.println(c.getCard_name());
          
        	
        }
       
	}
}
