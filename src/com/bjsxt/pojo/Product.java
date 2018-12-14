package com.bjsxt.pojo;

import java.io.Serializable;

public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String sname;
	private String place;
	private String unit;
	private String standard;
	private String packing;
	private String batchno;
	private String approval;
	private String remark;
	private String supplierName;
	private int supplierId;

	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
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
	public String getBatchno() {
		return batchno;
	}
	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}
	public String getApproval() {
		return approval;
	}
	public void setApproval(String approval) {
		this.approval = approval;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((approval == null) ? 0 : approval.hashCode());
		result = prime * result + ((batchno == null) ? 0 : batchno.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((packing == null) ? 0 : packing.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((sname == null) ? 0 : sname.hashCode());
		result = prime * result
				+ ((standard == null) ? 0 : standard.hashCode());
		result = prime * result + supplierId;
		result = prime * result
				+ ((supplierName == null) ? 0 : supplierName.hashCode());
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
		Product other = (Product) obj;
		if (approval == null) {
			if (other.approval != null)
				return false;
		} else if (!approval.equals(other.approval))
			return false;
		if (batchno == null) {
			if (other.batchno != null)
				return false;
		} else if (!batchno.equals(other.batchno))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
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
		if (supplierId != other.supplierId)
			return false;
		if (supplierName == null) {
			if (other.supplierName != null)
				return false;
		} else if (!supplierName.equals(other.supplierName))
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
		return "Product [id=" + id + ", name=" + name + ", sname=" + sname
				+ ", place=" + place + ", unit=" + unit + ", standard="
				+ standard + ", packing=" + packing + ", batchno=" + batchno
				+ ", approval=" + approval + ", remark=" + remark
				+ ", supplierName=" + supplierName + ", supplierId="
				+ supplierId + "]";
	}
	public Product(int id, String name, String sname, String place,
			String unit, String standard, String packing, String batchno,
			String approval, String remark, String supplierName, int supplierId) {
		this.id = id;
		this.name = name;
		this.sname = sname;
		this.place = place;
		this.unit = unit;
		this.standard = standard;
		this.packing = packing;
		this.batchno = batchno;
		this.approval = approval;
		this.remark = remark;
		this.supplierName = supplierName;
		this.supplierId = supplierId;
	}
	public Product() {
	}

}
