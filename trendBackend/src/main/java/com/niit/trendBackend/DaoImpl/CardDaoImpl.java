package com.niit.trendBackend.DaoImpl;

import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.trendBackend.Dao.CardDao;
import com.niit.trendBackend.model.Card;
import com.niit.trendBackend.model.ShippingAddress;


@Repository("cardDao")
@EnableTransactionManagement
public class CardDaoImpl implements CardDao {
	@Autowired
	SessionFactory sessionFactory;//referance variable 

	public CardDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveupdate(Card card) {
		sessionFactory.getCurrentSession().saveOrUpdate(card);
		return true;
	}

	@Transactional
	public boolean delete(String cardid) {
		
			Card card = new Card();
			card.setCard_id(cardid);
			System.out.println("object is set with data"+card.getCard_id());
			sessionFactory.getCurrentSession().delete(card);
			return true;
	}
			
			
		
	

	@Transactional
	public Card get(String id) {
		String q1 = "from Card where card_id='" + id + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Card> list1 = (List<Card>) w.list();
		if (list1 == null || list1.isEmpty()) {
			return null;
		} else {
			return list1.get(0);
		}

	}
	
	
	@Transactional
	public List<Card> getcardbyuser(String user_id){
		String q1 = "from Card where user_id='" + user_id + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Card> list1 = (List<Card>) w.list();
		if (list1 == null || list1.isEmpty()) {
			return null;
		} else {
			return list1;
		}

	}

	
	
	@Transactional
public List<Card> list() {
		@SuppressWarnings("unchecked")
		List<Card> card = (List<Card>) sessionFactory.getCurrentSession().createCriteria(Card.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
     return card;
	}

}
