package com.oms.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customers {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long customer_Id;
	@Column(name="Name")
	String name;
	@Column(name="MObile_No")
	long mobileNo;
	@Column(name="Email_Id")
	String emailId;
	@Column(name="Date_Of_Birth")
	Date dateOfBirth=new Date();
	@Column(name="No_Of_Trips_Booked")
	long noOfTripsBooked;
	@Column(name="Address")
	String Address;
	public Customers() {
		super();
	}
	public Customers(long customer_Id, String name, long mobileNo, String emailId, Date dateOfBirth,
			long noOfTripsBooked, String address) {
		super();
		this.customer_Id = customer_Id;
		this.name = name;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
		this.noOfTripsBooked = noOfTripsBooked;
		Address = address;
	}
	public long getCustomer_Id() {
		return customer_Id;
	}
	public void setCustomer_Id(long customer_Id) {
		this.customer_Id = customer_Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public long getNoOfTripsBooked() {
		return noOfTripsBooked;
	}
	public void setNoOfTripsBooked(long noOfTripsBooked) {
		this.noOfTripsBooked = noOfTripsBooked;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
}
