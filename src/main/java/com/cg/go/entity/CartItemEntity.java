package com.cg.go.entity;

import java.io.Serializable;
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
@Table(name="CartItemEntity")
public class CartItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "cartId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cartId;
	
	@Column(name = "userId")
	private String userId;
	
	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.PERSIST)
	@JoinColumn(name = "productId")
	private ProductEntity products;// product ,quantity
	private double cartTotalPrice;
	
	@Column(name = "totalQuantity")
	private long totalQuantity;
	
	public CartItemEntity() {
		// no implementation
	}

	public CartItemEntity(long cartId, String userId, ProductEntity products, double cartTotalPrice,
			long totalQuantity) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.products = products;
		this.cartTotalPrice = cartTotalPrice;
		this.totalQuantity = totalQuantity;
	}

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
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

	public double getCartTotalPrice() {
		return cartTotalPrice;
	}

	public void setCartTotalPrice(double cartTotalPrice) {
		this.cartTotalPrice = cartTotalPrice;
	}

	public long getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	@Override
	public String toString() {
		return String.format("CartItemEntity [cartId=%s, userId=%s, products=%s, cartTotalPrice=%s, totalQuantity=%s]",
				cartId, userId, products, cartTotalPrice, totalQuantity);
	}

}
