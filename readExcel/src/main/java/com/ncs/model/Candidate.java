package com.ncs.model;

public class Candidate {
	
	
	private String firstName;
	private String lastName;
	private String country;
	private String contactEmail;
	private int cellPhone;
	
	public Candidate() {
		super();
	}
    
	public Candidate( String firstName, String lastName, String country,  String contactEmail,
			int cellPhone) {
		super();
		
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.contactEmail = contactEmail;
		this.cellPhone = cellPhone;
	}
	

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public int getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(int cellPhone) {
		this.cellPhone = cellPhone;
	}

	
}
