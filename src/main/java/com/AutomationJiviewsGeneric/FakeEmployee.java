package com.AutomationJiviewsGeneric;

import java.util.Random;
import java.util.UUID;


public class FakeEmployee {


	private String empNumber;
	private String badgeNumber;
	private String firstName;
	private String middleName;
	private String lastName;
	private String displayName;
	private String DOB;
	private String Address;
	private String postCode;
	private String city;
	private String state;
	private String mobileNumber;
	private String phoneNumber;
	private String hireDate;
	private String probationExpirydate;
	private String designation;
	private String documentName;
	private String description;
	

	private String interests;
	private String email;

	// Constructor
	public FakeEmployee() {
		// You can generate unique IDs for empNumber and badgeNumber using UUID
		this.empNumber = generateEmpNumber(8);
		this.badgeNumber = generateBadgeNumber();
		this.postCode= generateFakePostalCode();
	}

	String generateEmpNumber(int length) {
		Random random = new Random();
		StringBuilder empNumber = new StringBuilder();

		for (int i = 0; i < length; i++) {
			empNumber.append(random.nextInt(10)); // Append a random digit (0-9)
		}

		return empNumber.toString();
	}
//	String generateEmpNumber() {
//		// Generate a random UUID and use it as the employee number
//		return UUID.randomUUID().toString();
//	}


	String generateBadgeNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(100000000); 
		return String.format("%08d", randomNumber);
		//		return  UUID.randomUUID().toString().substring(0, 8).toUpperCase();
	}
	String generateFakePostalCode() {
		Random random = new Random();
		// Adjust the range and format of the postal code based on your requirements
		int postalCodeNumber = random.nextInt(90000) + 10000; // Example: 10000 to 99999
		return String.format("ZIP%s", postalCodeNumber);
	}

	public String getEmpNumber() {
		return empNumber;
	}
	public void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
	}

	public String getBadgeNumber() {
		return badgeNumber;
	}


	public void setBadgeNumber(String badgeNumber) {
		this.badgeNumber = badgeNumber;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getProbationExpirydate() {
		return probationExpirydate;
	}

	public void setProbationExpirydate(String probationExpirydate) {
		this.probationExpirydate = probationExpirydate;
	}
	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
}
