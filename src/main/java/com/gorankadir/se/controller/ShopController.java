package com.gorankadir.se.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gorankadir.se.entities.Clothes;
import com.gorankadir.se.entities.Customer;
import com.gorankadir.se.entities.CustomerClothes;
import com.gorankadir.se.repositories.ClothesRepository;
import com.gorankadir.se.repositories.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class ShopController {

	@Autowired
	CustomerRepository custRepository;
	@Autowired
	ClothesRepository clothesRepository;

	/**
	 * show all customers and what clothes they owning!
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getAll() {
		List<Customer> listOfAllCustomers = custRepository.findAll();
		if (listOfAllCustomers.size() == 0) {
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Customer>>(listOfAllCustomers, HttpStatus.OK);
	}

	/**
	 * Show all clothes i stoke!
	 */
	@RequestMapping(value = "/clothes", method = RequestMethod.GET)
	public List<Clothes> getClothes() {
		List<Clothes> listClothes = clothesRepository.findAll();
		return listClothes;
	}

	/*
	 * Lägger till customer och vilken kläder den har
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Void> saveCustomer(@RequestBody Customer customer) {
		for (CustomerClothes cc : customer.getCustomerClothes()) {
			cc.setCustomer(customer);
		}
		custRepository.save(customer);
		HttpHeaders header = new HttpHeaders();
		return new ResponseEntity<Void>(header, HttpStatus.CREATED);
		
	}
	
	/*
	 * lägg till nya kläder
	 */
	@RequestMapping(value = "/postclothes", method = RequestMethod.POST)
	public ResponseEntity<Void> saveClothes(@RequestBody Clothes clothes) {
		clothesRepository.save(clothes);
		HttpHeaders header = new HttpHeaders();
		return new ResponseEntity<Void>(header, HttpStatus.CREATED);
	}
	
	

	// Funkar bara updatera med customer
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
		customer.setCustomerId(id);
		custRepository.saveAndFlush(customer);
		HttpHeaders header = new HttpHeaders();
		return new ResponseEntity<Void>(header, HttpStatus.OK);
	}

	/*
	 * Updaterar clothes
	 */
	@RequestMapping(value = "/updateclothes/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateClothes(@PathVariable("id") long id, @RequestBody Clothes clothes) {
		clothes.setClothesId(id);
		clothesRepository.saveAndFlush(clothes);
		HttpHeaders header = new HttpHeaders();
		return new ResponseEntity<Void>(header, HttpStatus.OK);
	}

	/*
	 * Delete en customer
	 */
	@RequestMapping(value = "/{customerId}", method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteCustomer(@PathVariable(name = "customerId") long id) {
		custRepository.delete(id);
		return ResponseEntity.ok().build();
	}

	/*
	 * Delete ett klädselplagg
	 */
	@RequestMapping(value = "/deleteclothes/{clothesId}", method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteClothes(@PathVariable(name = "clothesId") long id) {
		clothesRepository.delete(id);
		return ResponseEntity.ok().build();
	}

	/**
	 * Show customer by id!
	 */
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") long customerId) {
		Customer customer = custRepository.findOne(customerId);
		if (customer == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(customer);
	}
	
	@RequestMapping("/prod")
	public String listProducts(ModelMap model){
		model.addAttribute("prod", clothesRepository.findAll());
		return "prod";
	}

	/*
	 * Show clothes by id
	 */
	@RequestMapping(value = "/findclothes/{id}", method = RequestMethod.GET)
	public ResponseEntity<Clothes> getClothesById(@PathVariable(value = "id") long clothesId) {
		Clothes clothes = clothesRepository.findOne(clothesId);
		if (clothes == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(clothes);
	}

}
