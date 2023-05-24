package com.iemr.common.data.carestream;

public class CreateOrderData {
	private String firstName;
	private String middleName;
	private String LastName;
	private String gender;
	private String dob;
	private String patientID;
	private String acc;

	public CreateOrderData(String firstName, String middleName, String lastName, String gender, String dob,
			String patientID, String acc) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		LastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.patientID = patientID;
		this.acc = acc;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	public String getAcc() {
		return acc;
	}

	public void setAcc(String acc) {
		this.acc = acc;
	}

}
