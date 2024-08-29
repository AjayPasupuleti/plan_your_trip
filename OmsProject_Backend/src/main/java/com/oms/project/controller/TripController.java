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
import com.oms.project.model.Trips;
import com.oms.project.repository.TripRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins="http://localhost:4200")
public class TripController {
	@Autowired
	TripRepository tripRepository;
	@GetMapping("/Trips")
	public List<Trips> getAllTrips(){
		return tripRepository.findAll();
	}
	@PostMapping("/Trips")
	public Trips createTrip(@RequestBody Trips trip) {
		return tripRepository.save(trip);
	}
	@GetMapping("/Trips/{id}")
	public ResponseEntity<Trips> getTripById(@PathVariable Long id){
		Trips trip=tripRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Trip not found by id= "+id));
		return ResponseEntity.ok(trip);
	}
	@PutMapping("/Trips/{id}")
	public ResponseEntity<Trips> updateTripById(@PathVariable Long id, @RequestBody Trips trip){
		Trips t=tripRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Trip not found by id= "+id));
		t.setNoOfBookings(t.getNoOfBookings());
		t.setName(trip.getName());
		t.setPlacesCovered(trip.getPlacesCovered());
		t.setRating(trip.getRating());
		t.setServicesIncluded(trip.getServicesIncluded());
		t.setTotalDistance(trip.getTotalDistance());
		Trips upt=tripRepository.save(t);
		return ResponseEntity.ok(upt);
	}
	@PutMapping("/TripsOnly/{id}")
	public ResponseEntity<Trips> updateTripByIdOnly(@PathVariable Long id, @RequestBody Trips trip){
		Trips t=tripRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Trip not found by id= "+id));
		t.setNoOfBookings(t.getNoOfBookings()+1);
		Trips upt=tripRepository.save(t);
		return ResponseEntity.ok(upt);
	}

	@DeleteMapping("/Trips/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteTrip(@PathVariable Long id){
		Trips trip=tripRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Trip not found by id= "+id));
		tripRepository.delete(trip);
		Map<String,Boolean> response=new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
