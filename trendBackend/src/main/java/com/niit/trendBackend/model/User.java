package com.niit.trendBackend.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class User {
	@Id
	private String user_id;
	private String user_name;
	
	private String user_phno;
	private String user_emailid;
	//private String user_enable;
	private String user_role="ROLE_USER";
	private String user_password;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cart_id")
	private Cart cart;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="b_id")
	private BillingAddress billingAddress; //the primary key associated with the object will be assigned to b_id
	
	
	public User(){
		
			this.user_id="USER"+UUID.randomUUID().toString().substring(30).toUpperCase();
		
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	
	public String getUser_phno() {
		return user_phno;
	}
	public void setUser_phno(String user_phno) {
		this.user_phno = user_phno;
	}
	public String getUser_emailid() {
		return user_emailid;
	}
	public void setUser_emailid(String user_emailid) {
		this.user_emailid = user_emailid;
	}
//	public String getUser_enable() {
//		return user_enable;
//	}
//	public void setUser_enable(String user_enable) {
//		this.user_enable = user_enable;
//	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	

}
