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

import com.niit.trendBackend.Dao.CartItemsDao;
import com.niit.trendBackend.model.Cart;
import com.niit.trendBackend.model.CartItems;
import com.niit.trendBackend.model.Product;


@Repository("cartItemsDao")
@EnableTransactionManagement
public class CartItemsDaoImpl implements CartItemsDao {
	@Autowired
	SessionFactory sessionFactory;//referance variable 

	public CartItemsDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveupdate(CartItems cartItems) {
		sessionFactory.getCurrentSession().saveOrUpdate(cartItems);
		Cart c = cartItems.getCart();
		sessionFactory.getCurrentSession().saveOrUpdate(c);
		return true;
	}

	@Transactional
	public boolean delete(CartItems cartItems) {
		  sessionFactory.getCurrentSession().delete(cartItems);
			return true;
	}
			
			
		
	

	@Transactional
	public CartItems get(String id) {
		String q1 = "from CartItems where cartItem_id='" + id + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<CartItems> list1 = (List<CartItems>) w.list();
		if (list1 == null || list1.isEmpty()) {
			return null;
		} else {
			return list1.get(0);
		}

	}
	@Transactional
public List<CartItems> list() {
		@SuppressWarnings("unchecked")
		List<CartItems> cartItems = (List<CartItems>) sessionFactory.getCurrentSession().createCriteria(CartItems.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
     return cartItems;
	}

	@Transactional
	public CartItems getlistall(String CartId,String pro){
		String q1 = "from CartItems where  cart_id ='"+CartId+"'and prod_id='"+pro+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<CartItems> list1 = (List<CartItems>) w.list();
		if (list1 == null || list1.isEmpty()) {
			System.out.println("list is empty");
			return null;
		} else {
			return list1.get(0);
		}
	}
	
	@Transactional
	public List<CartItems> getCartItembyCartId(String cartId) {
		String q1 = "from CartItems where  cart_id ='"+cartId+"'"; 
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<CartItems> list1 = (List<CartItems>) w.list();
		if (list1 == null || list1.isEmpty()) {
			System.out.println("list is empty");
			return null;
		} else {
			return list1;
		}
	}

}
