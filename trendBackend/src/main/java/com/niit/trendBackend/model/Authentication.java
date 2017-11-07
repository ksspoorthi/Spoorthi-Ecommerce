package com.niit.trendBackend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Authentication {
	 
	@Id
	private String role_id;
	private String role_name = "ROLE_USER";
	private String username; //email-id of user
	
	public Authentication() {
		
		this.role_id = "ROLE"+UUID.randomUUID().toString().substring(10).toUpperCase();
	}
	
	public String getRole_id() {
		return role_id;
	}
	
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	
	public String getRole_name() {
		return role_name;
	}
	
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	

}
