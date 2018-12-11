package com.bl.model;

public class Student {
	private String studentID;
	private String password;
	private String name;
	private String address;
	private String phoneNo;
	private String email;
	private String bankAcc;
	private double monthWorkedHours;
	
	public Student(String studentID, String password, String studentName, String studentAddress, String studentPhoneNo, String studentEmail, String studentBankAcc, double studentMonthWorkedHours) {
		this.studentID = studentID;
		this.password = password;
		this.name = studentName;
		this.address = studentAddress;
		this.phoneNo = studentPhoneNo;
		this.email = studentEmail;
		this.bankAcc = studentBankAcc;
		this.monthWorkedHours = studentMonthWorkedHours;
		
	}

	public String getId() {
		return studentID;
	}

	public void setId(String id) {
		this.studentID = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBankAcc() {
		return bankAcc;
	}

	public void setBankAcc(String bankAcc) {
		this.bankAcc = bankAcc;
	}

	public double getMonthWorkedHours() {
		return monthWorkedHours;
	}

	public void setMonthWorkedHours(double monthWorkedHours) {
		this.monthWorkedHours = monthWorkedHours;
	}
	
	@Override
	public String toString() {
		return this.studentID + " " + this.name;
	}
}
