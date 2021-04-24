package com.cg.go.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="")
public class WishlistItemEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "wishlistId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long wishlistId;
	
	@Column(name = "userId")
	private String userId;
	
	@Column(name = "productId")
	private List<String> productId;
	
	 public WishlistItemEntity() {
	    	// no implementation
	    }
	 
	public WishlistItemEntity(long wishlistId, String userId, List<String> productId) {
		super();
		this.wishlistId = wishlistId;
		this.userId = userId;
		this.productId = productId;
	}

	public long getWishlistId() {
		return wishlistId;
	}
	public void setWishlistId(long wishlistId) {
		this.wishlistId = wishlistId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<String> getProductId() {
		return productId;
	}
	public void setProductId(List<String> productId) {
		this.productId = productId;
	}
	@Override
	public String toString() {
		return String.format("WishlistItemEntity [wishlistId=%s, userId=%s, productId=%s]", wishlistId, userId,
				productId);
	}
	
}
