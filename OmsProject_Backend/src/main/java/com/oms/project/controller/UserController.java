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
import com.oms.project.model.Users;
import com.oms.project.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/Users")
	public List<Users> getAllUsers(){
		return userRepository.findAll();
	}
	@PostMapping("/Users")
	public Users createCustomer(@RequestBody Users user) {
		return userRepository.save(user);
	}
	
	@GetMapping("/Users/{id}")
	public ResponseEntity<Users> getUserById(@PathVariable Long id){
		Users user=userRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("User not found by id= "+id));
		return ResponseEntity.ok(user);
	}
	@PutMapping("/Users/{id}")
	public ResponseEntity<Users> updateUserById(@PathVariable Long id, @RequestBody Users userDetails){
		Users user=userRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("User not found by id= "+id));
		System.out.println(userDetails.getUserName()+" "+userDetails.getPassword());
		System.out.println(user.getUserName()+" "+user.getPassword());
		user.setUserName(userDetails.getUserName());
		user.setPassword(userDetails.getPassword());
		System.out.println(user.getUserName()+" "+user.getPassword());
		return ResponseEntity.ok(userRepository.save(user));
	}
	
	@DeleteMapping("/Users/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteUser(@PathVariable Long id){
		Users user=userRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("User not found by id= "+id));
		userRepository.delete(user);
		Map<String,Boolean> response=new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
