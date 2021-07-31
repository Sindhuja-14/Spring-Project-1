package com.example.customer.container;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.dao.CustomerRepo;
import com.example.customer.model.Customer;




@RestController
public class CustomerController {
	@Autowired
	CustomerRepo repo;
	
	@GetMapping(path = "/checkIn")
	public Customer add(@RequestParam("name") String name ) {
       Customer n = new Customer();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
		n.setDate(dtf.format(now).toString());
		
		n.setTime(java.time.LocalTime.now().toString());  
		n.setName(name);
		n.setLogType("IN");
		n.setId(name+java.time.LocalTime.now().toString());
		repo.save(n);
		return n;
	}
	
	@GetMapping(path = "/checkOut")
	public Customer Out(@RequestParam("name") String name ) {
       Customer n = new Customer();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
		n.setDate(dtf.format(now).toString());
		
		n.setTime(java.time.LocalTime.now().toString());  
		n.setName(name);
		n.setLogType("OUT");
		n.setId(name+java.time.LocalTime.now().toString());
		repo.save(n);
		return n;
	}
	
	@GetMapping(path = "/getLog")
	public List<Customer> getCustomerName(@RequestParam("date") String date) {
		
		return repo.findAllByDate(date);
	}
	
	@GetMapping(path = "/getAllLog") 
	public List<Customer> getCustomers() {
		
		return repo.findAll();
	}
	
	

}
