package com.niit.trendBackend.config;

import java.util.Properties;

import javax.sql.DataSource;//jdbc connection

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.MailSender;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.trendBackend.Dao.AuthenticationDao;
import com.niit.trendBackend.Dao.BillingAddressDao;
import com.niit.trendBackend.Dao.CardDao;
import com.niit.trendBackend.Dao.CartDao;
import com.niit.trendBackend.Dao.CartItemsDao;
import com.niit.trendBackend.Dao.CategoryDao;
import com.niit.trendBackend.Dao.OrderDao;
import com.niit.trendBackend.Dao.OrderItemsDao;
import com.niit.trendBackend.Dao.PaymentDao;
import com.niit.trendBackend.Dao.ProductDao;
import com.niit.trendBackend.Dao.ShippingAddressDao;
import com.niit.trendBackend.Dao.SupplierDao;
import com.niit.trendBackend.Dao.UserDao;
import com.niit.trendBackend.DaoImpl.AuthenticationDaoImpl;
import com.niit.trendBackend.DaoImpl.BillingAddressDaoImpl;
import com.niit.trendBackend.DaoImpl.CardDaoImpl;
import com.niit.trendBackend.DaoImpl.CartDaoImpl;
import com.niit.trendBackend.DaoImpl.CartItemsDaoImpl;
import com.niit.trendBackend.DaoImpl.CategoryDaoImpl;
import com.niit.trendBackend.DaoImpl.OrderDaoImpl;
import com.niit.trendBackend.DaoImpl.OrderItemsDaoImpl;
import com.niit.trendBackend.DaoImpl.PaymentDaoImpl;
import com.niit.trendBackend.DaoImpl.ProductDaoImpl;
import com.niit.trendBackend.DaoImpl.ShippingAddressDaoImpl;
import com.niit.trendBackend.DaoImpl.SupplierDaoImpl;
import com.niit.trendBackend.DaoImpl.UserDaoImpl;
import com.niit.trendBackend.model.Authentication;
import com.niit.trendBackend.model.BillingAddress;
import com.niit.trendBackend.model.Card;
import com.niit.trendBackend.model.Cart;
import com.niit.trendBackend.model.CartItems;
import com.niit.trendBackend.model.Category;
import com.niit.trendBackend.model.Order;
import com.niit.trendBackend.model.OrderItems;
import com.niit.trendBackend.model.Payment;
import com.niit.trendBackend.model.Product;
import com.niit.trendBackend.model.ShippingAddress;
import com.niit.trendBackend.model.Supplier;
import com.niit.trendBackend.model.User;


@Configuration // makes java class files as configuration files(as xml file)
@ComponentScan("com.niit.*") // search methods,classes in a given package
@EnableTransactionManagement
class ApplicationContext {
	@Bean("dataSource") // @bean helps to create an object without new keyword
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");

		// Properties connectionProperties=new Properties();
		// connectionProperties.setProperty("hibernate.connection.pool_size",
		// "10");
		// connectionProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		// connectionProperties.setProperty("hibernate.show_sql", "true");
		// connectionProperties.setProperty("hibernate.dialect",
		// "org.hibernate.dialect");
		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.connection.pool_size", "10");//size in which it can execute
		properties.setProperty("hibernate.hbm2ddl.auto", "update");//update the table rather than dropping and creating
		properties.put("hibernate.show_sql", "true");//shows sql query in console(black text)
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");// Hibernate uses "dialect" configuration to know which database you are using so that it can switch to the database specific SQL generator code wherever/whenever necessary.
		return properties;
	}

	@Autowired //match the methods having same name
	@Bean("sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());

		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		 sessionBuilder.addAnnotatedClass(User.class);
		 sessionBuilder.addAnnotatedClass(Cart.class);
		 sessionBuilder.addAnnotatedClass(CartItems.class);
		 sessionBuilder.addAnnotatedClass(BillingAddress.class);
		 sessionBuilder.addAnnotatedClass(ShippingAddress.class);
		 sessionBuilder.addAnnotatedClass(Payment.class);
		 sessionBuilder.addAnnotatedClass(Card.class);
		 sessionBuilder.addAnnotatedClass(Authentication.class);
		 sessionBuilder.addAnnotatedClass(Order.class);
		 sessionBuilder.addAnnotatedClass(OrderItems.class);
		
		 
		// sessionBuilder.buildMapping(net.viralpatel.hibernate.UserDetails2);
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean("transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

	@Autowired
	@Bean("categoryDao")
	public CategoryDao getCategoryDao(SessionFactory sessionFactory) {
		return new CategoryDaoImpl(sessionFactory);
	}

	 @Autowired
	 @Bean("supplierDao")
	 public SupplierDao getSupplierDao(SessionFactory sessionFactory)
	 {
	 return new SupplierDaoImpl(sessionFactory);
	 }
	@Autowired
	@Bean("productDao")
	public ProductDao getProductDao(SessionFactory sessionFactory) {
		return new ProductDaoImpl(sessionFactory);
	}
	 @Autowired
	 @Bean("userDao")
	 public UserDao getUserDao(SessionFactory sessionFactory)
	 {
	 return new UserDaoImpl(sessionFactory);
	 }
	@Autowired
	 @Bean("cartDao")
	 public CartDao getCartDao(SessionFactory sessionFactory)
	 {
	 return new CartDaoImpl(sessionFactory);
	 }
	 @Autowired
	 @Bean("billingAddressDao")
	 public BillingAddressDao getBillingAddressDao(SessionFactory sessionFactory)
	 {
	 return new BillingAddressDaoImpl(sessionFactory);
	 }
	 @Autowired
	 @Bean("shippingAddressDao")
	 public ShippingAddressDao getShippingAddressDao(SessionFactory sessionFactory)
	 {
	 return new ShippingAddressDaoImpl(sessionFactory);
	 }
	 @Autowired
	 @Bean("paymentDao")
	 public PaymentDao getPaymentDao(SessionFactory sessionFactory)
	 {
	 return new PaymentDaoImpl(sessionFactory);
	 }
	 @Autowired
	 @Bean("cardDao")
	 public CardDao getCardDao(SessionFactory sessionFactory)
	 {
	 return new CardDaoImpl(sessionFactory);
	 }
	 @Autowired
	 @Bean("cartItemsDao")
	 public CartItemsDao getCartItemsDao(SessionFactory sessionFactory)
	 {
	 return new CartItemsDaoImpl(sessionFactory);
	 }
	 @Autowired
	 @Bean("authenticationDao")
	 public AuthenticationDao getAuthenticationDao(SessionFactory sessionFactory)
	 {
	 return new AuthenticationDaoImpl(sessionFactory);
	 }
	 @Autowired
	 @Bean("orderDao")
	 public OrderDao getOrderDao(SessionFactory sessionFactory)
	 {
		 return new OrderDaoImpl(sessionFactory);
	 }
	 @Autowired
	 @Bean("orderItemsDao")
	 public OrderItemsDao getOrderItemsDao(SessionFactory sessionFactory)
	 {
		 return new OrderItemsDaoImpl(sessionFactory);
	 }

}
