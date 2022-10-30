package com.bway.springmvc.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Currier {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)	
     private int id;
     private String productType;
     private String packagingType;
     private String quantity;
     private String weight;
     private String productValue;
     private String fullName;
     private String email;
     private String pickupCity;
     private String contact;
     
     @DateTimeFormat(pattern = "yyyy-MM-dd")
     private String pickupDatetime;
     
     private String dropoffCity;
     private String dropoffCountry;
     
     @OneToOne
     private User user;
     
     
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getPackagingType() {
		return packagingType;
	}
	public void setPackagingType(String packagingType) {
		this.packagingType = packagingType;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getProductValue() {
		return productValue;
	}
	public void setProductValue(String productValue) {
		this.productValue = productValue;
	}
		public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPickupCity() {
		return pickupCity;
	}
	public void setPickupCity(String pickupCity) {
		this.pickupCity = pickupCity;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPickupDatetime() {
		return pickupDatetime;
	}
	public void setPickupDatetime(String pickupDatetime) {
		this.pickupDatetime = pickupDatetime;
	}
	public String getDropoffCity() {
		return dropoffCity;
	}
	public void setDropoffCity(String dropoffCity) {
		this.dropoffCity = dropoffCity;
	}
	public String getDropoffCountry() {
		return dropoffCountry;
	}
	public void setDropoffCountry(String dropoffCountry) {
		this.dropoffCountry = dropoffCountry;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
       
    
}
