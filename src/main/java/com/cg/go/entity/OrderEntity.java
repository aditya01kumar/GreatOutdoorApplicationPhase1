package com.cg.go.entity;

import java.io.Serializable;
import java.time.LocalDate;
//import java.util.List;
//import java.util.Map;

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
@Table(name="OrderEntity")
public class OrderEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "orderId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String orderId;
	
	@Column(name = "userId")
	private String userId;
	
	
	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.PERSIST)
	@JoinColumn(name = "productID")
	private ProductEntity products; //product and quantity
	
	@Column(name = "totalPrice")
	private double totalPrice;
	
	@Column(name = "totalQuantity")
	private long totalQuantity;
	
	@Column(name = "dispatchDate")
	private LocalDate dispatchDate;
	
	@Column(name = "deliveryDate")
	private LocalDate deliveryDate;
	
	public OrderEntity() {
		// no implementation
	}
	
	public OrderEntity(String orderId, String userId, ProductEntity products, double totalPrice,
			long totalQuantity, LocalDate dispatchDate, LocalDate deliveryDate) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.products = products;
		this.totalPrice = totalPrice;
		this.totalQuantity = totalQuantity;
		this.dispatchDate = dispatchDate;
		this.deliveryDate = deliveryDate;
	}
	
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ProductEntity getProducts() {
		return products;
	}
	public void setProducts(ProductEntity products) {
		this.products = products;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public long getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public LocalDate getDispatchDate() {
		return dispatchDate;
	}
	public void setDispatchDate(LocalDate dispatchDate) {
		this.dispatchDate = dispatchDate;
	}
	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	@Override
	public String toString() {
		return String.format(
				"OrderEntity [orderId=%s, userId=%s, products=%s, totalPrice=%s, totalQuantity=%s, dispatchDate=%s, deliveryDate=%s]",
				orderId, userId, products, totalPrice, totalQuantity, dispatchDate, deliveryDate);
	}


}
