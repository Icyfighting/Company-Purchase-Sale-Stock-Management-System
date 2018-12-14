package com.bjsxt.pojo;

import java.io.Serializable;
import java.util.Date;

public class Sale implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int clientId;
	private Date sdate;
	private String operator;
	private String brokerage;
	private String settlement;
	private int productId;
	private double price;
	private int number;
	private double actualIncome;
	private String clientName;
	private String productName;

	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public Date getSdate() {
		return sdate;
	}
	public void setSdate(Date sdate) {
		this.sdate = sdate;
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
	public double getActualIncome() {
		return actualIncome;
	}
	public void setActualIncome(double actualIncome) {
		this.actualIncome = actualIncome;
	}

	public Sale() {
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(actualIncome);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((brokerage == null) ? 0 : brokerage.hashCode());
		result = prime * result + clientId;
		result = prime * result
				+ ((clientName == null) ? 0 : clientName.hashCode());
		result = prime * result + id;
		result = prime * result + number;
		result = prime * result
				+ ((operator == null) ? 0 : operator.hashCode());
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + productId;
		result = prime * result
				+ ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((sdate == null) ? 0 : sdate.hashCode());
		result = prime * result
				+ ((settlement == null) ? 0 : settlement.hashCode());
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
		Sale other = (Sale) obj;
		if (Double.doubleToLongBits(actualIncome) != Double
				.doubleToLongBits(other.actualIncome))
			return false;
		if (brokerage == null) {
			if (other.brokerage != null)
				return false;
		} else if (!brokerage.equals(other.brokerage))
			return false;
		if (clientId != other.clientId)
			return false;
		if (clientName == null) {
			if (other.clientName != null)
				return false;
		} else if (!clientName.equals(other.clientName))
			return false;
		if (id != other.id)
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
		if (sdate == null) {
			if (other.sdate != null)
				return false;
		} else if (!sdate.equals(other.sdate))
			return false;
		if (settlement == null) {
			if (other.settlement != null)
				return false;
		} else if (!settlement.equals(other.settlement))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Sale [id=" + id + ", clientId=" + clientId + ", sdate=" + sdate
				+ ", operator=" + operator + ", brokerage=" + brokerage
				+ ", settlement=" + settlement + ", productId=" + productId
				+ ", price=" + price + ", number=" + number + ", actualIncome="
				+ actualIncome + ", clientName=" + clientName
				+ ", productName=" + productName + "]";
	}
	public Sale(int id, int clientId, Date sdate, String operator,
			String brokerage, String settlement, int productId, double price,
			int number, double actualIncome, String clientName,
			String productName) {
		this.id = id;
		this.clientId = clientId;
		this.sdate = sdate;
		this.operator = operator;
		this.brokerage = brokerage;
		this.settlement = settlement;
		this.productId = productId;
		this.price = price;
		this.number = number;
		this.actualIncome = actualIncome;
		this.clientName = clientName;
		this.productName = productName;
	}

}
