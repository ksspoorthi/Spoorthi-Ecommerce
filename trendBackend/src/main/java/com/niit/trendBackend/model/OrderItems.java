package com.niit.trendBackend.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class OrderItems {
	@Id
	private String orderItem_id;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_Id")
	private Order order;
	private String p_id;
	
	public OrderItems()
	{
		this.orderItem_id = "ORDERITEM" +UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	public String getOrderItem_id() {
		return orderItem_id;
	}

	public void setOrderItem_id(String orderItem_id) {
		this.orderItem_id = orderItem_id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	
	
	

}
