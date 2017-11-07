package com.niit.trendBackend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Card {
	@Id
private	String card_id;
private	String card_no;
private	String card_name;
private	String card_expiry_month; //use alt+shift+s to automaticaly generate getter setter methods
private	String card_expiry_year;

@OneToOne
@JoinColumn(name="user_id")
User user;

public String getCard_id() {
	return card_id;
}
public void setCard_id(String card_id) {
	this.card_id = card_id;
}
public String getCard_no() {
	return card_no;
}
public void setCard_no(String card_no) {
	this.card_no = card_no;
}
public String getCard_name() {
	return card_name;
}
public void setCard_name(String card_name) {
	this.card_name = card_name;
}
public String getCard_expiry_month() {
	return card_expiry_month;
}
public void setCard_expiry_month(String card_expiry_month) {
	this.card_expiry_month = card_expiry_month;
}
public String getCard_expiry_year() {
	return card_expiry_year;
}
public void setCard_expiry_year(String card_expiry_year) {
	this.card_expiry_year = card_expiry_year;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}


//public Card(){
//	this.cat_id="CAT"+UUID.randomUUID().toString().substring(2,7).toUpperCase();
//}



}
