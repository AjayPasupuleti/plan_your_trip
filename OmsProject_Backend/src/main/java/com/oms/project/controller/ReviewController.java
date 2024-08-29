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
import com.oms.project.model.Reviews;
import com.oms.project.repository.ReviewRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins="http://localhost:4200")
public class ReviewController {

	@Autowired
	private ReviewRepository reviewRepository;
	
	@GetMapping("/Reviews")
	public List<Reviews> getAllReviews(){
		return reviewRepository.findAll();
	}
	
	@PostMapping("/Reviews")
	public Reviews createreview(@RequestBody Reviews review) {
		return reviewRepository.save(review);
	}
	
	@GetMapping("/Reviews/{id}")
	public ResponseEntity<Reviews> getreviewsById(@PathVariable Long id){
		Reviews reviews=(Reviews) reviewRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Review not found by id= "+id));
		return ResponseEntity.ok(reviews);
	}
	
	@PutMapping("/Reviews/{id}")
	public ResponseEntity<Reviews> updatereviewById(@PathVariable Long id, @RequestBody Reviews reviewDetails){
		Reviews review=reviewRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Review not found by id= "+id));
		review.setRating(review.getRating());
		review.setDescription(review.getDescription());
		return ResponseEntity.ok(review);
	}
	
	@DeleteMapping("/Reviews/{id}")
	public ResponseEntity<Map<String,Boolean>> deletereview(@PathVariable Long id){
		Reviews review=reviewRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Review not found by id= "+id));
		reviewRepository.delete(review);
		Map<String,Boolean> response=new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
