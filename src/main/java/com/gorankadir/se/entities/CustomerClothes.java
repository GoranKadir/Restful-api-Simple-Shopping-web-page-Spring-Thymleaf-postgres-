package com.gorankadir.se.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "customer_clothes")
public class CustomerClothes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tableid")
	private int tableid;
	
	@Column(name = "amount")
	private int amount;

	@ManyToOne
	@JoinColumn(name = "customerid", referencedColumnName = "customerid")
	@JsonBackReference
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "clothesid", referencedColumnName = "clothesid")
	private Clothes clothes;

	public CustomerClothes(){}
	
	public CustomerClothes(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Clothes getClothes() {
		return clothes;
	}

	public void setClothes(Clothes clothes) {
		this.clothes = clothes;
	}
	
}
