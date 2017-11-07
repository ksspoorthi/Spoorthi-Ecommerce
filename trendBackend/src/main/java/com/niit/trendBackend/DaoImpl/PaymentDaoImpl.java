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

import com.niit.trendBackend.Dao.PaymentDao;
import com.niit.trendBackend.model.Payment;


@Repository("paymentDao")
@EnableTransactionManagement
public class PaymentDaoImpl implements PaymentDao {
	@Autowired
	SessionFactory sessionFactory;//referance variable 

	public PaymentDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveupdate(Payment payment) {
		sessionFactory.getCurrentSession().saveOrUpdate(payment);
		return true;
	}

	@Transactional
	public boolean delete(String pid) {
		
			Payment pay = new Payment();
			pay.setPay_id(pid);
			System.out.println("object is set with data"+pay.getPay_id());
			sessionFactory.getCurrentSession().delete(pay);
			return true;
	}
			
			
		
	

	@Transactional
	public Payment get(String id) {
		String q1 = "from Payment where pay_id='" + id + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Payment> list1 = (List<Payment>) w.list();
		if (list1 == null || list1.isEmpty()) {
			return null;
		} else {
			return list1.get(0);
		}

	}
	@Transactional
public List<Payment> list() {
		@SuppressWarnings("unchecked")
		List<Payment> payment = (List<Payment>) sessionFactory.getCurrentSession().createCriteria(Payment.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
     return payment;
	}

}
