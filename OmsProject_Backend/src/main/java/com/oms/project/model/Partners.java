package com.oms.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Partner")
public class Partners {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long partnerId;
	@Column(name="PartnerName")
	private String partnerName;
	@Column(name="PartnerCompanyName")
	private String partnerCompanyName;
	@Column(name="ServicesProvided")
	private String servicesProvided;
	@Column(name="RegisteredDate")
	private Date registeredDate;
	@Column(name="ContactDetails")
	private String contactDetails;
	public Partners() {
		super();
	}
	public Partners(int partnerId,String partnerName, String partnerCompanyName, String servicesProvided, Date registeredDate,
			String contactDetails) {
		super();
		this.partnerId= partnerId;
		this.partnerName = partnerName;
		this.partnerCompanyName = partnerCompanyName;
		this.servicesProvided = servicesProvided;
		this.registeredDate = registeredDate;
		this.contactDetails = contactDetails;
	}
	public long getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(long partnerId) {
		this.partnerId = partnerId;
	}
	public String getPartnerName() {
		return partnerName;
	}
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
	public String getPartnerCompanyName() {
		return partnerCompanyName;
	}
	public void setPartnerCompanyName(String partnerCompanyName) {
		this.partnerCompanyName = partnerCompanyName;
	}
	public String getServicesProvided() {
		return servicesProvided;
	}
	public void setServicesProvided(String servicesProvided) {
		this.servicesProvided = servicesProvided;
	}
	public Date getRegisteredDate() {
		return registeredDate;
	}
	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}
	public String getContactDetails() {
		return contactDetails;
	}
	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}
}
