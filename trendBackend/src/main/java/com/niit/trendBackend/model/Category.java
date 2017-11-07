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
public class Category {
	@Id
private	String cat_id;
private	String cat_name;
private	String cat_desc; //use alt+shift+s to automaticaly generate getter setter methods




@OneToMany(mappedBy="category")
private List<Product> product;


public List<Product> getProduct() {
	return product;
}
public void setProduct(List<Product> product) {
	this.product = product;
}
public Category(){
	this.cat_id="CAT"+UUID.randomUUID().toString().substring(2,7).toUpperCase();
}
public String getCat_id() {
	return cat_id;
}
public void setCat_id(String cat_id) {
	this.cat_id = cat_id;
}
public String getCat_name(){
	return cat_name;
}
public void setCat_name(String cat_name) {
	this.cat_name = cat_name;
}
public String getCat_desc() {
	return cat_desc;
}
public void setCat_desc(String cat_desc) {
	this.cat_desc = cat_desc;
}
	

}
