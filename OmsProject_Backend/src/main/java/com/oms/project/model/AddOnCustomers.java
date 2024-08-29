package com.oms.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="addOnCustomers")
public class AddOnCustomers {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long SlNo;
	@Column(name="CustomerId")
	private long customerId;
	@Column(name="Name")
	private String name;
	@Column(name="DateOfBirth")
	private Date dateOfBirth=new Date();
	@Column(name="DateOfBooking")
	private Date dateOfBooking=new Date();
	public AddOnCustomers() {
		super();
	}
	public AddOnCustomers(long slNo, long customerId, String name, Date dateOfBirth,Date dateOfBooking) {
		super();
		SlNo = slNo;
		this.customerId = customerId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.dateOfBooking=dateOfBooking;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Date getDateOfBooking() {
		return dateOfBooking;
	}
	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}
}
