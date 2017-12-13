package com.gorankadir.se.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clothes")
public class Clothes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="clothesid")
	private long clothesId;

//	public List<CustomerClothes> getCustomerClothes() {
//		return customerClothes;
//	}
//
//	public void setCustomerClothes(List<CustomerClothes> customerClothes) {
//		this.customerClothes = customerClothes;
//	}

	@Column(name = "brandname")
	private String brandName;

	@Column(name = "clothestype")
	private String clothestype;

	@Column(name = "clothessize")
	private String size;
	
	@Column(name = "picurl")
	private String picname;
	
	
//	@OneToMany(mappedBy = "clothes")
//	private List<CustomerClothes> customerClothes;

	public Clothes() {}

	public Clothes(String brandName, String clothestype, String size) {
		
		this.brandName = brandName;
		this.clothestype = clothestype;
		this.size = size;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getClothestype() {
		return clothestype;
	}

	public void setClothestype(String clothestype) {
		this.clothestype = clothestype;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public long getClothesId() {
		return clothesId;
	}

	public void setClothesId(long clothesId) {
		this.clothesId = clothesId;
	}
	
	public String getPicname() {
		return picname;
	}

	public void setPicname(String picname) {
		this.picname = picname;
	}
}
