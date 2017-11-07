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

import com.niit.trendBackend.Dao.OrderDao;
import com.niit.trendBackend.model.Order;

@Repository("orderDao")
@EnableTransactionManagement
public class OrderDaoImpl implements OrderDao {
	@Autowired
	SessionFactory sessionFactory;//referance variable 

	public OrderDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveupdate(Order order) {
		sessionFactory.getCurrentSession().saveOrUpdate(order);
		return true;
	}

	@Transactional
	public boolean delete(Order order) {
		
			sessionFactory.getCurrentSession().delete(order);
			return true;
	}
			
			
		
	

	@Transactional
	public Order get(String id) {
		String q1 = "from Order where order_Id='" + id + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Order> list1 = (List<Order>) w.list();
		if (list1 == null || list1.isEmpty()) {
			return null;
		} else {
			return list1.get(0);
		}

	}
	@Transactional
public List<Order> list() {
		@SuppressWarnings("unchecked")
		List<Order> order = (List<Order>) sessionFactory.getCurrentSession().createCriteria(Order.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
     return order;
	}

}
