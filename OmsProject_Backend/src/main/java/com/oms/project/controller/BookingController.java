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
import com.oms.project.model.Booking;
import com.oms.project.repository.BookingRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins="http://localhost:4200")
public class BookingController {

	@Autowired
	BookingRepository bookingRepository;
	@GetMapping("/Bookings")
	public List<Booking> getAllBookings(){
		return bookingRepository.findAll();
	}
	@PostMapping("/Bookings")
	public Booking createBookings(@RequestBody Booking booking) {
		return bookingRepository.save(booking);
	}
	
	@GetMapping("/Bookings/{id}")
	public ResponseEntity<Booking> getBookingById(@PathVariable Long id){
		Booking booking=bookingRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Booking not found by id= "+id));
		return ResponseEntity.ok(booking);
	}
	@PutMapping("/Bookings/{id}")
	public ResponseEntity<Booking> updateBookingById(@PathVariable Long id, @RequestBody Booking bookingDetails){
		Booking booking=bookingRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Booking not found by id= "+id));
		booking.setTripId(bookingDetails.getTripId());
		booking.setNoOfTravellers(booking.getNoOfTravellers());
		booking.setStatus(bookingDetails.getStatus());
		return ResponseEntity.ok(bookingRepository.save(booking));
	}
	
	@DeleteMapping("/Bookings/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteBooking(@PathVariable Long id){
		Booking booking=bookingRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Booking not found by id= "+id));
		bookingRepository.delete(booking);
		Map<String,Boolean> response=new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
