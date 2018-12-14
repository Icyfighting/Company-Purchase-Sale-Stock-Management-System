package com.bjsxt.pojo;

import java.io.Serializable;
import java.util.Date;

public class Purchase implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int productId;
	private Date pdate;
	private int number;
	private double price;
	private double totalAmount;
	private String remark;
	private int supplierId;
	private String productName;
	private String supplierName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + number;
		result = prime * result + ((pdate == null) ? 0 : pdate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + productId;
		result = prime * result
				+ ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + supplierId;
		result = prime * result
				+ ((supplierName == null) ? 0 : supplierName.hashCode());
		temp = Double.doubleToLongBits(totalAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Purchase other = (Purchase) obj;
		if (id != other.id)
			return false;
		if (number != other.number)
			return false;
		if (pdate == null) {
			if (other.pdate != null)
				return false;
		} else if (!pdate.equals(other.pdate))
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
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (supplierId != other.supplierId)
			return false;
		if (supplierName == null) {
			if (other.supplierName != null)
				return false;
		} else if (!supplierName.equals(other.supplierName))
			return false;
		if (Double.doubleToLongBits(totalAmount) != Double
				.doubleToLongBits(other.totalAmount))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Purchase [id=" + id + ", productId=" + productId + ", pdate="
				+ pdate + ", number=" + number + ", price=" + price
				+ ", totalAmount=" + totalAmount + ", remark=" + remark
				+ ", supplierId=" + supplierId + ", productName=" + productName
				+ ", supplierName=" + supplierName + "]";
	}
	public Purchase(int id, int productId, Date pdate, int number,
			double price, double totalAmount, String remark, int supplierId,
			String productName, String supplierName) {
		this.id = id;
		this.productId = productId;
		this.pdate = pdate;
		this.number = number;
		this.price = price;
		this.totalAmount = totalAmount;
		this.remark = remark;
		this.supplierId = supplierId;
		this.productName = productName;
		this.supplierName = supplierName;
	}
	public Purchase() {
	}

}
