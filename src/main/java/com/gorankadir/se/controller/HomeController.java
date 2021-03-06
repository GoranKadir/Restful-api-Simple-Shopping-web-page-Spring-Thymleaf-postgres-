package com.gorankadir.se.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.classmate.GenericType;
import com.gorankadir.se.entities.Clothes;
import com.gorankadir.se.entities.Customer;
import com.gorankadir.se.repositories.CustomerRepository;

@Controller
public class HomeController {
	
	@Autowired CustomerRepository custRepository;
	
	@RequestMapping("/admin/customers/all")
    public String getCustomerList(Model model) {
		RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Customer[]> customers = restTemplate.getForEntity("http://localhost:8080/customers", Customer[].class);
        model.addAttribute("customers", customers.getBody());
        return "customertable";
	}
	
	@RequestMapping("/home")
    public String getAllClothesList(Model model) {
		RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Clothes[]> clothes = restTemplate.getForEntity("http://localhost:8080/customers/clothes", Clothes[].class);
        model.addAttribute("clothes", clothes.getBody());
        return "home";
	}
	
	@RequestMapping(path="/admin/clothes/all", method=RequestMethod.POST)
	public String postClothes(@ModelAttribute Clothes newclothes, Model model){
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForEntity("http://localhost:8080/customers/postclothes", newclothes, Object.class);
/*		ResponseEntity<Clothes[]> clothes = restTemplate.getForEntity("http://localhost:8080/customers/clothes", Clothes[].class);
        model.addAttribute("clothes", clothes.getBody());
        model.addAttribute("newclothes", new Clothes());
		model.addAttribute("postclothes", clothes.getBody());
		return "clothestable";*/
		return getClothesList(model);
	}
	
	@RequestMapping(path="/admin/clothes/all", method=RequestMethod.GET)
    public String getClothesList(Model model) {
		RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Clothes[]> clothes = restTemplate.getForEntity("http://localhost:8080/customers/clothes", Clothes[].class);
        model.addAttribute("clothes", clothes.getBody());
        model.addAttribute("newclothes", new Clothes());
        return "clothestable";
	}
	
//	@RequestMapping(path="/admin/clothes/all", method=RequestMethod.DELETE)
//	public void deleteClothes(Long id){
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.delete("http://localhost:8080/customers/deleteclothes" + id);
//	}
//	
	
}
