package com.bjsxt.pojo;

import java.io.Serializable;

public class Stock implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int productId;
	private String productName;
	private String sname;
	private String place;
	private String standard;
	private String packing;
	private String unit;
	private double price;
	private int number;
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getPacking() {
		return packing;
	}
	public void setPacking(String packing) {
		this.packing = packing;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + number;
		result = prime * result + ((packing == null) ? 0 : packing.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + productId;
		result = prime * result
				+ ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((sname == null) ? 0 : sname.hashCode());
		result = prime * result
				+ ((standard == null) ? 0 : standard.hashCode());
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
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
		Stock other = (Stock) obj;
		if (id != other.id)
			return false;
		if (number != other.number)
			return false;
		if (packing == null) {
			if (other.packing != null)
				return false;
		} else if (!packing.equals(other.packing))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
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
		if (sname == null) {
			if (other.sname != null)
				return false;
		} else if (!sname.equals(other.sname))
			return false;
		if (standard == null) {
			if (other.standard != null)
				return false;
		} else if (!standard.equals(other.standard))
			return false;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Stock [id=" + id + ", productId=" + productId
				+ ", productName=" + productName + ", sname=" + sname
				+ ", place=" + place + ", standard=" + standard + ", packing="
				+ packing + ", unit=" + unit + ", price=" + price + ", number="
				+ number + "]";
	}
	public Stock(int id, int productId, String productName, String sname,
			String place, String standard, String packing, String unit,
			double price, int number) {
		this.id = id;
		this.productId = productId;
		this.productName = productName;
		this.sname = sname;
		this.place = place;
		this.standard = standard;
		this.packing = packing;
		this.unit = unit;
		this.price = price;
		this.number = number;
	}
	public Stock() {
	}

}