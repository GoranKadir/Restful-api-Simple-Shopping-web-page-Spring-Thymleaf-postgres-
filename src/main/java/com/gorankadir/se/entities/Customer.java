package com.gorankadir.se.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long customerid;

	@Column(name = "firstname")
	private String fname;

	@Column(name = "lastname")
	private String lname;
	
	
	@OneToMany(mappedBy = "customer",  cascade = CascadeType.ALL)
	private List<CustomerClothes> customerClothes;
	
	public Customer() {
	}

	public Customer(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
	}

	public List<CustomerClothes> getCustomerClothes() {
		return customerClothes;
	}

	public void setCustomerClothes(List<CustomerClothes> customerClothes) {
		this.customerClothes = customerClothes;
	}

	public long getCustomerid() {
		return customerid;
	}

	public void setCustomerId(long customerid) {
		this.customerid = customerid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	

}
