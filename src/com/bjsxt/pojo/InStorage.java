package com.bjsxt.pojo;

import java.io.Serializable;
import java.util.Date;

public class InStorage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int supplierId;
	private Date idate;
	private String operator;
	private String brokerage;
	private String settlement;
	private int productId;
	private double price;
	private int number;
	private double actualPay;
	private String supplierName;
	private String productName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public Date getIdate() {
		return idate;
	}
	public void setIdate(Date idate) {
		this.idate = idate;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getBrokerage() {
		return brokerage;
	}
	public void setBrokerage(String brokerage) {
		this.brokerage = brokerage;
	}
	public String getSettlement() {
		return settlement;
	}
	public void setSettlement(String settlement) {
		this.settlement = settlement;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getActualPay() {
		return actualPay;
	}
	public void setActualPay(double actualPay) {
		this.actualPay = actualPay;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(actualPay);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((brokerage == null) ? 0 : brokerage.hashCode());
		result = prime * result + id;
		result = prime * result + ((idate == null) ? 0 : idate.hashCode());
		result = prime * result + number;
		result = prime * result
				+ ((operator == null) ? 0 : operator.hashCode());
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + productId;
		result = prime * result
				+ ((productName == null) ? 0 : productName.hashCode());
		result = prime * result
				+ ((settlement == null) ? 0 : settlement.hashCode());
		result = prime * result + supplierId;
		result = prime * result
				+ ((supplierName == null) ? 0 : supplierName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InStorage other = (InStorage) obj;
		if (Double.doubleToLongBits(actualPay) != Double
				.doubleToLongBits(other.actualPay))
			return false;
		if (brokerage == null) {
			if (other.brokerage != null)
				return false;
		} else if (!brokerage.equals(other.brokerage))
			return false;
		if (id != other.id)
			return false;
		if (idate == null) {
			if (other.idate != null)
				return false;
		} else if (!idate.equals(other.idate))
			return false;
		if (number != other.number)
			return false;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (productId != other.productId)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (settlement == null) {
			if (other.settlement != null)
				return false;
		} else if (!settlement.equals(other.settlement))
			return false;
		if (supplierId != other.supplierId)
			return false;
		if (supplierName == null) {
			if (other.supplierName != null)
				return false;
		} else if (!supplierName.equals(other.supplierName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "InStorage [id=" + id + ", supplierId=" + supplierId
				+ ", idate=" + idate + ", operator=" + operator
				+ ", brokerage=" + brokerage + ", settlement=" + settlement
				+ ", productId=" + productId + ", price=" + price + ", number="
				+ number + ", actualPay=" + actualPay + ", supplierName="
				+ supplierName + ", productName=" + productName + "]";
	}
	public InStorage(int id, int supplierId, Date idate, String operator,
			String brokerage, String settlement, int productId, double price,
			int number, double actualPay, String supplierName,
			String productName) {
		this.id = id;
		this.supplierId = supplierId;
		this.idate = idate;
		this.operator = operator;
		this.brokerage = brokerage;
		this.settlement = settlement;
		this.productId = productId;
		this.price = price;
		this.number = number;
		this.actualPay = actualPay;
		this.supplierName = supplierName;
		this.productName = productName;
	}
	public InStorage() {
	}

}
