package com.cg.go.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="")
public class SalesReportEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "salesReportId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long salesReportId;
	
	@Column(name = "productId")
	private String productId;
	
	@Column(name = "productName")
	private String productName;
	
	@Column(name = "quantitySold")
	private Integer quantitySold;
	
	@Column(name = "totalSale")
	private double totalSale;
	
	public SalesReportEntity() {
		// no implementation	
	}
	
	public SalesReportEntity(long salesReportId, String productId, String productName, Integer quantitySold,
			double totalSale) {
		super();
		this.salesReportId = salesReportId;
		this.productId = productId;
		this.productName = productName;
		this.quantitySold = quantitySold;
		this.totalSale = totalSale;
	}
	
	public long getSalesReportId() {
		return salesReportId;
	}
	public void setSalesReportId(long salesReportId) {
		this.salesReportId = salesReportId;
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
	public Integer getQuantitySold() {
		return quantitySold;
	}
	public void setQuantitySold(Integer quantitySold) {
		this.quantitySold = quantitySold;
	}
	public double getTotalSale() {
		return totalSale;
	}
	public void setTotalSale(double totalSale) {
		this.totalSale = totalSale;
	}
	@Override
	public String toString() {
		return String.format(
				"SalesReportEntity [salesReportId=%s, productId=%s, productName=%s, quantitySold=%s, totalSale=%s]",
				salesReportId, productId, productName, quantitySold, totalSale);
	}

	
}
