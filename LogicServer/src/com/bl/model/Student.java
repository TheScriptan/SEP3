package com.bl.model;

public class Student {
	private long studentID;
	private String password;
	private String name;
	private String address;
	private int phoneNo;
	private String email;
	private String bankAcc;
	private double monthWorkedHours;
	
	public Student(long studentID, String password, String studentname, String studentAddress, int studentPhoneNo, String studentEmail, String studentBankAcc, double studentMonthWorkedHours) {
		this.studentID = studentID;
		this.password = password;
		this.address = studentAddress;
		this.phoneNo = studentPhoneNo;
		this.email = studentEmail;
		this.bankAcc = studentBankAcc;
		this.monthWorkedHours = studentMonthWorkedHours;
		
	}

	public long getId() {
		return studentID;
	}

	public void setId(long id) {
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

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
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
