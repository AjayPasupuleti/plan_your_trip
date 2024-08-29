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
import com.oms.project.model.Partners;
import com.oms.project.repository.OmsRepository;



@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins="http://localhost:4200")
public class PartnerController  {

	@Autowired
	private OmsRepository omsRepository;
	
	@GetMapping("/Partners")
	public List<Partners> getAllPartners(){
		return omsRepository.findAll();
	}
	
	@PostMapping("/Partners")
	public Partners createPartner(@RequestBody Partners partner) {
		return omsRepository.save(partner);
	}
	
	@GetMapping("/Partners/{id}")
	public ResponseEntity<Partners> getPartnerById(@PathVariable Long id){
		Partners partner=omsRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Partner not found by id= "+id));
		return ResponseEntity.ok(partner);
	}
	
	@PutMapping("/Partners/{id}")
	public ResponseEntity<Partners> updatePartnerById(@PathVariable Long id, @RequestBody Partners partnerDetails){
		Partners partner=omsRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Partner not found by id= "+id));
		//employee.setemployeeId(employeedetails.getemployeeId());
		partner.setPartnerName(partnerDetails.getPartnerName());
		partner.setPartnerCompanyName(partnerDetails.getPartnerCompanyName());
		partner.setServicesProvided(partnerDetails.getServicesProvided());
		partner.setRegisteredDate(partnerDetails.getRegisteredDate());
		partner.setContactDetails(partnerDetails.getContactDetails());
		Partners upemployee=omsRepository.save(partner);
		return ResponseEntity.ok(upemployee);
	}
	
	@DeleteMapping("/Partners/{id}")
	public ResponseEntity<Map<String,Boolean>> deletePartner(@PathVariable Long id){
		Partners partner=omsRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Partner not found by id= "+id));
		omsRepository.delete(partner);
		Map<String,Boolean> response=new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}
