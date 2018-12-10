package com.bl.model;

import java.util.Date;

public class CompleteShift {
	private int ShiftDoneID;
	private int shiftID;
	private int companyID;
	private int studentID;
	private Date checkIn;
	private Date checkOut;
	
	public CompleteShift(int shiftDoneID, int shiftID, int companyID, int studentID, boolean status) {
		ShiftDoneID = shiftDoneID;
		this.shiftID = shiftID;
		this.companyID = companyID;
		this.studentID = studentID;
		
	}
	
	public int getShiftDoneID() {
		return ShiftDoneID;
	}
	public void setShiftDoneID(int shiftDoneID) {
		ShiftDoneID = shiftDoneID;
	}
	public int getShiftID() {
		return shiftID;
	}
	public void setShiftID(int shiftID) {
		this.shiftID = shiftID;
	}
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	
	
	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "CompleteShift [ShiftDoneID=" + ShiftDoneID + ", shiftID=" + shiftID + ", companyID=" + companyID
				+ ", studentID=" + studentID;
	}
}
