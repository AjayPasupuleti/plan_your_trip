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
import com.oms.project.model.AddOnCustomers;
import com.oms.project.repository.AddOnCustomerRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins="http://localhost:4200")
public class AddOnCustomerController {

	@Autowired
	private AddOnCustomerRepository addOnCustomerRepository;
	
	@GetMapping("/AddOnCustomers")
	public List<AddOnCustomers> getAllAddOnCustomers(){
		return addOnCustomerRepository.findAll();
	}
	
	@PostMapping("/AddOnCustomers")
	public AddOnCustomers createAddOnCustomer(@RequestBody AddOnCustomers addOnCustomer) {
		return addOnCustomerRepository.save(addOnCustomer);
	}
	
	@GetMapping("/AddOnCustomers/{id}")
	public ResponseEntity<AddOnCustomers> getAddOnCustomerById(@PathVariable Long id){
		AddOnCustomers addOnCustomer=addOnCustomerRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("AddOnCustomer not found by id= "+id));
		return ResponseEntity.ok(addOnCustomer);
	}
	
	@PutMapping("/AddOnCustomers/{id}")
	public ResponseEntity<AddOnCustomers> updateAddOnCustomerById(@PathVariable Long id, @RequestBody AddOnCustomers addOnCustomerDetails){
		AddOnCustomers addOnCustomer=addOnCustomerRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("AddOnCustomer not found by id= "+id));
		addOnCustomer.setCustomerId(addOnCustomerDetails.getCustomerId());
		addOnCustomer.setName(addOnCustomerDetails.getName());
		addOnCustomer.setDateOfBirth(addOnCustomerDetails.getDateOfBirth());
		addOnCustomer.setDateOfBooking(addOnCustomerDetails.getDateOfBooking());
		return ResponseEntity.ok(addOnCustomerRepository.save(addOnCustomer));
	}
	
	@DeleteMapping("/AddOnCustomers/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteAddOnCustomer(@PathVariable Long id){
		AddOnCustomers addOnCustomer=addOnCustomerRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("AddOnCustomer not found by id= "+id));
		addOnCustomerRepository.delete(addOnCustomer);
		Map<String,Boolean> response=new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	@DeleteMapping("/AddOnCustomers")
	public ResponseEntity<Map<String,Boolean>> deleteAllAddOnCustomer(){
		addOnCustomerRepository.deleteAll();
		Map<String,Boolean> response=new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}

