package com.niit.trendBackend.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Cart {
	@Id
private	String cart_id;
	private	double grand_total=0.0;
	private	int total_items=0; //use alt+shift+s to automaticaly generate getter setter methods
	
	@OneToMany(mappedBy="cart")
	List<CartItems> cartitems;

public List<CartItems> getCartitems() {
		return cartitems;
	}

	public void setCartitems(List<CartItems> cartitems) {
		this.cartitems = cartitems;
	}






public Cart(){
	
	this.cart_id="CART"+UUID.randomUUID().toString().substring(2,7).toUpperCase();

}

public String getCart_id() {
	return cart_id;
}
public void setCart_id(String cart_id) {
	this.cart_id = cart_id;
}
public double getGrand_total() {
	return grand_total;
}
public void setGrand_total(double grand_total) {
	this.grand_total = grand_total;
}
public int getTotal_items() {
	return total_items;
}
public void setTotal_items(int total_items) {
	this.total_items = total_items;
}




}
