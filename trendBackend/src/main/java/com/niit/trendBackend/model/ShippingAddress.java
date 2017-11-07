package com.niit.trendBackend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table
public class ShippingAddress {
	@Id
	private String s_id;
    private String s_dno;
	private String s_street;
	private String s_locality;
	private String s_city;
	private String s_state;
	private String s_pincode;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	User user;
	
	public ShippingAddress()
	{
		this.s_id="SHIP"+UUID.randomUUID().toString().substring(2,7).toUpperCase();
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getS_dno() {
		return s_dno;
	}
	public void setS_dno(String s_dno) {
		this.s_dno = s_dno;
	}
	public String getS_street() {
		return s_street;
	}
	public void setS_street(String s_street) {
		this.s_street = s_street;
	}
	public String getS_locality() {
		return s_locality;
	}
	public void setS_locality(String s_locality) {
		this.s_locality = s_locality;
	}
	public String getS_city() {
		return s_city;
	}
	public void setS_city(String s_city) {
		this.s_city = s_city;
	}
	public String getS_state() {
		return s_state;
	}
	public void setS_state(String s_state) {
		this.s_state = s_state;
	}
	public String getS_pincode() {
		return s_pincode;
	}
	public void setS_pincode(String s_pincode) {
		this.s_pincode = s_pincode;
	}
	
}