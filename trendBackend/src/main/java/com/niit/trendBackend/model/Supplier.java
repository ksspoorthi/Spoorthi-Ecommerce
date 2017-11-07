package com.niit.trendBackend.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Supplier {
	@Id
private	String sup_sid;
private	String sup_address;
private	String sup_phno;
private	String sup_name;

@OneToMany(mappedBy="supplier")
private List<Product> product;


	public List<Product> getProduct() {
	return product;
}
public void setProduct(List<Product> product) {
	this.product = product;
}
	public Supplier(){
	
	this.sup_sid = "SUP"+UUID.randomUUID().toString().toUpperCase();
}
	public String getSup_sid() {
		return sup_sid;
	}
	public void setSup_sid(String sup_sid) {
		this.sup_sid = sup_sid;
	}
	public String getSup_address() {
		return sup_address;
	}
	public void setSup_address(String sup_address) {
		this.sup_address = sup_address;
	}
	public String getSup_phno() {
		return sup_phno;
	}
	public void setSup_phno(String sup_phno) {
		this.sup_phno = sup_phno;
	}
	public String getSup_name() {
		return sup_name;
	}
	public void setSup_name(String sup_name) {
		this.sup_name = sup_name;
	}
	

}
