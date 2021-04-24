package com.cg.go.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "customerId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	
	@Column(name = "customerName")
	private String customerName;
	
	@Column(name = "mobileNo")
	private String mobileNo;
	
	@Column(name = "email")
	private String email;
	
	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.PERSIST)
	@JoinColumn(name = "addressID")
	private Address address;
	
	@Column(name = "role")
	private String role; // sales representative or retailer

	public Customer() {
		// no implementation
	}


	public Customer(int customerId, String customerName, String mobileNo, String email, Address address, String role) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.address = address;
		this.role = role;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return String.format("Customer [customerId=%s, customerName=%s, mobileNo=%s, email=%s, address=%s, role=%s]",
				customerId, customerName, mobileNo, email, address, role);
	}
}