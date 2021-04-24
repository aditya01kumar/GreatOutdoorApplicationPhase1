package com.cg.go.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Userdata")
public class Userdata implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "userName")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String userName;
	
	@Column(name = "userId")
	private int userId;
	
	@Column(name = "userType")
	private String userType;
	
	@Column(name = "userPassword")
	private String userPassword;
	
	public Userdata() {
		// no implementation
	}
	public Userdata(String userName, int userId, String userType, String userPassword) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.userType = userType;
		this.userPassword = userPassword;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return String.format("Userdata [userName=%s, userId=%s, userType=%s, userPassword=%s]", userName, userId,
				userType, userPassword);
	}
	
	
}
	