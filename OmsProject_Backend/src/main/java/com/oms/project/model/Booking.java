package com.oms.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Booking")
public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long SlNo;
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TripId")
	private long tripId;
	@Column(name="CustomerId")
	private long customerId;
	@Column(name="NoOfTravellers")
	private long noOfTravellers;
	@Column(name="BookedDate")
	private Date date=new Date();
	@Column(name="status")
	private String status;
	@Column(name="AmountPaid")
	private double amountPaid;
	public Booking() {
		super();
	}
	public Booking(long slNo, long customerId, long tripId, long noOfTravellers, Date date, String status) {
		super();
		SlNo = slNo;
		this.customerId = customerId;
		this.tripId = tripId;
		this.noOfTravellers = noOfTravellers;
		this.date = date;
		this.status = status;
	}
	public long getSlNo() {
		return SlNo;
	}
	public void setSlNo(long slNo) {
		SlNo = slNo;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public long getTripId() {
		return tripId;
	}
	public void setTripId(long tripId) {
		this.tripId = tripId;
	}
	public long getNoOfTravellers() {
		return noOfTravellers;
	}
	public void setNoOfTravellers(long noOfTravellers) {
		this.noOfTravellers = noOfTravellers;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
