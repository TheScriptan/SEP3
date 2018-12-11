package com.bl.model;

public class Employee {
	private String employeeID;
	private String password;
	private String employeeName;
	private String employeeAdress;
	private String employeePhoneNo;
	private String employeeEmail;
	private String employeeBankAcc;
	private double employeeMonthWorkedHours;
	
	public Employee(String employeeID, String password, String employeeName, String employeeAdress, String employeePhoneNo, String employeeEmail,
			String employeeBankAcc, double employeeMonthWorkedHours) {
		this.employeeID = employeeID;
		this.password = password;
		this.employeeName = employeeName;
		this.employeeAdress = employeeAdress;
		this.employeePhoneNo = employeePhoneNo;
		this.employeeEmail = employeeEmail;
		this.employeeBankAcc = employeeBankAcc;
		this.employeeMonthWorkedHours = employeeMonthWorkedHours;
	}

	public String getemployeeID() {
		return employeeID;
	}

	public void setemployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getemployeeName() {
		return employeeName;
	}

	public void setemployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getemployeeAdress() {
		return employeeAdress;
	}

	public void setemployeeAdress(String employeeAdress) {
		this.employeeAdress = employeeAdress;
	}

	public String getemployeePhoneNo() {
		return employeePhoneNo;
	}

	public void setemployeePhoneNo(String employeePhoneNo) {
		this.employeePhoneNo = employeePhoneNo;
	}

	public String getemployeeEmail() {
		return employeeEmail;
	}

	public void setemployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getemployeeBankAcc() {
		return employeeBankAcc;
	}

	public void setemployeeBankAcc(String employeeBankAcc) {
		this.employeeBankAcc = employeeBankAcc;
	}

	public double getemployeeMonthWorkedHours() {
		return employeeMonthWorkedHours;
	}

	public void setemployeeMonthWorkedHours(int employeeMonthWorkedHours) {
		this.employeeMonthWorkedHours = employeeMonthWorkedHours;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", password=" + password + ", employeeName=" + employeeName + ", employeeAdress="
				+ employeeAdress + ", employeePhoneNo=" + employeePhoneNo + ", employeeEmail=" + employeeEmail + ", employeeBankAcc=" + employeeBankAcc + ", employeeMonthWorkedHours="
				+ employeeMonthWorkedHours;
	}
}
