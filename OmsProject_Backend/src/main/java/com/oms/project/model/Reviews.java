package com.oms.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reviews")
public class Reviews {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long SlNo;
	@Column(name="TripId")
	long tripId;
	@Column(name="CustomerId")
	long customerId;
	@Column(name="Rating")
	long rating;
	@Column(name="Description")
	String description;
	public Reviews() {
		super();
	}
	public Reviews(long slNo, long tripId, long customerId, long rating, String description) {
		super();
		SlNo = slNo;
		this.tripId = tripId;
		this.customerId = customerId;
		this.rating = rating;
		this.description = description;
	}
	public long getSlNo() {
		return SlNo;
	}
	public void setSlNo(long slNo) {
		SlNo = slNo;
	}
	public long getTripId() {
		return tripId;
	}
	public void setTripId(long tripId) {
		this.tripId = tripId;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public long getRating() {
		return rating;
	}
	public void setRating(long rating) {
		this.rating = rating;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
