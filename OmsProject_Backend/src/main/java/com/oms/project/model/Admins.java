package com.oms.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admins")
public class Admins {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long adminId;
	@Column(name="Name")
	String name;
	@Column(name="DateOfBirth")
	Date dateOfBirth=new Date();
	@Column(name="EmailId")
	String emailId;
	public Admins() {
		super();
	}
	public Admins(long adminId, String name, Date dateOfBirth, String emailId) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.emailId = emailId;
	}
	public long getAdminId() {
		return adminId;
	}
	public void setAdminId(long adminId) {
		this.adminId = adminId;
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
