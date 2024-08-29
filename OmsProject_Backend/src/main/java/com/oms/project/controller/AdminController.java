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
import com.oms.project.model.Admins;
import com.oms.project.repository.AdminRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins="http://localhost:4200")
public class AdminController {
	@Autowired
	private AdminRepository adminRepository;
	
	@GetMapping("/Admins")
	public List<Admins> getAllAdmins(){
		return adminRepository.findAll();
	}
	
	@PostMapping("/Admins")
	public Admins createAdmin(@RequestBody Admins admin) {
		return adminRepository.save(admin);
	}
	
	@GetMapping("/Admins/{id}")
	public ResponseEntity<Admins> getAdminById(@PathVariable Long id){
		Admins admin=adminRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Admin not found by id= "+id));
		return ResponseEntity.ok(admin);
	}
	
	@PutMapping("/Admins/{id}")
	public ResponseEntity<Admins> updateAdminById(@PathVariable Long id, @RequestBody Admins adminDetails){
		Admins admin=adminRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Admin not found by id= "+id));
		admin.setName(adminDetails.getName());
		admin.setDateOfBirth(adminDetails.getDateOfBirth());
		admin.setEmailId(adminDetails.getEmailId());
		return ResponseEntity.ok(adminRepository.save(admin));
	}
	
	@DeleteMapping("/Admins/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteAdmin(@PathVariable Long id){
		Admins admin=adminRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Admin not found by id= "+id));
		adminRepository.delete(admin);
		Map<String,Boolean> response=new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
