package com.cg.go.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ProductEntity")
public class ProductEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "productId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String productId;

	@Column(name = "productName")
	private String productName;

	@Column(name = "price")
	private Double price;

	@Column(name = "image")
	private String image;

	@Column(name = "color")
	private String color;

	@Column(name = "category")
	private String category;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "manufacturer")
	private String manufacturer;

	@Column(name = "specification")
	private String specification;

	public ProductEntity() {
		// no implementation
	}

	public ProductEntity(String productId, String productName, Double price, String image, String color,
			String category, Integer quantity, String manufacturer, String specification) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.image = image;
		this.color = color;
		this.category = category;
		this.quantity = quantity;
		this.manufacturer = manufacturer;
		this.specification = specification;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	@Override
	public String toString() {
		return String.format(
				"ProductEntity [productId=%s, productName=%s, price=%s, image=%s, color=%s, category=%s, quantity=%s, manufacturer=%s, specification=%s]",
				productId, productName, price, image, color, category, quantity, manufacturer, specification);
	}

}
