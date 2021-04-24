package com.cg.go.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="addressId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String addressId;
	
	@Column(name= "buildingNo")
	private int buildingNo;
	
	@Column(name="streetName")
	private String streetName;
	
	@Column(name="area")
	private String area;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="zip")
	private int zip;
	
	public Address() {
		// no implementation
	}
	
	public Address(String addressId, int buildingNo, String streetName, String area, String city, String state,
			int zip) {
		super();
		this.addressId = addressId;
		this.buildingNo = buildingNo;
		this.streetName = streetName;
		this.area = area;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public int getBuildingNo() {
		return buildingNo;
	}
	public void setBuildingNo(int buildingNo) {
		this.buildingNo = buildingNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return String.format("Address [addressId=%s, buildingNo=%s, streetName=%s, area=%s, city=%s, state=%s, zip=%s]",
				addressId, buildingNo, streetName, area, city, state, zip);
	}

	
	
}
