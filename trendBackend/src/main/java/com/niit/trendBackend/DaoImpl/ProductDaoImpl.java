package com.niit.trendBackend.DaoImpl;

import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.trendBackend.Dao.ProductDao;
import com.niit.trendBackend.model.Category;
import com.niit.trendBackend.model.Product;

@Repository("productDao")
@EnableTransactionManagement
public class ProductDaoImpl implements ProductDao {
	@Autowired
	SessionFactory sessionFactory;// referance variable

	public ProductDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveupdate(Product product) {
		//sessionFactory.getCurrentSession().saveOrUpdate(product.getSupplier());
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		return true;

	}

	@Transactional
	public boolean delete(Product product) {

		
		//System.out.println("object is set with data" + prod.getProd_id());
		sessionFactory.getCurrentSession().delete(product);
		return true;
	}
	
		@Transactional
		public Product get(String pid) {
			String q1 = "from Product where prod_id='"+pid+"'";
			Query w = sessionFactory.getCurrentSession().createQuery(q1);
			@SuppressWarnings("unchecked")
			List<Product> list1 = (List<Product>) w.list();
			if (list1 == null || list1.isEmpty()) {
				return null;
			} else {
				return list1.get(0);
			}

		}
		
		@Transactional
		public List<Product> GetProductByCategory(String id){
			String q1 = "from Product where cat_id ='"+id+"'"; //cat_id is name given in ManyToOne in Product.java
			Query w = sessionFactory.getCurrentSession().createQuery(q1);
			@SuppressWarnings("unchecked")
			List<Product> list1 = (List<Product>) w.list();
			if (list1 == null || list1.isEmpty()) {
				return null;
			} else {
				return list1;
			}
		}
		
		@Transactional
		public List<Product> GetProductBySupplier(String id){
			String q1 = "from Product where sup_sid ='"+id+"'"; 
			Query w = sessionFactory.getCurrentSession().createQuery(q1);
			@SuppressWarnings("unchecked")
			List<Product> list1 = (List<Product>) w.list();
			if (list1 == null || list1.isEmpty()) {
				return null;
			} else {
				return list1;
			}
		}
		
		@Transactional
		public List<Product> list() {
				@SuppressWarnings("unchecked")
				List<Product> product = (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		     return product;
			}
}
