package com.bl.model;

import java.util.Date;

public class CompleteShift {
	private long completeShiftID;
	private long shiftID;
	private long companyID;
	private String studentID;
	private Date checkIn;
	private Date checkOut;
	
	public CompleteShift(long completeShiftID, long shiftID, long companyID, String studentID, Date checkIn, Date checkOut) {
		this.completeShiftID = completeShiftID;
		this.shiftID = shiftID;
		this.companyID = companyID;
		this.studentID = studentID;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public long getCompleteShiftID() {
		return completeShiftID;
	}

	public void setCompleteShiftID(long completeShiftID) {
		this.completeShiftID = completeShiftID;
	}

	public long getShiftID() {
		return shiftID;
	}

	public void setShiftID(long shiftID) {
		this.shiftID = shiftID;
	}

	public long getCompanyID() {
		return companyID;
	}

	public void setCompanyID(long companyID) {
		this.companyID = companyID;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
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
		return "CompleteShift [completeShiftID=" + completeShiftID + ", shiftID=" + shiftID + ", companyID=" + companyID
				+ ", studentID=" + studentID + ", checkIn=" + checkIn + ", checkOut=" + checkOut + "]";
	}
}
