package com.capgemini.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ContactData {

	@Column(nullable = false, length = 25)
	private String email;
	
	@Column(nullable = false, length = 15)
    private String homePhoneNumber;
	
	@Column(nullable = false, length = 15)
    private String mobilePhoneNumber;

	public ContactData() {
		
	}
	
	public ContactData(String email, String homePhoneNumber, String mobilePhoneNumber) {
		super();
		this.email = email;
		this.homePhoneNumber = homePhoneNumber;
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}

	public void setHomePhoneNumber(String homePhoneNumber) {
		this.homePhoneNumber = homePhoneNumber;
	}

	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}
	
	
}
