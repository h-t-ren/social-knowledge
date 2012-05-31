package com.huaxinshengyuan.socknow.domain;

import org.hibernate.validator.constraints.Email;
import org.springframework.data.neo4j.annotation.Indexed;

@SuppressWarnings("serial")
public class Contact extends KnowledgeNode{

	@Indexed @Email private String email;
	private String phone;
	private String address;
	private String biography;
	
	
	public Contact(){}
	
	public Contact(String email,String phone,String address,String biography){
		
		this.email=email;
		this.phone=phone;
		this.address=address;
		this.biography=biography;
		
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}
	@Override
	public String toString()
	{
		return this.email;
	}

	
}
