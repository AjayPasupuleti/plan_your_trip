package com.oms.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oms.project.exception.ResourceNotFoundException;
import com.oms.project.model.Customers;
import com.oms.project.repository.CustomerRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins="http://localhost:4200")
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository ;
	@GetMapping("/Customers")
	public List<Customers> getAllCustomers(){
		return customerRepository.findAll();
	}
	@PostMapping("/Customers")
	public Customers createCustomer(@RequestBody Customers customer) {
		return customerRepository.save(customer);
	}
	@PutMapping("/Customers/{id}")
	public ResponseEntity<Customers> updateCustomer(@PathVariable Long id, @RequestBody Customers customer){
		Customers c=customerRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Customer not found by id= "+id));
		c.setNoOfTripsBooked(customer.getNoOfTripsBooked());
		c.setEmailId(customer.getEmailId());
		c.setAddress(customer.getAddress());
		c.setMobileNo(customer.getMobileNo());
		c.setDateOfBirth(customer.getDateOfBirth());
		c.setName(customer.getName());
		return ResponseEntity.ok(customerRepository.save(c));
	}
	@PutMapping("/CustomersOnly/{id}")
	public ResponseEntity<Customers> updateCustomerOnly(@PathVariable Long id, @RequestBody Customers customer){
		Customers c=customerRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Customer not found by id= "+id));
		c.setNoOfTripsBooked(customer.getNoOfTripsBooked()+1);
		return ResponseEntity.ok(customerRepository.save(c));
	}
	@GetMapping("/Customers/{id}")
	public ResponseEntity<Customers> getCustomerById(@PathVariable Long id){
		Customers customer=customerRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Customer not found by id= "+id));
		return ResponseEntity.ok(customer);
	}

	@DeleteMapping("/Customers/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteCustomer(@PathVariable Long id){
		Customers customer=customerRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Customer not found by id= "+id));
		customerRepository.delete(customer);
		Map<String,Boolean> response=new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
