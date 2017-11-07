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

import com.niit.trendBackend.Dao.OrderItemsDao;
import com.niit.trendBackend.model.OrderItems;

@Repository("orderItemsDao")
@EnableTransactionManagement
public class OrderItemsDaoImpl implements OrderItemsDao {
	@Autowired
	SessionFactory sessionFactory;//referance variable 

	public OrderItemsDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveupdate(OrderItems orderItems) {
		sessionFactory.getCurrentSession().saveOrUpdate(orderItems);
		return true;
	}

	@Transactional
	public boolean delete(OrderItems orderItems) {
		
			sessionFactory.getCurrentSession().delete(orderItems);
			return true;
	}
			
			
		
	

	@Transactional
	public OrderItems get(String id) {
		String q1 = "from OrderItems where orderItem_Id='" + id + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<OrderItems> list1 = (List<OrderItems>) w.list();
		if (list1 == null || list1.isEmpty()) {
			return null;
		} else {
			return list1.get(0);
		}

	}
	
	@Transactional
	public List<OrderItems> getOrderItemsbyOrder(String order_id) {
		String q1 ="from OrderItems where order_Id='"+order_id+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<OrderItems> list = (List<OrderItems>) w.list();
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list;
	}
	
	@Transactional
public List<OrderItems> list() {
		@SuppressWarnings("unchecked")
		List<OrderItems> orderItems = (List<OrderItems>) sessionFactory.getCurrentSession().createCriteria(OrderItems.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
     return orderItems;
	}

}
