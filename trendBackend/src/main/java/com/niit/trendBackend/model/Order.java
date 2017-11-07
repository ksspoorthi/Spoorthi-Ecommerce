package com.niit.trendBackend.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.niit.trendBackend.model.BillingAddress;
import com.niit.trendBackend.model.Payment;
import com.niit.trendBackend.model.ShippingAddress;
import com.niit.trendBackend.model.User;

@Entity
@Table(name="orders")
@Component
public class Order {
	 private static final DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	 private static final DateFormat dtf = new SimpleDateFormat("HH:mm:ss");
	 private static final long SerialVersionUID=1l;
	 @Id
	 private String order_Id;
	 @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	 @JoinColumn(name ="b_id" )
	 BillingAddress billingAddress;
	 @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	 @JoinColumn(name = "s_id" )
	 ShippingAddress shippingAddress ;
	 @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	 @JoinColumn(name ="pay_id" )
	 Payment payment;
	 @OneToOne
	 @JoinColumn(name="user_id")
	 User user;
	 private double grand_total;
	 public static DateFormat getSdf() {
		return sdf;
	}
	public static DateFormat getDtf() {
		return dtf;
	}
	public static long getSerialversionuid() {
		return SerialVersionUID;
	}
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	 List<OrderItems> orderItems;
	 private String orderdate;
	 private String ordertime;
	 public Order()
	 {
		 Date date = new Date();
		 orderdate=sdf.format(date);
		 Calendar cal = Calendar.getInstance();
		 Date date1 = new Date();
		 ordertime=dtf.format(date1);
		 this.order_Id = UUID.randomUUID().toString().substring(30).toUpperCase();
	 }
	public String getOrder_Id() {
		return order_Id;
	}
	public void setOrder_Id(String order_Id) {
		this.order_Id = order_Id;
	}
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getGrand_total() {
		return grand_total;
	}
	public void setGrand_total(double grand_total) {
		this.grand_total = grand_total;
	}
	public List<OrderItems> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItems> orderItems) {
		orderItems = orderItems;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	 
	 
		 
	 }
	 
	 

	 
	 
	
	 

	 


