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

import com.niit.trendBackend.Dao.BillingAddressDao;
import com.niit.trendBackend.model.BillingAddress;



@Repository("billingAddressDao")
@EnableTransactionManagement
public class BillingAddressDaoImpl implements BillingAddressDao {
	@Autowired
	SessionFactory sessionFactory;//referance variable 

	public BillingAddressDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveupdate(BillingAddress billingAddress) {
		sessionFactory.getCurrentSession().saveOrUpdate(billingAddress);
		return true;
	}

	@Transactional
	public boolean delete(BillingAddress billingAddress) {
		
		
			sessionFactory.getCurrentSession().delete(billingAddress);
			return true;
	}
			
			
		
	

	@Transactional
	public BillingAddress get(String id) {
		String q1 = "from BillingAddress where b_id='" + id + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<BillingAddress> list1 = (List<BillingAddress>) w.list();
		if (list1 == null || list1.isEmpty()) {
			return null;
		} else {
			return list1.get(0);
		}

	}
	@Transactional
public List<BillingAddress> list() {
		@SuppressWarnings("unchecked")
		List<BillingAddress> billingAddress = (List<BillingAddress>) sessionFactory.getCurrentSession().createCriteria(BillingAddress.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
     return billingAddress;
	}

}
