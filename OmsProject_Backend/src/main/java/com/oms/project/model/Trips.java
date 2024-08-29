package com.oms.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Trip")
public class Trips {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long tripId;
	@Column(name="Name")
	private String name;
	@Column(name="Places_Covered")
	private String placesCovered;
	@Column(name="Total_Distance")
	private long totalDistance;
	@Column(name="No_Of_Bookings")
	private long noOfBookings;
	@Column(name="Rating")
	private String rating;
	@Column(name="Services_Included")
	private String servicesIncluded;
	public Trips() {
		super();
	}
	public Trips(long tripId, String name, String placesCovered, long totalDistance, long noOfBooking, String rating,
			String servicesIncluded) {
		super();
		this.tripId = tripId;
		this.name = name;
		this.placesCovered = placesCovered;
		this.totalDistance = totalDistance;
		this.noOfBookings = noOfBooking;
		this.rating = rating;
		this.servicesIncluded = servicesIncluded;
	}
	public long getTripId() {
		return tripId;
	}
	public void setTripId(long tripId) {
		this.tripId = tripId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlacesCovered() {
		return placesCovered;
	}
	public void setPlacesCovered(String placesCovered) {
		this.placesCovered = placesCovered;
	}
	public long getTotalDistance() {
		return totalDistance;
	}
	public void setTotalDistance(long totalDistance) {
		this.totalDistance = totalDistance;
	}
	public long getNoOfBookings() {
		return noOfBookings;
	}
	public void setNoOfBookings(long noOfBookings) {
		this.noOfBookings = noOfBookings;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getServicesIncluded() {
		return servicesIncluded;
	}
	public void setServicesIncluded(String servicesIncluded) {
		this.servicesIncluded = servicesIncluded;
	}

}
