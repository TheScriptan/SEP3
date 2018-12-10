package com.bl.model;

public class Employee {
	private int employeeID;
	private String password;
	private String name;
	private String address;
	private String phoneNo;
	private String email;
	private String bankAcc;
	private int MonthWorkedHours;
	private String role;
	
	public Employee(int employeeID, String password, String name, String address, String phoneNo, String email,
			String bankAcc, int monthWorkedHours, String role) {
		this.employeeID = employeeID;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
		this.bankAcc = bankAcc;
		MonthWorkedHours = monthWorkedHours;
		this.role = role;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
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

	public int getMonthWorkedHours() {
		return MonthWorkedHours;
	}

	public void setMonthWorkedHours(int monthWorkedHours) {
		MonthWorkedHours = monthWorkedHours;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", password=" + password + ", name=" + name + ", address="
				+ address + ", phoneNo=" + phoneNo + ", email=" + email + ", bankAcc=" + bankAcc + ", MonthWorkedHours="
				+ MonthWorkedHours + ", role=" + role + "]";
	}
}
