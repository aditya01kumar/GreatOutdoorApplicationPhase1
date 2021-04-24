package com.cg.go.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="")
public class GrowthReportEntity implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "growthReportId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long growthReportId;
	
	@Column(name = "currentdate")
	private LocalDate currentdate;
	
	@Column(name = "revenue")
	private double revenue;
	
	@Column(name = "amountChange")
	private double amountChange;
	
	@Column(name = "percentageGrowth")
	private double percentageGrowth;
	
	@Column(name = "colorCode")
	private String colorCode;
	
	public GrowthReportEntity() {
		// no implementation
	}

	public GrowthReportEntity(long growthReportId, LocalDate currentdate, double revenue, double amountChange,
			double percentageGrowth, String colorCode) {
		super();
		this.growthReportId = growthReportId;
		this.currentdate = currentdate;
		this.revenue = revenue;
		this.amountChange = amountChange;
		this.percentageGrowth = percentageGrowth;
		this.colorCode = colorCode;
	}

	public long getGrowthReportId() {
		return growthReportId;
	}

	public void setGrowthReportId(long growthReportId) {
		this.growthReportId = growthReportId;
	}

	public LocalDate getCurrentdate() {
		return currentdate;
	}

	public void setCurrentdate(LocalDate currentdate) {
		this.currentdate = currentdate;
	}

	public double getRevenue() {
		return revenue;
	}

	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}

	public double getAmountChange() {
		return amountChange;
	}

	public void setAmountChange(double amountChange) {
		this.amountChange = amountChange;
	}

	public double getPercentageGrowth() {
		return percentageGrowth;
	}

	public void setPercentageGrowth(double percentageGrowth) {
		this.percentageGrowth = percentageGrowth;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	@Override
	public String toString() {
		return String.format(
				"GrowthReportEntity [growthReportId=%s, currentdate=%s, revenue=%s, amountChange=%s, percentageGrowth=%s, colorCode=%s]",
				growthReportId, currentdate, revenue, amountChange, percentageGrowth, colorCode);
	}


}
